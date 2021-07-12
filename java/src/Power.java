import java.math.*;

import static java.lang.Math.abs;

public class Power {

    public static double pow(int a, int b){
        // assumptions
        /*
        b can be negative
        a can be negative
        b is not a fraction
         */
         double result = 1;

         for(int i = 1; i <= abs(b); i++){
             result *=a;
         }
          return b<0? 1/result : result;

    }

    public static void main (String [] args){
       /* System.out.println(pow(2,3));
        System.out.println(pow(-2,3));
        System.out.println(pow(2,-3));
        System.out.println(pow(3,0));


        */

        int x =7;
        int y = x;
        x=2;
        System.out.println(x + ","+y);
    }
}
