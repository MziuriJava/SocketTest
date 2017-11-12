package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("მოგესალმები კლიენტო, რით შემიძლია დაგეხმარო?");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String textFromClient = dis.readUTF();
            System.out.println(textFromClient);
            dos.close();
            socket.close();
            serverSocket.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
