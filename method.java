import java.util.*;
import java.lang.Math;
public class method {


    void swap(int a,int b){
        int temp = a;
        a=b;
        b=temp;
        System.out.println("a="+a);
        System.out.println("b="+b);
    }
    int fact(int n){
        int fact = 1;
        for(int i=1;i<=n;i++){

            fact = fact * i;
        }
        return fact;
    }
    int combination(int n,int r){

        int n_fact = fact(n);
        int r_fact = fact(r);
        int diff_fact = fact(n-r);
        int ans = n_fact/(r_fact*diff_fact);
        return ans;
    }
    boolean isprime(int n){

        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    void primeinrange(int n){
        for(int i=0;i<n;i++){
            if(isprime(i)){
                System.out.println("i = "+ i);
            }
        }
        System.out.println();
    }
    void binarytodecimal(int binarynum){
 
        int mynum = binarynum;
        int power=0;
        int decimal=0;


        while(binarynum > 0){


            int lasdigit = binarynum % 10;
            decimal = decimal + lasdigit*(int)Math.pow(2,power);  //typecasting is used beacuse pow method
                                                                   //pow method need flaot input and return float
            power++;
            binarynum = binarynum / 10;
        }
        System.out.println("the conversion is: "+decimal);     
    }
    void decimaltobinary(int decimal){
        int mynum = decimal;
        int power = 0;
        int binary = 0;
        while(decimal > 0){

            int rem = decimal % 2;
            binary = binary + rem*(int)Math.pow(10,power);
            //typecasting is used beacuse pow method
           //pow method need flaot input and return float
            power ++;
            decimal = decimal / 2;
        }
        System.out.println("the decimal "+ mynum + " converted into binary: "+ binary);
    }
    void reverse(int num){
        
        int mynum = num;
        int rev = 0;
        while(num > 0){

            int lastdigit = num % 10;
            rev = (rev*10) + lastdigit; 
            num = num / 10;
        }
        System.out.println("reversed number : " + rev);
    }
    boolean ispalindrome(int num){
        int mynum = num;
        int rev = 0;
        while(num > 0){
            int lastdigit = num % 10;
            rev = rev*10 + lastdigit;
            num = num / 10;
        }
        if(rev == mynum){
            return true;
        }
        return false;
    }
    void sumofdigit(int num){
        int sum = 0;
        while(num > 0){

            int lastdigit = num % 10;
            sum = sum + lastdigit;
            num = num / 10;
        }
        System.out.println("sum = "+ sum);
    }
    void rev3(int num){

        int count=0;
        int mynum = num;
        int num2 = num;
        while(num>0){

            num = num/2;
            count++;
             
        }
        int arr[] = new int[count];
        for(int i=0;i<count;i++){
            int rem = num2%2;
            arr[i] = rem;
            num2 = num2/2;
        }
        System.out.print("the binary conversion of "+mynum +" is ");
        for(int i=0;i<count;i++){
            
            System.out.print(arr[count-1-i]);
        }
       
    }
    public static void main(String args[]){

       
        method o = new method();
        // System.out.println(o.fact(4));
        
        // int answer = o.combination(6,5);
        // System.out.println("ans = "+ answer);
        // System.out.println(o.isprime(12));
        // o.primeinrange(10);
        // o.binarytodecimal(1111);
        // o.decimaltobinary(15);
        // o.reverse(584);
        // System.out.println(o.ispalindrome(532));
        // o.sumofdigit(731);
        o.rev3(10);
        
        
        /* 
        int a = 4;
        int b = 6;
        o.swap(a,b);
        System.out.println("a="+&a);
        System.out.println("b="+&b);        
        */
        
    

    }
    
}
