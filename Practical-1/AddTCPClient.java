import java.io.*;
import java.net.*;

public class AddTCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9090);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("Enter two numbers separated by comma:");
        String numbers = inFromUser.readLine();

        outToServer.writeBytes(numbers + '\n');

        String sumFromServer = inFromServer.readLine();
        System.out.println("Sum of numbers from server: " + sumFromServer);

        socket.close();
    }
}
