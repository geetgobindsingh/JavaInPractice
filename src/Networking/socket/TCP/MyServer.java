package Networking.socket.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by geetgobindsingh on 12/11/17.
 */
public class MyServer {

    private ServerSocket mServerSocket;
    private Socket mSocket;

    public static void main(String[] args) {
        MyServer object = new MyServer();
        try {
            System.out.println("Server Started");
            object.mServerSocket = new ServerSocket(9898);
            object.mSocket = object.mServerSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(object.mSocket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(object.mSocket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String received = "";
            while (!received.equalsIgnoreCase("stop")) {
                received = dataInputStream.readUTF();
                System.out.println("Client Said : '" + received + "'");
                System.out.print("You: ");
                dataOutputStream.writeUTF(bufferedReader.readLine());
                dataOutputStream.flush();
                System.out.println("Waiting for client response...");
            }
            dataInputStream.close();
            dataOutputStream.close();
            object.mSocket.close();
            object.mServerSocket.close();
            System.out.println("Server Stopped");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
