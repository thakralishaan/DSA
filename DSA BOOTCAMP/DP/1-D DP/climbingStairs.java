class Solution {
    public int climbStairs(int n) {
        return totalWays(0,n, new HashMap<Integer,Integer>());
    }
    
    private int totalWays(int current, int target, HashMap<Integer,Integer> memo){
        
        if(current==target){                     //base cases one for adding the total ways and other to check the                                                                                                          limit(n)
            return 1;
        }
        if(current>target){
            return 0;
        }
        
        int currentKey=current;          //current key initialised for DP
        
        if (memo.containsKey(currentKey))     //check if the sub problem is solved earlier
            return memo.get(currentKey);            //else continue to totalWays function
        
        int oneJump=totalWays(current+1,target,memo);
        int twoJumps=totalWays(current+2,target,memo);
        
        memo.put(currentKey, oneJump + twoJumps);      //returning the answer in T.C 0(n)  S.C 0(n)
        return memo.get(currentKey);
    }
}