public class ThreadRunnableMain {
    public static void main(String[] args){
        // to create the thread using the Runnable interface,
        // pass an instance of the Runnable class to the Thread constructor along with the thread's name
        // para crear el hilo utilizando la interfaz Runnable,
        // pasa una instancia de la clase Runnable al constructor de Thread junto con el nombre del hilo
        Thread thread1 = new Thread(new ThreadRunnable(), "Runnable thread 1 ");
        Thread thread2 = new Thread(new ThreadRunnable(), "Runnable thread 2 ");
        thread1.start(); //calling run method from Runnable Class
        thread2.start();
    }
}
