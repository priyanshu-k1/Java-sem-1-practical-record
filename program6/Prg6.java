// Write a program to demonstrate Linked list class.
import java.util.LinkedList;
public class Prg6 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10); 
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        display(list);
    }
    public static void display(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                System.out.print(list.get(i) + " -> ");
            } else {
                System.out.println(list.get(i));
            }
        }
    }
}

