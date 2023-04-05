package Sorting;

import java.util.Arrays;

public class Sorting_1 {
    public static void main(String[] args) {
        // System.out.println("max mod : "+maxMod(new int[]{2,2,2,2}));
        // System.out.println("Consecutive Numbers : "+consecutiveElements(new int[]{3,1,2,4,5}));
        // System.out.println("Kth Smallest Element : "+kthsmallest(new int[]{1,2,0},2));
        // System.out.println("Merge Two Arrays :"+Arrays.toString(mergeTwoArrays(new int[]{1,2,3,4},new int[]{1,3,4,4})));
        System.out.println(" Chocolate Distribution :"+chocolateDistribution(new int[]{3,4,1,9,56,7,9,12}, 5));

    }

    /* Question : MaxMod
    * Given an array A of size N, Groot wants you to pick 2 indices i and j such that
    *  1 <= i, j <= N A[i] % A[j] is maximum among all possible pairs of (i, j).
    * Help Groot in finding the maximum value of A[i] % A[j] for some i, j.
    * */
    public static int maxMod(int[] A) {
        // can also be done in sorting, use Arrays.sort(A), then find second max element which is not equal to firstMax then return secondMax else return 0;
        int max = A[0],ans = 0;
        for(int i=1; i<A.length; i++){
            if(A[i] > max){
                max = A[i];
            }
        }
        for(int i = 0; i<A.length; i++){
            if(A[i]% max > ans){
                ans = A[i]%max;
            }
        }
        return ans;
    }

    /* Question : Array with Consecutive elements
    * Given an array of positive integers A, check and return whether the array elements are consecutive or not.
    * NOTE: Try this with O(1) extra space.
    * */
    public static int consecutiveElements(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        int start = A[0];
        for(int i = 0;i<n;i++,start++){
            if(A[i] != start){
                return 0;
            }
        }
        return 1;
    }

    /* Question : Kth Smallest Element
    * Find the Bth smallest element in given array A .
    * NOTE: Users should try to solve it in less than equal to B swaps.
    * */
    public static int kthsmallest(final int[] A, int B) {
        // using selection sort we can find the Kth smallest element of an array
        int n = A.length;
        int[] temp = new int[n];
        for(int i=0; i<n;i++){
            temp[i] = A[i];
        }

        for(int i = 0; i<B;i++){
            int min = temp[i],idx = i;
            for(int j = i;j<n;j++){
                if(min > temp[j]){
                    min = temp[j];
                    idx = j;
                }
            }
            int tempVal = temp[i];
            temp[i] = min;
            temp[idx] = tempVal;
        }
        return temp[B-1];

    }

    /* Question : Merge two sorted arrays
    * Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
    * */
    public static int[] mergeTwoArrays(final int[] A, final int[] B) {
        // make use of merge sort
        int m = A.length, n = B.length, i=0,j=0,k=0;
        int[] ans = new int[m+n];
        while( i < m && j < n){
            if(A[i] < B[j]){
                ans[k] = A[i];
                i++;
                k++;
            }else{
                ans[k] = B[j];
                j++;
                k++;
            }
        }
        while(i < m){
            ans[k] = A[i];
            k++;
            i++;
        }
        while(j < n){
            ans[k] = B[j];
            k++;
            j++;
        }

        return ans;
    }

    /* Question : Chocolate Distribution
    * Given an array A of N integers where the i-th element represent the number of chocolates in the i-th packet.
    * There are B number of students, the task is to distribute chocolate packets following below conditions:
    * 1. Each student gets one packet.
    * 2. The difference between the number of chocolates given to any two students is minimum.
    * Return the minimum difference (that can be achieved) between the student who gets minimum
    *  number of chocolates and the student who gets maximum number of chocolates.
    * */
    public static int chocolateDistribution(int[] A, int B) {
        // sort the array and check for min difference of  subsets of length B
        Arrays.sort(A);
        int start = 0, end = B-1, min = Integer.MAX_VALUE;
        while(end < A.length){
            int val  = A[end] - A[start];
            if(val < min){
                min = val;
            }
            start++;
            end++;
        }
        return min;
    }

}
