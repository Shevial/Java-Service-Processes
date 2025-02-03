/*
The thread is the basic unit of execution.
The Thread class allows you to manage multiple units of execution.
*/
public class ThreadExample extends Thread {
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Executing thread " + i);
        }
    }

    public static void main(String[] args) {
        ThreadExample thread = new ThreadExample();
        ThreadExample thread2= new ThreadExample();
        thread.start();

        thread2.start();
    }
}

