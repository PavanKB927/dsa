package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting_2 {
    static int mod = 1000000007;
    public static void main(String[] args) {

        List<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 2, 3, 1));
       // System.out.println("largest number :"+largestNumber(A));

        // System.out.println("Inverse Count of an array :"+inverseCount(new int[]{45, 10, 15, 25, 50}));

        //System.out.println("Unique Elements :"+uniqueElements(new int[]{1,2,1,2,3}));
        System.out.println("Reverse Pairs :"+reversePairs(A));

    }

    /* Question :  Largest Number
    * Given an array A of non-negative integers, arrange them such that they form the largest number.
    * Note: The result may be very large, so you need to return a string instead of an integer.
    * */
    public static String largestNumber(final List<Integer> A) {

        List<Integer> temp = new ArrayList<>(A);
        temp.sort((Comparator<? super Integer>) new intComp());
        System.out.println("givan input :"+Arrays.deepToString(A.toArray()));
        System.out.println("sorted array :"+ Arrays.deepToString(temp.toArray()));
        String ans = "";
        for(int i:temp){
            ans += i;
        }
        if(ans.charAt(0) == '0'){
            return "0";
        }
        return ans;
    }
    static class intComp implements Comparator<Integer>{
        @Override //your comparator implementation.
        public int compare(Integer a, Integer b) {
            String o1 = String.valueOf(a);
            String o2 = String.valueOf(b);
            return (o2+o1).compareTo(o1+o2);
        }

    }

    /* Question : Inversion Count in the array
    * Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A.
    *  Find the total number of inversions of A modulo (109 + 7).
    * */
    public static int inverseCount(int[] A) {
        return mergeSortAndCount(A,0,A.length-1);
    }

    public static int mergeSortAndCount(int[] A,int l, int r){
        int count = 0;

        if(l < r){
            int m = (l + r) / 2;
            count += mergeSortAndCount(A,l,m) % mod;
            count += mergeSortAndCount(A,m+1,r) % mod;
            count += mergeCount(A,l,m,r) % mod;
        }

        return count%mod;
    }

    public static int mergeCount(int[] A, int l, int m, int r){

        int[] left = Arrays.copyOfRange(A, l ,m+1);
        int[] right = Arrays.copyOfRange(A,m+1,r+1);

        int i=0,j=0,k=l,swaps =0;

        while(i < left.length && j < right.length ){
            if(left[i] <= right[j]){
                A[k++] = left[i++];
            }else {
                A[k++] = right[j++];
                swaps += ((m+1) - (l+i)) % mod;
            }
        }

        while(i < left.length){
            A[k++] = left[i++];
        }

        while(j < right.length){
            A[k++] = right[j++];
        }

        return swaps % mod;
    }

    /* Question : Unique Elements
    * You are given an array A of N elements. You have to make all elements unique.
    * To do so, in one step you can increase any number by one.
    * Find the minimum number of steps.
    * */
    public static int uniqueElements(int[] A) {
        // sort and compare
        if(A.length ==1 ){
            return 0;
        }
        Arrays.sort(A);
        int count = 0;

        System.out.println("sorted array :"+ Arrays.toString(A));
        for(int i = 1; i<A.length;i++) {
            if (A[i] <= A[i - 1]) {
                int difference = A[i - 1] + 1 - A[i];
                A[i] = A[i] + difference;
                count += difference;
            }
        }

        return count;
    }

    /* Question : Reverse Pairs
    * Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
    * Return the number of important reverse pairs in the given array A.
    * */
    public static int reversePairs(List<Integer> A) {
        return reversePairs(A,0,A.size()-1);
    }

    public static int reversePairs(List<Integer> A,int start,int end){
        //Base Case
        if(start == end) return 0;
        int mid = (start+end)>>1;
        int leftReversePairs  = reversePairs(A,start,mid);
        int rightReversePairs = reversePairs(A,mid+1,end);
        int mergeReversePairs = merge(A,start,mid,end);
        return leftReversePairs + rightReversePairs + mergeReversePairs;
    }

    public static int merge(List<Integer>A,int start,int mid,int end){
        ArrayList<Integer>helper = new ArrayList<>(); //helper array for merging
        int p1 = start,p2 = mid+1;
        int ans = 0;
        while(p1<=mid && p2 <= end){
            if((long)A.get(p1) > 2 * (long) A.get(p2)){
                ans += mid-p1+1;
                p2++;
            }else{
                p1++;
            }
        }
        p1 = start;p2=mid+1;
        while(p1<=mid && p2<=end){
          if(A.get(p1)<=A.get(p2))
              helper.add(A.get(p1++));
          else
              helper.add(A.get(p2++));
        }
        while(p1<=mid)
            helper.add(A.get(p1++));
        while(p2<=mid)
            helper.add(A.get(p2++));
        for(int i = 0 ; i < helper.size() ;++i)
            A.set(start+i,helper.get(i));
        return ans;
    }
}
