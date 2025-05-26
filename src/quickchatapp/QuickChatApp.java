package quickchatapp;

import java.util.Scanner;

public class QuickChatApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login with hardcoded validation
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Allow any password EXCEPT "password1"
        if (password.equalsIgnoreCase("password1")) {
            System.out.println("Invalid login. Exiting app.");
            return;
        }

        // Login success
        System.out.println("Welcome to QuickChat!");

        // Ask how many messages the user wants to send
        System.out.print("How many messages would you like to send? ");
        int maxMessages = Integer.parseInt(scanner.nextLine());
        int messagesSent = 0;

        while (true) {
            // Menu
            System.out.println("\nMenu:");
            System.out.println("1) Send Message");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    if (messagesSent < maxMessages) {
                        // Prompt for message details
                        System.out.print("Enter recipient cellphone number (+27...): ");
                        String recipient = scanner.nextLine();

                        System.out.print("Enter your message: ");
                        String messageText = scanner.nextLine();

                        // Create and validate message
                        Message message = new Message(recipient, messageText);
                        String result = message.printMessage();
                        System.out.println(result);

                        // Count only valid messages
                        if (!result.startsWith("Invalid")) {
                            messagesSent++;
                        }
                    } else {
                        System.out.println("Message limit reached.");
                    }
                }

                case "2" -> {
                    System.out.println("Coming Soon.");
                }

                case "3" -> {
                    System.out.println("Goodbye!");
                    return;
                }

                default -> {
                    System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }
}
