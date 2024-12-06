import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.Desktop;

public class HTML_helper 
{
    public static void openHtmlFile(String message) throws IOException, URISyntaxException 
    {
        // Create the HTML content
        // String htmlContent = "<html><body><h1>" + message + "</h1></body></html>";
        String htmlContent = "<!DOCTYPE html>\r\n" + //
                        "<html lang=\"en\">\r\n" + //
                        "<head>\r\n" + //
                        "    <meta charset=\"UTF-8\">\r\n" + //
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                        "    <title>Server Address</title>\r\n" + //
                        "    <style>\r\n" + //
                        "        body {\r\n" + //
                        "            font-family: Arial, sans-serif;\r\n" + //
                        "            background-color: #f4f4f9;\r\n" + //
                        "            display: flex;\r\n" + //
                        "            justify-content: center;\r\n" + //
                        "            align-items: center;\r\n" + //
                        "            height: 100vh;\r\n" + //
                        "            margin: 0;\r\n" + //
                        "        }\r\n" + //
                        "        .login-container {\r\n" + //
                        "            background: #fff;\r\n" + //
                        "            padding: 20px;\r\n" + //
                        "            border-radius: 8px;\r\n" + //
                        "            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\r\n" + //
                        "            width: 300px;\r\n" + //
                        "        }\r\n" + //
                        "        h2 {\r\n" + //
                        "            text-align: center;\r\n" + //
                        "            margin-bottom: 20px;\r\n" + //
                        "            color: #333;\r\n" + //
                        "        }\r\n" + //
                        "        p{\r\n" + //
                        "            text-align:center;\r\n" + //
                        "            margin: 10px;\r\n" + //
                        "        }\r\n" + //
                        "        h3{\r\n" + //
                        "            text-align: center;\r\n" + //
                        "            color: #5cb85c;\r\n" + //
                        "        }\r\n" + //
                        "        .form-group {\r\n" + //
                        "            margin-bottom: 15px;\r\n" + //
                        "        }\r\n" + //
                        "        label {\r\n" + //
                        "            display: block;\r\n" + //
                        "            margin-bottom: 5px;\r\n" + //
                        "            color: #555;\r\n" + //
                        "        }\r\n" + //
                        "        input {\r\n" + //
                        "            width: 100%;\r\n" + //
                        "            padding: 8px;\r\n" + //
                        "            box-sizing: border-box;\r\n" + //
                        "            border: 1px solid #ddd;\r\n" + //
                        "            border-radius: 4px;\r\n" + //
                        "        }\r\n" + //
                        "        button {\r\n" + //
                        "            width: 100%;\r\n" + //
                        "            padding: 10px;\r\n" + //
                        "            background-color: #5cb85c;\r\n" + //
                        "            color: #fff;\r\n" + //
                        "            border: none;\r\n" + //
                        "            border-radius: 4px;\r\n" + //
                        "            cursor: pointer;\r\n" + //
                        "            font-size: 16px;\r\n" + //
                        "        }\r\n" + //
                        "        button:hover {\r\n" + //
                        "            background-color: #4cae4c;\r\n" + //
                        "        }\r\n" + //
                        "    </style>\r\n" + //
                        "</head>\r\n" + //
                        "<body>\r\n" + //
                        "    <div class=\"login-container\">\r\n" + //
                        "        <h2>Server is active on</h2>\r\n" + //
                        "        <h3>"+message+"</h3>\r\n" + //
                        "    </div>\r\n" + //
                        "\r\n" + //
                        "</body>\r\n" + //
                        "</html>\r\n" + //
                        "";

        // Define the path where the HTML file will be saved
        File tempHtmlFile = new File("tempPage.html");

        // Write the HTML content to the file
        java.nio.file.Files.write(tempHtmlFile.toPath(), htmlContent.getBytes());

        // Check if Desktop is supported (on most systems it should be)
        if (Desktop.isDesktopSupported()) 
        {
            Desktop desktop = Desktop.getDesktop();

            // Open the file in the default browser
            if (tempHtmlFile.exists()) 
            {
                desktop.open(tempHtmlFile);
            }
        } 
        else 
        {
            System.out.println("Desktop is not supported on your system.");
        }
    }    
}
