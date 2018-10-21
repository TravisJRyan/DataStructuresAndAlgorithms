/*
    8.1 Triple Step - A child is running up a staircase with n steps. They can run 1, 2, or 3 steps at a time.
    Implement a method to count how many possible ways the child can run up the steps.
*/

import java.util.Arrays;

public class TripleStep{
    public static void main(String[] args){
        System.out.println("# of Combinations for 10 Steps: "+tripleStep(10));
        System.out.println("# of Combinations for 20 Steps: "+tripleStep(20));
        System.out.println("# of Combinations for 5 Steps: "+tripleStep(5));

        System.out.println("# of Combinations for 10 Steps: "+countWaysCaching(10));
        System.out.println("# of Combinations for 20 Steps: "+countWaysCaching(20));
        System.out.println("# of Combinations for 5 Steps: "+countWaysCaching(5));
    }

    // my solution, simple (but inefficient) recursion running at roughly O(3^n) due to depth of n, and branching of 3
    public static int tripleStep(int stepsRemaining){
        if(stepsRemaining < 0)
            return 0;
        else if(stepsRemaining==0)
            return 1;
        else{
            return tripleStep(stepsRemaining-1) + tripleStep(stepsRemaining-2) + tripleStep(stepsRemaining-3);
        }
    }

    // CTCI solution, uses caching for O(n) runtime, although overflow still occurs due to recursion
    public static int countWaysCaching(int n){
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return countWaysCaching(n, memo);
    }

    public static int countWaysCaching(int n, int[] memo){
        if(n<0)
            return 0;
        else if(n==0)
            return 1;
        else if(memo[n]>-1)
            return memo[n];
        else{
            memo[n] = countWaysCaching(n-1, memo) + countWaysCaching(n-2, memo) + countWaysCaching(n-3, memo);
            return memo[n];
        }
    }


}