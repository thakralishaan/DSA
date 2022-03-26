class Solution {
    public int uniquePathsWithObstacles(int[][] obstacle) {
        
        return totalWays(0,0,obstacle.length,obstacle[0].length, obstacle, new HashMap<String,Integer>());
        
    }
    
    private int totalWays(int CurrentRow, int currentColumn, int m , int n,int[][] obstacle, HashMap<String,Integer> memo){
        
        
        if(CurrentRow==m-1 && currentColumn==n-1 && obstacle[CurrentRow][currentColumn]!=1)
            return 1;
        
        if(CurrentRow>=m || currentColumn>=n || obstacle[CurrentRow][currentColumn]==1)
            return 0;
        
        String currentKey= currentColumn + "-" + CurrentRow;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int moveDown= totalWays(CurrentRow +1 , currentColumn, m,n,obstacle, memo);
        int moveRight=totalWays(CurrentRow, currentColumn +1 , m ,n,obstacle, memo);
        
        memo.put(currentKey, moveDown+moveRight);
        return memo.get(currentKey);
    }
}