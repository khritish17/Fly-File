import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import com.sun.net.httpserver.*;

public class Server 
{   
    public static void start(String ip_address, int port) throws IOException
    {
        HttpServer server = HttpServer.create(new InetSocketAddress(ip_address,port),0);
        server.createContext("/", new RootHandler());
        server.createContext("/upload", new UploadHandler());
        server.start();
        System.out.println("Server started");
    } 
    static class RootHandler implements HttpHandler
    {
        @Override
        public void handle(HttpExchange exchange) throws IOException
        {
            Path htmlPath = Path.of("home.html");
            String response = Files.readString(htmlPath);

            // Set headers and send response
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, response.getBytes().length);

            try (OutputStream os = exchange.getResponseBody()) 
            {
                os.write(response.getBytes());
            }
        }
    }
    static class UploadHandler implements HttpHandler
    {
        @Override
        public void handle(HttpExchange exchange) throws IOException 
        {
            if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) 
            {
                // parse headers to extract original file name
                String contentDisposition = exchange.getRequestHeaders().getFirst("Content-Disposition");
                String originalFileName = "uploaded_fly_file";
                System.out.println(exchange.getRequestHeaders().isEmpty());
                System.out.println(contentDisposition);
                if(contentDisposition != null && contentDisposition.contains("filename="))
                {
                    originalFileName = contentDisposition.split("filename=")[1].replace("\"","").trim();
                }
                System.out.println(originalFileName);
                String unique_file_name = "uploads/" + originalFileName + "_" + System.currentTimeMillis();
            } 
            else 
            {
                exchange.sendResponseHeaders(405, -1); // Method not allowed
            }
        }
    }
}

