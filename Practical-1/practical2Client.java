import java.io.*;
import java.net.*;

public class practical2Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 3500);
        InputStream inputStream = client.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        String str = dataInputStream.readUTF();

        System.out.println(str);

        dataInputStream.close();
        inputStream.close();
        client.close();
    }
}
