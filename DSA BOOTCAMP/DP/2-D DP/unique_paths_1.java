class Solution {
    public int uniquePaths(int m, int n) {
        
        return totalWays(0,0,m,n, new HashMap<String,Integer>());
        
    }
    
    private int totalWays(int CurrentRow, int currentColumn, int m , int n, HashMap<String,Integer> memo){
        
        
        if(CurrentRow==m-1 && currentColumn==n-1)
            return 1;
        
        if(CurrentRow>=m || currentColumn>=n)
            return 0;
        
        String currentKey= currentColumn + "-" + CurrentRow;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int moveDown= totalWays(CurrentRow +1 , currentColumn, m,n, memo);
        int moveRight=totalWays(CurrentRow, currentColumn +1 , m ,n, memo);
        
        memo.put(currentKey, moveDown+moveRight);     //  T.C  0(2**m*n)  S.C 0(m*n) 
        return memo.get(currentKey);
    }
}