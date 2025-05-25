package quickchatapp;

public final class Message {

    static String returnTotalMessages() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private final String recipientCell;
    private final String messageText;
    public String messageHash;

    public Message(String recipientCell, String messageText) {
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }

    // 1. Validate the recipient's cell number
    public boolean checkRecipientCell() {
        // Must start with '+' and be 12 characters total (e.g., +27712345678)
        return recipientCell.startsWith("+27") && recipientCell.length() == 12;
    }

    // 2. Validate message length
    public boolean checkMessageLength() {
        return messageText.length() <= 250;
    }

    // 3. Create a hash based on message text (converted to uppercase words)
    public String createMessageHash() {
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

    // (Optional) Getters if needed
    public String getRecipientCell() {
        return recipientCell;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }

    Object sendMessage(String choice) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
