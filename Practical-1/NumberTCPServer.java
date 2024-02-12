import java.io.*;
import java.net.*;
import java.util.Arrays;

public class NumberTCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6789);

        while (true) {
            Socket connectionSocket = serverSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            String clientInput = inFromClient.readLine();
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

            outToClient.writeBytes(sortedNumbers.toString() + '\n');
        }
    }
}
