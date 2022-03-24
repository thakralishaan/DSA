public static int knapSack(int Capacity, int wt[], int val[], int n) 
    { 
         return maxProfit(Capacity, wt, val,0,n, new HashMap<>());
    } 
    
    public static int maxProfit(int capacity , int[] weight, int[] profit,  int currIndex,int n, HashMap<String, Integer> map)
    {
        if(currIndex>=n) return 0;

         int currItemWeight =  weight[currIndex];
         int currItemProfit =  profit[currIndex];
                                        
        String key = currIndex + "-" + capacity;
        
        if(map.containsKey(key))
            return map.get(key);

        int pickItem = 0;                             //as if and else statement both can take its value so we specify 
        
        if(currItemWeight<=capacity)                 //checking if we can even add the item to the bag if yes then
        pickItem = currItemProfit + maxProfit(capacity - currItemWeight, weight, profit,currIndex+1, n, map);   //decrease the capacity by the weight of the item and go to next index
        
        int nonPickItem =  maxProfit(capacity , weight, profit,currIndex+1,  n, map);
        
         map.put(key, Math.max(pickItem, nonPickItem));                // T.C n S.C:  0(n x w) we check the items in key which are changing there is  number of items n and weight of each item w.
        
        return map.get(key);
        
    }