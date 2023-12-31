import java.util.*;
public class sortingprac {

    void bubblesort(int arr[],int n){

        for(int i=0;i<n;i++){
            
            for(int j=0;j<n-1-i;j++){

                if(arr[j] > arr[j+1]){

                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }

        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    void selectionsort(int arr[],int n){

        for(int i=0;i<n-1;i++){

            int min = i;
            for(int j=i+1;j<n;j++){

                if(arr[min] > arr[j]){

                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
   
    void insertionsort(int arr[],int n){

        for(int i=1;i<n;i++){
            
            int curr = arr[i];
            int prev = i-1;
            if(prev>=0 && arr[prev] > curr){

                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;  //insertion 
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    void countingsort(int arr[],int n){

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max,arr[i]);
        }
        int count[] = new int[max+1];
        for(int i=0;i<max+1;i++){

            count[arr[i]]++;       //counting the freq of each number.
        }
        int j=0;
        int m = count.length;
       // int arr1[] = new int[n];
       for(int i=0;i<m;i++){

           while(count[i]>0){

            arr[j]=i;
            j++;
            count[i]--;
            
           }
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        
    }
    
    public static void main(String args[]){

        int arr[] ={3,6,2,1,8,7,4,5,3,1};
        int n = arr.length;
        sortingprac o = new sortingprac();
       // o.bubblesort(arr, n);
       // o.selectionsort(arr, n);
       // o.insertionsort(arr, n);
        o.countingsort(arr, n);
       



    }
}
