import java.util.Scanner;
import java.util.prefs.BackingStoreException;

public class oop {
    
    public static void main(String args[]){

        bankaccount o = new bankaccount();
       // o.username ="chinmay";
      //  o.password = "fdsf";     //object cant accesst/modify the private attribute.

       // o.getpassword("nfsdoi");
       // o.displaypass();       //we are using public functions of that class to modify/set/get the private data.
      //  Deer d = new Deer();
      //  d.eat(); 
      //  vehicle de = new vehicle();        //we can't create an object of abtract class.
     //   Car c = new Car();
      //  c.brakes();
      //  c.wheels();

        Queen q = new Queen();
        q.moves();
      //  chess ch = new chess();          //just like Abstract class we can't create an object of interfaces.
        bankaccount b = new bankaccount();
       
        System.out.println(b.schoolname);

        Complex c1 = new Complex();
        c1.getdata();
        Complex c2 = new Complex();
        c2.getdata();
        Complex c = new Complex();
        c.sum(c1,c2);
        c.diff(c1,c2);
        c.multiple(c1,c2);
    }
}
class bankaccount{

    public String username;
    private String password;      //private attribute.

    static String schoolname="jjjs" ;

    public void getpassword(String password){
        this.password = password;       //this keyword refers to the object's attribute.
    }
    public void displaypass(){
        System.out.println(password);
    }

}
class Animal{

    void eat(){
        System.out.println("eat anything");
    }
}
class Deer extends Animal{


    void eat(){
        System.out.println("eat grass");
    }
}


//Abstraction using Abstract classes***************************************

abstract class vehicle{

    void brakes(){
        System.out.println("powerful");
    }
    abstract void wheels();
}
class Bike extends vehicle{

    void wheels(){
        System.out.println("bike has 2 wheels");
    }
}
class Car extends vehicle{

    void wheels(){
        System.out.println("car has 4 wheels");
    }
}
//****************************************************************** */

// Abstration using Interfaces

interface chess{
    void moves();
}
class Queen implements chess{

    public void moves(){          // we need to state as public/static or it is default.
        System.out.println("up,down,left,right,diagonally");
    }
}
class Rook implements chess{

    public void moves(){
        System.out.println("up,down,rigth,left");
    }
}
class Complex{

    float real;
    float img;
   
    void getdata(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the real part: ");
        this.real =sc.nextFloat();
        System.out.println("enter the img part: ");
        this.img =sc.nextFloat();
    }

    void sum(Complex c1,Complex c2){

        float realpart;
        realpart = c1.real + c2.real;
        float imgpart;
        imgpart = c1.img + c2.img; 

        System.out.println("sum of two complex numbers: "+realpart +"+"+imgpart+"i");

    }
    void diff(Complex c1,Complex c2){

        float realpart;
        realpart = c2.real - c1.real;
        float imgpart;
        imgpart = c2.img - c1.img; 

        System.out.println("diff of two complex numbers: "+realpart +"+"+imgpart+"i");

    }
    void multiple(Complex c1,Complex c2){

        float realpart;
        realpart = (c2.real*c1.real) - (c1.img*c2.img);
        float imgpart;
        imgpart = (c1.real*c2.img) + (c1.img*c2.real); 

        System.out.println("diff of two complex numbers: "+realpart +"+"+imgpart+"i");

    }

}