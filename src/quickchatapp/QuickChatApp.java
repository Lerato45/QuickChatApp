package quickchatapp;

import java.util.Scanner;

public class QuickChatApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean isLoggedIn = false;

    public static void main(String[] args) {
        System.out.println("Welcome to QuickChat.");

        // Login simulation
        isLoggedIn = login();

        if (!isLoggedIn) {
            System.out.println("Login failed. Exiting...");
            return;
        }

        // Ask how many messages user wants to send
        System.out.print("How many messages would you like to send? ");
        int totalMessages = Integer.parseInt(scanner.nextLine());
        Message[] messages = new Message[totalMessages];

        int messageIndex = 0;
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1) Send Message");
            System.out.println("2) Show Recently Sent Messages");
            System.out.println("3) Quit");
            System.out.print("Choose an option: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1" -> {
                    if (messageIndex < totalMessages) {
                        System.out.print("Enter recipient cell number (e.g., +27...): ");
                        String recipient = scanner.nextLine();

                        System.out.print("Enter message: ");
                        String messageText = scanner.nextLine();

                        Message message = new Message(recipient, messageText);
                        messages[messageIndex] = message;
                        messageIndex++;

                        System.out.println(message.sendMessage("Send"));
                        System.out.println(message.printMessage());
                    } else {
                        System.out.println("Message limit reached. Cannot send more messages.");
                    }
                }

                case "2" -> System.out.println("Coming Soon.");

                case "3" -> {
                    System.out.println("Exiting QuickChat. Goodbye!");
                    running = false;
                }

                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static boolean login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Basic login simulation
        return username.equals("admin") && password.equals("password123");
    }
}
