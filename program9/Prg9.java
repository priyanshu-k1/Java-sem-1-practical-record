//Write a program to accept data and display output in key, value pair.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prg9 {
    public static void main(String[] args) {
        HashMap<String, Character> studentGrades = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Enter Student Data (Type 'exit' to finish) ---");
        while (true) {
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.print("Enter Grade (A, B, C, etc.): ");
            char grade = scanner.next().charAt(0);
            scanner.nextLine(); 
            studentGrades.put(name, grade);
        }

        System.out.println("\n--- Displaying Student Records ---");
        for (Map.Entry<String, Character> entry : studentGrades.entrySet()) {
            System.out.println("Key (Name): " + entry.getKey() + " | Value (Grade): " + entry.getValue());
        }
        scanner.close();
        
    }
}
