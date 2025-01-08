import java.util.concurrent.RecursiveTask;

/*
This class represents a recursive task that can be executed in parallel.
It implements the compute() method to divide the task into smaller subtasks if necessary.
*/
public class ParallelismExample extends RecursiveTask<Integer> {

    private int[] array;
    private int start;
    private int end;
    private int threshold = 1000;

    public ParallelismExample(int[] array, int start, int end)
    {
        this.array = array;
        this.start = start;
        this.end = end;
    }
/*
Method.
If the task range is small enough (i.e., end - start <= threshold),
the sum of the elements in the array within the range defined by start and end is computed.

If the range is too large, the task is split into two subtasks:

The range is divided into two halves.
A new instance of ParallelismExample is created for each half of the array (left and right).
The left task is executed asynchronously using the fork() method.
The right task is executed sequentially with compute().
Then, the result of the left task is awaited using join(),
and the results of both tasks (left and right) are summed and returned.
*/
    @Override
    protected Integer compute()
    {
        if (end - start <= threshold)
        {
            int sum = 0;
            for (int i = start; i < end; i++)
            {
                sum += array[i];
            }
            return sum;
        }
        else
        {
            int half = start + (end - start) / 2;
            ParallelismExample leftTask = new ParallelismExample(array, start, half);
            ParallelismExample rightTask = new ParallelismExample(array, half, end);
            leftTask.fork();
            int rightResult = rightTask.compute();
            int leftResult = leftTask.join(); // join waits for the thread to end
            return leftResult + rightResult;
        }
    }
/*
An array of 100,000,000 integers is created and initialized with values ranging from 0 to 99,999,999.
An instance of the ParallelismExample class is created, which calculates the sum of the values in the array in parallel.
The execution time of the operation is measured using System.currentTimeMillis().
*/
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        int[] array = new int[100000000];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = i;
        }
        ParallelismExample task = new ParallelismExample(array, 0, array.length);
        long end = System.currentTimeMillis();
        System.out.println("Result: " + task.compute());
        System.out.println("Execution time: " + (end - start) + "ms");
    }
}

