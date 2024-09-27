//concorrente
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Waiter waiter = new Waiter(4);
        Fork[] forks = new Fork[5];
        String[] names = new String[]{"Aristoteles", "Socrates", "Platao", "Pascal", "Locke"};
        Philosopher[] phil = new Philosopher[5];

        // Criando os garfos
        for (int i = 0; i < 5; i++) {
            forks[i] = new Fork();
        }

        // Criando os filósofos
        for (int i = 0; i < 5; i++) {
            phil[i] = new Philosopher(waiter, forks, i, names[i]);
        }

        // Iniciando as threads dos filósofos
        for (int i = 0; i < 5; i++) {
            phil[i].start();
            Thread.sleep(5000); // 5 segundos entre cada filósofo iniciar
        }

        // Esperando os filósofos terminarem
        for (int i = 0; i < 5; i++) {
            phil[i].join();
        }

        System.out.println("Mesa vazia.");
        System.out.println("Ordem de encerramento: " + String.join(", ", Philosopher.getOrderFinished()));
    }
}
