package modul3arraylist;

import java.util.ArrayList;
import java.util.Scanner;

class User {
    String name;
    String pass;
    String phone;

    User(String name, String pass, String phone) {
        this.name = name;
        this.pass = pass;
        this.phone = phone;
    }
}

public class Modul3ArrayList {

    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Input Data");
            System.out.println("2. Show Data");
            System.out.println("3. Delete Data");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    inputData(sc);
                    break;
                case 2:
                    showData();
                    break;
                case 3:
                    deleteData(sc);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        } while (choice != 4);

        sc.close();
    }

    // Function input data
    //=====================
    public static void inputData(Scanner sc) {
        System.out.print("Name : ");
        String name = sc.nextLine();
        System.out.print("Pass : ");
        String pass = sc.nextLine();

        String phone;
        do {
            System.out.print("Phone : ");
            phone = sc.nextLine();
            if (!phone.matches("\\d+")) {
                System.out.println("Phone must contain only numbers!");
            }
        } while (!phone.matches("\\d+"));

        users.add(new User(name, pass, phone));
        System.out.println("New data is added\n");
    }

    // Function show data
    //====================
    public static void showData() {
        if (users.isEmpty()) {
            System.out.println("No data exists!\n");
        } else {
            System.out.println();
            System.out.println("===============================================");
            System.out.printf("%-5s %-15s %-15s %-15s\n", "No", "Name", "Pass", "Phone");
            System.out.println("===============================================");
            for (int i = 0; i < users.size(); i++) {
                User u = users.get(i);
                System.out.printf("%-5d %-15s %-15s %-15s\n", i + 1, u.name, u.pass, u.phone);
            }
            System.out.println();
        }
    }

    // Function delete data
    //======================
    public static void deleteData(Scanner sc) {
        if (users.isEmpty()) {
            System.out.println("No data exists!\n");
        } else {
            System.out.println("===============================================");
            System.out.printf("%-5s %-15s %-15s %-15s\n", "No", "Name", "Pass", "Phone");
            System.out.println("===============================================");
            for (int i = 0; i < users.size(); i++) {
                User u = users.get(i);
                System.out.printf("%-5d %-15s %-15s %-15s\n", i + 1, u.name, u.pass, u.phone);
            }
            System.out.println();
            System.out.print("Input data number to be deleted: ");
            int del = sc.nextInt();
            sc.nextLine();
            if (del > 0 && del <= users.size()) {
                users.remove(del - 1);
                System.out.println("Data is removed\n");
            } else {
                System.out.println("Invalid number!\n");
            }
        }
    }
}
