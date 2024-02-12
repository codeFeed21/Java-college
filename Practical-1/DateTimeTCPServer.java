import java.io.*;
import java.net.*;
import java.util.*;

public class DateTimeTCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Server started. Waiting for client...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            OutputStreamWriter outToClient = new OutputStreamWriter(clientSocket.getOutputStream());
            PrintWriter pw = new PrintWriter(outToClient, true);
            pw.println(getDateTime()); // Send date and time to client

            clientSocket.close();
            System.out.println("Client disconnected.");
        }
    }

    // Method to get current date and time
    private static String getDateTime() {
        Date date = new Date();
        return date.toString();
    }
}
