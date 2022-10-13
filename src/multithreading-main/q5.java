
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name+" entered A.foo");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("A interrupted.");
        }
        System.out.println(name+" trying to call B.last()");
        b.last();
    }
    synchronized void last() {
        System.out.println("Inside A.last");
    }
}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name+" entered B.bar");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("B interrupted.");
        }
        System.out.println(name+" trying to call A.last()");
        a.last();
    }
    synchronized void last() {
        System.out.println("Inside B.last");
    }
}

public class q5 implements Runnable {
    A a = new A();
    B b = new B();
    Thread t;
 
    Lock lock = new ReentrantLock();

    q5() {
        Thread.currentThread().setName("MainThread");
        t = new Thread(this, "RacingThread");
    }
    void deadlockStart() {
        t.start();

       
        lock.lock();

    
        a.foo(b);

   
        lock.unlock();
        System.out.println("Back in main thread.");
    }
    public void run() {
        
        lock.lock();
 
        b.bar(a);
 
        lock.unlock();
        System.out.println("Back in other thread.");
    }
    public static void main(String[] args) {
        q5 obj = new q5();
        obj.deadlockStart();
    }
}
