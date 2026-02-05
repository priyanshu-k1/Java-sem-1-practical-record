//Write a program to demonstrate mutual exclusion using thread synchronization.

class BankAccount {
    private int balance = 0;
    public synchronized void deposit(String threadName, int amount) {
        System.out.println(threadName + " is depositing " + amount);
        int newBalance = balance + amount;
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        balance = newBalance;
        System.out.println(threadName + " finished. Current Balance: " + balance);
    }
}

class Transaction extends Thread {
    BankAccount account;
    String name;
    Transaction(BankAccount account, String name) {
        this.account = account;
        this.name = name;
    }
    public void run() {
        account.deposit(name, 100);
    }
}
public class Prg5 {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount();
        Transaction t1 = new Transaction(myAccount, "Thread-1");
        Transaction t2 = new Transaction(myAccount, "Thread-2");
        t1.start();
        t2.start();
    }
}