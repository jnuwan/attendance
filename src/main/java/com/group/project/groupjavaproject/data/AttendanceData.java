/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.groupjavaproject.data;

import com.group.project.groupjavaproject.model.Attendance;
import com.group.project.groupjavaproject.service.LoginServiceImpl;
import com.group.project.groupjavaproject.util.JDBCConnection;
import java.sql.Connection;
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
public class AttendanceData {

    public void createAttendance(Attendance attendance) {

        try {
            String sql
                    = "INSERT INTO `attendance_db`.`attendance` (`empId`, `type`, `currentDateTime`) "
                    + "VALUES (?, ?, ?)";

            JDBCConnection jdbc = new JDBCConnection();
            Connection connection = jdbc.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, attendance.getEmpId());
            statement.setString(2, attendance.getType());
            System.out.println("date "+attendance.getCurrentDateTime());
            //Date date = new Date(attendance.getCurrentDateTime().getTime());
            //System.out.println("date "+date);
            statement.setString(3, attendance.getCurrentDateTime());
            statement.executeUpdate();
            System.out.println("Attendance record created.");
        } catch (SQLException e) {
            System.err.println("Eception when attendance created. e:" + e);
        }
    }
    
    public int getAttendCount(String startDate, String endDate){
        try {
            JDBCConnection jdbc = new JDBCConnection();
            Connection connection = jdbc.getConnection();
            if (!connection.isClosed()) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "SELECT COUNT(*) AS ae FROM attendance_db.attendance WHERE `type`= 'Login' AND currentDateTime BETWEEN '"+startDate+"' AND '"+endDate+"'");
                if (resultSet.next()) {
                    int attendEmployeeCount = resultSet.getInt("ae");
                    return attendEmployeeCount;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
