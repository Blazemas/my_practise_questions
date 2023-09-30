
import java.util.*;
public class numsyscon {

    public static void binconversion(int num){

        int bin = 0;
        double power=0;
        int mynum = num;
        while(num > 0){

            int rem = num % 2;
            bin = bin + rem*(int)Math.pow(10,power);

            num = num / 2;
            power++;
        }
        System.out.println("binary conversion of "+mynum +" is "+bin);
    }
    public static void decimalconversion(int bin){

        int mybin = bin;
        int power = 0;
        int decimal = 0;

        while(bin > 0){

            int lastdigit = bin % 10;

            decimal = decimal + lastdigit*(int)Math.pow(2,power);

            bin = bin / 10;

            power++;
        }
        System.out.println("decimal conversion of "+mybin +" is "+decimal);
    }
 

    public static void main(String args[]){

        //System.out.println(pow(2, 4));

        binconversion(10);
        decimalconversion(1111);



    }
    
}
