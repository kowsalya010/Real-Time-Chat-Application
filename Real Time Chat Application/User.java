public class User {
    private String username;
    private IClientCommunication clientCommunication;

    public User(String username, IClientCommunication clientCommunication) {
        this.username = username;
        this.clientCommunication = clientCommunication;
    }

    public String getUsername() {
        return username;
    }

    public void update(String message) {
        clientCommunication.sendMessage(message);
    }
}
