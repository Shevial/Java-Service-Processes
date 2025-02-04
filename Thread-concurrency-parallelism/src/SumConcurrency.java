/**
 * SumConcurrency uses traditional threads to divide the task
 * of summing the elements of a large array into multiple parts.
 * In this case, it creates a fixed number of threads,
 * and each thread handles summing a portion of the array.
 * At the end, the results of the threads are combined to obtain the total sum.
 *
 * Each thread works independently on a section of the array.
 * It uses Thread.join() to wait for all threads to finish before continuing.
 * The number of threads is fixed and determined in advance.
 */



public class SumConcurrency extends Thread{
    private int[] array;
    private int sum;
    private int start;
    private int end;

    //constructor
    public SumConcurrency(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }
    //run method executes when thread starts
    public void run() {
        sum=0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
    }
    //
    public int getSum() {
        return sum;
    }

    public static void main(String [] args){
        int[]array = new int[100000000];
        for(int i = 0; i < array.length; i++){
            array[i] = i;
        }
        int numThreads = 2; // number of threads (independent of each other)
        SumConcurrency[] threads = new SumConcurrency[numThreads];
        int sizePerThread = array.length/numThreads;
        long initiate = System.currentTimeMillis();

        //loop that create threads
        for(int i = 0 ; i < numThreads; i++){
            int inicio = i * sizePerThread;
            int fin = (i + 1) * sizePerThread;
            if(i == numThreads - 1){
                fin=array.length;
            }
            threads[i] = new SumConcurrency(array, inicio, fin);
            threads[i].start();
        }
        //wait for threads to end
        for(int i=0; i<numThreads; i++){
            try{
                threads[i].join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        //sum the results
        int sumaTotal = 0;
        long ending = System.currentTimeMillis();
        for(int i = 0; i < numThreads; i++){
            sumaTotal+= threads[i].getSum();
        }
        System.out.println("La suma total es: " + sumaTotal);
        System.out.println("Tiempo de ejecución: " + (ending-initiate) + "ms");
    }
}
