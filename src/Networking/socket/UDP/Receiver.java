package Networking.socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by geetgobindsingh on 12/11/17.
 */
public class Receiver {

    private DatagramSocket mDatagramSocket;
    private DatagramPacket mDatagramPacket;

    public static void main(String[] args) {
        Receiver receiver = new Receiver();

        try {
            receiver.mDatagramSocket = new DatagramSocket(8989);

            byte[] inputBuffer = new byte[1024];

            receiver.mDatagramPacket = new DatagramPacket(inputBuffer, inputBuffer.length);

            receiver.mDatagramSocket.receive(receiver.mDatagramPacket);

            String receivedData = new String(receiver.mDatagramPacket.getData(), receiver.mDatagramPacket.getOffset(), receiver.mDatagramPacket.getLength());

            System.out.println("Data received is :" + receivedData);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
