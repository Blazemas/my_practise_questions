import java.util.*;



public class backtracking {

    public static boolean IsSafe_Q(char chessboard[][],int row,int column){
         
        //st.upwards
        for(int i=row-1;i>=0;i--){
            if(chessboard[i][column]=='Q'){
                return false;
            }
        }
        //left upper corner
        for(int i=row-1,j=column-1;i>=0 &&j>=0;i--,j--){

            if(chessboard[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=column+1;i>=0 && j<chessboard.length;i--,j++){

            if(chessboard[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static boolean IsSafe_K(char chessboard[][],int row,int column,int n){
        
      while(row-1>=0 && column-2>=0){
        if(chessboard[row-1][column-2]=='k'){
            return false;
        }
      }
      while(row-1>=0 && column+2>=n-1){
        if(chessboard[row-1][column+2]=='k'){
            return false;
        }
      }
      while(row-2>=0 && column-1>=0){
        if(chessboard[row-2][column-1]=='k'){
            return false;
        }
      }
      while(row-2>=0 && column+1>=0){
        if(chessboard[row-2][column+1]=='k'){
            return false;
        }
      }
      return true;
    }

    public static void printboard(char chessboard[][],int n){

        System.out.println("----------chess Board----------");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(chessboard[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void placeNqueen(int row,char chessboard[][],int n){
    
        //base condition:
        if(row==n){
            printboard(chessboard,n);
            return;
        }
    
        //placing queen : 
        for(int column=0;column<n;column++){
    
            if(IsSafe_K(chessboard, row, column,n)){
                chessboard[row][column] = 'k';
                placeNqueen(row+1,chessboard,n);
                //Backtracking:
                chessboard[row][column] = 'X';  
            }

        }
    }
    public static int gridproblem(int x,int y,int n,int m){

        //Base condition:
        if(x==n-1 && y==m-1){ //for last cell
            return 1;
        }
        else if(x==n || y==m){//for boundary crossing
            return 0;
        }
        int down_ways = gridproblem(x+1, y, n, m);
        int right_ways = gridproblem(x, y+1, n, m); 
        return down_ways + right_ways;
    } 
    public static boolean is_safe(int sudoku[][],int digit,int row,int col){

        //for row 
        for(int i=0;i<9;i++){

            if(sudoku[i][col] == digit){
                return false;
            }
        }
        //for column
        for(int j=0;j<9;j++){

            if(sudoku[row][j] == digit){
                return false;
            }
        }
        //for grid
        int start_grid_x = (row/3)*3;
        int start_grid_y = (col/3)*3;

        for(int i=start_grid_x;i<start_grid_x+3;i++){
            for(int j=start_grid_y;j<start_grid_y+3;j++){

                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    } 
    public static boolean sudokusolver(int sudoku[][],int row,int col){

        //base condition

        if(row == 9 && col == 0){
            return true;
        }

        
        //recursion
        int nextrow = row;
        int nextcol = col+1;
        if(nextcol == 9){
            nextrow = row+1;
            nextcol = 0;
        }
        if(sudoku[row][col] !=0){
            return sudokusolver(sudoku, nextrow, nextcol);
        }

        for(int digit=1;digit<=9;digit++){

            if(is_safe(sudoku,digit,row,col)){

                sudoku[row][col] = digit;
                sudokusolver(sudoku, nextrow, nextcol);
                if(sudokusolver(sudoku, nextrow, nextcol)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;

    }
    public static void printsol(int sudoku[][]){

        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("enter the size of chessboard: ");
        n = sc.nextInt();
        char chessboard[][] = new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chessboard[i][j] = 'X';
            }
        } 
        placeNqueen(0,chessboard,n); 

        // }
        // int sudoku[][]={{0,0,8,0,0,0,0,0,0},
        //                 {4,9,0,1,5,7,0,0,2},
        //                 {0,0,3,0,0,4,1,9,0},
        //                 {1,8,5,0,6,0,0,2,0},
        //                 {0,0,0,0,2,0,0,6,0},
        //                 {9,6,0,4,0,5,3,0,0},
        //                 {0,3,0,0,7,2,0,0,4},
        //                 {0,4,9,0,3,0,0,5,7},
        //                 {8,2,7,0,0,9,0,1,3}};

        // if(sudokusolver(sudoku, 0, 0)){
        //     System.out.println("solution exists: ");
        //     printsol(sudoku);
        // }   
        // else{
        //     System.out.println("solution does not exists.");
        // }

        // placeNqueen(0,chessboard,n);
        // int rows=3,columns=3;
        // System.out.println(gridproblem(0, 0, rows, columns));

    }
    
}
