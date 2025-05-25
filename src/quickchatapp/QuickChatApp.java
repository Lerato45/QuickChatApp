package quickchatapp;

import java.util.Scanner;

public class QuickChatApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to QuickChat.");

        // Simple login system
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // You can change this login check if you have real users
        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid login. Exiting app.");
            return;
        }

        System.out.print("How many messages would you like to send? ");
        int totalMessages = Integer.parseInt(scanner.nextLine());
        Message[] messages = new Message[totalMessages];
        int messageCount = 0;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1) Send Message");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Enter option (1-3): ");
            String option = scanner.nextLine();

            switch (option) {
                case "1" -> {
                    if (messageCount < totalMessages) {
                        System.out.print("Enter recipient number: ");
                        String cell = scanner.nextLine();

                        System.out.print("Enter message: ");
                        String text = scanner.nextLine();

                        Message msg = new Message(cell, text);
                        messages[messageCount] = msg;
                        msg.sendMessage();  // Only works if Message.java has this method implemented correctly
                        messageCount++;
                    } else {
                        System.out.println("Message limit reached.");
                    }
                }
                case "2" -> System.out.println("Coming Soon.");
                case "3" -> {
                    System.out.println("Exiting QuickChat. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
