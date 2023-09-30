public class buystock {

    void buystock(int price[],int n){

        int buyprice = Integer.MAX_VALUE;
        int maxprofit = 0;        //total max profit

        for(int i=0;i<n;i++){
            int profit = 0;      //that day's profit
            if(buyprice < price[i]){
                profit = price[i] - buyprice;
                maxprofit = Math.max(profit,maxprofit);
            }
            else{
                buyprice = price[i];
                
            }
           
        }
        System.out.println("max profit: "+maxprofit);
    
    }
    void triplet(int num[],int n){

        for(int i=0;i<n-2;i++){
            int a,b,c;
            if(num[i]!=num[i+1])

        }


    }
      
    public static void main(String args[]){

        int price[] = {7,1,5,3,6,4};
        int n = price.length;
        int num[] = {-1,0,1,2,-1,4};
        int m = num.length;
        buystock o = new buystock();
        o.buystock(price, n);


    }
}
