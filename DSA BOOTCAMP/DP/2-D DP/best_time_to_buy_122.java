class Solution {
    public int maxProfit(int[] prices) {
        
        return maxProfit(prices,0,1, new HashMap<String,Integer>());
        
    }
    
    private int maxProfit(int[] prices,int currentDay, int canBuy, HashMap<String,Integer> memo){
        
        if(currentDay >=prices.length)
            return 0;
    
    String currentKey=currentDay + "-" + canBuy;
    
    if(memo.containsKey(currentKey))
        return memo.get(currentKey);
    
    int ans=0;
    
    if(canBuy==1){
        
        int idle= maxProfit(prices, currentDay+1, canBuy, memo );
        
        int buy= -prices[currentDay]+ maxProfit(prices, currentDay+1 , 0,memo);
        
        ans= Math.max(idle,buy);
    }
    else{
        
        int idle= maxProfit(prices,currentDay+1 , canBuy,memo);
        
        int sell= prices[currentDay] + maxProfit(prices, currentDay+1, 1,memo);
        
        ans= Math.max(idle,sell);
    }
    
    memo.put(currentKey,ans);
    return ans;
}
}
