import java.io.*;
import java.net.*;

public class AddTCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Server started. Waiting for client...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

            String[] numbers = inFromClient.readLine().split(",");
            int num1 = Integer.parseInt(numbers[0]);
            int num2 = Integer.parseInt(numbers[1]);

            int sum = num1 + num2;

            outToClient.writeBytes(String.valueOf(sum) + '\n');

            clientSocket.close();
            System.out.println("Client disconnected.");
        }
    }
}
