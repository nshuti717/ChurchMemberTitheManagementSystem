/*
 * Church Member & Tithe System — Contribution Module
 */
package rw.church.view;

public class ContributionModule extends javax.swing.JFrame {

    private javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel();
    private String currentUsername;
    private javax.swing.JButton backBtn;

    // Date dropdown fields (outside GEN block)
    private javax.swing.JComboBox<String> dayCombo;
    private javax.swing.JComboBox<String> monthCombo;
    private javax.swing.JComboBox<String> yearCombo;

    /** No-arg constructor (used when no user context available) */
    public ContributionModule() {
        this(null);
    }

    /** Constructor with logged-in username for member pre-selection */
    public ContributionModule(String username) {
        this.currentUsername = username;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Contribution Management");
        addColumnsToTable();
        loadMembers();
        loadServices();
        loadAllContributions();
        preselectLoggedInMember();

        // Styling
        getContentPane().setBackground(new java.awt.Color(240, 245, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
        jLabel1.setForeground(new java.awt.Color(51, 102, 153));
        for (javax.swing.JLabel lbl : new javax.swing.JLabel[]{jLabel2, jLabel3, jLabel4, jLabel5, jLabel6}) {
            lbl.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
        }
        for (javax.swing.JButton btn : new javax.swing.JButton[]{saveBtn, deleteBtn}) {
            btn.setBackground(new java.awt.Color(51, 102, 153));
            btn.setForeground(java.awt.Color.WHITE);
            btn.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
            btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
        amountTxt.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
        amountTxt.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 153)),
            javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)));
        for (javax.swing.JComboBox<?> cb : new javax.swing.JComboBox[]{dayCombo, monthCombo, yearCombo}) {
            cb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
        }

        // Back button
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

    /** Auto-select the member that belongs to the logged-in user */
    private void preselectLoggedInMember() {
        if (currentUsername == null || currentUsername.isEmpty()) return;
        try {
            java.rmi.registry.Registry registry =
                java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            rw.church.service.UserService userService =
                (rw.church.service.UserService) registry.lookup("UserService");
            rw.church.model.User user = userService.findUserByUsername(currentUsername);
            if (user != null && user.getMember() != null) {
                String targetName = user.getMember().getFullName();
                for (int i = 0; i < memberCombo.getItemCount(); i++) {
                    String item = memberCombo.getItemAt(i);
                    if (item.startsWith(targetName + "|")) {
                        memberCombo.setSelectedIndex(i);
                        break;
                    }
                }
            }
        } catch (Exception ex) { /* silent — combo stays at index 0 */ }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        memberCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        serviceCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        typeCombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        amountTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        // Date dropdowns
        dayCombo   = new javax.swing.JComboBox<>();
        monthCombo = new javax.swing.JComboBox<>();
        yearCombo  = new javax.swing.JComboBox<>();

        jScrollPane1 = new javax.swing.JScrollPane();
        contributionTable = new javax.swing.JTable();
        saveBtn   = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("CONTRIBUTION MANAGEMENT");
        jLabel2.setText("Member:");
        memberCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1"}));

        jLabel3.setText("Service:");
        serviceCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1"}));
        serviceCombo.addActionListener(evt -> serviceComboActionPerformed(evt));

        jLabel4.setText("Type:");
        typeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Tithe", "Offering", "Special"}));

        jLabel5.setText("Amount (RWF):");
        jLabel6.setText("Date:");

        // --- Populate day combo (01-31) ---
        javax.swing.DefaultComboBoxModel<String> dayModel = new javax.swing.DefaultComboBoxModel<>();
        for (int d = 1; d <= 31; d++) dayModel.addElement(String.format("%02d", d));
        dayCombo.setModel(dayModel);

        // --- Populate month combo ---
        monthCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "01","02","03","04","05","06","07","08","09","10","11","12"}));

        // --- Populate year combo (2024–2028) ---
        yearCombo.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"2024","2025","2026","2027","2028"}));

        // Default to today
        java.util.Calendar cal = java.util.Calendar.getInstance();
        dayCombo.setSelectedIndex(cal.get(java.util.Calendar.DAY_OF_MONTH) - 1);
        monthCombo.setSelectedIndex(cal.get(java.util.Calendar.MONTH));
        yearCombo.setSelectedItem(String.valueOf(cal.get(java.util.Calendar.YEAR)));

        contributionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{{null,null,null,null},{null,null,null,null}},
            new String[]{"Title 1","Title 2","Title 3","Title 4"}
        ));
        jScrollPane1.setViewportView(contributionTable);

        saveBtn.setText("Save");
        saveBtn.addActionListener(evt -> saveBtnActionPerformed(evt));

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(evt -> deleteBtnActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(memberCombo, 0, 180, Short.MAX_VALUE)
                            .addComponent(serviceCombo, 0, 180, Short.MAX_VALUE)
                            .addComponent(typeCombo, 0, 99, Short.MAX_VALUE)
                            .addComponent(amountTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(saveBtn)
                        .addGap(137, 137, 137)
                        .addComponent(deleteBtn)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(memberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(serviceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(amountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(deleteBtn))
                .addGap(85, 85, 85)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void serviceComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceComboActionPerformed
    }//GEN-LAST:event_serviceComboActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            // TECHNICAL RULE 4: Amount must be a valid number
            double amount;
            try {
                amount = Double.parseDouble(amountTxt.getText().trim());
            } catch (NumberFormatException nfe) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Amount must be a valid number", "Validation",
                    javax.swing.JOptionPane.WARNING_MESSAGE); return;
            }

            // BUSINESS RULE 2: Amount must be positive
            if (amount <= 0) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Amount must be greater than zero", "Validation",
                    javax.swing.JOptionPane.WARNING_MESSAGE); return;
            }

            // TECHNICAL RULE 5: Build & validate date from dropdowns
            String dayStr   = (String) dayCombo.getSelectedItem();
            String monthStr = (String) monthCombo.getSelectedItem();
            String yearStr  = (String) yearCombo.getSelectedItem();
            String dateStr  = yearStr + "-" + monthStr + "-" + dayStr;
            java.util.Date contribDate;
            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                sdf.setLenient(false);
                contribDate = sdf.parse(dateStr);
            } catch (Exception dateEx) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Invalid date: day " + dayStr + " does not exist in month " + monthStr,
                    "Validation", javax.swing.JOptionPane.WARNING_MESSAGE); return;
            }

            // BUSINESS RULE 3: Date cannot be in the future
            if (contribDate.after(new java.util.Date())) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Contribution date cannot be in the future", "Validation",
                    javax.swing.JOptionPane.WARNING_MESSAGE); return;
            }

            // BUSINESS RULE 4: Member must be Active
            String selectedMemberStr = (String) memberCombo.getSelectedItem();
            int memberId = Integer.parseInt(selectedMemberStr.split("\\|")[1]);
            try {
                java.rmi.registry.Registry regCheck = java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
                rw.church.service.MemberService mSvc =
                    (rw.church.service.MemberService) regCheck.lookup("MemberService");
                rw.church.model.Member mCheck = new rw.church.model.Member();
                mCheck.setId(memberId);
                rw.church.model.Member foundMember = mSvc.findMemberById(mCheck);
                if (foundMember != null && !"Active".equals(foundMember.getStatus())) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                        "Only Active members can record contributions", "Validation",
                        javax.swing.JOptionPane.WARNING_MESSAGE); return;
                }
            } catch (Exception checkEx) { checkEx.printStackTrace(); }

            rw.church.model.Member member = new rw.church.model.Member();
            member.setId(memberId);

            String selectedService = (String) serviceCombo.getSelectedItem();
            int serviceId = Integer.parseInt(selectedService.split("\\|")[1]);
            rw.church.model.Service srv = new rw.church.model.Service();
            srv.setId(serviceId);

            rw.church.model.Contribution contribution = new rw.church.model.Contribution();
            contribution.setContributionType((String) typeCombo.getSelectedItem());
            contribution.setAmount(amount);
            contribution.setContributionDate(contribDate);
            contribution.setMember(member);
            contribution.setChurchService(srv);

            java.rmi.registry.Registry registry =
                java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            rw.church.service.ContributionService service =
                (rw.church.service.ContributionService) registry.lookup("ContributionService");
            service.saveContribution(contribution);

            javax.swing.JOptionPane.showMessageDialog(this,
                "Contribution saved: RWF " + String.format("%,.0f", amount),
                "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            loadAllContributions();
            amountTxt.setText("");
            typeCombo.setSelectedIndex(0);
            serviceCombo.setSelectedIndex(0);
            preselectLoggedInMember();

        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage(), "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int selectedRow = contributionTable.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Please select a contribution to delete", "Warning",
                javax.swing.JOptionPane.WARNING_MESSAGE); return;
        }
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
            "Delete this contribution?", "Confirm",
            javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm != javax.swing.JOptionPane.YES_OPTION) return;
        try {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            rw.church.model.Contribution c = new rw.church.model.Contribution();
            c.setId(id);
            java.rmi.registry.Registry registry =
                java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            rw.church.service.ContributionService service =
                (rw.church.service.ContributionService) registry.lookup("ContributionService");
            service.deleteContribution(c);
            javax.swing.JOptionPane.showMessageDialog(this,
                "Deleted successfully", "Success",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
            loadAllContributions();
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage(), "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName()); break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ContributionModule.class.getName())
                .log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new ContributionModule().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountTxt;
    private javax.swing.JTable contributionTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> memberCombo;
    private javax.swing.JButton saveBtn;
    private javax.swing.JComboBox<String> serviceCombo;
    private javax.swing.JComboBox<String> typeCombo;
    // End of variables declaration//GEN-END:variables

    private void addColumnsToTable() {
        tableModel.addColumn("ID");
        tableModel.addColumn("MEMBER");
        tableModel.addColumn("SERVICE");
        tableModel.addColumn("TYPE");
        tableModel.addColumn("AMOUNT (RWF)");
        tableModel.addColumn("DATE");
        contributionTable.setModel(tableModel);
    }

    private void loadMembers() {
        try {
            java.rmi.registry.Registry registry =
                java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            rw.church.service.MemberService service =
                (rw.church.service.MemberService) registry.lookup("MemberService");
            java.util.List<rw.church.model.Member> list = service.findAllMembers();
            memberCombo.removeAllItems();
            for (rw.church.model.Member m : list) {
                memberCombo.addItem(m.getFullName() + "|" + m.getId());
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    private void loadServices() {
        try {
            java.rmi.registry.Registry registry =
                java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            rw.church.service.ChurchServiceService service =
                (rw.church.service.ChurchServiceService) registry.lookup("ChurchServiceService");
            java.util.List<rw.church.model.Service> list = service.findAllChurchServices();
            serviceCombo.removeAllItems();
            for (rw.church.model.Service s : list) {
                serviceCombo.addItem(s.getServiceType() + "|" + s.getId());
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    private void loadAllContributions() {
        try {
            tableModel.setRowCount(0);
            java.rmi.registry.Registry registry =
                java.rmi.registry.LocateRegistry.getRegistry("127.0.0.1", 5000);
            rw.church.service.ContributionService service =
                (rw.church.service.ContributionService) registry.lookup("ContributionService");
            java.util.List<rw.church.model.Contribution> list = service.findAllContributions();
            for (rw.church.model.Contribution c : list) {
                tableModel.addRow(new Object[]{
                    c.getId(),
                    c.getMember() != null ? c.getMember().getFullName() : "",
                    c.getChurchService() != null ? c.getChurchService().getServiceType() : "",
                    c.getContributionType(),
                    "RWF " + String.format("%,.0f", c.getAmount()),
                    c.getContributionDate()
                });
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}
