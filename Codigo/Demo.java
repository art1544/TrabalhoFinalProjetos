public class Demo {
    public static void main(String[] args) {
        // 1. Usando a Factory para criar eventos
        Evento eventoCorp = EventoFactory.criarEvento("CORPORATIVO", "Reunião Anual de Vendas");
        Evento eventoComu = EventoFactory.criarEvento("COMUNIDADE", "Festival de Rua");

        // 2. Criando participantes (Observers)
        Participante p1 = new Participante("Ana", "ana@empresa.com", "9999-0001");
        Participante p2 = new Participante("Bruno", "bruno@provedor.com", "9999-0002");
        Participante p3 = new Participante("Carla", "carla@email.com", "9999-0003");

        // 3. Inscrevendo participantes nos eventos
        eventoCorp.inscrever(p1);
        eventoCorp.inscrever(p2);

        eventoComu.inscrever(p2);
        eventoComu.inscrever(p3);

        // 4. Disparando as notificações
        eventoCorp.notificarInscritos("O local da reunião foi alterado para o Auditório Principal.");
        eventoComu.notificarInscritos("O festival foi adiado em 1 hora devido à chuva.");
    }
}