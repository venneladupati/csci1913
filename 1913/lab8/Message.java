//Author: vennela dupati
public class Message {
    
    private String sender;
    private String recipient;
    private String message;

    /**
     * constructor
     * @param sender - sender of message
     * @param recipient - recipient of message
     * @param message - message string
     */
    public Message(String sender, String recipient, String message) {
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;

    }

    /**
     * 
     * @return the sender of message
     */
    public String getFrom() {
        return sender;
    }

    /**
     * 
     * @return the recipient of the message
     */
    public String getTo() {
        return recipient;
    }

    /**
     * changes the recipient of message
     * @param newReci - new recipient of message
     */
    public void setTo(String newReci){
        recipient = newReci;
    }

    /**
     * @return the message string
     */
    public String getMessage() {
        return message;
    }

    /**
     * changes the message
     * @param newMesg - new message
     */
    public void setMessage(String newMesg){
        message = newMesg;
    }

    /**
     * prints out a string contain the message's details
     */
    public String toString() {
        return "Message from: " + sender + " to: " + recipient + " Message: \"" + message + "\"";

    }

}
