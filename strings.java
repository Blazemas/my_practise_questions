import java.util.*;
public class strings {

    boolean palindrome(String word){

        String rev ="";
        int len = word.length();
        
        for(int i=0;i<=len/2;i++){

            if(word.charAt(i)!=word.charAt(len-1-i)){
                System.out.println("not a palindrome");
                return false;
            }

        }
        System.out.println("yes it is a  palindrome");
        return true;

    }
    void shortestdist(String directions){

        int n = directions.length();
       // int north = 0;
        int x_co = 0;
        int y_co = 0;
        //int south = 0;
       // int east = 0;
       // int west =0;
        for(int i=0;i<n;i++){   //O(n)

            if(directions.charAt(i)=='N'||directions.charAt(i)=='n'){
                x_co+=1;
            }
            else if(directions.charAt(i)=='W'||directions.charAt(i)=='w'){
                y_co-=1;
            }
            else if(directions.charAt(i)=='E'||directions.charAt(i)=='e'){
                y_co+=1;
            }
            else if(directions.charAt(i)=='S'||directions.charAt(i)=='s'){
                x_co-=1;
            }
        }
       // int x_co = east - west;
        //int y_co = north - south;
        int under_root = (int)Math.pow(x_co,2) + (int)Math.pow(y_co,2);
        int dist = (int)Math.sqrt(under_root);

        System.out.println(x_co+" "+y_co);

        System.out.println("shortest dist: "+ dist);

       // System.out.println(x_co+" "+y_co);
    }
    void uppercase1st(String name){

        StringBuilder chr = new StringBuilder("");

        chr.append(Character.toUpperCase(name.charAt(0)));

        for(int i=0;i<name.length()-1;i++){

            if(name.charAt(i)==' '){
                chr.append(name.charAt(i));
                //i++;
                chr.append(Character.toUpperCase(name.charAt(i+1)));
            }
            else{
                chr.append(name.charAt(i+1));
            }
        }
        System.out.println(chr);
    }
    void compression(String name){

        StringBuilder str = new StringBuilder("");

        for(int i=0;i<name.length();i++){   //O(n)

            Integer count = 1;  //used Integer instead of int because to typecast it into string.
            while(i<name.length()-1 && name.charAt(i)==name.charAt(i+1)){

                count ++;
                i++;
            }
            str.append(name.charAt(i));
            if(count > 1){             //for count = 1 we won't print count ,it will decompress the string then 
                str.append(count.toString());
            }
        }
        System.out.println(str);
    }
    void countlowercasse(String name){

        int count = 0;

        for(int i=0;i<name.length();i++){

            char ch = name.charAt(i);

          if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            count++;
          }
        }
        System.out.println("total lowercase vowels: "+count );
    }
    void anagrams(String str1,String str2){

        if(str1.length()==str2.length()){

            int n = str1.length();
            int m = 0;

            for(int i=0;i<n;i++){

                int count1 = 1;
                int count2 = 1;
                
                while(i<n-1 && str1.charAt(i)==str1.charAt(i+1)){
    
                    count1 ++;
                    i++;
                }
                while(i<n-1 && str2.charAt(i)==str2.charAt(i+1)){
    
                    count1 ++;
                    i++;
                }
                if(count1==count2){
                    m+=1;
                }
            }
            if(m==n){
                System.out.println("1-its a anagram!!");
            }
            else{
                System.out.println("2-not a anagram!");
            }

        }
        else{
            System.out.println("3-not a anagram!!");
        }

    }
    void rev_sen(String sentence){

        int n = sentence.length();
        Character rev[] = new Character[n];
        for(int i=0;i<n;i++){

            rev[n-1-i] = sentence.charAt(i);
        }
        int end = 0;
        int start = 0;
        for(int i=0;i<n;i++){
            
            if(rev[i]==' '){
                
                start = i-1;
                for(int j=start;j>=end;j--){
                    System.out.print(rev[j]);
                }
                System.out.print(" ");
                end = i+1;
            }
            if(i==n-1){
                start = i;
                for(int k=start;k>=end;k--){
                    System.out.print(rev[k]);
                }
            }
        }
    }
    void stringfreqsort(String word){

        int n = word.length();
         
        Character arr[] = new Character[n];

        //1]adding string into array part:

        for(int i=0;i<n;i++){

            arr[i] = word.charAt(i);
        }
        for(int i=0;i<n-1;i++){

            for(int j=0;j<n-1-i;j++){

                if(arr[j] > arr[j+1]){
                    
                    Character temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        //2]counting each character frequency and storing in int array at corresponding last index.
        int arr2[] = new int[n];
        for(int i=0;i<n;i++){

            int count = 1 ;
            //int curr = i;

           while(i<n-1 && arr[i]==arr[i+1]){

                count++;
                i++;
           }
           System.out.println(arr[i]+" count: "+ count);
           
           arr2[i] = count;
           
        }
        for(int i=0;i<n;i++){

            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(arr2[i]+" ");
        }
        //3] finding the largest freq in arr2
        int max_count = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){

            if(max_count < arr2[i]){
                max_count = arr2[i];
            }
        }
        //4]printing by decending freq count of character in string.
        System.out.println();
        while(max_count >= 1){

            for(int i=0;i<n;i++){
    
                if(max_count == arr2[i]){
    
                    for(int j=0;j<arr2[i];j++){
    
                        System.out.print(arr[i]+" ");
                    }
                }
            }
            max_count--;

        }
        

    }

    
    public static void main(String args[]){

        String name = "kkkbbccccc";
        strings o = new strings();
        //System.out.println(o.palindrome(name));
       // o.shortestdist(name);
       //o.uppercase1st(name);
       String str1 = "babiiiitaa";
       String str2 = "";
       //o.compression(name);
      // o.countlowercasse(name);
      // o.anagrams(str1, str2);
       //o.rev_sen(str2);
       o.stringfreqsort(name);


    }
}
