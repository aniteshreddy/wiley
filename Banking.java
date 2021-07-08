package wiley.internship.com;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Banking {

    void showBalance(BankUser bankUser) {
        System.out.println(bankUser.balance);
    }

    void debit(BankUser bankUser, int debitA) {
        if (bankUser.balance - debitA >= 0) {
            bankUser.balance -= debitA;
            bankUser.addTransactions(new Transactions(java.time.LocalDateTime.now(), debitA));
            System.out.println("Transaction succesfull\nNow updated balance is");
            showBalance(bankUser);

        }
    }

    void miniStatement(BankUser bankUser) {
        bankUser.transactionList.stream().forEach(System.out::println);
    }

    void credit(BankUser bankUser, int credit) {
        bankUser.balance += credit;
        bankUser.addTransactions(new Transactions(java.time.LocalDateTime.now(), debitA));
        System.out.println("Transaction succesfull\n\n");
    }

    public static void main(String[] args) {
        BankUser user = null;
        List<BankUser> bankUsers = new ArrayList();
        bankUsers.add(new BankUser("Anitesh", 123456789, 200.0, 1235));
        //
        int val = 0;
        Banking banking = new Banking();
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        while (true) {
            if (loggedIn) {
                System.out.println("\f\f");
                System.out.println("User successfully logged in");

                while (val!=5) {
                    System.out.println("1. Check balance\n2. Mini statement\n3.Withdraw amount\n4. Credit\n5. Exit");
                    val = scanner.nextInt();
                    switch (val) {
                        case 1:
                            banking.showBalance(user);
                            break;
                        case 2:
                            banking.miniStatement(user);
                            System.out.println("\n\n");
                            break;
                        case 3:
                            System.out.println("Enter the amount to Withdraw");
                            banking.debit(user, scanner.nextInt());

                            System.out.println("\n\n");
                            break;
                        case 4:
                            System.out.println("Enter the amount to Withdraw");
                            banking.credit(user, scanner.nextInt());
                            System.out.println("\n\n");
                            break;

                        case 5:
                            System.out.println("User Logout successfull");
                            loggedIn=false;
                            break;
                        default:
                            if(val==5){
                                break;
                            }                        


                    }
                }

            } else {
                System.out.println("Enter account number");
                int acc = scanner.nextInt();
                System.out.println("Enter PIN");
                int pass = scanner.nextInt();

                user = bankUsers.stream().filter(e -> e.accountNum == acc).filter(a -> a.pin == pass).findAny()
                        .orElse(null);
                if (user == null) {
                    System.out.println("User not available");

                } else {
                    loggedIn = true;
                }

            }
        }
    }
}

class Transactions {
    final LocalDateTime date;
    final int amount;

    Transactions(LocalDateTime localDateTime, int amount) {
        this.amount = amount;
        this.date = localDateTime;
    }
}

class BankUser {
    String name;
    int accountNum;
    int pin;
    double balance;
    List<Transactions> transactionList = new ArrayList<>();

    void addTransactions(Transactions transactions) {
        transactionList.add(transactions);
    }

    BankUser(String name, int accountNum, Double balance, int pin) {
        this.name = name;
        this.accountNum = accountNum;
        this.balance = balance;
        this.pin = pin;
    }

}