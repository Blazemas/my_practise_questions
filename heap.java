import java.util.*;

public class heap{

   static class Heap{

      ArrayList<Integer> arr = new ArrayList<>();

      //min heap add fucntion
      public void add(int data){

        arr.add(data);

        int x = arr.size() - 1 ;
        int par = (x-1)/2;

        while(arr.get(x) < arr.get(par)){
            
            //swaping
            int temp = arr.get(x);
            arr.set(x,arr.get(par));
            arr.set(par,temp);

            x = par;
            par = (x-1)/2;
        }
      }
      //view the root of min heap
      public int peek(){
        return arr.get(0);
      }

      // private void heapify(int i){

      //   int left = 2*i + 1;
      //   int right = 2*i + 2;
      //   int minidx = i;

      //   if(left < arr.size() && arr.get(minidx) > arr.get(left)){
      //       minidx = left;
      //   }
      //   else if(right < arr.size()  && arr.get(minidx) > arr.get(right)){
      //       minidx = right;
      //   }
      //   if(minidx != i){
            
      //       //swaping
      //       int temp = arr.get(i);
      //       arr.set(i,arr.get(minidx));
      //       arr.set(minidx,temp);

      //       heapify(minidx);
      //   }
      // }
      // public int remove(){

      //   int data = arr.get(0);

      //   //step 1 - swap with last node
      //   int temp = arr.get(0);
      //   arr.set(0,arr.get(arr.size()-1));
      //   arr.set(arr.size() -1 ,temp);

      //   //step 2 - delete last
      //   arr.remove(arr.size() - 1);

      //   //step 3 - heapify
      //   heapify(0);
      //   return data;
      // }

      public boolean isEmpty(){
        return arr.size() == 0;
      }
   }
   public static void heapify(int arr[],int i,int size){

    int left = 2*i+1;
    int right = 2*i+2;
    int maxidx = i;

    if(left < size && arr[maxidx] < arr[left]){
      maxidx = left;
    }

    if(right < size && arr[maxidx] < arr[right]){
      maxidx = right;
    }

    if(maxidx != i){

      int temp = arr[i];
      arr[i] = arr[maxidx];
      arr[maxidx] = temp;
      heapify(arr, maxidx, size);
    }
    
   }
   public static void heapsort(int arr[]){  //O(nlogn)

      //step 1 - build maxheap
      int n = arr.length;
      for(int i=n/2;i>=0;i--){
        heapify(arr,i,arr.length);
      }
      
      //step 2 - push largest at the end

      for(int i=n-1;i>=0;i--){
        //swap largest-first with last
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;

        heapify(arr,0,i);
      }
    }
   
    public static void main(String args[]){

        // Heap h = new Heap();
        // h.add(3);
        // h.add(4);
        // h.add(1);
        // h.add(5);   //output is wrong (not working properly)
        
        // while(!h.isEmpty()){
        //     System.out.println(h.peek());
        //     h.remove();
        // }
        int arr[] = {1,2,4,6,8};
        heapsort(arr);
        
        for(int i=0;i<arr.length;i++){
          System.out.print(arr[i]+" ");
        }

        

    }
    
}
