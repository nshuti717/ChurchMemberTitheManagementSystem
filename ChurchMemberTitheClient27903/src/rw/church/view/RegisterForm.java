/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import rw.church.model.*;
import rw.church.service.*;

/**
 *
 * @author nshut
 */
public class RegisterForm extends javax.swing.JFrame {

    private java.util.List<rw.church.model.CellGroup> cellGroups;

    public RegisterForm() {
        initComponents();
        setTitle("Church Member & Tithe System - Register");
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        loadCellGroups();
        applyStyles();
    }

    private void loadCellGroups() {
        try {
            java.rmi.registry.Registry registry =
                java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            CellGroupService service = (CellGroupService)
                registry.lookup("CellGroupService");
            cellGroups = service.findAllCellGroups();
            cellGroupCombo.removeAllItems();
            for (rw.church.model.CellGroup cg : cellGroups) {
                cellGroupCombo.addItem(cg.getName() + "|" + cg.getId());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Cannot connect to server: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void applyStyles() {
        getContentPane().setBackground(new java.awt.Color(240, 245, 255));
        jPanel1.setBackground(new java.awt.Color(240, 245, 255));
        titleLabel.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
        titleLabel.setForeground(new java.awt.Color(51, 102, 153));
        registerBtn.setBackground(new java.awt.Color(51, 102, 153));
        registerBtn.setForeground(java.awt.Color.WHITE);
        registerBtn.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        registerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.setBackground(new java.awt.Color(153, 51, 51));
        cancelBtn.setForeground(java.awt.Color.WHITE);
        cancelBtn.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fullNameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        phoneTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        genderCombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cellGroupCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        usernameTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        registerBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        titleLabel.setText("MEMBER REGISTRATION");
        jPanel1.add(titleLabel);
        titleLabel.setBounds(150, 20, 300, 30);

        jLabel2.setText("Full Name:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 70, 100, 25);

        jPanel1.add(fullNameTxt);
        fullNameTxt.setBounds(160, 70, 250, 25);

        jLabel3.setText("Phone:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 110, 100, 25);

        jPanel1.add(phoneTxt);
        phoneTxt.setBounds(160, 110, 250, 25);

        jLabel4.setText("Email:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 150, 100, 25);

        jPanel1.add(emailTxt);
        emailTxt.setBounds(160, 150, 250, 25);

        jLabel5.setText("Gender:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 190, 100, 25);

        genderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel1.add(genderCombo);
        genderCombo.setBounds(160, 190, 250, 25);

        jLabel6.setText("Cell Group:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 230, 100, 25);

        jPanel1.add(cellGroupCombo);
        cellGroupCombo.setBounds(160, 230, 250, 25);

        jLabel7.setText("Username:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 270, 100, 25);

        jPanel1.add(usernameTxt);
        usernameTxt.setBounds(160, 270, 250, 25);

        jLabel8.setText("Password:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(50, 310, 100, 25);

        jPanel1.add(passwordField);
        passwordField.setBounds(160, 310, 250, 25);

        registerBtn.setText("Register");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });
        jPanel1.add(registerBtn);
        registerBtn.setBounds(120, 360, 120, 30);

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        jPanel1.add(cancelBtn);
        cancelBtn.setBounds(280, 360, 120, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerBtnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        // Validation
        String fullName = fullNameTxt.getText().trim();
        String phone = phoneTxt.getText().trim();
        String email = emailTxt.getText().trim();
        String username = usernameTxt.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String gender = (String) genderCombo.getSelectedItem();

        if (fullName.isEmpty() || phone.isEmpty() || email.isEmpty()
            || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "All fields are required", "Validation",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(this,
                "Invalid email format", "Validation",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (phone.length() != 10 || !phone.matches("\\d+")) {
            JOptionPane.showMessageDialog(this,
                "Phone must be exactly 10 digits", "Validation",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (password.length() < 4) {
            JOptionPane.showMessageDialog(this,
                "Password must be at least 4 characters", "Validation",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            java.rmi.registry.Registry registry =
                java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);

            // Get selected cell group
            String selected = (String) cellGroupCombo.getSelectedItem();
            int cellGroupId = Integer.parseInt(selected.split("\\|")[1]);
            rw.church.model.CellGroup cg = new rw.church.model.CellGroup();
            cg.setId(cellGroupId);

            // Create Member
            rw.church.model.Member member = new rw.church.model.Member();
            member.setFullName(fullName);
            member.setPhone(phone);
            member.setEmail(email);
            member.setGender(gender);
            member.setStatus("Active");
            member.setCellGroup(cg);

            MemberService memberService = (MemberService)
                registry.lookup("MemberService");
            rw.church.model.Member savedMember =
                memberService.saveMember(member);

            // Create User account linked to the new Member
            rw.church.model.User user = new rw.church.model.User();
            user.setUsername(username);
            user.setPassword(password);
            user.setRole("User");
            user.setMember(savedMember);

            UserService userService = (UserService)
                registry.lookup("UserService");
            userService.saveUser(user);

            JOptionPane.showMessageDialog(this,
                "Registration successful!\nWelcome email sent to: "
                + email + "\nYou can now login.",
                "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Registration failed: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registerBtnActionPerformed

    private void cancelBtnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JComboBox<String> cellGroupCombo;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField fullNameTxt;
    private javax.swing.JComboBox<String> genderCombo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JButton registerBtn;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
