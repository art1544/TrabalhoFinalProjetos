public class EventoFactory {
    public static Evento criarEvento(String tipo, String nome) {
        if ("CORPORATIVO".equalsIgnoreCase(tipo)) {
            return new Evento(nome, new EmailNotificationStrategy());
        } else if ("COMUNIDADE".equalsIgnoreCase(tipo)) {
            return new Evento(nome, new SmsNotificationStrategy());
        }
        throw new IllegalArgumentException("Tipo de evento desconhecido.");
    }
}