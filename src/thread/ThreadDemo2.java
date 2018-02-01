package thread;
//销售员
class Clerk{
    private int product = 0;
    //生产
    public synchronized void add(){
        if(product >= 20){
            try{
                wait();
                System.out.println("暂停生产。");

            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            product++;
            System.out.println("生产者生产了第"+product+"个商品");
            notify();
        }
    }
    //消费商品
    public synchronized void remove(){
        if (this.product <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("消费者消费了第"+ product +"个商品");
            product--;
            notify();
        }
    }
}

//生产者
class Productor implements Runnable{
    Clerk clerk1;
    public Productor(Clerk clerk){
        this.clerk1=clerk;
    }
    public void run(){
        System.out.println("生产者开始生产");
        while(true){
            try {
                Thread.sleep((int)(Math.random()*2000));
            } catch (Exception e) {
                e.printStackTrace();
            }
            clerk1.add();
        }
    }
}

//消费者
class Consumer implements Runnable{
    Clerk clerk1;
    public Consumer(Clerk clerk){
        this.clerk1=clerk;
    }
    public void run(){
        System.out.println("消费者开始消费");
        while(true){
            try {
                Thread.sleep((int)(Math.random()*2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk1.remove();
        }
    }
}
public class ThreadDemo2 {
    public static void main(String []args){
        Clerk clerk=new Clerk();
        new Thread(new Productor(clerk)).start();
        new Thread(new Consumer(clerk)).start();
    }
}
