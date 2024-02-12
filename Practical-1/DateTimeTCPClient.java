import java.io.*;
import java.net.*;

public class DateTimeTCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9090);

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String dateTimeFromServer = inFromServer.readLine();
        System.out.println("Date and time from server: " + dateTimeFromServer);

        socket.close();
    }
}
