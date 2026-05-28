/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.view;

import javax.swing.*;
import rw.church.model.*;
import rw.church.service.*;

/**
 *
 * @author nshut
 */
public class MemberProfileForm extends javax.swing.JFrame {

    private String currentUsername;

    public MemberProfileForm(String username) {
        initComponents();
        this.currentUsername = username;
        setTitle("My Profile - " + username);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        loadProfile();
        applyStyles();
    }

    private void loadProfile() {
        try {
            java.rmi.registry.Registry registry =
                java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            UserService userService = (UserService)
                registry.lookup("UserService");
            User user = userService.findUserByUsername(currentUsername);
            if (user != null && user.getMember() != null) {
                Member m = user.getMember();
                fullNameTxt.setText(m.getFullName());
                phoneTxt.setText(m.getPhone());
                emailTxt.setText(m.getEmail());
                genderTxt.setText(m.getGender());
                statusTxt.setText(m.getStatus());
                if (m.getCellGroup() != null) {
                    cellGroupTxt.setText(m.getCellGroup().getName());
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Error loading profile: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void applyStyles() {
        getContentPane().setBackground(new java.awt.Color(240, 245, 255));
        jPanel1.setBackground(new java.awt.Color(240, 245, 255));
        titleLabel.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
        titleLabel.setForeground(new java.awt.Color(51, 102, 153));
        closeBtn.setBackground(new java.awt.Color(51, 102, 153));
        closeBtn.setForeground(java.awt.Color.WHITE);
        closeBtn.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        for (javax.swing.JTextField tf : new javax.swing.JTextField[]{
            fullNameTxt, phoneTxt, emailTxt, genderTxt, statusTxt, cellGroupTxt}) {
            tf.setBackground(new java.awt.Color(245, 245, 245));
            tf.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fullNameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        phoneTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        genderTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        statusTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cellGroupTxt = new javax.swing.JTextField();
        closeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        titleLabel.setText("MY PROFILE");
        jPanel1.add(titleLabel);
        titleLabel.setBounds(130, 20, 200, 30);

        jLabel1.setText("Full Name:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 70, 110, 25);

        fullNameTxt.setEditable(false);
        jPanel1.add(fullNameTxt);
        fullNameTxt.setBounds(150, 70, 250, 25);

        jLabel2.setText("Phone:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 110, 110, 25);

        jPanel1.add(phoneTxt);
        phoneTxt.setBounds(150, 110, 250, 25);

        jLabel3.setText("Email:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 150, 110, 25);

        jPanel1.add(emailTxt);
        emailTxt.setBounds(150, 150, 250, 25);

        jLabel4.setText("Gender:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 190, 110, 25);

        genderTxt.setEditable(false);
        jPanel1.add(genderTxt);
        genderTxt.setBounds(150, 190, 250, 25);

        jLabel5.setText("Status:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 230, 110, 25);

        statusTxt.setEditable(false);
        jPanel1.add(statusTxt);
        statusTxt.setBounds(150, 230, 250, 25);

        jLabel6.setText("Cell Group:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 270, 110, 25);

        cellGroupTxt.setEditable(false);
        jPanel1.add(cellGroupTxt);
        cellGroupTxt.setBounds(150, 270, 250, 25);

        closeBtn.setText("Save & Close");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        jPanel1.add(closeBtn);
        closeBtn.setBounds(160, 320, 120, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        try {
            java.rmi.registry.Registry registry =
                java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            rw.church.service.UserService userService =
                (rw.church.service.UserService) registry.lookup("UserService");
            rw.church.model.User user =
                userService.findUserByUsername(currentUsername);
            if (user != null && user.getMember() != null) {
                String phone = phoneTxt.getText().trim();
                String email = emailTxt.getText().trim();
                if (!email.contains("@") || !email.contains(".")) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                        "Invalid email format", "Validation",
                        javax.swing.JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (phone.length() != 10 || !phone.matches("\\d+")) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                        "Phone must be exactly 10 digits", "Validation",
                        javax.swing.JOptionPane.WARNING_MESSAGE);
                    return;
                }
                rw.church.model.Member m = user.getMember();
                m.setPhone(phone);
                m.setEmail(email);
                rw.church.service.MemberService memberService =
                    (rw.church.service.MemberService)
                    registry.lookup("MemberService");
                memberService.updateMember(m);
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Profile updated successfully", "Success",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
            this.dispose();
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Update failed: " + ex.getMessage(), "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_closeBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MemberProfileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberProfileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberProfileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberProfileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberProfileForm("demo").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cellGroupTxt;
    private javax.swing.JButton closeBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField fullNameTxt;
    private javax.swing.JTextField genderTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JTextField statusTxt;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
