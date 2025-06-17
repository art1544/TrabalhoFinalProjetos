public interface Observer {
    void update(String mensagem, NotificationStrategy strategy);
    String getEmail(); // Método auxiliar para a strategy
    String getTelefone(); // Método auxiliar para a strategy
}