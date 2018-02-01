package thread;
class Thread1 extends Thread{
    public void run(){
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+" run ");
            try {
                sleep((int)Math.random()*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Thread2 implements Runnable{
    public void run(){
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+" run ");
            try {
                Thread.sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadDemo1 {
    public static void main(String []args){
        /*
        Thread1 thread1=new Thread1();
        Thread1 thread2=new Thread1();
        thread1.start();
        thread2.start();
        */
        Thread2 thread3=new Thread2();
        new Thread(thread3).start();
        new Thread(thread3).start();
    }
}
