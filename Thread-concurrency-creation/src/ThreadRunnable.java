/**
 * Java no soporta herencia multiple, asique implementamos una interfaz
 */


public class ThreadRunnable implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i < 5; i++){
            System.out.println("Executing thread runnable " + Thread.currentThread().getName());
            System.out.println("Iteration number " + i);
            System.out.println("------");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
