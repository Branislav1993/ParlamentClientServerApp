/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.start;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import javax.swing.JOptionPane;
import rs.fon.silab.communication.Communication;

/**
 *
 * @author Branislav Vidojevic
 */
public class ClientStart extends Thread {

    private int port;

    public ClientStart(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket("localhost", port);
            System.out.println("Socket kreiran " + socket.getInetAddress() + " " + socket.getLocalAddress());
            Communication.getInstance().setSocket(socket);
        } catch (SocketException ex) {
            JOptionPane.showMessageDialog(null, "Server closed the connection!\n Program will now exit!", "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("ClientStart.class IOException!");
        }
    }

}
