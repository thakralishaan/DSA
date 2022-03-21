class Solution {
    public int fib(int n) {
        return Fibo(n, new HashMap<Integer,Integer>());
        
    }
    
    private int Fibo (int n, HashMap<Integer,Integer>memo){
        
        if(n==0){                 //base conditions given fibo starts from 0 and 1
            return 0;
        }
        
        if(n==1){
            return 1;
        }
        
        int currentKey=n;            //creating a key mandatory for DP
        
        if(memo.containsKey(currentKey))       //checking the sub problems already exist or not
            return memo.get(currentKey);
        
        int a=Fibo(n-1, memo);
        int b=Fibo(n-2, memo);
        
        memo.put(currentKey, a+b);
        return memo.get(currentKey);
    }
}