
public class ThreadExtendsMain {
    public static void main(String[] args){
// to create the thread using extends, simply instantiate the class
        ThreadExtends thread1 = new ThreadExtends();
        thread1.setName("Thread 1 from extend");
        thread1.start();
        ThreadExtends thread2 = new ThreadExtends();
        thread2.setName("Thread 2 from extend");
        thread2.start();
    }
}
