import javax.xml.transform.Source;

public class patternsadv {


    //hollow ractangle pattern 
    void hollow_rectangle(int totalrows,int totalcolums){

        for(int i=1;i<=totalrows;i++){   //no of rows 
 
            for(int j=1;j<=totalcolums;j++){ // no of columns

                if(i==1 || i==totalrows || j==1 || j==totalcolums)  //condition
                    System.out.print("*");
                
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    void inverted_pyramid(int n){

        for(int i=1;i<=n;i++){   //for outer loop (no of rows = n)

            for(int j=1;j<=n-i;j++){  //for spaces(1st)
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){   //for stars (2nd)
                System.out.print("*");
            }
            System.out.println();
        }
    }
    void inverted_numpyra(int n){   

        for(int i=1;i<=n;i++){    //for outer loop(no of rows)

          for(int j=1;j<=n-i+1;j++){   //for numbers 
            System.out.print(j);
          }
          System.out.println();
        }
    }
    void floyds_triangle(int n){

        int num = 1;          //to increment numbers constantly 
        for(int i=1;i<=n;i++){     //for outer loop(no of rows)
             
            for(int j=1;j<=i;j++){     //for  numbers
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }  
    void triangle_0_1(int n){       

        for(int i=1;i<=n;i++){

            for(int j=1;j<=i;j++){

                if((i+j)%2==0){
                    System.out.print(1);
                }
                else{
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }  
    void butterfly(int n){

        for(int i=1;i<=n;i++){      //for upper half of 

            for(int j=1;j<=i;j++){        //for 1st time stars
                System.out.print("*");
            }
            for(int j=1;j<=(2*(n-i));j++){   //for in between spaces 
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){       //for 2nd time stars
                System.out.print("*");
            }
            System.out.println();
    
        }
        
        for(int i=n;i>=1;i--){        //for the inverted half of pyramid

            for(int j=1;j<=i;j++){    //for 1st time stars
                System.out.print("*");
            }
            for(int j=1;j<=(2*n)-(2*i);j++){   //for in between spaces 
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){       //for 2nd time stars
                System.out.print("*");
            }
            System.out.println();
    
        }
    }
    void solid_rhombus(int n){

        for(int i=1;i<=n;i++){

            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    void hollow_rhombus(int n){

        for(int i=1;i<=n;i++){

            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){

                if(i==1||i==n || j==1 || j==n){
                    System.out.print("*");
                }
                else
                System.out.print(" ");
            }
            System.out.println();
        }
       
    }
    void diamond_pattern(int n){

        for(int i=1;i<=n;i++){

            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){

                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--){

            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i-1);j++){

                System.out.print("*");
            }
            System.out.println();
        }

    }
    void palindrome(int n){  //palindrome pattern
        
        for(int i=1;i<=n;i++){   //for outer loop (no of rows=n)

            for(int j=1;j<=n-i;j++){  //for spaces = n-i
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){    //for 1st descending numbers from i to 1
                System.out.print(j);
            }
            for(int j=2;j<=i;j++){    //for 2nd ascending numbers from 2 to i
                System.out.print(j);
            }
            System.out.println();
        }
    }
 
    
    public static void main(String args[]){

        patternsadv o = new patternsadv();

       // o.hollow_rectangle(4,5 );
       // o.inverted_pyramid(5);
       // o.inverted_numpyra(5);
        o.floyds_triangle(5);
       // o.triangle_0_1(5);
     //  o.butterfly(4);
      // o.solid_rhombus(4);
      // o.hollow_rhombus(5);
      // o.diamond_pattern(4);
      // o.palindrome(5);

    
    }
}
