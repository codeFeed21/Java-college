import java.io.*;
import java.net.*;

public class NumberTCPClient {
    public static void main(String[] args) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 6789);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Enter 10 numbers separated by commas:");
        String numbers = inFromUser.readLine();

        outToServer.writeBytes(numbers + '\n');

        String sortedNumbers = inFromServer.readLine();
        System.out.println("Sorted numbers from server: " + sortedNumbers);

        clientSocket.close();
    }
}
