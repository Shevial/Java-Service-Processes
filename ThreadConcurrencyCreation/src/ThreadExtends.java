/**
 * Creation of threads by extending the Thread class
 *
 *  * - Extending the Thread class.
 *  * - Controlling thread execution.
 */

public class ThreadExtends extends Thread{
    public void run(){
       for(int i = 1; i < 5; i++){
           System.out.println("Executing thread " + Thread.currentThread().getName());
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
