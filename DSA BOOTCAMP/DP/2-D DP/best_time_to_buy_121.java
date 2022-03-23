class Solution {
    public int maxProfit(int[] prices) {
        
        return maxProfit(prices,0,1,1 , new HashMap<String,Integer>()); // taking currentday=0 , canbuy as 1 so that on buying we decrease its value and then 1 for transcount as a metric to check if it is still left
        
    }
    
    private int maxProfit(int[] prices,int currentDay, int canBuy, int transCount , HashMap<String,Integer> memo){
        
        if(currentDay >=prices.length || transCount ==0)
            return 0;
    
    String currentKey=currentDay + "-" + canBuy + "-" + transCount;
    
    if(memo.containsKey(currentKey))
        return memo.get(currentKey);
    
    int ans=0;
    
    if(canBuy==1){
        
        int idle= maxProfit(prices, currentDay+1, canBuy, transCount,memo );
        
        int buy= -prices[currentDay]+ maxProfit(prices, currentDay+1 , 0, transCount,memo);   //increasing days as given in ques
        
        ans= Math.max(idle,buy);
    }
    else{
        
        int idle= maxProfit(prices,currentDay+1 , canBuy, transCount,memo);
        
        int sell= prices[currentDay] + maxProfit(prices, currentDay+1, 1 , transCount-1,memo);   // on selling 1 trans is complete so decreasing     
        
        ans= Math.max(idle,sell);
    }
    
    memo.put(currentKey,ans);
    return ans;                                    T.C 0(n)  S.C 0(n)
 }
}
