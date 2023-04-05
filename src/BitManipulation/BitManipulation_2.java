package BitManipulation;

import java.util.Arrays;

public class BitManipulation_2 {
    public static void main(String[] args) {
        // singleNumber3(new int[]{1, 2, 3, 1, 2, 4});
        // singleNumber2(new int[]{1, 2, 4, 3, 3, 2, 2, 3, 1, 1});
        // maximumANDPair(new int[]{53, 39, 88});
        //strangeEquality(5);
        // subArrayOr(new int[]{1, 2, 3, 4, 5}); -------------------------------->>> Pending
        findMinXor(new int[]{0,4,7,9});

    }
    // Check bit
    private static boolean checkBit(int val, int i) {
        if((1 & (val >> i)) ==1){
            return true;
        }
        return false;
    }

    /* Question: Single Number III
     * Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
    * Find the two integers that appear only once.
    * */
    public static void singleNumber3(int[] A) {
        int[] answer = new int[2];
        int a = 0,b=0,pos = 0,n = A.length,val= 0;
        for(int i = 0; i<n; i++){
            val = val ^ A[i];
        }
        System.out.println("xor of two integers appear only once :"+val);
        // find the set bit in val
        for(int i = 0;i<=31; i++){
            if(checkBit(val, i)){
                pos = i;
                break;
            }
        }
        System.out.println("position :"+pos);

        //if Ai setbit is equals to pos setbit then add to xor of a, else add to xor of b
        for(int i = 0; i<n; i++){
            if(checkBit(A[i],pos)){
                a = a^A[i];
            }else{
                b = b^A[i];
            }
        }
        System.out.println("A :"+a+" :: B :"+b);
        answer[0] = a;
        answer[1] = b;
    }

    /* Question: Single Number II
    * Given an array of integers, every element appears thrice except for one, which occurs once.
    * Find that element that does not appear thrice.
    * NOTE: Your algorithm should have a linear runtime complexity.
    * Could you implement it without using extra memory?
    * */
    public static void singleNumber2(final int[] A) {
        int ans = 0,n = A.length;
        for(int i = 0; i<31; i++){
            int setBit = 0;
            for(int j=0; j<n; j++){
                if(checkBit(A[j],i)){
                    setBit++;
                }
            }
            if(setBit%3 ==1){
                ans = ans | (1<<i);
            }
        }
        System.out.println("answer :"+ans);
    }

    /* Question: Maximum AND Pail
    * Given an array A. For every pair of indices i and j (i != j), find the maximum A[i] & A[j].
    * */
    public static void maximumANDPair(int[] A) {
        int ans = 0,n = A.length;
        for(int i = 31; i >= 0; i--){
            int count = 0;
            for(int j=0; j<n; j++){
                if(checkBit(A[j],i)){
                    count++;
                }
            }
            if(count >= 2){
                ans = ans | (1 << i);
                for(int j = 0; j<n; j++ ){
                    if(!checkBit(A[j],i)){
                        A[j] = 0;
                    }
                }
            }
        }
        System.out.println("Answer :"+ans);
    }

    /* Question: Strange Equality
     * Given an integer A.Two numbers, X and Y, are defined as follows:
    * X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
    * Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
    * Find and return the XOR of X and Y.
    * NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.
    * NOTE 2: Your code will be run against a maximum of 100000 Test Cases.
    * */
    public static void strangeEquality(int A) {
        //to find number of bits
        int num_bits=(int)(Math.log(A)/Math.log(2))+1;
        System.out.println("Number of Bits :"+num_bits);
        int val = A, bits =0;
        /*while(val > 0){
            System.out.println("val :"+val);
            bits++;
            val = val/2;
        }
        System.out.println("bits :"+bits);*/
        System.out.println("X :"+(((1 << num_bits)-1)^A));
        System.out.println("Y :"+(1 << num_bits));
        int ans = (((1 << num_bits)-1)^A)^(1 << num_bits);
        System.out.println("answer ::"+ans);
    }

    /* Question :  SUBARRAY OR
    * You are given an array of integers A of size N.
    * The value of a subarray is defined as BITWISE OR of all elements in it.
    * Return the sum of value of all subarrays of A % 109 + 7.
    * */
    public static void subArrayOr(int[] A) {
        //approach : can be solved in n2 using 2 for loops
        int ans = 0,n = A.length;
        int mod = 1000000007;
        for(int i=0; i<31;i++){
            int idx = n;
            for(int j=n-1; j>=0;j--){
                if(checkBit(A[j],i)){
                    idx = j;
                    ans += ((n-idx) * (Math.pow(2,i)%mod))%mod;
                }
            }
        }
        System.out.println("Answer :"+ans);

    }

    /* Question: MinimumXor
    * Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.
    * */
    public static void findMinXor(int[] A) {
        int n = A.length,ans = Integer.MAX_VALUE;
        Arrays.sort(A);
        for(int i=1; i<n; i++){
            if((A[i-1]^A[i]) < ans){
                ans = A[i-1] ^ A[i];
            }
        }
        System.out.println("Answer :"+ans);
    }
}
