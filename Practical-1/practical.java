import java.net.*;

public class practical {
    public static void main(String[] args) {
        try {

            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Host:");
            System.out.println("Host Name: " + localHost.getHostName());
            System.out.println("Host Address: " + localHost.getHostAddress());

            InetAddress byHostName = InetAddress.getByName("www.google.com");
            System.out.println("\nBy Host Name:");
            System.out.println("Host Name: " + byHostName.getHostName());
            System.out.println("Host Address: " + byHostName.getHostAddress());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
