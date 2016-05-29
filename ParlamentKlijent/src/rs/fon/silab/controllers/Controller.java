/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.controllers;

import java.net.SocketException;
import java.util.List;
import javax.swing.JOptionPane;
import rs.fon.silab.communication.Communication;
import rs.fon.silab.gui.MainGUI;
import rs.silab.constants.ParlamentConstants;
import rs.silab.domain.Member;
import rs.silab.domain.Party;
import rs.silab.domain.PartyMembership;
import rs.silab.domain.PlenarySession;
import rs.silab.domain.Speech;
import rs.silab.domain.Town;
import rs.silab.transfers.ClientObjectTransfer;
import rs.silab.transfers.ServerObjectTransfer;

/**
 *
 * @author Branislav Vidojevic
 */
public class Controller {

    private static Controller instance;

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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainGUI mainGUI = new MainGUI();
                mainGUI.setVisible(true);
                mainGUI.setLocationRelativeTo(null);
            }
        });
    }

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    private void closeProgramOnSocketException() {
        JOptionPane.showMessageDialog(null, "Server closed the connection!\n Program will now exit!", "Error!", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }

    public List<Member> getMembers() throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.RETURN_ALL_MEMBERS);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return (List<Member>) st.getData();
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return null;
        }
    }

    public List<Party> getMemberParties(Member m) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setParameter(m);
        kt.setOperation(ParlamentConstants.RETURN_ALL_MEMBER_PARTIES);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return (List<Party>) st.getData();
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return null;
        }
    }

    public List<Party> getParties() throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.RETURN_ALL_PARTIES);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return (List<Party>) st.getData();
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return null;
        }
    }

    public List<Town> getTowns() throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.RETURN_ALL_TOWNS);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return (List<Town>) st.getData();
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return null;
        }
    }

    public boolean createMember(Member m) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.CREATE_MEMBER);
        kt.setParameter(m);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return true;
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }

    public boolean savePartyMemberhip(PartyMembership pm) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.SAVE_PARTY_MEMBERSHIP);
        kt.setParameter(pm);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return true;
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }

    public boolean deleteMember(Member m) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.DELETE_MEMBER);
        kt.setParameter(m);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return true;
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }

    public boolean updateMember(Member m) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.UPDATE_MEMBER);
        kt.setParameter(m);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return true;
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }

    public List<Member> searchMembers(String searchCriteria) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.SEARCH_MEMBERS);
        kt.setParameter(searchCriteria);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return (List<Member>) st.getData();
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return null;
        }
    }

    public List<Speech> getMemberSpeeches(Member m) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.GET_MEMBER_SPEECHES);
        kt.setParameter(m);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return (List<Speech>) st.getData();
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return null;
        }
    }

    public List<Party> searchParties(String searchCriteria) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.SEARCH_PARTIES);
        kt.setParameter(searchCriteria);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return (List<Party>) st.getData();
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return null;
        }
    }

    public boolean saveParty(Party p) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.CREATE_PARTY);
        kt.setParameter(p);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return true;
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }

    public boolean deleteParty(Party p) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.DELETE_PARTY);
        kt.setParameter(p);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return true;
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }

    public boolean updateParty(Party p) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.UPDATE_PARTY);
        kt.setParameter(p);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return true;
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }

    public List<Speech> getSpeeches() throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.RETURN_ALL_SPEECHES);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return (List<Speech>) st.getData();
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return null;
        }
    }

    public List<Speech> searchSpeeches(String searchCriteria) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.SEARCH_SPEECHES);
        kt.setParameter(searchCriteria);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return (List<Speech>) st.getData();
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return null;
        }
    }

    public List<PlenarySession> getSessions() throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.RETURN_ALL_SESSIONS);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return (List<PlenarySession>) st.getData();
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return null;
        }
    }

    public List<PlenarySession> searchSessions(String searchCriteria) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.SEARCH_SESSIONS);
        kt.setParameter(searchCriteria);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return (List<PlenarySession>) st.getData();
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return null;
        }
    }

    public boolean deleteSession(PlenarySession ps) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.DELETE_SESSION);
        kt.setParameter(ps);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return true;
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }

    public boolean deleteSpeech(Speech s) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.DELETE_SPEECH);
        kt.setParameter(s);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return true;
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }

    public boolean updateSession(PlenarySession ps) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.UPDATE_SESSION);
        kt.setParameter(ps);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return true;
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }

    public boolean updateSpeech(Speech s) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.UPDATE_SPEECH);
        kt.setParameter(s);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return true;
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }

    public boolean createSession(PlenarySession ps) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.CREATE_SESSION);
        kt.setParameter(ps);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return true;
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }

    public boolean createSpeech(Speech s) throws Exception {
        ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.CREATE_SPEECH);
        kt.setParameter(s);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return true;
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }

    public boolean createSpeeches(List<Speech> speeches) throws Exception {
         ClientObjectTransfer kt = new ClientObjectTransfer();
        kt.setOperation(ParlamentConstants.CREATE_SPEECHES);
        kt.setParameter(speeches);
        try {
            Communication.getInstance().sendRequest(kt);
            ServerObjectTransfer st = Communication.getInstance().readResponse();
            if (st.getOperationSuccess() == ParlamentConstants.SUCCESS_OPERATION) {
                return true;
            } else {
                Exception ex = st.getException();
                throw ex;
            }
        } catch (SocketException ex) {
            closeProgramOnSocketException();
            return false;
        }
    }

}
