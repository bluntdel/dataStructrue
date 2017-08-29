/**
 * Created by blunt on 2017/8/23.
 */
class  Singleton{
    public static Singleton instance;

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();

        }
        return instance;
    }

    private Singleton(){};

    public void showMessage(){
        System.out.println("show!");
    }
}

//多线程
class  SingletonMulti{
    private SingletonMulti(){};
    public static  SingletonMulti instance= new SingletonMulti();
    public static SingletonMulti getInstance(){
        return  instance;
    }
}

class Singleton2{
    private static class SingletonHolder {
        private static  final Singleton2 INSTANCE = new Singleton2();
    }

    private Singleton2 (){};

    public static final Singleton2 getInstace(){
        return SingletonHolder.INSTANCE;
    }


}

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton singletonObject = Singleton.getInstance();
        singletonObject.showMessage();

    }
}
