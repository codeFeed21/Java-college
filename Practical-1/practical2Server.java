
// practical2Server.java
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class practical2Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3500);
        Socket socket = serverSocket.accept();

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        dataOutputStream.writeUTF("HI THere");

        dataOutputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
