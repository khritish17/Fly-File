import java.io.IOException;
import java.net.URISyntaxException;

public class Main
{
    public static void main(String[] args) throws IOException, URISyntaxException
    {
        // Get the IP Address for the hotspot network interface
        String ip_address = Networking.get_IP_address();
        int server_port = 8000;
        
        // Display the Server IP address in a browser
        HTML_helper.openHtmlFile(ip_address + ":" + Integer.toString(server_port));

        // Start the server
        Server.start(ip_address, server_port);

    }
}