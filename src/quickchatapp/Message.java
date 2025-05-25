package quickchatapp;

public class Message {
    private final String recipientCell;
    private final String messageText;

    public Message(String recipientCell, String messageText) {
        this.recipientCell = recipientCell;
        this.messageText = messageText;
    }

    public boolean checkRecipientCell() {
        // Only accept cell numbers starting with +27 and 11 digits total
        return recipientCell.matches("\\+27\\d{9}");
    }

    public boolean checkMessageLength() {
        return messageText.length() <= 250;
    }

    public String createMessageHash() {
        // Simple hash: uppercase message content without spaces
        return messageText.toUpperCase().replaceAll(" ", "") + recipientCell;
    }

    public void sendMessage() {
        if (!checkRecipientCell()) {
            System.out.println("Invalid cell number.");
            return;
        }

        if (!checkMessageLength()) {
            System.out.println("Message is too long.");
            return;
        }

        System.out.println("Message sent to: " + recipientCell);
        System.out.println("Message: " + messageText);
        System.out.println("Message Hash: " + createMessageHash());
    }
}
