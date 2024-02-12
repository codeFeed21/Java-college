import java.net.*;
import java.util.Arrays;
import java.io.*;

public class NumberUDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);

        byte[] receiveData = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            String clientInput = new String(receivePacket.getData(), 0, receivePacket.getLength());
            String[] numbersAsString = clientInput.split(",");
            int[] numbers = new int[numbersAsString.length];
            for (int i = 0; i < numbersAsString.length; i++) {
                numbers[i] = Integer.parseInt(numbersAsString[i]);
            }

            Arrays.sort(numbers);

            StringBuilder sortedNumbers = new StringBuilder();
            for (int num : numbers) {
                sortedNumbers.append(num).append(" ");
            }

            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            byte[] sendData = sortedNumbers.toString().getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}
