import java.util.*;
public class array {

    public static void binsearch(int arr[],int key){

        int Low = 0;
        int High = arr.length-1;
        int flag = 1;
        while(Low <= High){

            int middle = (Low+High)/2;
            if(key==arr[middle]){
                System.out.println("found");
                flag = 0;
                break;
            }
            else if(key > arr[middle]){
                Low = middle+1;
            }
            else{
                High = middle-1;
            }
        }
        if(flag == 1){
            System.out.println("not found");
        }

    }

    // medium level DSA Q - Rainwater collection 

    public static void rainwater(int num[],int n){
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
    
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        //1st - printing no. of pairs in array.

        /*int arr[] = new int[6];
        for(int i=0;i<arr.length;i++){

            arr[i] = sc.nextInt();
        }
       // System.out.print("enter which element to search: ");
       // int key = sc.nextInt();
       // binsearch(arr, key);
       int totalpairs=0;
        for(int i=0;i<arr.length-1;i++){

            for(int j=i+1;j<arr.length;j++){
                System.out.print(arr[i]+","+arr[j]+" ");
                totalpairs++;
            }
            System.out.println();                          //n = no of elements in array
        }
        System.out.println("total pairs: "+totalpairs);   //no of pairs = n(n-1)/2*/

        //2nd - finding maxsum of subarray method-1

        /* 
        int n = 6;
        int arr[] = {3,6,2,5,1,7};

        int maxsum = Integer.MIN_VALUE;   //to set variable to - infinity
        int currsum = 0;

        int totalsubarr = 0;
        for(int i=0;i<n;i++){

            for(int j=i;j<n;j++){

                currsum = 0;

                for(int k=i;k<=j;k++){
                    System.out.print("("+arr[k]+")");
                    currsum = currsum + arr[k];
                }
                //System.out.println("the sum of subarray: "+sum);
                System.out.println("sum of subarray: "+currsum);
                if(maxsum < currsum){
                    maxsum = currsum;
                }
                totalsubarr++;
                System.out.println();
            }
            
            System.out.println();
        }
        System.out.println("the max sum of subarray: "+ maxsum);
        System.out.println("total subarray: "+totalsubarr);
        */
        int num[] = {4,2,0,-2,3,2,5};
        int n = num.length;
        rainwater(num,n);

    }


}
