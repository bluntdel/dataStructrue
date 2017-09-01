package Sort;

/**
 * Created by blunt on 2017/9/1.
 */
public class Case11 {
    public static void main(String[] args) {
        try {
            System.out.println(power(0,-23));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double power(double base, int exponent) throws Exception {
        double result = 0.0;
        if ( equals(0.0, base) && exponent <= 0 )
            throw  new Exception("0不能作为除数");

        if ( exponent <= 0 ){
             int  absExponent = -exponent;
             return 1/powerWithExponent(base,absExponent);
        }else {
            return powerWithExponent(base,exponent);
        }


    }

    public static double powerWithExponent(double base, int exponent){
        if ( exponent == 0) {
            return 1;
        }

        if ( exponent == 1) {
            return base;
        }

        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
            result = result * base;
        }

        return result;

    }

    public static boolean equals(double d1, double d2){
        if ( ( d1 - d2 )<0.0000001 && (d2- d1) <0.00000001){
            return true;
        }else {
            return false;
        }
    }
}
