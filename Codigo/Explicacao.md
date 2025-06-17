# Explicação dos Padrões de Projeto Aplicados

[cite_start]Este documento detalha os padrões de projeto GoF (Gang of Four) que foram escolhidos e implementados no sistema de Gerenciamento de Eventos, conforme os requisitos do trabalho. 

---

### 1. Padrão Strategy

* **O que é?**
    O padrão **Strategy** permite definir uma família de algoritmos, colocar cada um deles em uma classe separada e torná-los intercambiáveis.

* **Onde foi aplicado?**
    Foi aplicado no sistema de notificação. Criamos a interface `NotificationStrategy` e duas implementações concretas: `EmailNotificationStrategy` e `SmsNotificationStrategy`. A classe `Evento` recebe e utiliza um objeto dessa estratégia para enviar suas notificações.

* **Benefício Obtido: Flexibilidade e Desacoplamento**
    A classe `Evento` não precisa conhecer os detalhes de como uma notificação é enviada. Podemos adicionar novas formas de notificação (como WhatsApp ou Push Notification) sem alterar a classe `Evento`, apenas criando uma nova classe que implemente a interface `NotificationStrategy`.

---

### 2. Padrão Factory Method

* **O que é?**
    O padrão **Factory Method** fornece uma interface para criar objetos, mas permite que as subclasses (ou uma classe fábrica dedicada) decidam qual classe instanciar.

* **Onde foi aplicado?**
    Na classe `EventoFactory`, com o método estático `criarEvento()`. A fábrica centraliza a lógica de criação e decide, com base no tipo de evento ("Corporativo" ou "Comunidade"), qual `NotificationStrategy` o evento deve usar como padrão.

* **Benefício Obtido: Centralização e Encapsulamento da Criação**
    A lógica de criação de objetos complexos fica centralizada em um único ponto. O código cliente que solicita um evento não precisa saber das regras de negócio (por exemplo, que um evento corporativo notifica por e-mail). Isso simplifica o código, reduz a duplicação e facilita a manutenção.

---

### 3. Padrão Observer

* **O que é?**
    O padrão **Observer** define uma dependência um-para-muitos entre objetos. Quando um objeto (o *Subject*) muda de estado, todos os seus dependentes (os *Observers*) são notificados e atualizados automaticamente.

* **Onde foi aplicado?**
    A classe `Evento` atua como o *Subject* (ou observável) e a classe `Participante` atua como o *Observer* (ou observador). Cada `Evento` mantém uma lista de `Participantes` inscritos. Quando o método `notificarInscritos()` é chamado, ele percorre a lista e chama o método `update()` de cada participante.

* **Benefício Obtido: Baixo Acoplamento**
    O `Evento` não "conhece" os detalhes dos `Participantes`; ele sabe apenas que são `Observers` que podem receber notificações. Isso permite que outros tipos de observadores (como um sistema de logs ou um painel de monitoramento) possam se inscrever para receber notificações no futuro, sem que seja necessário modificar a classe `Evento`. Isso promove um design mais limpo, flexível e extensível.