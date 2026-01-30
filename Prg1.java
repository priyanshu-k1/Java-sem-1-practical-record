// Write a program to calculate salary of n employees using concept of classes with constructors and methods.
import java.io.*;


class Employee{
    int id;
    String name;
    double basicSalary,netSalary;


    public Employee(int id, String name , double basicSalary){
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public double calculateNetSalary() {
        double allowance = 0.15 * basicSalary;
        double pf = 0.12 * basicSalary;
        double tax = 0.10 * basicSalary;
        double grossSalary = basicSalary + allowance;
        netSalary = grossSalary - (pf + tax);
        return netSalary;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Gross Salary: " + calculateNetSalary());
        System.out.println("---------------------------");
    }


}

public class Prg1 {
    public static void main(String[] args) throws IOException {
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of employees: ");
        int noOfEmployee = Integer.parseInt(input.readLine());

        Employee[] employees = new Employee[noOfEmployee];

        for(int i = 0 ; i < noOfEmployee ; i++){

            System.out.println("Enter details for employee " + (i + 1));
            System.out.print("ID: ");
            int id = Integer.parseInt(input.readLine());

            System.out.print("Name: ");
            String name = input.readLine();

            System.out.print("Basic Salary: ");
            double basicSalary = Double.parseDouble(input.readLine());

            employees[i] = new Employee(id, name, basicSalary);

        }

        System.out.println("\n--- Employee Salary Details ---");
        for (int i = 0; i < noOfEmployee; i++) {
            employees[i].displayDetails();
        }

    }
    
}
