import java.net.*;

public class NumberUDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");

        byte[] sendData;
        byte[] receiveData = new byte[1024];

        System.out.println("Enter 10 numbers separated by commas:");
        String numbers = System.console().readLine();

        sendData = numbers.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String sortedNumbers = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Sorted numbers from server: " + sortedNumbers);

        clientSocket.close();
    }
}
