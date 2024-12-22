/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.groupjavaproject.service;

import com.group.project.groupjavaproject.data.AttendanceData;
import com.group.project.groupjavaproject.model.Attendance;
import com.group.project.groupjavaproject.model.Employee;
import com.group.project.groupjavaproject.util.EncryptPassword;
import com.group.project.groupjavaproject.util.JDBCConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class LoginServiceImpl implements LoginService {

    @Override
    public Employee getUserbyUsername(String username) {

        try {
            JDBCConnection jdbc = new JDBCConnection();
            Connection connection = jdbc.getConnection();
            if (!connection.isClosed()) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM employee WHERE empId = " + username);
                return createEmployeeObject(resultSet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean verifyUser(Employee employee, String username, String password) {
        String encPassword = new EncryptPassword().encryptedPassword(password);
        return employee.getEmpId().equals(username) && employee.getPassword().equals(encPassword);
    }

    private Employee createEmployeeObject(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            Employee employee = new Employee(
                    resultSet.getInt("id"),
                    resultSet.getString("empId"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getDate("dob"),
                    resultSet.getString("type"),
                    resultSet.getString("password"));
            return employee;
        }
        return null;
    }

    @Override
    public void updateAttendance(Employee employee) {
        Attendance attendance = new Attendance();
        attendance.setEmpId(employee.getId());
        attendance.setType("Login");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        Date date = new Date();
        attendance.setCurrentDateTime(formatter.format(date));
        new AttendanceData().createAttendance(attendance);
    }
}
