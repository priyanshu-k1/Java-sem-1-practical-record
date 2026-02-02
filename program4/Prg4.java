//Write a program to demonstrate client-server environment using multithreading.
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Prg4 {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(hostname, port);
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {

            Scanner scanner = new Scanner(System.in);
            String text;
            System.out.println("Connected to server. Type your messages (type 'bye' to quit):");

            do {
                System.out.print("Enter text: ");
                text = scanner.nextLine();
                writer.println(text);

                String response = reader.readLine();
                System.out.println(response);

            } while (!text.equals("bye"));
            scanner.close();

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }

}