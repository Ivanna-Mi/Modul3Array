package javaapplication2;

import java.util.Scanner;

public class JavaApplication2 {

    static final int MAX = 100;
    static String[] names = new String[MAX];
    static String[] passes = new String[MAX];
    static String[] phones = new String[MAX];
    static int count = 0;

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
    //==========================
    public static void inputData(Scanner sc) {
        System.out.print("Name : ");
        names[count] = sc.nextLine();
        System.out.print("Pass : ");
        passes[count] = sc.nextLine();
        String phone;
        do {
            System.out.print("Phone : ");
            phone = sc.nextLine();
            if (!phone.matches("\\d+")) {
                System.out.println("Phone must contain only numbers!");
            }
        } while (!phone.matches("\\d+"));

        phones[count] = phone;
        count++;
        System.out.println("New data is added\n");
    }

    // Function show data
    //==========================
    public static void showData() {
        if (count == 0) {
            System.out.println("No data exists!\n");
        } else {
            System.out.println("===============================================");
            System.out.printf("%-5s %-15s %-15s %-15s\n", "No", "Name", "Pass", "Phone");
            System.out.println("===============================================");
            for (int i = 0; i < count; i++) {
                System.out.printf("%-5d %-15s %-15s %-15s\n", i + 1, names[i], passes[i], phones[i]);
            }
            System.out.println();
        }
    }

    // Function delete data
    //==========================
    public static void deleteData(Scanner sc) {
        if (count == 0) {
            System.out.println("No data exists!\n");
        } else {
            System.out.println("===============================================");
            System.out.printf("%-5s %-15s %-15s %-15s\n", "No", "Name", "Pass", "Phone");
            System.out.println("===============================================");
            for (int i = 0; i < count; i++) {
                System.out.printf("%-5d %-15s %-15s %-15s\n", i + 1, names[i], passes[i], phones[i]);
            }
            System.out.println();
            
            System.out.print("Input data number to be deleted: ");
            int del = sc.nextInt();
            sc.nextLine();
            if (del > 0 && del <= count) {
                for (int i = del - 1; i < count - 1; i++) {
                    names[i] = names[i + 1];
                    passes[i] = passes[i + 1];
                    phones[i] = phones[i + 1];
                }
                count--;
                System.out.println("Data is removed\n");
            } else {
                System.out.println("Invalid number!\n");
            }
        }
    }
}
