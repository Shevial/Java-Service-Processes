/**
 * A lambda expression in Java is a concise way to write an anonymous function,
 * meaning a function without a name. It is used to implement interfaces with a single method,
 * such as functional interfaces.
 * Lambda expressions simplify the code by allowing more direct blocks of code to be written.
 */
public class ThreadLambdaMain {
    public static void main(String[] args){
        Thread thread1 = new Thread(
                () -> { // Lambda expression directly in the constructor
                    for(int i = 1; i < 5; i++){
                           System.out.println("Executing thread runnable " + Thread.currentThread().getName());
                           System.out.println("Priority " + Thread.currentThread().getPriority());
                           System.out.println("Iteration number " + i);
                           System.out.println("------");
                           try {
                               Thread.sleep(1000);
                           } catch (InterruptedException e) {
                               throw new RuntimeException(e);
                           }
                    }
                }
        );
        thread1.start();
    }
}
