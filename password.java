import java.util.*;

public class password {

    public static boolean validpass(String password){

        int Uppercase = 0;
        int lowercase = 0;
        int special = 0;
        int numbers = 0;

        if(password.length() >= 8 && password.length() <=20){   //length should be in 8 to 20 character range.

            for(int i=0;i<password.length();i++){

                Character chr = password.charAt(i);

                if(chr =='@' || chr=='#'||chr=='!'||chr=='*'||chr=='%'||chr=='$'||chr=='&'||chr=='+'||chr=='-'||chr=='_'||chr=='/'||chr=='?'){

                    special+=1;
                }

            }
            for(int i=0;i<password.length();i++){

                Character chr1 = password.charAt(i);

                if(Character.isUpperCase(chr1)){

                    Uppercase+=1;
                }

            }
            for(int i=0;i<password.length();i++){

                Character chr2 = password.charAt(i);

                if(Character.isLowerCase(chr2)){

                    lowercase+=1;
                }

            }
            numbers = password.length() - (Uppercase+lowercase+special);      
                
            if(special>= 1 && Uppercase>=1 && lowercase>=1 && numbers>=1){

                System.out.println(special+" "+Uppercase+" "+lowercase+" "+numbers);
                return true;
            }

        }
        return false;
    
    }
   
    
    public static void main(String args[]){


        Scanner sc = new Scanner(System.in);
        System.out.println("1]password must be of 8 to 20 characters.");
        System.out.println("2]password must contain atleast 1 Uppercase character.");
        System.out.println("3]password must contain atleast 1 lowercase character.");
        System.out.println("4]password must contain atleast 1 Special charcter(!@#$%&*_-+/?"); 

        System.out.println("enter the password: ");
        String password = sc.next();

        while(validpass(password)!=true){

            System.out.println("sorry the password is not valid, please enter again !!");
            System.out.println("enter the password: ");
            password = sc.next();

        }
        System.out.println("password is valid");
    }
}
