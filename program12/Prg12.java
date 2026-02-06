//Write a program to illustrate Serialization

import java.io.*;
class Employ implements Serializable { 
    
    private String empName;
    private int empSalary;
    private int empId;
    
    public Employ(String empName, int empSalary, int empId) {
        this.empName = empName;
        this.empSalary = empSalary;
        this.empId = empId;
    }

    public void display() {
        System.out.println("Name: " + empName);
        System.out.println("Salary: " + empSalary);
        System.out.println("ID: " + empId);
    }
}

public class Prg12{
    public static void main(String[] args) {
        String newfile = "employ.txt";
        
        // Create object and serialize
        Employ student = new Employ("Sarkar", 220002, 101);
        System.out.println("\n*********************************" + 
                "\n Displaying original object: \n"
        );
        student.display();
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(newfile))) {
            out.writeObject(student);
            System.out.println("*********************************");
            System.out.println("Object serialized to " + newfile);
            System.out.println("Open " + newfile + " to see the serialized data. \n");
        } catch (IOException e) {
            System.out.println("Thete is an error during serialization");
        }
        
    }
}
