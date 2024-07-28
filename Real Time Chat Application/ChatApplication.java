import java.util.List;
import java.util.ArrayList;
public class ChatApplication {
    public static void main(String[] args) {
        ChatRoomManager chatRoomManager = ChatRoomManager.getInstance();
        ChatRoom room = chatRoomManager.getOrCreateChatRoom("Room123");

        User alice = new User("Alice", new WebSocketAdapter());
        User bob = new User("Bob", new WebSocketAdapter());
        User charlie = new User("Charlie", new WebSocketAdapter());

        room.join(alice);
        room.join(bob);
        room.join(charlie);

        room.sendMessage(alice, "Hello, everyone!");
        room.sendMessage(bob, "How's it going?");
        room.sendMessage(charlie, "Goodbye!");

        List<String> activeUsers = room.getActiveUsers();
        for (String user : activeUsers) {
            System.out.println(user);
        }

        List<String> history = room.getMessageHistory();
        for (String message : history) {
            System.out.println(message);
        }

        room.leave(bob);
    }
}
