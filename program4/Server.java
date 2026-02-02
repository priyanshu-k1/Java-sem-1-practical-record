import java.io.*;
import java.net.*;


// This class handles the logic for each individual client
class ClientHandler implements Runnable {
    private final Socket socket;
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){
        try (InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true); socket) {
            String text;

            while ((text = reader.readLine()) != null) {
                System.out.println("Received from client: " + text);
                writer.println("Server echoed: " + text);  
                if ("bye".equalsIgnoreCase(text)) break;
            }
        } 
        catch (IOException ex) {
            System.out.println("Handler exception: " + ex.getMessage());
        }
    }
}

public class Server {
    public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                new Thread(new ClientHandler(socket)).start();
            }
        } 
        catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
        }
    }  
}




