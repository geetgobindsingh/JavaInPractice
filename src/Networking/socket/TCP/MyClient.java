package Networking.socket.TCP;

import java.io.*;

import java.net.Socket;

/**
 * Created by geetgobindsingh on 12/11/17.
 */
public class MyClient {

    private Socket mSocket;

    public static void main(String[] args) {
        MyClient object = new MyClient();
        try {
            object.mSocket = new Socket("localhost", 9898);
            DataInputStream dataInputStream = new DataInputStream(object.mSocket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(object.mSocket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Connected To server Start Speaking");

            String received = "";
            while (!received.equalsIgnoreCase("stop")) {
                System.out.print("You: ");
                dataOutputStream.writeUTF(bufferedReader.readLine());
                dataOutputStream.flush();
                System.out.println("Waiting for server response...");
                received = dataInputStream.readUTF();
                System.out.println("Server Said : '" + received + "'");
            }

            dataInputStream.close();
            dataOutputStream.close();
            dataOutputStream.close();
            object.mSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
