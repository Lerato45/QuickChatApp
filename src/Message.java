import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

public final class Message {
    private final String messageID;
    private final String recipient;
    private final String messageText;
    private final String messageHash;
    private static int totalMessages = 0;
    private static int messageCount = 0;

    public Message(String recipient, String messageText) {
        this.messageID = generateMessageID();
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
        messageCount++;
        totalMessages++;
    }

    private String generateMessageID() {
        return String.format("%010d", (long)(Math.random() * 1_000_000_0000L));
    }

    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    public boolean checkRecipientCell() {
        return recipient.length() >= 10 && recipient.length()<=13 && recipient.startsWith("+");
    }

    public String createMessageHash() {
        String[] words = messageText.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        return messageID.substring(0, 2) + ":" + messageCount + ":" + firstWord.toUpperCase() + lastWord.toUpperCase();
    }

    public String sendMessage(String option) {
        switch (option) {
            case "Send" -> {
                return "Message successfully sent.";
            }
            case "Disregard" -> {
                return "Press 0 to delete message.";
            }
            case "Store" -> {
                storeMessage();
                return "Message successfully stored.";
            }
            default -> {
                return "Invalid option.";
            }
        }
    }

    public void storeMessage() {
        try (FileWriter writer = new FileWriter("messages.json", true)) {
            Gson gson = new Gson();
            gson.toJson(this, writer);
        } catch (IOException e) {
            System.out.println("Error saving message: " + e.getMessage());
        }
    }

    public String printMessage() {
        return "Message ID: " + messageID + "\nHash: " + messageHash + "\nRecipient: " + recipient + "\nMessage: " + messageText;
    }

    public static int returnTotalMessages() {
        return totalMessages;
    }

    int length() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

