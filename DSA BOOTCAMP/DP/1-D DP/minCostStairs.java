class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer,Integer> memo= new HashMap<Integer,Integer>();  //Declaring hashmap
        return Math.min(minCost(cost,0,memo), minCost(cost,1,memo));   //can also be written as minCost(1);
            
        
    }
    
    private int minCost(int[] cost, int currentIndex, HashMap<Integer,Integer> memo){
        
        if(currentIndex==cost.length)
            return 0;
        
        if(currentIndex>cost.length)       //Whenever minimum we check the constraints and return upper limit +1
            return 1001;
        
        int currentKey=currentIndex;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int oneJump= cost[currentIndex] + minCost(cost, currentIndex+1,memo);
        int twoJumps=cost [currentIndex] +minCost(cost, currentIndex+2,memo);
        
        memo.put(currentKey, Math.min(oneJump,twoJumps));       //T.C 0(n)   S.C  0(n)
        return memo.get(currentKey);
        
    }
}