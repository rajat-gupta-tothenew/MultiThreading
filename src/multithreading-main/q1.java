 

class NewThread implements Runnable {
     String name;
    Thread t;

    NewThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: "+t);
    }

     @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name+": "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name+" interrupted.");
        }
        System.out.println(name+" exiting.");
    }
}

public class q1 {
    public static void main(String[] args) {
        NewThread nt1 = new NewThread("One");
        NewThread nt2 = new NewThread("Two");
        NewThread nt3 = new NewThread("Three");

         nt1.t.start();
        nt2.t.start();
        nt3.t.start();

      
        try {
            System.out.println("Waiting for the threads to finish.");
            nt1.t.join();
            nt2.t.join();
            nt3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Main thread exiting.");
    }
}
