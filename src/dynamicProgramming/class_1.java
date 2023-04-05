package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class class_1 {
    static int mod = 1000000007;
    public static void main(String[] args) {
        // System.out.println("unique ways to climb stairs : "+climbStairs(3));

        int n = 6;
        ArrayList<Integer> dp = new ArrayList<>(Collections.nCopies(n+1,-1));
        System.out.println("Fibonacci of a number : "+fibonacci(n,dp));
    }

    /* Question 1: Stairs
    * You are climbing a staircase and it takes A steps to reach the top.
    * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    * Return the number of distinct ways modulo 1000000007
    * */
    public static int climbStairs(int A) {
        ArrayList<Integer> dp = new ArrayList<>(Collections.nCopies(A+1,-1));
        System.out.println("dp :: "+ Arrays.toString(dp.toArray()));
        return waysToClimb(A,dp);
    }
    public static int waysToClimb(int A, ArrayList<Integer> dp) {
        if(A <= 2)  return A;
        if(dp.get(A) == -1){
            int ans = ((waysToClimb(A-1,dp)%mod)+(waysToClimb(A-2,dp)%mod))%mod;
            dp.set(A,ans);
        }
        return dp.get(A)%mod;
    }

    /* Question 2: Fibonacci of a Number
    * Given a positive integer A, write a program to find the Ath Fibonacci number.
    * In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1.
    *  i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.
    * NOTE: 0th term is 0. 1th term is 1 and so on.
    * */
    public static int fibonacci(int n,ArrayList<Integer> dp){
        if(n == 0 || n == 1){
            return n;
        }
        if(dp.get(n) == -1){
            int ans = fibonacci(n-1,dp) + fibonacci(n-2,dp);
            dp.set(n,ans);
        }
        return dp.get(n);
    }
}
