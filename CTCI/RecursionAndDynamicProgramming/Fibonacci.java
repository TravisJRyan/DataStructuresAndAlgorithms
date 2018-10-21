/*
    3 solutions to the Fibonacci problem (printing first N fibonacci numbers) to 
    illustrate recursion and DP concepts (memoization and bottom-up)
*/

public class Fibonacci{
    public static void main(String[] args){
        // simple recursion O(2^n), inefficient
        System.out.println(fibonacciRecursive(5));
        System.out.println(fibonacciRecursive(20));

        // memoization  O(N)
        System.out.println(fibonacciDynamic(5));
        System.out.println(fibonacciDynamic(20));

        // bottom up iteration O(N)
        System.out.println(bottomUpFib(5));
        System.out.println(bottomUpFib(20));
    }

    // Using the recursive tree, you can visualize this solution to be roughly O(2^n)
    // Increases exponentially
    public static int fibonacciRecursive(int i){
        if(i==0) return 0;
        if(i==1) return 1;
        return fibonacciRecursive(i-1) + fibonacciRecursive(i-2);
    }

    // Dynamic Solution: only O(n) time becase of cached results
    public static int fibonacciDynamic(int n){
        return fibDynamicAux(n, new int[n+1]);
    }

    // passing around an int[] to store previous computations
    public static int fibDynamicAux(int n, int[] memo){
        if(n==0 || n==1) return 1;
        
        if(memo[n]==0)
            memo[n] = fibDynamicAux(n-1, memo) + fibDynamicAux(n-2, memo);
        
        return memo[n];
    }

    // Another Dynamic Solution: bottom-up iteration
    // also O(n) and more space efficient
    public static int bottomUpFib(int n){
        if(n==0)
            return 0;
        int a = 0;
        int b = 1;
        for(int i = 2; i < n; i++){
            int c = a + b;
            a = b;
            b = c;
        }
        return a + b;
    }
}