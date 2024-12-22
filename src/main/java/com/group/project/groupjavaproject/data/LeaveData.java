/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.groupjavaproject.data;

import com.group.project.groupjavaproject.model.Leave;
import com.group.project.groupjavaproject.service.LoginServiceImpl;
import com.group.project.groupjavaproject.util.JDBCConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class LeaveData {
    
    public void createLeave(Leave leave) {

        try {
            String sql =
                    "INSERT INTO `attendance_db`.`leave` (`empId`, `leaveType`, `leaveDate`) "
                    + "VALUES (?, ?, ?)";

            JDBCConnection jdbc = new JDBCConnection();
            Connection connection = jdbc.getConnection();
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, leave.getEmpId());
            statement.setString(2, leave.getLeaveType());
            Date date = new Date(leave.getLeaveDate().getTime());
            statement.setDate(3, date);
            statement.executeUpdate();
            System.out.println("Leave record created.");
        } catch (SQLException e) {
            System.err.println("Eception when leave created. e:"+e);
        }

    }
    
    public int getLeaveCount(String startDate, String endDate){
        try {
            JDBCConnection jdbc = new JDBCConnection();
            Connection connection = jdbc.getConnection();
            if (!connection.isClosed()) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS le FROM attendance_db.leave WHERE leaveDate BETWEEN '"+startDate+"' AND '"+endDate+"'");
                if (resultSet.next()) {
                    int leaveEmployeeCount = resultSet.getInt("le");
                    return leaveEmployeeCount;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public int getRemainingLeave(int empId){
        
         try {
            JDBCConnection jdbc = new JDBCConnection();
            Connection connection = jdbc.getConnection();
            if (!connection.isClosed()) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS ol FROM `attendance_db`.`leave` WHERE empId = " + empId);
                if (resultSet.next()) {
                    int ol = resultSet.getInt("ol");
                    return ol;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
        
}
