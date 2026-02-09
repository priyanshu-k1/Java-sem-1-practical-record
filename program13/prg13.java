//13.Write a program to retrieve web page using URL class.

import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class prg13 {
    public static void main(String[] args) throws Exception {
        // 1. Point to the website
        URL url = new URI("https://avanthipg.ac.in/").toURL();

        // 2. Read the website content into one String
        Scanner sc = new Scanner(url.openStream());
        sc.useDelimiter("\\A"); // This tells Scanner to read everything at once
        String content = sc.next();

        // 3. Simple "Slicing" to find the Title
        int start = content.indexOf("<title>") + "<title>".length();
        int end = content.indexOf("</title>");
        
        String title = content.substring(start, end);

        System.out.println("\nWebsite Title is: " + title);
        sc.close();
    }
}