//Write a program to demonstrate Hash set and Iterator classes

import java.util.HashSet;
import java.util.Iterator;

public class Prg7 {
        public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Warangal");
        cities.add("Karimnagar");
        cities.add("Hyderabad");
        cities.add("Siddipet");
        System.out.println("Iterating through the set:");
        Iterator<String> it = cities.iterator();

        while (it.hasNext()) {
            String cityName = it.next();
            if (cityName.equals("Tokyo")) {
                it.remove();
                System.out.println("Removed Tokyo.");
            } else {
                System.out.println("City: " + cityName);
            }
        }
    }
    
}




