/*
* 11. Write a Java program to add two text files and save the result in another text file.
*  
*  Sample Input: file1.txt and file2.txt 
*  Sample Output: Two text files added successfully
*/
import java.io.*;
public class Prg11 {
    public static void main(String[] args) {

        try {
            BufferedReader br1 = new BufferedReader(new FileReader("file1.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("file2.txt"));

            String line1,line2;

            // Read both file
            while ((line1 = br1.readLine()) != null
                && (line2 = br2.readLine()) != null)
            {
                    // Print the content of both file
                if (line1 != null && line2 != null) 
                {
                    System.out.println("\n************************\n");
                    System.out.println(line1);
                    System.out.println(line2);
                    System.out.println("\n************************\n");
                }
            }
            br1.close();
            br2.close();

            System.out.println("Two text files added successfully");

        } catch (IOException e) {
            System.out.println("Error occurred");
        }
    }
}