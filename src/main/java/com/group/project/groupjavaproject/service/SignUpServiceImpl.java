/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.groupjavaproject.service;

import com.group.project.groupjavaproject.data.EmployeeData;
import com.group.project.groupjavaproject.model.Employee;

/**
 *
 * @author user
 */
public class SignUpServiceImpl implements SignUpService{

    @Override
    public void createEmployee(Employee employee) {
        new EmployeeData().createEmployee(employee);
    }
    
}
