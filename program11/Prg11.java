/*
* 11. Write a Java program to add two text files and save the result in another text file.
*  
*  Sample Input: file1.txt and file2.txt 
*  Sample Output: Two text files added successfully
*/
import java.io.*;
public class Prg11 {
        public static void main(String[] args) {
        String file1Path = "file1.txt";
        String file2Path = "file2.txt";
        StringBuilder concatenatedContent = new StringBuilder();

        try { 
            BufferedReader reader1 = new BufferedReader(new FileReader(file1Path));
            String line;
            while ((line = reader1.readLine()) != null) {
                concatenatedContent.append(line).append("\n");
            }
            reader1.close(); 
            BufferedReader reader2 = new BufferedReader(new FileReader(file2Path));
            while ((line = reader2.readLine()) != null) {
                concatenatedContent.append(line).append("\n");
            }
            reader2.close(); 
            System.out.println("\nConcatenated Content:");
            System.out.println("\n*************************");
            System.out.println(concatenatedContent.toString());
            System.out.println("*************************\n");

        } catch (IOException e) {
            System.out.println("An error occurred while reading files: " + e.getMessage());
        }
    }
}