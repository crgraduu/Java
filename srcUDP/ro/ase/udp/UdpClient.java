package ro.ase.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(8888);
            String message= "Hello World";
            byte[] buf = message.getBytes();
            DatagramPacket packetToBeSent = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 8888);
            socket.send(packetToBeSent);
            byte[] buffer = new byte[1024];
            DatagramPacket packetToBeReceived = new DatagramPacket(buffer, buffer.length);
            socket.receive(packetToBeReceived);
            String receivedMessage = new String(packetToBeReceived.getData(), 0, packetToBeReceived.getLength());


        } catch  (Exception e) {
            e.printStackTrace();
        }
        
    }
}
