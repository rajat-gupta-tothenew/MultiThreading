
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ans2FixedTheardPool{

    public static void main(String[] args) {

        Runnable task1 = () -> {
            System.out.println(Thread.currentThread().getName() + " TASK 1");
        };
        Runnable task2=()->
        {
            System.out.println(Thread.currentThread().getName()+ " TASK 2");
        };
        ExecutorService executorService = Executors.Ans2newFixedThreadPool(3);
        for (int i = 0; i <= 5; i++) {
            executorService.execute(task1);
        }
    }
}
