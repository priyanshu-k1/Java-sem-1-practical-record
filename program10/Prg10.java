import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream; 
import java.io.FileNotFoundException;
import java.io.IOException;

public class Prg10 {
    public static void main(String[] args) {
        File fileOne = new File("C:\\Users\\priya\\Documents\\GitHub\\Java-sem-1-practical-record\\program10\\textFileOne.txt");
        File fileTwo = new File("C:\\Users\\priya\\Documents\\GitHub\\Java-sem-1-practical-record\\program10\\textFileTwo.txt");
        if (fileOne.exists()) {
            try (FileInputStream fis = new FileInputStream(fileOne);
                 FileOutputStream fos = new FileOutputStream(fileTwo)) {
                
                int byte_value;
                while ((byte_value = fis.read()) != -1) {
                    fos.write(byte_value);
                }
                System.out.println("File copied successfully!");
                
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("IO Error: " + e.getMessage());
            }
        } else {
            System.out.println("Source file does not exist.");
        }
    }
}