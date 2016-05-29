/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.gui.member;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import rs.fon.silab.controllers.Controller;
import rs.silab.domain.Member;
import rs.silab.domain.Town;

/**
 *
 * @author Branislav Vidojevic
 */
public class AddMemberForm extends javax.swing.JFrame {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
    private Member member;
    private MemberForm memberForm;

    /**
     * Creates new form AddMemberForm
     */
    public AddMemberForm(MemberForm memberForm) {
        this.memberForm = memberForm;
        initComponents();
        fillCOmboBoxes();
        this.member = null;
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
//        fillMemberPartiesTable();
    }

    public AddMemberForm(MemberForm memberForm, Member member) {
        this.memberForm = memberForm;
        initComponents();
        fillCOmboBoxes();
        this.member = member;
        fillFormWithMemberData();
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtBirthDate = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        cbBirthPlace = new javax.swing.JComboBox<>();
        cbResidencePlace = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("First name");

        jLabel2.setText("Last name");

        jLabel3.setText("Gender");

        jLabel4.setText("Birth date (dd-MM-yyyy)");

        jLabel5.setText("Email");

        jLabel6.setText("Birth place");

        jLabel7.setText("Residence place");

        jLabel8.setText("Biography");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1, 1));

        jLabel10.setText("1 - male");

        jLabel11.setText("0 - female");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtBirthDate)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(38, 38, 38))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(12, 12, 12)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbBirthPlace, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbResidencePlace, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel10)))
                                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtEmail, txtFirstName, txtLastName});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSave, btnUpdate, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10))))
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbResidencePlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jSpinner1});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSave, btnUpdate, jButton2});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        boolean valid = validateForm();
        if (!valid) {
            JOptionPane.showMessageDialog(this, "Please fix errors!\n They are marked in red border.", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            getMemberDataAndSave();
            this.memberForm.fillMemberTable();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        boolean valid = validateForm();
        if (!valid) {
            JOptionPane.showMessageDialog(this, "Please fix errors!\n They are marked in red border.", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            getMemberDataAndUpdate();
            this.memberForm.fillMemberTable();

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbBirthPlace;
    private javax.swing.JComboBox<String> cbResidencePlace;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtBirthDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables

//    private void fillMemberPartiesTable() {
//        try {
//            tableMemberParties.setModel(new AddMemberPartiesTableModel(Controller.getInstance().getParties()));
//            tableMemberParties.setRowSelectionAllowed(true);
//            tableMemberParties.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//        } catch (IOException ex) {
//            Logger.getLogger(AddMemberForm.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(AddMemberForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    private boolean validateForm() {
        refreshBordersOnForm();
        boolean valid = true;
        if (txtFirstName.getText().isEmpty()) {
            txtFirstName.setBorder(BorderFactory.createLineBorder(Color.RED));
            valid = false;
        }

        if (txtLastName.getText().isEmpty()) {
            txtLastName.setBorder(BorderFactory.createLineBorder(Color.RED));
            valid = false;
        }

        String dateString = txtBirthDate.getText();
        try {
            SDF.parse(dateString);
        } catch (ParseException ex) {
            txtBirthDate.setBorder(BorderFactory.createLineBorder(Color.RED));
            valid = false;
        }

        if (txtEmail.getText().isEmpty()) {
            txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED));
            valid = false;
        }

        if (jTextArea1.getText().isEmpty()) {
            jTextArea1.setBorder(BorderFactory.createLineBorder(Color.RED));
            valid = false;
        }

//        int selectedRows[] = tableMemberParties.getSelectedRows();
//
//        if (selectedRows.length < 1) {
//            tableMemberParties.setBorder(BorderFactory.createLineBorder(Color.RED));
//            valid = false;
//        }
        return valid;
    }

    private void refreshBordersOnForm() {
        txtFirstName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtLastName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtBirthDate.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtEmail.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        jTextArea1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
//        tableMemberParties.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    private void refreshFormValues() {
        txtFirstName.setText(null);
        txtLastName.setText(null);
        txtBirthDate.setText(null);
        txtEmail.setText(null);
        jTextArea1.setText(null);
//        tableMemberParties.getSelectionModel().clearSelection();
    }

    private void getMemberDataAndSave() {
        Member m = new Member();
        m.setName(txtFirstName.getText());
        m.setLastName(txtLastName.getText());
        m.setEmail(txtEmail.getText());
        m.setGender((Integer) jSpinner1.getValue());
        m.setPlaceOfBirth((Town) cbBirthPlace.getSelectedItem());
        m.setPlaceOfResidence((Town) cbResidencePlace.getSelectedItem());
        String dateString = txtBirthDate.getText();
        try {
            m.setDateOfBirth(SDF.parse(dateString));
        } catch (ParseException ex) {
            System.out.println("Date parse exception");
        }
        m.setBiography(jTextArea1.getText());

        //get all selected parties from model
//        int selectedRows[] = tableMemberParties.getSelectedRows();
//        List<Party> parties = new LinkedList<>();
//        AddMemberPartiesTableModel model = (AddMemberPartiesTableModel) tableMemberParties.getModel();
//        for (int selectedRow : selectedRows) {
//            Party p = model.getPartyByIndex(selectedRow);
//            parties.add(p);
//        }
//
//        //create party memberships for new member
//        List<PartyMembership> partyMemberships = new LinkedList<>();
//        for (Party p : parties) {
//            PartyMembership pm = new PartyMembership();
//            pm.setMember(m);
//            pm.setParty(p);
//            partyMemberships.add(pm);
//        }
        //save Member and all party Memberships
        try {
            Controller.getInstance().createMember(m);
//            for (PartyMembership partyMembership : partyMemberships) {
//                boolean statusPM = Controller.getInstance().savePartyMemberhip(partyMembership);
//                if (!statusPM) {
////                    JOptionPane.showMessageDialog(this, "Member was not created!", "Error!", JOptionPane.ERROR_MESSAGE);
//                    System.out.println("Vratio je false");
//                    return;
//                }
//            }
            refreshFormValues();
            JOptionPane.showMessageDialog(this, "Member successfully created!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Member was not created!", "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void fillFormWithMemberData() {
        txtFirstName.setText(member.getName());
        txtLastName.setText(member.getLastName());
        txtBirthDate.setText(SDF.format(member.getDateOfBirth()));
        jSpinner1.setValue(member.getGender());
        txtEmail.setText(member.getEmail());
        jTextArea1.setText(member.getBiography());
        ComboBoxModel model1 = cbBirthPlace.getModel();
        for (int i = 0; i < model1.getSize(); i++) {
            if (model1.getElementAt(i).equals(member.getPlaceOfBirth())) {
                model1.setSelectedItem(model1.getElementAt(i));
                break;
            }
        }
        ComboBoxModel model2 = cbResidencePlace.getModel();
        for (int i = 0; i < model2.getSize(); i++) {
            if (model2.getElementAt(i).equals(member.getPlaceOfResidence())) {
                model2.setSelectedItem(model1.getElementAt(i));
                break;
            }
        }
    }

    private void getMemberDataAndUpdate() {
        Member m = new Member();
        m.setId(this.member.getId());
        m.setName(txtFirstName.getText());
        m.setLastName(txtLastName.getText());
        m.setEmail(txtEmail.getText());
        m.setGender((Integer) jSpinner1.getValue());
        m.setPlaceOfBirth((Town) cbBirthPlace.getSelectedItem());
        m.setPlaceOfResidence((Town) cbResidencePlace.getSelectedItem());
        String dateString = txtBirthDate.getText();
        try {
            m.setDateOfBirth(SDF.parse(dateString));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Date parse exception!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        m.setBiography(jTextArea1.getText());

        //save Member and all party Memberships
        try {
            Controller.getInstance().updateMember(m);
//            refreshFormValues();
            JOptionPane.showMessageDialog(this, "Member successfully updated!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Member was not updated!", "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void fillCOmboBoxes() {
        try {
            List<Town> towns = Controller.getInstance().getTowns();
            cbBirthPlace.setModel(new DefaultComboBoxModel(towns.toArray()));
            cbResidencePlace.setModel(new DefaultComboBoxModel(towns.toArray()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Couldn't get towns from server!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
