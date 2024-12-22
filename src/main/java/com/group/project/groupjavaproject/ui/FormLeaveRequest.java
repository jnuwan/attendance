/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.group.project.groupjavaproject.ui;

import com.group.project.groupjavaproject.App;
import com.group.project.groupjavaproject.data.LeaveData;
import com.group.project.groupjavaproject.model.Leave;
import com.group.project.groupjavaproject.util.Constant;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class FormLeaveRequest extends javax.swing.JInternalFrame {

    private App app;
    private JDesktopPane deskPane;

    private LeaveData laveData = new LeaveData();

    /**
     * Creates new form FormLeaveRequest
     */
    public FormLeaveRequest(JDesktopPane deskPane, App app) {
        initComponents();
        this.deskPane = deskPane;
        this.app = app;
        txtEmpId.setText(app.getEmployee().getEmpId());
        setEmployeeLeaveData();
    }

    private void setEmployeeLeaveData() {
        int maxLeave = Constant.MAX_LEAVE;
        int leaveCount = laveData.getRemainingLeave(this.app.getEmployee().getId());
        int remainingLeave = maxLeave;
        if (leaveCount > 0) {
            remainingLeave = maxLeave - leaveCount;
        }
        lblAllowed.setText(String.valueOf(maxLeave));
        lblRemaining.setText(String.valueOf(remainingLeave));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtEmpId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLeaveDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblAllowed = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblRemaining = new javax.swing.JLabel();
        btnApply = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Apply Leave");

        jLabel1.setText("Employ ID :");

        txtEmpId.setEnabled(false);

        jLabel2.setText("Leave Request Date :");

        txtLeaveDate.setToolTipText("yyyy-mm-dd");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Max. Allowed Leaves: ");

        lblAllowed.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAllowed.setText("0");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Remaining Leaves:");

        lblRemaining.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRemaining.setText("0");

        btnApply.setText("Apply");
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        jLabel4.setText("Leave Type :");

        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sick Leave", "Annual Leave", "Birthday Leave", "Annivesary Leave" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnApply)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmpId)
                            .addComponent(txtLeaveDate)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAllowed)
                                    .addComponent(lblRemaining))
                                .addGap(0, 293, Short.MAX_VALUE))
                            .addComponent(cmbType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLeaveDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblAllowed))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblRemaining))
                .addGap(18, 18, 18)
                .addComponent(btnApply)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        try {
            // TODO add your handling code here:
            String leaveDateStr = txtLeaveDate.getText();
            String leaveType = cmbType.getSelectedItem().toString();

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            Date leaveDate = formatter.parse(leaveDateStr);
            if (date.before(leaveDate)) {
                Leave leave = new Leave(this.app.getEmployee().getId(), leaveType, leaveDate);
                laveData.createLeave(leave);
                JOptionPane.showMessageDialog(deskPane, "Leave request success.");
                setEmployeeLeaveData();
            } else {
                JOptionPane.showMessageDialog(deskPane, "Invalid leave date. Please check and apply again.");
            }

//        attendance.setCurrentDateTime(formatter.parse(date));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(deskPane, "Invalid leave date. Please check and apply again.");
        }
    }//GEN-LAST:event_btnApplyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAllowed;
    private javax.swing.JLabel lblRemaining;
    private javax.swing.JTextField txtEmpId;
    private javax.swing.JTextField txtLeaveDate;
    // End of variables declaration//GEN-END:variables
}
