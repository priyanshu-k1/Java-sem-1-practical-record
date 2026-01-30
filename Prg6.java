// Write a program to demonstrate Linked list class.

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = this;
        return newNode;
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        Node current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    void display() {
        Node current = this;
        while (current != null) {
            if (current.next != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            } 
            else {
                System.out.println(current.data);
                break;
            }
        }

    }
}

public class Prg6 {

    public static void main(String[] args) {
        Node head = new Node(10);
        head.insertAtEnd(20);
        head.insertAtEnd(30);
        head = head.insertAtBeginning(5);
        head.display();
    }
}
