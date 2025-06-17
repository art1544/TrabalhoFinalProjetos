
public class EmailNotificationStrategy implements NotificationStrategy {
    @Override
    public void enviar(String mensagem, Participante participante) {
        System.out.println("Enviando E-MAIL para " + participante.getEmail() + ": '" + mensagem + "'");
        // Lógica de envio de e-mail real...
    }
}