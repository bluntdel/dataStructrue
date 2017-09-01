/**
 * Created by blunt on 2017/9/1.
 * fibonacci序列
 */

public class Case9 {
    public static void main(String[] args) {

    }

    long fibonacci(int n){
     long result = 0;
     long Pre1 = 0;
     long Pre2 = 1;
     if ( n ==0) return 0;
     if ( n ==1) return 1;

     for (int i =2;i<= n;i++){
         result = Pre1 + Pre2;
         Pre1 = Pre2;
         Pre2 = result;
     }

     return  result;
    }
}
