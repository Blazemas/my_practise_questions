public class recursion {

    public static void decreasingnum(int num){

        
        
        if(num==1){           //bass case (Stoping conditions)
            System.out.println(num+" ");
            return;
        }
        System.out.println(num +" ");
        decreasingnum(num-1);
        
        
    }
    public static void increasingnum(int num){

        
        if(num == 1){           //bass case (Stoping conditions)
            System.out.println(num);
            return;
        }
        increasingnum(num-1);        //
        System.out.println(num);
        
    }
    public static int fact(int num){       //time complexity = O(n) space complexity = O(n)

        if(num==0){    //base condition 0! = 1
            return 1;
        }
        int fact_n_1 = fact(num-1);
        int fact = fact_n_1 * num;
        return fact;
    }
    public static int sum_to_n(int num){     //time complexity = O(n) space complexity = O(n)

        if(num == 1){
            return 1;
        }
        int sum_n_1 = sum_to_n(num-1);

        int sumupton = num + sum_n_1;
        return sumupton;
    }
    public static int fibonacci(int num){   //time complexity = O(2^n) space complexity = O(n)
 
        if(num==0){
            return 0;
        }
        else if(num==1){
            return 1;
        }
        int fibon_1 = fibonacci(num-1);
        int fibon_2 = fibonacci(num-2);
        int fibo = fibon_1 + fibon_2;
        return fibo;
    }
    public static boolean is_sorted(int arr[],int start){ //checking is arr sorted in ascending order or not
                                                         //by using recursion
        if(start == arr.length - 1){  //base condition
            return true;
        }
        else if(arr[start] > arr[start+1]){  
            return false;
        }
        return is_sorted(arr,start+1);
    }    //time complexity = O(n)  && space coplexity = O(n)

    public static int first_occur(int arr[],int key,int i){

        if(i == arr.length){   //iteration till conditon.

            return -1;        //represent that  key is not found in arr.
        }
        if(key == arr[i]){
            return i;       //shows the first occurance index of that key in arr.
        }
        return first_occur(arr, key, i+1);    //incrementing from i+1
    }
    public static int last_occur(int arr[],int key ,int end ){  //my logic(traversing from end to start)

        if(end == 0){
            return -1;
        }
        if(key == arr[end]){
            return end;
        }
        return last_occur(arr, key, end-1);
    }
    public static int last_occur2(int arr[],int key ,int i ){   //original logic

        if(i == arr.length){
            return -1;
        }

        int isfound = last_occur2(arr, key, i+1);

        if(isfound == -1 && arr[i] == key){
            return i;
        }
        return isfound;
    }
    public static int powerof(int num,int pow){

        if(pow==1){
            return num;
        }
        int powerof_pow_1 = powerof(num, pow-1);
        int ans = num * powerof_pow_1;
        return ans;
            //OR
        //return num * powerof(num, pow-1);
    }
    public static int powoptimized(int num,int pow){   //O(logn)

        if(pow == 1){
            return num;
        }
        //for pow = even

        int halfpower = powoptimized(num, pow/2);   // instead of using 2 times recursion store it in a variable.
        int halfpowersq = halfpower * halfpower;    // instead of using 2 times recursion store it in a variable.

        //for pow = odd
        if(pow % 2 != 0){   

            halfpowersq = num * halfpowersq;

        }
        return halfpowersq;
        
    }

    // IMP Java question ( TIlling problem )

    public static int no_of_ways(int n){  //till to fill of 2xn;

        if(n==0 || n==1){
            return 1;
        }

        int vertical = no_of_ways(n-1);

        int horizantal = no_of_ways(n-2);

        int total_ways = vertical + horizantal;

        return total_ways;

    }
    //removing the duplicate string using recursion and Stringbuilder

    public static void duplicateremove(String word,int index,StringBuilder newstr,boolean map[]){
        
        if(index == word.length()){
            System.out.println(newstr);
            return;
        }

        char currchar = word.charAt(index);
        if(map[currchar-'a'] == true){
            //duplicate
            duplicateremove(word, index+1, newstr, map);
        }
        else{
            map[currchar - 'a'] = true;
            duplicateremove(word, index+1, newstr.append(currchar), map);
        }
    }

    //Friends pairig problem

    public static int no_ofways(int n){

        //base case.
        if(n==1 || n==2){
            return n;
        }
        //working part

        int single = no_ofways(n-1);

        int pair = no_ofways(n-2);

        int ways = single + pair;

        return ways+1;
    }
    public static int friendpair(int n){

        if(n==1 || n==2){
            return n;
        }
        int single = friendpair(n-1);

        int pair = friendpair(n-2);

        int pairways = (n-1) * pair;

        int totalways = single + pairways;

        return totalways;
    }

    //Binary String problem:print all binary strings of size N without consecutive ones

    public static void binarystring(int n,int lastplace,String str){

        if(n==0){
            System.out.println(str);
            return;
        }
        binarystring(n-1,0, str+"0");
        if(lastplace == 0){
            binarystring(n-1,1, str+"1");
        }
    }

 
    public static void main(String args[]){

        //decreasingnum(12);
        //increasingnum(12);
        //System.out.println(fact(4));
        //System.out.println(sum_to_n(10));
        //System.out.println(fibonacci(25));
        int arr[] = {3,6,5,8,6,9,10};  
        int arr1[] = {3,5,5,5};
        int n = arr.length;   //n = 7
        //System.out.println(is_sorted(arr, 0));
        //System.out.println(first_occur(arr, 10, 0));
        //System.out.println(last_occur(arr,6,n-1));
        // System.out.println(last_occur2(arr,6,0)); 
        // System.out.println(powerof(2, 10));
        // System.out.println(powoptimized(2, 10));
        //System.out.println(no_of_ways(6));

        StringBuilder newstr = new StringBuilder();  //or new Stringbuilder("");
        boolean map[] = new boolean[26];
        String word = "appnacollege";
        //duplicateremove(word, 0,newstr,map);
        //System.out.println(no_ofways(3));
        //System.out.println(friendpair(5));
        binarystring(3, 0,"");

    }  
    
}
