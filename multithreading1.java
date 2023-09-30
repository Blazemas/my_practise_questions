import java.util.*;

class thread1 extends Thread{
        
        @Override
        public void run(){

            int i = 0;
            while(i!=12){
               System.out.println("my thread 1 is running");
               System.out.println("i am happy");
               i++;
            }
        }
        
    }
    class thread2 extends Thread{

        @Override
        public void run(){

            int i = 0;
            while(i!=10){
               System.out.println("my thread 2 is running");
               System.out.println("i am sad");
               i++;
            }
        }

    }

public class multithreading1{
    
    public static void main(String args[]){


        thread1 T1 = new thread1();
        thread2 T2 = new thread2();

        T1.start();   //start function is used to initialize the threads
        T2.start();   //start will implicitly call the method within the thread

    }
}
