import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {

    private static final int MAX_MESSAGE_LENGTH = 250;

    @Test
    public void testCheckRecipientCell_ValidCellNumber() {
        Message msg = new Message("+27718693002", "Hi Mike");
        assertTrue("Expected valid cell number to return true", msg.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCell_InvalidCellNumber() {
        Message msg = new Message("08575975889", "Hi");
        assertFalse("Expected invalid cell number to return false", msg.checkRecipientCell());
    }

    @Test
    public void testMessageLength_ValidLength() {
        String message = "Short message";
        assertTrue("Message length should be valid", message.length() <= MAX_MESSAGE_LENGTH);
    }

    @Test
    public void testMessageLength_ExceedsMaxLength() {
        String message = "A".repeat(MAX_MESSAGE_LENGTH + 1);
        assertFalse("Message length should exceed the maximum limit", message.length() <= MAX_MESSAGE_LENGTH);
    }

    @Test
    public void testCreateMessageHash_ContainsExpectedContent() {
        Message msg = new Message("+27718693002", "Hi Mike");
        String hash = msg.createMessageHash();
        assertTrue("Hash should contain 'HI' and 'MIKE'", hash.contains("HI") && hash.contains("MIKE"));
    }
}
