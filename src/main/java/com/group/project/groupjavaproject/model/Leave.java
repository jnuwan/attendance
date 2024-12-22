/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.project.groupjavaproject.model;

import java.util.Date;

/**
 *
 * @author user
 */
public class Leave {
    
    private int id;
    private int empId;
    private String leaveType;
    private Date leaveDate;

    public Leave(int empId, String leaveType, Date leaveDate) {
        this.empId = empId;
        this.leaveType = leaveType;
        this.leaveDate = leaveDate;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }
    
}
