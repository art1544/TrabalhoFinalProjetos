public class Participante implements Observer {
    private String nome;
    private String email;
    private String telefone;

    public Participante(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    @Override
    public void update(String mensagem, NotificationStrategy strategy) {
        System.out.print("[" + this.nome + "] Recebeu uma notificação. ");
        strategy.enviar(mensagem, this);
    }
    
    @Override 
    public String getEmail() { 
        return this.email; 
    }
    
    @Override 
    public String getTelefone() { 
        return this.telefone; 
    }
}