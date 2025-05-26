package quickchatapp;

public class Message {
    private final String recipientCell;
    private final String messageText;
    private final String messageHash;

    public Message(String recipientCell, String messageText) {
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }

    // 1. Validate the recipient's cell number
    public boolean checkRecipientCell() {
        // Must start with '+27' and be 12 characters total
        return recipientCell.startsWith("+27") && recipientCell.length() == 12;
    }

    // 2. Validate message length
    public boolean checkMessageLength() {
        return messageText.length() <= 250;
    }

    // 3. Create a hash based on message text (converted to uppercase words)
    public final String createMessageHash() {
        String[] words = messageText.toUpperCase().split(" ");
        StringBuilder hash = new StringBuilder();

        for (String word : words) {
            hash.append("#").append(word);
        }

        return hash.toString();
    }

    // 4. Print message details
    public String printMessage() {
        if (!checkRecipientCell()) {
            return "Invalid recipient number. It must start with +27 and be 12 characters long.";
        }

        if (!checkMessageLength()) {
            return "Message is too long. Limit is 250 characters.";
        }

        return "To: " + recipientCell + "\nMessage: " + messageText + "\nHash: " + messageHash;
    }

    
    public String getRecipientCell() {
        return recipientCell;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }
}
