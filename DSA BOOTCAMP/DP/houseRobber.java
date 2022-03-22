class Solution {
    public int rob(int[] nums) {
        
        return maxAmt(nums,0, new HashMap<Integer,Integer>());
        
    }
    
    private int maxAmt(int[] nums, int currentIndex, HashMap<Integer,Integer> memo){
        
        if (currentIndex>=nums.length)
            return 0;
        
        int currentKey=currentIndex;
        
        if(memo.containsKey(currentIndex))
            return memo.get(currentKey);
        
        
        int rob=nums[currentIndex]+maxAmt(nums, currentIndex+2,memo);
        int noRob= maxAmt(nums, currentIndex+1,memo);
        
        memo.put(currentKey, Math.max(rob, noRob));
        return memo.get(currentKey);                               //T.C 0(n)  S.C 0(n)
    }
}