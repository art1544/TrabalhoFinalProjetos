public class SmsNotificationStrategy implements NotificationStrategy {
    @Override
    public void enviar(String mensagem, Participante participante) {
        System.out.println("Enviando SMS para " + participante.getTelefone() + ": '" + mensagem + "'");
        // Lógica de envio de SMS real...
    }
}