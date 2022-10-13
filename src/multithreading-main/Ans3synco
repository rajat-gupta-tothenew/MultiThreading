
class SynchronizationMethod {

    synchronized void add(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.println(Thread.currentThread().getName() + " " + (n + n));
        }
    }
}
class Thread3 extends  Thread
{
    SynchronizationMethod s;
    Thread3(SynchronizationMethod s)
    {
        this.s=s;

    }
    public  void run()
    {
        s.add(5);
    }


}
class Thread4 extends  Thread
{
    SynchronizationMethod s;
    Thread4(SynchronizationMethod s)
    {
        this.s=s;

    }
    public  void run()
    {
        s.add(5);
    }
}

public class Ans3synco
{
    public static void main(String[] args) {

        SynchronizationMethod obj = new SynchronizationMethod();
        Thread3 t1=new Thread3(obj);
        Thread4 t2=new Thread4(obj);
        t1.start();
        t2.start();
    }
}
