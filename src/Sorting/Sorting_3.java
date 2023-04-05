package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Sorting_3 {
    public static void main(String[] args) {
        // arrangeFirstElement(new int[]{5,3,6,9,2,1});
        // quickSortArray(new int[]{5,3,6,9,2,1});
        // System.out.println(" SUm of Diff :"+sumOfDifference(new int[]{1,2,3,4}));
       // magicMaxMin(new int[]{3,11,-1,5});
        subUnsort(new ArrayList<>(Arrays.asList( 1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15)));
    }

    public static void arrangeFirstElement(int[] A){
        int l = 1,r = A.length-1;

        while(l < r){
            if(A[l] < A[0]){ l++;}
            else if(A[r] > A[0]){ r--;}
            else {
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;
                l++;
                r--;
            }
        }
        System.out.println(" array :"+ Arrays.toString(A));
        int temp = A[0];
        A[0] = A[l-1];
        A[l-1] = temp;
        System.out.println("Result array :"+ Arrays.toString(A));
    }

    /* Question : Quick Sort
    * Given an integer array A, sort the array using QuickSort.
    * */
    public static void quickSortArray(int[] A) {
        quickSort(A,0,A.length-1);
        System.out.println("sorted array :"+Arrays.toString(A));
    }

    private static void quickSort(int[] a, int l, int r) {
        if(l < r) {
            int pivot = rearrange(a, l, r);
            quickSort(a, l, pivot - 1);
            quickSort(a, pivot + 1, r);
        }
    }

    private static int rearrange(int[] a, int l, int r) {
        int start = l+1, end = r;
        while(start <= end){
            if(a[start] <= a[l]){ start++;}
            else if(a[end] > a[l]){ end--; }
            else {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start++;
                end--;
            }
        }
        int temp = a[start-1];
        a[start-1] = a[l];
        a[l] = temp;

        return (start-1);
    }


    /* Question :sum of Difference
    * Given an integer array, A of size N.
    * You have to find all possible non-empty subsequences of the array of numbers and then, for each subsequence,
    * find the difference between the largest and smallest numbers in that subsequence. Then add up all the differences to get the number.
    * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
    * NOTE: Subsequence can be non-contiguous.
    * */
    public static int sumOfDifference(int[] A) {
        //using Horner method find sum of max and min of subsets and fins its differences
        int mod = 1000000007;
        Arrays.sort(A);
        long maxSum = 0, minSum = 0;
        int n = A.length;
        for(int i=0;i<n;i++){
            maxSum = 2 * maxSum + A[n - 1 - i];
            maxSum %= mod;

            minSum = 2 * minSum + A[i];
            minSum %= mod;
        }

        return (int)(maxSum - minSum +mod)%mod;
    }

    /*Question : Maximum and minimum magic
    * Given an array of integers A of size N where N is even.Divide the array into two subsets such that
    * 1.Length of both subset is equal.
    * 2.Each element of A occurs in exactly one of these subset.
    * Magic number = sum of absolute difference of corresponding elements of subset.
    * Note: You can reorder the position of elements within the subset to find the value of the magic number.
    * For Ex:- subset 1 = {1, 5, 1}, subset 2 = {1, 7, 11}
    * Magic number = abs(1 - 1) + abs(5 - 7) + abs(1 - 11) = 12
    * Return an array B of size 2, where B[0] = maximum possible value of Magic number modulo 109 + 7,
    * B[1] = minimum possible value of a Magic number modulo 109 + 7.
    * */
    public static void magicMaxMin(int[] A) {
        Arrays.sort(A);
        int mid = A.length/2;
        int max = findMax(A,mid);
        int min = findMin(A,mid);

        System.out.println("max :"+max);
        System.out.println("min :"+min);
    }

    private static int findMin(int[] a, int mid) {
        int mod = 10;
        int n = a.length, ans = 0;
        for(int i = 0,count=0; i< n; i += 2){
            ans += Math.abs(a[i] - a[i+1]);
            count++;
            if(count == mid) break;
        }

        return ans;
    }

    private static int findMax(int[] a, int mid) {
        int mod = 10;
       int n = a.length;
       int f = 0, s = n-mid,ans = 0;
       while((f+1) <= mid || (s < n)){
           ans += Math.abs(a[f++] - a[s++]);
       }
       return ans;
    }

    /* Question : Maximum Unsorted SubArray
    * Given an array A of non-negative integers of size N.
    *  Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array,
    * then the whole array should get sorted. If A is already sorted, output -1.
    * */
    public static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int n = A.size(), start=-1,end=-1;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isrearrange(A,i)){
                if(start == -1){
                    start = i;
                }
            }else{
                if(start > -1 && end == -1){
                    end = i-1;
                }
            }
        }

        System.out.println("start :"+start+ " :: end :"+end);
        if(start > -1){
            ans.add(start);
            ans.add(end);
        }else{
            ans.add(-1);
        }
        System.out.println("Answer :"+Arrays.deepToString(ans.toArray()));
        return ans;
    }

    private static boolean isrearrange(ArrayList<Integer> A, int i) {
        int start = i+1;
        while(start < A.size()){
            if(A.get(start++) < A.get(i)){
                return true;
            }
        }
        int s = 0;
        while(s < i){
            if(A.get(s++) > A.get(i)){
                return true;
            }
        }
        return false;
    }


}
