/*
 * Church Member & Tithe System — Service Module
 */
package rw.church.view;

public class ServiceModule extends javax.swing.JFrame {
    private javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel();
    private javax.swing.JButton backBtn;

    // Date dropdown fields (outside GEN block)
    private javax.swing.JComboBox<String> dayCombo;
    private javax.swing.JComboBox<String> monthCombo;
    private javax.swing.JComboBox<String> yearCombo;

    public ServiceModule() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Church Service Management");
        addColumnsToTable();
        loadAllServices();

        // Styling
        getContentPane().setBackground(new java.awt.Color(240, 245, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
        jLabel1.setForeground(new java.awt.Color(51, 102, 153));
        for (javax.swing.JLabel lbl : new javax.swing.JLabel[]{jLabel2, jLabel3, jLabel4}) {
            lbl.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
        }
        for (javax.swing.JButton btn : new javax.swing.JButton[]{saveBtn, updateBtn, deleteBtn}) {
            btn.setBackground(new java.awt.Color(51, 102, 153));
            btn.setForeground(java.awt.Color.WHITE);
            btn.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
            btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
        descriptionTxt.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
        descriptionTxt.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 153)),
            javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)));
        for (javax.swing.JComboBox<?> cb : new javax.swing.JComboBox[]{dayCombo, monthCombo, yearCombo}) {
            cb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
        }

        backBtn = new javax.swing.JButton("Back to Dashboard");
        backBtn.setBackground(new java.awt.Color(51, 102, 153));
        backBtn.setForeground(java.awt.Color.WHITE);
        backBtn.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addActionListener(evt -> this.dispose());
        javax.swing.JPanel mainWrapper = new javax.swing.JPanel(new java.awt.BorderLayout());
        mainWrapper.setBackground(new java.awt.Color(240, 245, 255));
        mainWrapper.add(getContentPane(), java.awt.BorderLayout.CENTER);
        mainWrapper.add(backBtn, java.awt.BorderLayout.SOUTH);
        setContentPane(mainWrapper);
        pack();
    }

    /** Build a date string from the three dropdowns */
    private String getSelectedDateString() {
        return yearCombo.getSelectedItem() + "-"
             + monthCombo.getSelectedItem() + "-"
             + dayCombo.getSelectedItem();
    }

    /** Set the three date combos from a Date object */
    private void setDateCombos(java.util.Date date) {
        java.text.SimpleDateFormat ySdf = new java.text.SimpleDateFormat("yyyy");
        java.text.SimpleDateFormat mSdf = new java.text.SimpleDateFormat("MM");
        java.text.SimpleDateFormat dSdf = new java.text.SimpleDateFormat("dd");
        yearCombo.setSelectedItem(ySdf.format(date));
        monthCombo.setSelectedItem(mSdf.format(date));
        dayCombo.setSelectedItem(dSdf.format(date));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        serviceTypeCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        descriptionTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        // Date dropdowns
        dayCombo   = new javax.swing.JComboBox<>();
        monthCombo = new javax.swing.JComboBox<>();
        yearCombo  = new javax.swing.JComboBox<>();

        saveBtn   = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        serviceTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Church Service Management");
        jLabel2.setText("Service Type:");
        serviceTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"Sunday Service", "Midweek Service", "Special Service"}));

        jLabel3.setText("Description:");
        jLabel4.setText("Date:");

        // Day combo (01-31)
        javax.swing.DefaultComboBoxModel<String> dayModel = new javax.swing.DefaultComboBoxModel<>();
        for (int d = 1; d <= 31; d++) dayModel.addElement(String.format("%02d", d));
        dayCombo.setModel(dayModel);

        // Month combo (01-12)
        monthCombo.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"01","02","03","04","05","06","07","08","09","10","11","12"}));

        // Year combo (2024-2028)
        yearCombo.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"2024","2025","2026","2027","2028"}));

        // Default to today
        java.util.Calendar cal = java.util.Calendar.getInstance();
        dayCombo.setSelectedIndex(cal.get(java.util.Calendar.DAY_OF_MONTH) - 1);
        monthCombo.setSelectedIndex(cal.get(java.util.Calendar.MONTH));
        yearCombo.setSelectedItem(String.valueOf(cal.get(java.util.Calendar.YEAR)));

        saveBtn.setText("Save");
        saveBtn.addActionListener(evt -> saveBtnActionPerformed(evt));

        updateBtn.setText("Update");
        updateBtn.addActionListener(evt -> updateBtnActionPerformed(evt));

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(evt -> deleteBtnActionPerformed(evt));

        serviceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{{null,null,null,null},{null,null,null,null}},
            new String[]{"Title 1","Title 2","Title 3","Title 4"}
        ));
        serviceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serviceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(serviceTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(serviceTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(descriptionTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4)
                                        .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4)
                                        .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(saveBtn)
                        .addGap(69, 69, 69)
                        .addComponent(updateBtn)
                        .addGap(76, 76, 76)
                        .addComponent(deleteBtn)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(serviceTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(descriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(updateBtn)
                    .addComponent(deleteBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int selectedRow = serviceTable.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Please select a service to delete", "Warning",
                javax.swing.JOptionPane.WARNING_MESSAGE); return;
        }
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
            "Delete this service?", "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm != javax.swing.JOptionPane.YES_OPTION) return;
        try {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            rw.church.model.Service srv = new rw.church.model.Service();
            srv.setId(id);
            java.rmi.registry.Registry registry =
                java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            rw.church.service.ChurchServiceService service =
                (rw.church.service.ChurchServiceService) registry.lookup("ChurchServiceService");
            service.deleteChurchService(srv);
            javax.swing.JOptionPane.showMessageDialog(this,
                "Deleted successfully", "Success",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
            loadAllServices();
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage(), "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            String description = descriptionTxt.getText().trim();
            String dateStr = getSelectedDateString();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            java.util.Date date;
            try {
                date = sdf.parse(dateStr);
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Invalid date: day does not exist in the chosen month", "Validation",
                    javax.swing.JOptionPane.WARNING_MESSAGE); return;
            }

            rw.church.model.Service srv = new rw.church.model.Service();
            srv.setServiceType((String) serviceTypeCombo.getSelectedItem());
            srv.setDescription(description);
            srv.setServiceDate(date);

            java.rmi.registry.Registry registry =
                java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            rw.church.service.ChurchServiceService service =
                (rw.church.service.ChurchServiceService) registry.lookup("ChurchServiceService");
            service.saveChurchService(srv);

            javax.swing.JOptionPane.showMessageDialog(this,
                "Service saved successfully", "Success",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
            loadAllServices();
            descriptionTxt.setText("");
            serviceTypeCombo.setSelectedIndex(0);
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage(), "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        int selectedRow = serviceTable.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Please select a service to update", "Warning",
                javax.swing.JOptionPane.WARNING_MESSAGE); return;
        }
        try {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            String dateStr = getSelectedDateString();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            java.util.Date date;
            try {
                date = sdf.parse(dateStr);
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Invalid date selected", "Validation",
                    javax.swing.JOptionPane.WARNING_MESSAGE); return;
            }

            rw.church.model.Service srv = new rw.church.model.Service();
            srv.setId(id);
            srv.setServiceType((String) serviceTypeCombo.getSelectedItem());
            srv.setDescription(descriptionTxt.getText().trim());
            srv.setServiceDate(date);

            java.rmi.registry.Registry registry =
                java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            rw.church.service.ChurchServiceService service =
                (rw.church.service.ChurchServiceService) registry.lookup("ChurchServiceService");
            service.updateChurchService(srv);

            javax.swing.JOptionPane.showMessageDialog(this,
                "Service updated successfully", "Success",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
            loadAllServices();
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage(), "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void serviceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceTableMouseClicked
        int selectedRow = serviceTable.getSelectedRow();
        if (selectedRow != -1) {
            descriptionTxt.setText((String) tableModel.getValueAt(selectedRow, 2));
            Object dateVal = tableModel.getValueAt(selectedRow, 3);
            if (dateVal != null) {
                try {
                    java.util.Date d = (java.util.Date) dateVal;
                    setDateCombos(d);
                } catch (Exception ex) { /* ignore */ }
            }
        }
    }//GEN-LAST:event_serviceTableMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName()); break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ServiceModule.class.getName())
                .log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new ServiceModule().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField descriptionTxt;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTable serviceTable;
    private javax.swing.JComboBox<String> serviceTypeCombo;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

    private void addColumnsToTable() {
        tableModel.addColumn("ID");
        tableModel.addColumn("TYPE");
        tableModel.addColumn("DESCRIPTION");
        tableModel.addColumn("DATE");
        serviceTable.setModel(tableModel);
    }

    private void loadAllServices() {
        try {
            tableModel.setRowCount(0);
            java.rmi.registry.Registry registry =
                java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            rw.church.service.ChurchServiceService service =
                (rw.church.service.ChurchServiceService) registry.lookup("ChurchServiceService");
            java.util.List<rw.church.model.Service> list = service.findAllChurchServices();
            for (rw.church.model.Service s : list) {
                tableModel.addRow(new Object[]{
                    s.getId(), s.getServiceType(), s.getDescription(), s.getServiceDate()
                });
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}
