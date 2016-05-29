/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import rs.silab.constants.ParlamentConstants;
import rs.fon.silab.controllers.Controller;
import rs.silab.domain.AbstractObject;
import rs.silab.domain.Member;
import rs.silab.domain.Party;
import rs.silab.domain.PartyMembership;
import rs.silab.domain.PlenarySession;
import rs.silab.domain.Speech;
import rs.silab.transfers.ClientObjectTransfer;
import rs.silab.transfers.ServerObjectTransfer;

/**
 *
 * @author Branislav Vidojevic
 */
public class ClientThread extends Thread {

    Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());) {
            while (true) {
                ClientObjectTransfer ct = (ClientObjectTransfer) in.readObject();

                if (ct.getOperation() == ParlamentConstants.RETURN_ALL_MEMBERS) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        List<AbstractObject> members = Controller.getInstance().getMembers();
                        st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        st.setData(members);
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.RETURN_ALL_MEMBER_PARTIES) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        List<AbstractObject> parties = Controller.getInstance().getMemberParties((Member) ct.getParameter());
                        st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        st.setData(parties);
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.RETURN_ALL_PARTIES) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        List<AbstractObject> parties = Controller.getInstance().getParties();
                        st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        st.setData(parties);
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.RETURN_ALL_TOWNS) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        List<AbstractObject> towns = Controller.getInstance().getTowns();
                        st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        st.setData(towns);
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.CREATE_MEMBER) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        boolean success = Controller.getInstance().createMember((Member) ct.getParameter());
                        if (success) {
                            st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        } else {
                            st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        }
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.UPDATE_MEMBER) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        boolean success = Controller.getInstance().updateMember((Member) ct.getParameter());
                        if (success) {
                            st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        } else {
                            st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        }
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.SAVE_PARTY_MEMBERSHIP) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        boolean success = Controller.getInstance().savePartyMemberships((PartyMembership) ct.getParameter());
                        if (success) {
                            st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        } else {
                            st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        }
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.DELETE_MEMBER) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        boolean success = Controller.getInstance().deleteMember((Member) ct.getParameter());
                        if (success) {
                            st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        } else {
                            st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        }
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.SEARCH_MEMBERS) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        List<AbstractObject> members = Controller.getInstance().searchMembers((String) ct.getParameter());
                        st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        st.setData(members);
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.GET_MEMBER_SPEECHES) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        List<AbstractObject> speeches = Controller.getInstance().getMemberSpeeches((Member) ct.getParameter());
                        st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        st.setData(speeches);
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.SEARCH_PARTIES) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        List<AbstractObject> parties = Controller.getInstance().searchParties((String) ct.getParameter());
                        st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        st.setData(parties);
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.CREATE_PARTY) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        boolean success = Controller.getInstance().createParty((Party) ct.getParameter());
                        if (success) {
                            st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        } else {
                            st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        }
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.DELETE_PARTY) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        boolean success = Controller.getInstance().deleteParty((Party) ct.getParameter());
                        if (success) {
                            st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        } else {
                            st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        }
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.UPDATE_PARTY) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        boolean success = Controller.getInstance().updateParty((Party) ct.getParameter());
                        if (success) {
                            st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        } else {
                            st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        }
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.RETURN_ALL_SPEECHES) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        List<AbstractObject> speeches = Controller.getInstance().getSpeeches();
                        st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        st.setData(speeches);
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.SEARCH_SPEECHES) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        List<AbstractObject> parties = Controller.getInstance().searchSpeeches((String) ct.getParameter());
                        st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        st.setData(parties);
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.RETURN_ALL_SESSIONS) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        List<AbstractObject> sessions = Controller.getInstance().getSessions();
                        st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        st.setData(sessions);
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.SEARCH_SESSIONS) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        List<AbstractObject> sessions = Controller.getInstance().searchSessions((String) ct.getParameter());
                        st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        st.setData(sessions);
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.DELETE_SESSION) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        boolean success = Controller.getInstance().deleteSession((PlenarySession) ct.getParameter());
                        if (success) {
                            st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        } else {
                            st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        }
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.DELETE_SPEECH) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        boolean success = Controller.getInstance().deleteSpeech((Speech) ct.getParameter());
                        if (success) {
                            st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        } else {
                            st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        }
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.CREATE_SPEECH) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        boolean success = Controller.getInstance().createSpeech((Speech) ct.getParameter());
                        if (success) {
                            st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        } else {
                            st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        }
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
                
                if (ct.getOperation() == ParlamentConstants.CREATE_SPEECHES) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        boolean success = Controller.getInstance().createSpeeches((List<AbstractObject>) ct.getParameter());
                        if (success) {
                            st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        } else {
                            st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        }
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.CREATE_SESSION) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        boolean success = Controller.getInstance().createSession((PlenarySession) ct.getParameter());
                        if (success) {
                            st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        } else {
                            st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        }
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (ct.getOperation() == ParlamentConstants.UPDATE_SPEECH) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        boolean success = Controller.getInstance().updateSpeech((Speech) ct.getParameter());
                        if (success) {
                            st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        } else {
                            st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        }
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
                
                if (ct.getOperation() == ParlamentConstants.UPDATE_SESSION) {
                    ServerObjectTransfer st = new ServerObjectTransfer();
                    try {
                        boolean success = Controller.getInstance().updateSession((PlenarySession) ct.getParameter());
                        if (success) {
                            st.setOperationSuccess(ParlamentConstants.SUCCESS_OPERATION);
                        } else {
                            st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        }
                    } catch (Exception ex) {
                        st.setOperationSuccess(ParlamentConstants.FAILIRE_OPERATION);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
            }
        } catch (IOException ex) {
            System.out.println("Client disconnected from server.");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException in ClientThread");
        }
    }

}
