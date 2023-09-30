public class divideandconquer {

    public static void merge(int arr[],int si,int mid,int ei){

        int temp[] = new int[ei-si+1];
        int i = si; //index for 1st sorted part
        int j = mid+1;//index for 1st sorted part
        int k = 0;  //index for temp

        while(i<=mid && j<=ei){

            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            } 
            k++;
        }

        //for leftover elements of 1st sorted part.
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        //for leftover elements of 2nd sorted part.
        while(j <= ei){
            temp[k++] = arr[j++];
        }

        //copy temp to original arr.
        for(k=0,i=si;k<temp.length;k++,i++){

            arr[i] = temp[k];
        }

    }

    public static void mergesort(int arr[],int si,int ei){

        if(si >= ei){
            return;
        }
        int mid = si + (ei-si)/2;  // or (si+ei)/2
        mergesort(arr, si, mid);
        mergesort(arr, mid+1, ei);
        merge(arr,si,mid,ei);
    }
    public static void quicksort(int arr[],int si,int ei){

        if(si >= ei){
            return;
        }
        int idx = partition(arr,si,ei);
        quicksort(arr, si, idx-1);
        quicksort(arr, idx+1, ei);

    }
    public static int partition(int arr[],int si,int ei){

        int pivot = arr[ei];
        int i = si-1;

        for(int j=si;j<ei;j++){
            
            if(arr[j] < pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        }
        i++;
        int temp = pivot;   //pivot is variable 
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;

    }
    public static int binsearch(int arr[],int key,int si,int ei){

        if(si > ei){
            return -1;
        }
        int mid = (si+ei)/2;
        //found case: 
        if(arr[mid] == key){
            return mid;
        }

        //on line 1 case:
        if(arr[si] <= arr[mid]){
            
            if(arr[si] <= key && key <= arr[mid]){
                return binsearch(arr, key, si, mid-1);
            }
            else{
                return binsearch(arr, key, mid+1, ei);
            }
        }
        else{
            if(arr[mid] <= key && key <= arr[ei]){
                return binsearch(arr, key, mid+1, ei);
            }
            else{
                return binsearch(arr, key, si, mid-1);
            }
        }
        
    }
    
    public static void main(String args[]){

        int arr[] = {4,7,2,9,1,6};
        int arr2[] = {4,5,6,7,0,1,2};
        int n1 = arr2.length;
        int n = arr.length;
        //mergesort(arr, 0, n-1);
        quicksort(arr, 0, n-1);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
        //binsearch(arr, 9, 0, n-1);
        System.out.println(binsearch(arr2, 0, 0, n1-1));
        
        
    }

}
