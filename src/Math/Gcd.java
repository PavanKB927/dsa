package Math;

import java.util.Arrays;

public class Gcd {
    public static void main(String[] args) {
        // deleteOne(new int[]{7,21});
        // pubG(new int[]{36, 57, 84, 82, 88, 32, 76, 20});
        allGcdPairs(new int[]{5,5,10});
    }

    // To find gcd of two numbers(using Euclid's Algo)
    public static int euclidGcd(int A, int B){
        if(B == 0){
            return A;
        }
        return euclidGcd(B, A%B);
    }

    /* Question : Delete one
    * Given an integer array A of size N.
    * You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
    * Find the maximum value of GCD.
    * */
    public static void deleteOne(int[] A) {
        System.out.println("input :"+ Arrays.toString(A));
        int n = A.length;
        if(n == 2){
            System.out.println("Answer :"+ Math.max(A[0],A[1]));
            return;
        }
        int[] prefixGcd = new int[n+2];
        int[] suffixGcd = new int[n+2];

        prefixGcd[1] = A[0];
        for(int i = 2; i<=n; i++){
            prefixGcd[i] = euclidGcd(prefixGcd[i-1],A[i-1]);
        }
        System.out.println("Prefix gcd :"+Arrays.toString(prefixGcd));

        suffixGcd[n] = A[n-1];
        for(int i = n-1; i>=1; i--){
            suffixGcd[i] = euclidGcd(suffixGcd[i+1],A[i-1]);
        }
        System.out.println("Suffix gcd :"+Arrays.toString(suffixGcd));

        int ans = Math.min(suffixGcd[2], prefixGcd[n-1]);
        for(int i=2; i<n; i++){
            ans = Math.max(ans, euclidGcd(prefixGcd[i-1],suffixGcd[i+1]));
        }
        System.out.println("ans :"+ans);

    }

    /* Question : Pubg
    * There are N players, each with strength A[i]. when player i attack player j,
    * player j strength reduces to max(0, A[j]-A[i]).
    *  When a player's strength reaches zero, it loses the game,
    * and the game continues in the same manner among other players until only 1 survivor remains.
    * Can you tell the minimum health last surviving person can have?
    * */
    public static void pubG(int[] A) {
        System.out.println("Input :"+Arrays.toString(A));
        int ans = A[0];
        for(int i=1; i<A.length; i++){
            ans = Math.min(ans,euclidGcd(ans,A[i]));
        }
        System.out.println("answer :"+ans);
    }

    /* Question : All GCD Pair
    * Given an array of integers A of size N containing GCD of every possible pair of elements of another array.
    * Find and return the original numbers used to calculate the GCD array in any order.
    * For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.
    * */
    public static void allGcdPairs(int[] A) {
        System.out.println("Input :"+Arrays.toString(A));
        int n = A.length;
        int interval = (int)Math.sqrt(n);
        int[] res = new int[interval];
        int max = 0;
        int count = 0, k = 0;

        for (int j : A) {
            if (j > max) max = j;
            count++;
            if (count == interval) {
                res[k++] = max;
                max = 0;
                count = 0;
            }
        }
        System.out.println("Result :"+Arrays.toString(res));

    }
}
