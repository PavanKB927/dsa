package Math;

import java.util.Arrays;

public class Combinatorics {
    public static void main(String[] args) {
       // compute_nCr_nonPrime(41,27,143);
       // compute_nCr_prime(51299,25646,3685739);
        System.out.println("Find Rank :"+findRank("baca"));

    }

    /* Question : Compute nCr%m
    * Given three integers A, B, and C, where A represents n, B represents r, and C represents m,
    *  find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
    * x! means factorial of x i.e. x! = 1 * 2 * 3... * x.*/
    public static void compute_nCr_nonPrime(int A, int B, int C) {
        int[][] pascalArray = new int[A+1][B+1];
        for(int j = 0; j<=B;j++){
            pascalArray[0][j] = j==0? 1:0;
        }
        for(int i = 1; i<=A; i++){
            for(int j=0; j<=B; j++){
                if(j == 0){
                    pascalArray[i][j] = 1;
                }else {
                   // pascalArray[i][j] = pascalArray[i-1][j-1] + pascalArray[i-1][j];
                    pascalArray[i][j] = (getmod(pascalArray[i-1][j-1],C) + getmod(pascalArray[i-1][j],C)) % C;
                }
            }
        }
        System.out.println("Pascal's matrix:\n"+ Arrays.deepToString(pascalArray));

        // using pascal's: nCr%p = ((n-1Cr-1)%p + (n-1Cr)%p)%p
        int answer  = (( pascalArray[A-1][B-1] % C ) + ( pascalArray[A-1][B] % C)) % C;
        System.out.println("answer :"+answer);
    }

    public static int getmod(int val, int mod){
        if(val > 0){
            return val % mod;
        }else {
            return (val+mod) % mod;
        }
    }

    /* Question : Compute nCr % p
    * Given three integers A, B, and C, where A represents n, B represents r, and C represents p and
    * p is a prime number greater than equal to n, find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.
    * x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
    * NOTE: For this problem, we are considering 1 as a prime.
    * */
    public static void compute_nCr_prime(int A, int B, int C) {
        // using fermat's little theorem
        // nCr % p = ( fact(n)%p * modInverse(fact(r) % p) * modInverse(fact(n-r) %p)) % p
        if(A < B){
            System.out.println("answer :"+0);
            return;
        }
        if(B == 0){
            System.out.println("answer >>> "+1);
            return;
        }
        long[] fact = new long[A+1];
        fact[0] = 1;
        for (int i=1; i<= A; i++){
            fact[i] = (fact[i-1] * i) % C;
        }
        System.out.println("factorial :"+Arrays.toString(fact));

        long val1 = fact[A]%C;
        long val2 = modInverse((int)fact[B], C) % C;
        long val3 = modInverse( (int)fact[A-B],C) % C;
        long answer = ((val1 * val2)% C * val3)% C;
        System.out.println("answer :"+answer);
        return;
    }

    private static long modInverse(int n, int p) {
        return power(n, p-2, p);
    }

    private static long power(long x, int y, int p) {
        long res = 1;
        x = x%p;
        while(y > 0){
            if(y%2 ==1) {
                res = (res * x) % p;
                x = (x * x) % p;
                y = (y-1)/ 2;
            }else {
                y = y >> 1;
                x = (x * x) % p;
            }
        }
        return res;
    }

    public int sum(int n){
        if(n == 0){
            return 0;
        }
        return n+sum(n-1);
    }

    /* Sorted Permutation Rank
    * Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
    * Assume that no characters are repeated.
    * Note: The answer might not fit in an integer, so return your answer % 1000003
    * */
    public static int findRank(String A) {
        int n= A.length(), ans = 0, mod = 1000003;

        for(int i = 0; i<n-1; i++){
            int c = 0;
            for(int j = i+1;j<n;j++){
                if(A.charAt(j) < A.charAt(i)){
                    c++;
                }
            }
            System.out.println("char count less than "+ A.charAt(i)+" is :"+c);
            ans += (c * fact(n-i-1, mod)) % mod;
        }
        System.out.println("answer :"+(ans+1)%mod);
        return (ans+1)%mod;
    }

    private static int fact(int a, int mod) {
        if(a == 0){
            return 1;
        }
        return ( (a%mod) * (fact(a-1,mod)%mod) ) % mod;
    }


}
