import java.util.*;
import java.util.Scanner;
public class datatypes{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
       
        /*System.out.println("enter the number: ");
        int input = sc.nextInt();
        switch(input){

            case 1:System.out.println("sunday");
                   break;
            case 2:System.out.println("monday");
                   break; 
                   case 3:System.out.println("thusday");
                   break;   
                   case 4:System.out.println("wednesday");
                   break;   
                   case 5:System.out.println("thursday");
                   break;   
                   case 6:System.out.println("friday");
                   break;
                   case 7:System.out.println("saturday");
                   break;  
                   default:System.out.println("invalid input!");
                   break;          

        }*/
        /*int num = 3754;
        while(num>0){

            int lasdigit = num%10;
            System.out.print(lasdigit);
            num/=10;
        }*/
        
        /* 
        System.out.println("enter number: ");
        int n = sc.nextInt();
        int fact=1;
        for(int i=1;i<=n;i++){

            fact = fact*i;

        }
        System.out.println(fact);
         */
         char ch ='a';
         for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print(ch);
                ch++;
             
            }
            System.out.println();
         }
    }
}