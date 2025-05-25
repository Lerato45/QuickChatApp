package quickchatapp;

import java.util.Scanner;

public class QuickChatApp {

    private static boolean loggedIn = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Login
        while (!loggedIn) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            // You can add real login logic later
            if (username.equals("admin") && password.equals("password")) {
                loggedIn = true;
                System.out.println("\nWelcome to QuickChat.\n");
            } else {
                System.out.println("Login failed. Try again.\n");
            }
        }

        // 2. Set message limit
        System.out.print("How many messages do you want to send? ");
        int messageLimit = Integer.parseInt(scanner.nextLine());
        int messagesSent = 0;

        while (true) {
            // 3. Display menu
            System.out.println("\nChoose an option:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");

            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (messagesSent < messageLimit) {
                        System.out.print("Enter recipient: ");
                        String recipient = scanner.nextLine();

                        System.out.print("Enter your message: ");
                        String text = scanner.nextLine();

                        Message message = new Message(recipient, text);
                        System.out.println("\n" + message.printMessage());

                        messagesSent++;
                    } else {
                        System.out.println("Message limit reached.\n");
                    }
                    break;
                case "2":
                    System.out.println("Coming Soon.\n");
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

