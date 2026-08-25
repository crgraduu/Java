package ro.ase.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(8888);
            System.out.println("Server Started on port 8888");

            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String message = new String(packet.getData());
        }
    }
}
