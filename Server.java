import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.*;

public class Server 
{   
    public static void start(String ip_address, int port) throws IOException
    {
        HttpServer server = HttpServer.create(new InetSocketAddress(ip_address,port),0);
        server.createContext("/", new RootHandler());
        server.start();
        System.out.println("Server started");
    } 
    static class RootHandler implements HttpHandler
    {
        @Override
        public void handle(HttpExchange exchange) throws IOException
        {
            String response = "Hello message from the hello handler";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
