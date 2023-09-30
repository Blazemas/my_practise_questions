import java.util.*;

import javax.swing.plaf.BorderUIResource.MatteBorderUIResource;
public class twodarray {

    void spiralmatrix(int matrix[][],int n,int m){

        int startrow = 0;
        int lastrow = n-1;
        int startcolumn = 0;
        int lastcolumn = m-1;

        while(startrow <= lastrow && startcolumn <= lastcolumn){

                
                for(int j=startcolumn;j<=lastcolumn;j++){   //top

                    System.out.print(matrix[startrow][j]+" ");
                }
               // startrow++;
                for(int i=startrow+1;i<=lastrow;i++){        //right

                    
                    System.out.print(matrix[i][lastcolumn]+" ");
                }
               // lastcolumn--;
                for(int j=lastcolumn-1;j>=startcolumn;j--){   //bottom

                    if(startrow == lastrow){      //to avoid printing the nunber twice for odd no.rows and columns
                        break;
                    }
                    System.out.print(matrix[lastrow][j]+" ");
                }
                //lastrow--;
                for(int i=lastrow-1;i>=startrow+1;i--){         //left

                    if(startcolumn == lastcolumn){      //to avoid printing the nunber twice for odd no.rows and columns
                        break;
                    }
                    System.out.print(matrix[i][startcolumn]+" ");
                }
                //startcolumn++;

                startrow++;
                lastrow--;
                startcolumn++;
                lastcolumn--;

        }
    }
    void sumofdiagonal(int matrix[][],int n){     //only possible for nxn matrix || time complexity: O(n^2)
        
        int sum = 0;
        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){

                if(i==j){  
                    sum+=matrix[i][j];    //primary diagonal sum 
                }
                else if(i+j==n-1){   
                    sum+=matrix[i][j];   //secondary diagonal sum
                }
            }
        }
        System.out.println("total diagonal sum: "+sum);
    
    }
    void sumofdiagonal1(int matrix[][],int n){  //time complexity O(n)

        int sum = 0;
        for(int i=0;i<n;i++){

            sum+=matrix[i][i];  //sum for primary diagonal
            
            if(i !=n-1-i){       //to avoid adding same values again
                sum+=matrix[i][n-1-i];         //sum of secondary diagonal
            }
            
        }
        System.out.println("total sum of diagonal 1 : "+sum);
    }
    void staircasesearch(int matrix[][],int n,int m,int key){

        int i=0;
        int j = m-1;  //considering the upper right corner
        int flag=1;
        while(i<n && j>=0){

            if(matrix[i][j]==key){
                flag = 0;
                System.out.println("found! at: "+i+","+j);
                break;
            }
            else if(matrix[i][j] > key){
                j--;
            }
            else{
                i++;
            }    
        }
        if(flag==1){
            System.out.println("not found!");
        }
    }
    void transpose(int matrix2[][],int n){

        int trans[][] = new int[n][n];

        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){

                trans[i][j] = matrix2[j][i];
              
            }
        }
        
        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){

                System.out.print(trans[i][j]+" ");
            }
        }
        
    }
 
    
    public static void main(String args[]){

        //Scanner sc = new Scanner(System.in);
       // System.out.println("enter the no of rows: ");
       // int n = sc.nextInt();
       // System.out.println("enter the no of columns: ");
       // int m = sc.nextInt();

        int matrix2[][] ={{10,20,30,40},
                         {15,25,35,45},
                         {27,29,37,48},
                         {32,33,39,50}};


      /*   int matrix[][] = new int[n][m];
        if(n%2==0){}
        for(int i=0;i<n;i++){    //matrix row length = matrix.length;

            for(int j=0;j<m;j++){   //matrix column length = matrix[0].length;
                
                matrix[i][j] = sc.nextInt();

            }
        }*/

        /*for(int i=0;i<matrix.length;i++){

            for(int j=0;j<matrix[0].length;j++){

                System.out.print(matrix[i][j]+ " ");
                
            }
            System.out.println();
        }*/
        twodarray o = new twodarray();
        //o.spiralmatrix(matrix,n,m);
      //  o.sumofdiagonal(matrix, n);          //O(n^2) - worst time complexity.
       // o.sumofdiagonal1(matrix, n);        //O(n) - best time complexity.

        //o.staircasesearch(matrix2, 4, 4, 35);
        o.transpose(matrix2, 4);

    }
}
