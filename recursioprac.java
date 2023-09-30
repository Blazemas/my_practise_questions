import javax.sound.sampled.SourceDataLine;

public class recursioprac {

    public static void occurance(int arr[],int idx,int key){

        if(idx == arr.length){
            return;
        }

        if(arr[idx] == key){
            System.out.print(idx +" ");
        }
        occurance(arr, idx+1, key);
    }
    public static void convertstring(String arr2[],int n,int count){

        if(n <= 0 ){
            return;
        }
        int lastdigt = n % 10;
        if(count==0 && lastdigt == 0){  //not considering the condition where last digit is 0.
            return;
        }
        convertstring(arr2, n/10,count+1);
        System.out.print(arr2[lastdigt]+" ");
    
    }
    public static void substring(String str,int si,int curr){

        if(si == str.length()){
            return;
        }

        for(int i=si;i<str.length();i++){

            for(int j=curr;j<=i;j++){

                System.out.print(str.charAt(j));
            
            }
            System.out.println();
        }
        substring(str, si+1, curr+1);

    }

    
    public static void main(String args[]){

        int arr[] = {7,2,1,2};
        String arr2[] ={"zero","one","two","three","four","five","six","seven","eight","nine"};
        //occurance(arr, 0, 2);
        //convertstring(arr2, 347,0);
        String  str= "abdfsd";
        int n = str.length();
        String newstr ="";
        substring(str,0,0);
       
    }
}
