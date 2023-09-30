import java.util.*;
public class sortings {

    void bubblesort(int arr[],int n){
       
        for(int i=0;i<n-1;i++){ //outer loop for turns = n-1

            for(int j=0;j<n-1-i;j++){  //inner loop for swaping = n-1-i

                if(arr[j] > arr[j+1]){      //condition for swaping

                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
      
    }
    void display(int arr[],int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    void selectionsort(int arr[],int n){

         for(int i=0;i<n-1;i++){
            int min = i;        //considering the curr element as min
            for(int j=i+1;j<n;j++){      //to find the min in unsorted array
                
                if(arr[min] > arr[j]){
                    min = j;          //pin the index of min element in min
                }
            }
            int temp = arr[min];  //swaping the element with min element in unsorted array
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    void insertionsort(int arr[],int n){

        for(int i=1;i<n;i++)
        {
            int curr = arr[i];
            int prev = i-1;

            while(prev >=0 && arr[prev] > curr){
                
                arr[prev+1] = arr[prev];
                prev--;
                
            }
            arr[prev+1] = curr;
        }
    }
    void countingsort(int arr[],int n){


        int max = Integer.MIN_VALUE; 

        for(int i=0;i<n;i++){          //to find the max element in array to find the range of count array.
            max = Math.max(max,arr[i]);
        }
        int count[] = new int[max+1];   //max + 1 : because stating with 0 to max 

        for(int i=0;i<n;i++){         //traversing the array to count the freq
            
            count[arr[i]]++;         //inbuilt counting function
        }
        int m = count.length; 
        int j = 0;
        for(int i=0;i<m;i++){      //traversin the count array which stores freq
            
            while(count[i] > 0){

                arr[j] = i;            //updating in the original array
                j++;  
                count[i]--;       //decremeting the frequncy .
                            //storing at index (because the size is unknown
            }
        }
    }
    

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        sortings o = new sortings();
        int arr[] = {3,6,2,1,8,7,4,5,3,1};
        int n = arr.length;
       // o.bubblesort(arr, n);
       // o.selectionsort(arr, n);
       // o.display(arr, n);
       // o.selectionsort(arr, n);
       // o.insertionsort(arr, n);
         o.countingsort(arr, n);
        o.display(arr, n);
    }
}
