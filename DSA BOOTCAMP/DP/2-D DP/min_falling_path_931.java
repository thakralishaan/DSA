class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int m=matrix.length;
        int n=matrix[0].length;
        
        int ans=10000;
        
        HashMap<String,Integer> memo=new HashMap<>();
        
        for(int currentCol=0; currentCol<n; currentCol++){
            int tempAns= minPathSum(matrix,0, currentCol,m,n,memo);
            ans= Math.min(ans, tempAns);
        }
        
        return ans;
        
    }
    
    private int minPathSum(int[][]matrix, int currentRow, int currentCol, int m, int n,HashMap<String,Integer> memo){
        if (currentCol<0 || currentCol>=n)
            return 100001;
        
        if(currentRow== m-1)
            return matrix[currentRow][currentCol];
        
        String currentKey= currentRow + "-" + currentCol;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int leftDiagnol= matrix[currentRow][currentCol] + minPathSum(matrix, currentRow+1, currentCol-1, m,n,memo);
        int down= matrix[currentRow][currentCol] + minPathSum(matrix, currentRow+1, currentCol, m,n,memo);
        int rightDiagnol= matrix[currentRow][currentCol] + minPathSum(matrix, currentRow+1, currentCol+1, m,n,memo);
        
        memo.put(currentKey, Math.min(leftDiagnol, Math.min(down,rightDiagnol)));                      //T.C 0(n*3*m*n)  S.C 0(m)
        return memo.get(currentKey);
        
    }
}