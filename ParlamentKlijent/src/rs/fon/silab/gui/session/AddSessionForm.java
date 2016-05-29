/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.gui.session;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import rs.fon.silab.controllers.Controller;
import rs.silab.domain.PlenarySession;

/**
 *
 * @author Baki
 */
public class AddSessionForm extends javax.swing.JFrame {
    
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private SessionsForm sessionsForm;
    private PlenarySession session;

    /**
     * Creates new form AddSessionForm
     */
    public AddSessionForm(SessionsForm sessionsForm) {
        this.sessionsForm = sessionsForm;
        initComponents();
        btnUpdate.setEnabled(false);
        btnAdd.setEnabled(true);
    }
    
    public AddSessionForm(SessionsForm sessionsForm, PlenarySession session) {
        this.session = session;
        this.sessionsForm = sessionsForm;
        initComponents();
        btnUpdate.setEnabled(true);
        btnAdd.setEnabled(false);
        fillFormWithSessionData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaAgenda = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaTranscript = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txtSessionDate = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Session form");
        setResizable(false);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agenda text", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        textAreaAgenda.setColumns(20);
        textAreaAgenda.setRows(5);
        jScrollPane1.setViewportView(textAreaAgenda);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transcript text", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        textAreaTranscript.setColumns(20);
        textAreaTranscript.setRows(5);
        jScrollPane2.setViewportView(textAreaTranscript);

        jLabel1.setText("Session Date dd-MM-yyyy");

        txtSessionDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtSessionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnCancel, btnUpdate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSessionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancel)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnCancel, btnUpdate});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        boolean valid = validateForm();
        if (!valid) {
            JOptionPane.showMessageDialog(this, "Please fix errors!\n They are marked in red border.", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            getSessionDataAndUpdate();
            this.sessionsForm.fillSessionTable();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        boolean valid = validateForm();
        if (!valid) {
            JOptionPane.showMessageDialog(this, "Please fix errors!\n They are marked in red border.", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            getSessionDataAndSave();
            this.sessionsForm.fillSessionTable();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea textAreaAgenda;
    private javax.swing.JTextArea textAreaTranscript;
    private javax.swing.JTextField txtSessionDate;
    // End of variables declaration//GEN-END:variables

    private void fillFormWithSessionData() {
        txtSessionDate.setText(sdf.format(session.getDate()));
        textAreaAgenda.setText(session.getAgenda());
        textAreaTranscript.setText(session.getTranscriptText());
    }
    
    private void getSessionDataAndUpdate() {
        PlenarySession ps = new PlenarySession();
        ps.setId(session.getId());
        ps.setAgenda(textAreaAgenda.getText());
        ps.setTranscriptText(textAreaTranscript.getText());
        try {
            ps.setDate(sdf.parse(txtSessionDate.getText()));
        } catch (ParseException ex) {
            System.out.println("Parse exception: AddSessionForm.class");
        }
        try {
            Controller.getInstance().updateSession(ps);
//            refreshFormValues();
            JOptionPane.showMessageDialog(this, "Session successfully updated!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Session was not updated!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validateForm() {
        refreshBordersOnForm();
        boolean valid = true;
        if (textAreaAgenda.getText().isEmpty()) {
            textAreaAgenda.setBorder(BorderFactory.createLineBorder(Color.RED));
            valid = false;
        }
        if (textAreaTranscript.getText().isEmpty()) {
            textAreaTranscript.setBorder(BorderFactory.createLineBorder(Color.RED));
            valid = false;
        }
        String dateString = txtSessionDate.getText();
        try {
            sdf.parse(dateString);
        } catch (ParseException ex) {
            txtSessionDate.setBorder(BorderFactory.createLineBorder(Color.RED));
            valid = false;
        }
        return valid;
    }
    
    private void refreshBordersOnForm() {
        textAreaAgenda.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textAreaTranscript.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtSessionDate.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }
    
    private void getSessionDataAndSave() {
        PlenarySession ps = new PlenarySession();
        ps.setAgenda(textAreaAgenda.getText());
        ps.setTranscriptText(textAreaTranscript.getText());
        try {
            ps.setDate(sdf.parse(txtSessionDate.getText()));
        } catch (ParseException ex) {
            System.out.println("Parse exception: AddSessionForm.class");
        }
        try {
            Controller.getInstance().createSession(ps);
            refreshFormValues();
            JOptionPane.showMessageDialog(this, "Session successfully created!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Session was not created!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void refreshFormValues() {
        txtSessionDate.setText(null);
        textAreaAgenda.setText(null);
        textAreaTranscript.setText(null);
    }
}