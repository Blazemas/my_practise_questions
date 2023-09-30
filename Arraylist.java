import java.util.ArrayList;;
import java.util.*;

public class Arraylist {

    public static int storewater(ArrayList<Integer> height){

        //Brute force approach - Time complexity is O(n^2)
        int maxwater = 0;
        for(int i=0;i<height.size();i++){

            for(int j=i+1;j<height.size();j++){

                int width = j - i;
                int Ht = Math.min(height.get(i),height.get(j));
                int waterarea = Ht * width;
                maxwater = Math.max(maxwater, waterarea);
            }
        }
        return maxwater;
    }
    public static int storewater2(ArrayList<Integer> height){
        // two pointer approach - Time complexity is O(n)
        int maxwater = 0;
        int left_L = 0;
        int right_L = height.size() - 1;

        while(left_L < right_L){

            //calculate water area
            int ht = Math.min(height.get(left_L),height.get(right_L));
            int width = right_L - left_L;
            int currwaterarea = ht * width;

            maxwater = Math.max(maxwater,currwaterarea);

            //updating the pointers
            if(left_L < right_L){
                left_L ++;
            }
            else{
                right_L --;
            }
        }
        return maxwater;
    }

    public static void swap(ArrayList<Integer> list,int idx1,int idx2){

        int temp = list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
       
    }
    public static boolean pairsum1(ArrayList<Integer> arr, int target){

        //brute force approach - all possible pairs ||      O(n^2)
        for(int i=0;i<arr.size();i++){

            for(int j=i+1;j<arr.size();j++){
                
                if(arr.get(i) + arr.get(j) == target){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean pairsum2(ArrayList<Integer> arr, int target){

        int left = 0;
        int right = arr.size()-1;

        while(left < right){  //same as left != right

            if(arr.get(right) + arr.get(left) == target){
                return true;
            }
            else if(arr.get(right) + arr.get(left) > target){
                right --;
            }
            else{
                left ++;
            }
        }
        return false;
    }
    public static boolean pairsumAdv(ArrayList<Integer> arr3, int target){

    //    int lower=0;
    //    int upper=0;
       int upper = -1;
       int n = arr3.size();
       for(int i=0;i<arr3.size();i++){
        if(arr3.get(i) > arr3.get(i+1)){
            upper = i;
            break;
        }
       }
       int lower = upper + 1;
       System.out.println(upper+" ,"+lower);
       while(lower != upper){

        if(arr3.get(lower) + arr3.get(upper) == target){
            return true;
        }
        else if(arr3.get(lower) + arr3.get(upper) < target){

            lower = (lower + 1)%n;    //same as (lower+1)%n if n = arr.size()
        }
        else{
            upper = (upper-1+n)%n;  //same as (upper-1+n)%n if n = arr.size()
        }
       }
       return false;
    }

    public static void main(String args[]){

        ArrayList<Integer> list = new ArrayList<>();

        //Adding element in Arraylist
        list.add(23); //O(1)
        list.add(33);
        list.add(78);
        list.add(10);

        //Adding element at specific index 
        list.add(1,11);  //O(n)


        System.out.println(list);
        //accessing the element from index
        int element = list.get(3);
        
        //removing an element
        list.remove(1);
        System.out.println(list);

        //update the element
        list.set(2,56);
        System.out.println(list);

        System.out.println(list.contains(56));
        System.out.println(list.contains(11));

        //printing the arraylist using for loop 
        //list.size() - gives the size of ArrayList
        for(int i=0;i<list.size();i++){

            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        //Finding the maximum element in Arraylist

        int max = Integer.MIN_VALUE;

        for(int i=0;i<list.size();i++){

            // if(max < list.get(i)){
            //     max = list.get(i);
            // }
            max= Math.max(max, list.get(i));
        }
        System.out.println("maximun element in ArrayList: "+max);

        System.out.println(list);
        //swaping the elements:
        int idx1 = 1;
        int idx2 = 3;
        swap(list,idx1,idx2);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);

        //creating a Arraylist that stores another Arraylist in it
        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
        // mainlist.add(1);
        // mainlist.add(2);
        // mainlist.add(3);
        // mainlist.add(4);
        // mainlist.add(5);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(4);
        list1.add(6);
        list1.add(8);
        list1.add(10);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(6);
        list2.add(9);
        list2.add(12);
        list2.add(15);
        
        //adding the Arraylist list1 and list2 in mainlist.
        mainlist.add(list1);
        mainlist.add(list2);
        System.out.println(mainlist);

        for(int i=0;i<mainlist.size();i++){

            //Here i is iterating the Arraylist not the elements
            ArrayList<Integer> currlist = mainlist.get(i);
            for(int j=0;j<currlist.size();j++){
                //interatine the currlist ArrayList elements
                System.out.print(currlist.get(j)+" ");
            }
            System.out.println();
        }
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        //System.out.println("maximum area of water stored in cylinders: "+storewater(height));
        //System.out.println("maximum area of water stored in cylinders: "+storewater2(height));
        ArrayList<Integer> arr2 = new ArrayList<>();
        //Sorted ArrayList
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        arr2.add(4);
        arr2.add(5);
        arr2.add(6);

        ArrayList<Integer> arr3 = new ArrayList<>();
        // Sorted and rotated around 10 as pivot point
        arr3.add(11);
        arr3.add(15);
        arr3.add(6);
        arr3.add(8);
        arr3.add(9);
        arr3.add(10);
        System.out.println(pairsumAdv(arr3,16));

    }
    
}
