package Networking.socket.UDP;

import java.io.IOException;
import java.net.*;

/**
 * Created by geetgobindsingh on 12/11/17.
 */
public class Sender {

    private DatagramSocket mDatagramSocket;
    private DatagramPacket mDatagramPacket;

    public static void main(String[] args) {
        Sender sender = new Sender();
        try {
            sender.mDatagramSocket = new DatagramSocket();

            String str = "Welcome java";
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            System.out.println(ip);

            sender.mDatagramPacket = new DatagramPacket(str.getBytes(), str.length(), ip, 8989);
            sender.mDatagramSocket.send(sender.mDatagramPacket);
            sender.mDatagramSocket.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
