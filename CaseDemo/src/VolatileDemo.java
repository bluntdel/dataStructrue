/**
 * Created by blunt on 2017/8/23.
 */
class Counter{
    public  volatile  static int counter = 0;

    public  static void inc(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        counter++;
    }
}


public class VolatileDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
             new Thread(new Runnable() {
                 @Override
                 public void run() {
                     Counter.inc();
                 }
             }).start();
        }

        System.out.println(Counter.counter);
    }
}
