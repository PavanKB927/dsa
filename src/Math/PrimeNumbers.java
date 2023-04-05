package Math;

import java.util.Arrays;

public class PrimeNumbers {
    public static void main(String[] args) {
        System.out.println("factorial array :: "+solveFactorialArray(new int[]{125, 798, 631, 637, 572, 348, 234, 945, 504, 457, 255, 790, 586, 758, 173, 192, 706, 503, 419, 893, 140, 561, 492, 647, 979, 321, 751, 336, 23, 299, 65, 500, 449, 697, 137, 22, 397, 723, 967, 253, 533, 222, 396, 119, 980, 569, 311, 38, 424, 731, 932, 565, 644, 424, 564, 623, 745, 315, 311, 120, 615, 377, 621, 416, 426, 110, 438, 823, 834, 405, 429, 367, 979, 825, 486, 959, 746, 149, 350, 171, 232, 282, 88, 876, 706, 4, 852, 804, 671, 163, 924, 286, 892, 897, 55, 318, 8, 493, 494, 194 }));

    }

    /* Question : Factorial array
    * Groot has an array A of size N. Boring, right? Groot thought so too,
    *  so he decided to construct another array B of the same size and defined elements of B as:
    * B[i] = factorial of A[i] for every i such that 1<= i <= N.
    * factorial of a number X denotes (1 x 2 x 3 x 4......(X-1) x (X)).
    * Now Groot is interested in the total number of non-empty subsequences of array B
    *  such that every element in the subsequence has the same non-empty set of prime factors.
    * Since the number can be huge, return it modulo 109 + 7.
    * NOTE: A set is a data structure having only distinct elements. E.g : the set of prime factors of Y=12 will be {2,3} and not {2,2,3}
    * */
    public static int solveFactorialArray(int[] A) {
        int mod = 1000000007;
        Arrays.sort(A);
        int max = A[A.length-1];
        // compute prime numbers upto max
        boolean[] isPrime = new boolean[max+1];
        for(int i = 2;i*i<=max;i++){
            if(!isPrime[i]){
                for(int j = i*i;j<=max;j=j+i){
                    isPrime[j] = true;
                }
            }
        }

        //compute prime count for each index
        int[] isPrimeCount = new int[max+1];
        for(int i =2;i<=max;i++){
            if(!isPrime[i]){
                isPrimeCount[i] = isPrimeCount[i-1]+1;
            }else{
                isPrimeCount[i] = isPrimeCount[i-1];
            }
        }

        System.out.println("sorted array : "+Arrays.toString(A));
        System.out.println("isPrime array : "+Arrays.toString(isPrime));
        System.out.println("prime count : "+Arrays.toString(isPrimeCount));

        int count = 1;
        if(A[0]<2){
            count =0;
        }
        long sum =0;
        for(int i=0;i<A.length-1;i++){
            if(isPrimeCount[A[i]] == isPrimeCount[A[i+1]]){
                count++;
            }else{
                sum = (sum + (1<<count) -1)%mod;
                count = 1;
            }
        }
        sum = (sum + (1<<count) -1)%mod;
        return (int)sum;
    }


}
