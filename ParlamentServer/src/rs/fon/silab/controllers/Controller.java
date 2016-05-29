/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.controllers;

import java.io.IOException;
import java.util.List;
import rs.fon.silab.forms.ServerGUI;
import rs.fon.silab.server.SocketServer;
import rs.fon.silab.system_operations.member.SOGetMemberParties;
import rs.fon.silab.system_operations.member.SOGetMembers;
import rs.fon.silab.system_operations.party.SOGetParties;
import rs.fon.silab.system_operations.member.SOGetTowns;
import rs.fon.silab.system_operations.member.SOCreateMember;
import rs.fon.silab.system_operations.party.SOCreateParty;
import rs.fon.silab.system_operations.session.SOCreateSession;
import rs.fon.silab.system_operations.speech.SOCreateSpeech;
import rs.fon.silab.system_operations.member.SODeleteMember;
import rs.fon.silab.system_operations.party.SODeleteParty;
import rs.fon.silab.system_operations.session.SODeleteSession;
import rs.fon.silab.system_operations.speech.SODeleteSpeech;
import rs.fon.silab.system_operations.member.SOGetMemberSpeeches;
import rs.fon.silab.system_operations.session.SOGetSessions;
import rs.fon.silab.system_operations.speech.SOGetSpeeches;
import rs.fon.silab.system_operations.member.SOSavePartyMembership;
import rs.fon.silab.system_operations.member.SOSearchMembers;
import rs.fon.silab.system_operations.party.SOSearchParties;
import rs.fon.silab.system_operations.session.SOSearchSessions;
import rs.fon.silab.system_operations.speech.SOSearchSpeeches;
import rs.fon.silab.system_operations.member.SOUpdateMember;
import rs.fon.silab.system_operations.party.SOUpdateParty;
import rs.fon.silab.system_operations.session.SOUpdateSession;
import rs.fon.silab.system_operations.speech.SOCreateSpeeches;
import rs.fon.silab.system_operations.speech.SOUpdateSpeech;
import rs.silab.domain.AbstractObject;
import rs.silab.domain.Member;
import rs.silab.domain.Party;
import rs.silab.domain.PartyMembership;
import rs.silab.domain.PlenarySession;
import rs.silab.domain.Speech;

/**
 *
 * @author Branislav Vidojevic
 */
public class Controller {

    private static SocketServer ss;
    private static Controller instance;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

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
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ServerGUI gui = new ServerGUI();
                gui.setVisible(true);
                gui.setLocationRelativeTo(null);
            }
        });
    }

    public void startServer(int port) {
        ss = new SocketServer(port);
        ss.start();
    }

    public void stopServer() throws IOException {
        ss.closeServerSocket();
    }

    public List<AbstractObject> getMembers() throws Exception {
        SOGetMembers so = new SOGetMembers();
        so.executeOperation();
        return so.getMembers();
    }

    public List<AbstractObject> getMemberParties(Member m) throws Exception {
        SOGetMemberParties so = new SOGetMemberParties(m);
        so.executeOperation();
        return so.getParties();
    }

    public List<AbstractObject> getParties() throws Exception {
        SOGetParties so = new SOGetParties();
        so.executeOperation();
        return so.getParties();
    }

    public List<AbstractObject> getTowns() throws Exception {
        SOGetTowns so = new SOGetTowns();
        so.executeOperation();
        return so.getTowns();
    }

    public boolean createMember(Member m) throws Exception {
        SOCreateMember so = new SOCreateMember(m);
        so.executeOperation();
        return so.isSuccess();
    }

    public boolean updateMember(Member m) throws Exception {
        SOUpdateMember so = new SOUpdateMember(m);
        so.executeOperation();
        return so.isSuccess();
    }

    public boolean savePartyMemberships(PartyMembership partyMembership) throws Exception {
        SOSavePartyMembership so = new SOSavePartyMembership(partyMembership);
        so.executeOperation();
        return so.isSuccess();
    }

    public boolean deleteMember(Member member) throws Exception {
        SODeleteMember so = new SODeleteMember(member);
        so.executeOperation();
        return so.isSuccess();
    }

    public List<AbstractObject> searchMembers(String searchCriteria) throws Exception {
        SOSearchMembers so = new SOSearchMembers(searchCriteria);
        so.executeOperation();
        return so.getMembers();
    }

    public List<AbstractObject> getMemberSpeeches(Member member) throws Exception {
        SOGetMemberSpeeches so = new SOGetMemberSpeeches(member);
        so.executeOperation();
        return so.getSpeeches();
    }

    public List<AbstractObject> searchParties(String searchCriteria) throws Exception {
        SOSearchParties so = new SOSearchParties(searchCriteria);
        so.executeOperation();
        return so.getParties();
    }

    public boolean createParty(Party party) throws Exception {
        SOCreateParty so = new SOCreateParty(party);
        so.executeOperation();
        return so.isSuccess();
    }

    public boolean deleteParty(Party party) throws Exception {
        SODeleteParty so = new SODeleteParty(party);
        so.executeOperation();
        return so.isSuccess();
    }

    public boolean updateParty(Party party) throws Exception {
        SOUpdateParty so = new SOUpdateParty(party);
        so.executeOperation();
        return so.isSuccess();
    }

    public List<AbstractObject> getSpeeches() throws Exception {
        SOGetSpeeches so = new SOGetSpeeches();
        so.executeOperation();
        return so.getSpeeches();
    }

    public List<AbstractObject> searchSpeeches(String searchCriteria) throws Exception {
        SOSearchSpeeches so = new SOSearchSpeeches(searchCriteria);
        so.executeOperation();
        return so.getSpeeches();
    }

    public List<AbstractObject> getSessions() throws Exception {
        SOGetSessions so = new SOGetSessions();
        so.executeOperation();
        return so.getSessions();
    }

    public List<AbstractObject> searchSessions(String searchCriteria) throws Exception {
        SOSearchSessions so = new SOSearchSessions(searchCriteria);
        so.executeOperation();
        return so.getSessions();
    }

    public boolean deleteSession(PlenarySession plenarySession) throws Exception {
        SODeleteSession so = new SODeleteSession(plenarySession);
        so.executeOperation();
        return so.isSuccess();
    }

    public boolean deleteSpeech(Speech speech) throws Exception {
        SODeleteSpeech so = new SODeleteSpeech(speech);
        so.executeOperation();
        return so.isSuccess();
    }

    public boolean createSpeech(Speech speech) throws Exception {
        SOCreateSpeech so = new SOCreateSpeech(speech);
        so.executeOperation();
        return so.isSuccess();
    }
    
    public boolean createSpeeches(List<AbstractObject> speeches) throws Exception {
        SOCreateSpeeches so = new SOCreateSpeeches(speeches);
        so.executeOperation();
        return so.isSuccess();
    }

    public boolean createSession(PlenarySession plenarySession) throws Exception {
        SOCreateSession so = new SOCreateSession(plenarySession);
        so.executeOperation();
        return so.isSuccess();
    }

    public boolean updateSpeech(Speech speech) throws Exception {
        SOUpdateSpeech so = new SOUpdateSpeech(speech);
        so.executeOperation();
        return so.isSuccess();
    }

    public boolean updateSession(PlenarySession plenarySession) throws Exception {
        SOUpdateSession so = new SOUpdateSession(plenarySession);
        so.executeOperation();
        return so.isSuccess();
    }
}
