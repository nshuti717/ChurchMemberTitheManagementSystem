/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.view;

/**
 *
 * @author nshut
 */
public class MemberModule extends javax.swing.JFrame {
    private javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel();
    /**
     * Creates new form MemberModule
     */
    private javax.swing.JButton backBtn;

    public MemberModule() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Member Management");
        loadCellGroups();
        addColumnsToTable();
        loadAllMembers();
        getContentPane().setBackground(new java.awt.Color(240, 245, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
        jLabel1.setForeground(new java.awt.Color(51, 102, 153));
        for (javax.swing.JLabel lbl : new javax.swing.JLabel[]{jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7}) {
            lbl.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
        }
        for (javax.swing.JButton btn : new javax.swing.JButton[]{saveBtn, updateBtn, deleteBtn, clearBtn}) {
            btn.setBackground(new java.awt.Color(51, 102, 153));
            btn.setForeground(java.awt.Color.WHITE);
            btn.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
            btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
        for (javax.swing.JTextField tf : new javax.swing.JTextField[]{fullNameTxt, phoneTxt, emailTxt}) {
            tf.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
            tf.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 153)),
                javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)));
        }
        backBtn = new javax.swing.JButton("Back to Dashboard");
        backBtn.setBackground(new java.awt.Color(51, 102, 153));
        backBtn.setForeground(java.awt.Color.WHITE);
        backBtn.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        javax.swing.JPanel mainWrapper = new javax.swing.JPanel(new java.awt.BorderLayout());
        mainWrapper.setBackground(new java.awt.Color(240, 245, 255));
        mainWrapper.add(getContentPane(), java.awt.BorderLayout.CENTER);
        mainWrapper.add(backBtn, java.awt.BorderLayout.SOUTH);
        setContentPane(mainWrapper);
        pack();
    }

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }
    private void addColumnsToTable() {
        tableModel.addColumn("ID");
        tableModel.addColumn("FULL NAME");
        tableModel.addColumn("PHONE");
        tableModel.addColumn("EMAIL");
        tableModel.addColumn("GENDER");
        tableModel.addColumn("STATUS");
        tableModel.addColumn("CELL GROUP");
        memberTable.setModel(tableModel);
    }

    private void loadCellGroups() {
        try {
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            rw.church.service.CellGroupService service = (rw.church.service.CellGroupService) registry.lookup("CellGroupService");
            java.util.List<rw.church.model.CellGroup> list = service.findAllCellGroups();
            cellGroupCombo.removeAllItems();
            for (rw.church.model.CellGroup cg : list) {
                cellGroupCombo.addItem(cg.getName() + "|" + cg.getId());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadAllMembers() {
        try {
            tableModel.setRowCount(0);
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            rw.church.service.MemberService service = (rw.church.service.MemberService) registry.lookup("MemberService");
            java.util.List<rw.church.model.Member> list = service.findAllMembers();
            for (rw.church.model.Member m : list) {
                tableModel.addRow(new Object[]{
                    m.getId(),
                    m.getFullName(),
                    m.getPhone(),
                    m.getEmail(),
                    m.getGender(),
                    m.getStatus(),
                    m.getCellGroup() != null ? m.getCellGroup().getName() : ""
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fullNameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        phoneTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        genderCombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        statusCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cellGroupCombo = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Member Management");

        jLabel2.setText("Full Name:");

        jLabel3.setText("Phone:");

        jLabel4.setText("Email:");

        jLabel5.setText("Gender:");

        genderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", " ", " ", " " }));
        genderCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderComboActionPerformed(evt);
            }
        });

        jLabel6.setText("Status:");

        statusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));

        jLabel7.setText("Cell Group:");

        cellGroupCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cellGroupCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cellGroupComboActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear ");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        memberTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        memberTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memberTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(memberTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fullNameTxt)
                            .addComponent(phoneTxt)
                            .addComponent(emailTxt)
                            .addComponent(genderCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(statusCombo, 0, 120, Short.MAX_VALUE)
                            .addComponent(cellGroupCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(86, 86, 86)
                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(fullNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cellGroupCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(updateBtn)
                    .addComponent(deleteBtn)
                    .addComponent(clearBtn))
                .addGap(84, 84, 84)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void genderComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderComboActionPerformed

    private void cellGroupComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cellGroupComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cellGroupComboActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        try {
            String fullName = fullNameTxt.getText().trim();
            String phone = phoneTxt.getText().trim();
            String email = emailTxt.getText().trim();

            if (fullName.isEmpty() || phone.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Full Name and Phone are required", "Validation Error", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!phone.matches("\\d{10}")) {
                javax.swing.JOptionPane.showMessageDialog(this, "Phone must be exactly 10 digits", "Validation Error", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            String selectedCG = (String) cellGroupCombo.getSelectedItem();
            int cellGroupId = Integer.parseInt(selectedCG.split("\\|")[1]);

            rw.church.model.CellGroup cg = new rw.church.model.CellGroup();
            cg.setId(cellGroupId);

            rw.church.model.Member member = new rw.church.model.Member();
            member.setFullName(fullName);
            member.setPhone(phone);
            member.setEmail(email);
            member.setGender((String) genderCombo.getSelectedItem());
            member.setStatus((String) statusCombo.getSelectedItem());
            member.setCellGroup(cg);
            
            
            // TECHNICAL RULE 1: Required fields cannot be empty
if (fullNameTxt.getText().trim().isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(this, "Full Name is required",
    "Validation", javax.swing.JOptionPane.WARNING_MESSAGE); return;
}

// TECHNICAL RULE 2: Phone must be exactly 10 digits
phone = phoneTxt.getText().trim();
if (!phone.matches("\\d{10}")) {
    javax.swing.JOptionPane.showMessageDialog(this, "Phone must be exactly 10 digits",
    "Validation", javax.swing.JOptionPane.WARNING_MESSAGE); return;
}

// TECHNICAL RULE 3: Email must contain @ and .
email = emailTxt.getText().trim();
if (!email.isEmpty() && (!email.contains("@") || !email.contains("."))) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please enter a valid email address",
    "Validation", javax.swing.JOptionPane.WARNING_MESSAGE); return;
}

// BUSINESS RULE 1: Phone number must be unique
try {
    java.rmi.registry.Registry regCheck = java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
    rw.church.service.MemberService svcCheck = (rw.church.service.MemberService) regCheck.lookup("MemberService");
    java.util.List<rw.church.model.Member> allMembers = svcCheck.findAllMembers();
    for (rw.church.model.Member existing : allMembers) {
        if (existing.getPhone().equals(phone)) {
            javax.swing.JOptionPane.showMessageDialog(this, "This phone number is already registered",
            "Validation", javax.swing.JOptionPane.WARNING_MESSAGE); return;
        }
    }
} catch (Exception checkEx) { checkEx.printStackTrace(); } 
            
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            rw.church.service.MemberService service = (rw.church.service.MemberService) registry.lookup("MemberService");
            service.saveMember(member);

            javax.swing.JOptionPane.showMessageDialog(this, "Member saved successfully", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            loadAllMembers();
            clearFields();

        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_saveBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = memberTable.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a member to update", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            String fullName = fullNameTxt.getText().trim();
            String phone = phoneTxt.getText().trim();

            if (fullName.isEmpty() || phone.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Full Name and Phone are required", "Validation Error", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            String selectedCG = (String) cellGroupCombo.getSelectedItem();
            int cellGroupId = Integer.parseInt(selectedCG.split("\\|")[1]);
            rw.church.model.CellGroup cg = new rw.church.model.CellGroup();
            cg.setId(cellGroupId);

            rw.church.model.Member member = new rw.church.model.Member();
            member.setId(id);
            member.setFullName(fullName);
            member.setPhone(phone);
            member.setEmail(emailTxt.getText().trim());
            member.setGender((String) genderCombo.getSelectedItem());
            member.setStatus((String) statusCombo.getSelectedItem());
            member.setCellGroup(cg);

            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            rw.church.service.MemberService service = (rw.church.service.MemberService) registry.lookup("MemberService");
            service.updateMember(member);

            javax.swing.JOptionPane.showMessageDialog(this, "Member updated successfully", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            loadAllMembers();
            clearFields();

        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = memberTable.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a member to delete", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this member?", "Confirm Delete", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm != javax.swing.JOptionPane.YES_OPTION) return;

        try {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            rw.church.model.Member member = new rw.church.model.Member();
            member.setId(id);

            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            rw.church.service.MemberService service = (rw.church.service.MemberService) registry.lookup("MemberService");
            service.deleteMember(member);

            javax.swing.JOptionPane.showMessageDialog(this, "Member deleted successfully", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            loadAllMembers();

        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void memberTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberTableMouseClicked
        // TODO add your handling code here:
        int selectedRow = memberTable.getSelectedRow();
        if (selectedRow != -1) {
            fullNameTxt.setText(tableModel.getValueAt(selectedRow, 1).toString());
            phoneTxt.setText(tableModel.getValueAt(selectedRow, 2).toString());
            emailTxt.setText(tableModel.getValueAt(selectedRow, 3).toString());
        } 
    }//GEN-LAST:event_memberTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MemberModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberModule().setVisible(true);
            }
        });
    }
    private void clearFields() {
        fullNameTxt.setText("");
        phoneTxt.setText("");
        emailTxt.setText("");
        genderCombo.setSelectedIndex(0);
        statusCombo.setSelectedIndex(0);
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cellGroupCombo;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField fullNameTxt;
    private javax.swing.JComboBox<String> genderCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable memberTable;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JComboBox<String> statusCombo;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
