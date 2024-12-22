/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.groupjavaproject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class JDBCConnection {

    Connection connection;

    public Connection getConnection() {
        try {
            if (null != connection && !connection.isClosed()) {
                System.out.println("Returning existing connection.");
                return connection;
            }
            ////Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_db", "root", "root");
            System.out.println("COnnection is ready.");
        } catch (SQLException e) {
            System.out.println("Exception : " + e);
        }
        return connection;
    }
}
