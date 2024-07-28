import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChatRoom {
    private String roomId;
    private List<User> users;
    private List<String> messageHistory;

    public ChatRoom(String roomId) {
        this.roomId = roomId;
        this.users = new ArrayList<>();
        this.messageHistory = new ArrayList<>();
    }

    public void join(User user) {
        users.add(user);
        notifyUsers(user.getUsername() + " has joined the chat.");
    }

    public void leave(User user) {
        users.remove(user);
        notifyUsers(user.getUsername() + " has left the chat.");
    }

    public void sendMessage(User sender, String message) {
        String formattedMessage = "[" + sender.getUsername() + "] " + message;
        messageHistory.add(formattedMessage);
        notifyUsers(formattedMessage);
    }

    private void notifyUsers(String message) {
        for (User user : users) {
            user.update(message);
        }
    }

    public List<String> getActiveUsers() {
        return users.stream().map(User::getUsername).collect(Collectors.toList());
    }

    public List<String> getMessageHistory() {
        return messageHistory;
    }
}
