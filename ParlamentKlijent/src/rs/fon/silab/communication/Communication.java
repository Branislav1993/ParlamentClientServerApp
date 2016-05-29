/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import rs.silab.transfers.ClientObjectTransfer;
import rs.silab.transfers.ServerObjectTransfer;

/**
 *
 * @author Branislav Vidojevic
 */
public class Communication {

    private Socket socket;
    private static Communication instance;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public static Communication getInstance() {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public void setSocket(Socket soket) throws IOException {
        this.socket = soket;
        this.out = new ObjectOutputStream(this.socket.getOutputStream());
        this.in = new ObjectInputStream(this.socket.getInputStream());
    }

    public void sendRequest(ClientObjectTransfer ct) throws SocketException, IOException {
        out.writeObject(ct);
    }

    public ServerObjectTransfer readResponse() throws SocketException, ClassNotFoundException, IOException {
        return (ServerObjectTransfer) in.readObject();
    }
}
