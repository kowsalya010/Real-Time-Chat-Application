public class WebSocketAdapter implements IClientCommunication {
    @Override
    public void sendMessage(String message) {
        System.out.println("[WebSocket] " + message);
    }
}
