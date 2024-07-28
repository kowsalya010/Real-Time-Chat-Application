public class HttpAdapter implements IClientCommunication {
    @Override
    public void sendMessage(String message) {
        System.out.println("[HTTP] " + message);
    }
}
