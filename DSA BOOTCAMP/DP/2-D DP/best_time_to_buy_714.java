class Solution {
    public int maxProfit(int[] prices,int fees) {
        
        return maxProfit(prices,0,1, new HashMap<String,Integer>(),fees); // taking currentday=0 , canbuy as 1 so that on buying we decrease its value and then 1 for transcount as a metric to check if it is still left
        
    }
    
    private int maxProfit(int[] prices,int currentDay, int canBuy , HashMap<String,Integer> memo, int fees){
        
        if(currentDay >=prices.length)
            return 0;
    
    String currentKey=currentDay + "-" + canBuy;
    
    if(memo.containsKey(currentKey))
        return memo.get(currentKey);
    
    int ans=0;
    
    if(canBuy==1){
        
        int idle= maxProfit(prices, currentDay+1, canBuy,memo ,fees);
        
        int buy= -prices[currentDay]+ maxProfit(prices, currentDay+1 , 0,memo,fees);   //increasing days as given in ques
        
        ans= Math.max(idle,buy);
    }
    else{
        
        int idle= maxProfit(prices,currentDay+1 , canBuy,memo,fees);
        
        int sell= -fees + prices[currentDay] + maxProfit(prices, currentDay+1, 1,memo,fees);   // on selling 1 trans is complete so decreasing     
        
        ans= Math.max(idle,sell);
    }
    
    memo.put(currentKey,ans);
    return ans;                                   // T.C 0(n)  S.C 0(n)
 }
}
