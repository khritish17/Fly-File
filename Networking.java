import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class Networking 
{
    public static String get_IP_address() throws IOException
    {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements())
        {
            NetworkInterface networkInterface = interfaces.nextElement();
            if (networkInterface.isLoopback() || !networkInterface.isUp()){
                continue;
            }
            if (networkInterface.getDisplayName().contains("wlan0")  || networkInterface.getDisplayName().contains("Wi-Fi Direct") || networkInterface.getDisplayName().contains("HostedNetwork"))
            {
                Enumeration<InetAddress> addressess = networkInterface.getInetAddresses();
                while(addressess.hasMoreElements())
                {
                    InetAddress addr = addressess.nextElement();
                    if(addr.isSiteLocalAddress())
                    {
                        return addr.getHostAddress();
                    }
                }
            }
        }
        throw new RuntimeException("Unable to detremine IP address.");
    }    
}
