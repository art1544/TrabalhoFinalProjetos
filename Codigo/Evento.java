import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nome;
    private List<Observer> inscritos = new ArrayList<>();
    private NotificationStrategy notificationStrategy;

    public Evento(String nome, NotificationStrategy strategy) {
        this.nome = nome;
        this.notificationStrategy = strategy;
        System.out.println("Evento '" + nome + "' criado com notificação via " + strategy.getClass().getSimpleName());
    }

    public void inscrever(Observer observer) {
        inscritos.add(observer);
    }

    public void desinscrever(Observer observer) {
        inscritos.remove(observer);
    }

    public void notificarInscritos(String mensagem) {
        System.out.println("\nNotificando " + inscritos.size() + " inscritos sobre o evento '" + nome + "'...");
        for (Observer observer : inscritos) {
            observer.update(mensagem, this.notificationStrategy);
        }
    }
}