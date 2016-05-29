/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;
import java.util.List;
import rs.fon.silab.threads.ClientThread;

/**
 *
 * @author Branislav Vidojevic
 */
public class SocketServer extends Thread {

    private ServerSocket serverSocket;
    public static List<ClientThread> clients = new LinkedList<>();

    public SocketServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("ServerSocket was created.");
        } catch (IOException ex) {
            System.out.println("ServerSocket was not created.");
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket s = serverSocket.accept();
                ClientThread clientThread = new ClientThread(s);
                clientThread.start();
                clients.add(clientThread);
                int i = clients.size();
                System.out.println("Client number " + i + " has connected!");
            } catch (SocketException ex) {
                System.out.println("Server is closed!");
                break;
            } catch (IOException ex) {
                System.out.println("Client couldn't connect!");
            }
        }
    }

    public void closeServerSocket() {
        for (ClientThread ct : clients) {
            try {
                ct.getSocket().close();
            } catch (IOException ex) {
                System.out.println("Client couldn't be disconected. " + ct.getSocket().getInetAddress());
                ex.printStackTrace();
            }
        }
        try {
            serverSocket.close();
        } catch (IOException ex) {
            System.out.println("Server socket couldn't be closed.");
            ex.printStackTrace();
        }
    }
}
