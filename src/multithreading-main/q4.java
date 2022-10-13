 

import java.util.Random;
import java.util.concurrent.*;
 
class LoopTask implements Runnable {
    private static int count = 0;
    private int id;

    @Override
    public void run() {
        System.out.println("##### <Task-"+id+"> Starting #####");
        for (int i = 5; i > 0; i--) {
            System.out.println("<"+id+"> Tick Tick - "+i);
            try {
                TimeUnit.MILLISECONDS.sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("##### <Task-"+id+"> Completed #####");
    }

    LoopTask() {
        this.id = ++count;
    }
}

public class q4 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

       
        Future<Integer> future = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(4000);

                System.out.println("Starting...");

                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Finished.");
                return duration;
            }
        });


   
        for (int i = 0; i < 3; i++) {
            service.execute(new LoopTask());
        }

         service.shutdown();

        try {
            System.out.println("Result is: "+future.get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
