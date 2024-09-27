public class Fork {
    private boolean lock = false;

    // Pegar o garfo (retardando em 1 segundo)
    public synchronized void vb() throws InterruptedException {
        while (lock) {
            wait();
        }
        lock = true;
        Thread.sleep(1000); // 1 segundo para pegar o garfo
    }

    // Soltar o garfo (retardando em 1 segundo)
    public synchronized void pb() {
        if (lock) {
            notify();
        }
        lock = false;
    }
}
