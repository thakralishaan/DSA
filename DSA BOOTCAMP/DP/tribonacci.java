class Solution {
    public int tribonacci(int n) {

        return trio(n, new HashMap<Integer, Integer>());

    }

    public int trio(int n, HashMap<Integer, Integer> memo) {

        if (n == 0) // as t(0)=0
            return 0;

        if (n == 1 || n == 2) // two cases as t(1) and t(2) both are 1 so it returns 1
            return 1;

        int currentKey = n;

        if (memo.containsKey(n))
            return memo.get(n);

        int a = trio(n - 1, memo); // (n-1)+(n-2) for Fibonacci
        int b = trio(n - 2, memo);
        int c = trio(n - 3, memo);

        memo.put(n, a + b + c); // T.C: 0(n) S.C 0(n)
        return memo.get(n);

    }

}