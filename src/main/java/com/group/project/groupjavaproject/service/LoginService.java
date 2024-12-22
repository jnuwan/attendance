/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.groupjavaproject.service;

import com.group.project.groupjavaproject.model.Employee;

/**
 *
 * @author user
 */
public interface LoginService {
    
    Employee getUserbyUsername(String username);
    
    boolean verifyUser(Employee employee, String username, String password); 
    
    void updateAttendance(Employee employee);
}
