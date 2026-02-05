//Write a program to demonstrate Enumeration and Comparator interfaces.
import java.util.*;

class Prg8{
    public static void main(String[] args) {
        Vector<Integer> numbers = new Vector<>();
        numbers.add(10);
        numbers.add(50);
        numbers.add(30);

        Comparator<Integer> highToLow = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        };

        Collections.sort(numbers, highToLow);
        System.out.println("Sorted high to low: " + numbers);

        System.out.println("Printing via Enumeration:");
        Enumeration<Integer> e = numbers.elements();
        
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }
}



