/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.groupjavaproject.data;

import com.group.project.groupjavaproject.model.Employee;
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
public class EmployeeData {

    public void createEmployee(Employee employee) {

        try {
            String sql
                    = "INSERT INTO `attendance_db`.`employee` (`empId`, `firstName`, `lastName`, `dob`, `type`, `password`) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            JDBCConnection jdbc = new JDBCConnection();
            Connection connection = jdbc.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getEmpId());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            Date date = new Date(employee.getDob().getTime());
            statement.setDate(4, date);
            statement.setString(5, employee.getType());
            statement.setString(6, employee.getPassword());
            statement.executeUpdate();
            System.out.println("Employee record created.");
        } catch (SQLException e) {
            System.err.println("Eception when employee created. e:" + e);
        }
    }

    public int getAllEmployeeCount() {
        try {
            JDBCConnection jdbc = new JDBCConnection();
            Connection connection = jdbc.getConnection();
            if (!connection.isClosed()) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS ne FROM attendance_db.employee");
                if (resultSet.next()) {
                    int numberOfEmployee = resultSet.getInt("ne");
                    return numberOfEmployee;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

}
