import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        boolean loggedIn = true; // Simulated login
        if (!loggedIn) return;

        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");

        int totalMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages do you want to send?"));

        List<Message> messages = new ArrayList<>();
        int sentCount = 0;

        while (true) {
            String menu = JOptionPane.showInputDialog("Choose an option:\n1) Send Messages\n2) Show recently sent messages\n3) Quit");
            switch (menu) {
                case "1":
                    for (int i = 0; i < totalMessages; i++) {
                        String recipient = JOptionPane.showInputDialog("Enter recipient phone number (e.g., +27718693002):");
                        String msg = JOptionPane.showInputDialog("Enter your message:");

                        if (msg.length() > 250) {
                            JOptionPane.showMessageDialog(null, "Message exceeds 250 characters by " + (msg.length() - 250) + ", please reduce size!");
                            i--;
                            continue;
                        }

                        Message message = new Message(recipient, msg);

                        String choice = JOptionPane.showInputDialog("Choose:\nSend\nStore\nDisregard");
                        JOptionPane.showMessageDialog(null, message.sendMessage(choice));
                        
                        if (choice.equalsIgnoreCase("Send")) {
                            messages.set(sentCount++, message);
                            JOptionPane.showMessageDialog(null, message.printMessage());
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Total messages sent: " + Message.returnTotalMessages());
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon.");
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice.");
            }
        }
    }
}

