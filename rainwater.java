import java.util.*;



public class rainwater {

    void rainwater(int num[],int n){      //method 1 - my mehthod (time complexity = O(n^2))
        int rainwater = 0;
        int width = 1;
     
        for(int i=0;i<n;i++){
            if(i==0){
                continue;
            }
            else{
                int waterlevel = 0;
                int area=0;
                int height = num[i];
                int leftmax = Integer.MIN_VALUE;
                int rightmax = Integer.MIN_VALUE;
                for(int j=i;j>0;j--){
                    if(leftmax < num[j-1]){
                        leftmax = num[j-1];
                    }
                }
                for(int k=i;k<n-1;k++){
                    if(rightmax < num[k+1]){
                        rightmax = num[k+1];
                    }
                }
                waterlevel = Math.min(leftmax,rightmax);        //to find water level .
    
                if(waterlevel < height){
                    area = 0;
                }
                else{
                    area = (waterlevel-height)*width;    //area to calculate area of water for each block.
                }
                System.out.println("area of water level: "+area);
               
                rainwater = rainwater + area;
            }
          
        }
        System.out.println("total rainwater collected: "+rainwater);    
    }
    void rainwater2(int num[],int n){        //method 2 - official method(time complexity = O(n))

        int rainwater = 0;
        int width = 1;
        int leftmost[] = new int[n];
        leftmost[0] = num[0];
        for(int i=1;i<n;i++){

            leftmost[i] = Math.max(num[i],leftmost[i-1]);
        }
        int rightmost[] = new int[n];
        rightmost[n-1] = num[n-1];      //
        for(int i=n-2;i>=0;i--){

            rightmost[i] = Math.max(num[i],rightmost[i+1]);
        }
        int area = 0;
        int waterlevel = 0;
        for(int i=0;i<n;i++){
            
            int height = num[i];
            waterlevel = Math.min(leftmost[i],rightmost[i]);
            if(waterlevel < height){
                area = 0;
            }
            else{
                area = (waterlevel - height)*width;
            }
            System.out.println("area: "+area);
            rainwater +=area;
        }
        System.out.println("total rainwater trapped: "+rainwater);
    }

    public static void main(String args[]){

        int num[] = {4,2,0,-2,3,2,5};
        int n = num.length;
        rainwater o = new rainwater();
        o.rainwater(num,n);
        o.rainwater2(num,n);

    }
}       

       