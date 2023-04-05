package TwoPointers;

import java.util.Arrays;

public class Class_1 {
    public static void main(String[] args) {
        //subArraySum(new int[]{ 42, 9, 38, 36, 48, 33, 36, 50, 38, 8, 13, 37, 33, 38, 17, 25, 50, 50, 41, 29, 34, 18, 16, 6, 49, 16, 21, 29, 41, 7, 37, 14, 5, 30, 35, 26, 38, 35, 9, 36, 34, 39, 9, 4, 41, 40, 3, 50, 27, 17, 14, 5, 31, 42, 5, 39, 38, 38, 47, 24, 41, 5, 50, 9, 29, 14, 19, 27, 6, 23, 17, 1, 22, 38, 35, 6, 35, 41, 34, 21, 30, 45, 48, 45, 37  },100);

        //System.out.println("max volume :"+maxArea(new int[]{1, 5, 4, 3}));
        pairsOfSum(new int[]{ 2, 2, 3, 4, 4, 5, 6, 7, 10},8);
    }

    /* Question : SubArray with Given Sum
    * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
    * If the answer does not exist return an array with a single element "-1".
    * First sub-array means the sub-array for which starting index in minimum.
    * */
    public static void subArraySum(int[] A, int B) {
        int n = A.length;
        if(n ==1 && A[0] == B){
            System.out.println("Ans :"+ Arrays.toString(A));
        }

        int p1=0;
        int p2=1;
        int sum = (A[p1]+A[p2]);
        int[] ans;
        while(p2 < n){
            if(sum == B){
                ans = getAnswer(A,p1,p2);
                System.out.println("Ans :"+Arrays.toString(ans));
                break;
            }else if(sum < B){
                p2++;
                if(p2 < n)  sum += A[p2];
            }else{
                sum -= A[p1];
                p1++;
            }
        }

        ans = new int[1];
        ans[0] = -1;
        System.out.println("Ans :: "+ Arrays.toString(ans));
    }

    private static int[] getAnswer(int[] A, int p1, int p2) {
        int l = p2-p1;
        int[] ans = new int[l+1];
        for(int i=p1,j=0;i<=p2;i++,j++){
            ans[j] = A[i];
        }
        return ans;
    }

    /* Question : Container with most water
    * Given n non-negative integers A[0], A[1], ..., A[n-1] , where each represents a point at coordinate (i, A[i]).
    * N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
    * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
    * Note: You may not slant the container.
    * */
    public static int maxArea(int[] A) {
        int n = A.length;
        int p1=0,p2 = n-1, maxVolume = 0;
        while(p1 < p2){
            int vol = Math.min(A[p1],A[p2]) * (Math.abs(p2-p1));
            System.out.println("volume :"+vol);
            maxVolume = Math.max(maxVolume,vol);
            if(A[p2] < A[p1]){
                p2--;
            }else{
                p1++;
            }
        }
        return maxVolume;
    }


    /* Question : Pairs with given sum
    * Given a sorted array of integers (not necessarily distinct) A and an integer B,
    * find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
    * Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
    * */
    public static int pairsOfSum(int[] A, int B) {
        System.out.println("A :"+Arrays.toString(A));
        int p1 = 0, p2 = A.length-1;
        long count = 0, mod = (long) 1e9+7;
        while(p1 < p2){
            long val = (A[p1]+A[p2]) % mod;
            if(val == B){
                long count_p1 = countDuplicates(A,p1,p2);
                long count_p2 = countDuplicatesReverse(A,p2,p1);
                System.out.println("p1 cnt :"+count_p1);
                System.out.println("p2 cnt :"+count_p2);
                count += (count_p1 % mod * count_p2 % mod) % mod;
                System.out.println("count :"+count);
                p1 += count_p1;
                p2 -= count_p2;
            }else if(val > B){
                p2--;
            }else{
                p1++;
            }
        }
        count = count % mod;

        return (int) count;

    }

    public static long countDuplicates(int[] A, int pointer1, int pointer2){
        System.out.println("pointer1 :"+pointer1 +" :: pointer2 :"+pointer2);
        long ans = 1;
        for(int i = pointer1+1; i< pointer2; i++){
            if(A[pointer1] == A[i]){
                ans++;
            }else{
                break;
            }
        }
        return ans;
    }
    public static long countDuplicatesReverse(int[] A, int pointer2, int pointer1){
        System.out.println("pointer2 :"+pointer2+" :: pointer1 :"+pointer1);
        long ans = 1;
        for(int i = pointer2-1; i> pointer1; i--){
            if(A[pointer2] == A[i]){
                ans++;
            }else{
                break;
            }
        }
        return ans;
    }
}
