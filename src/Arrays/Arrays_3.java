package Arrays;

public class Arrays_3 {
    public static void main(String[] args) {
        // firstMissingPositive(new int[]{1,6,4,5,2,3});
       // trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        minimumJumps(new int[]{1, 5, 5, 8, 2, 2, 9, 6, 3, 4, 5, 8, 6, 4, 2, 6, 6, 5, 8, 7, 4 });

    }

    /* Question: First missing smallest integer
    * Given an unsorted integer array, A of size N. Find the first missing positive integer.
    * Note: Your algorithm should run in O(n) time and use constant space.
    * */
    public static void firstMissingPositive(int[] A) {
        int n = A.length;
        for (int i=0;i<n;i++){
            if(A[i] <= 0){
                A[i] = n+1;
            }
        }
        for(int i = 0; i<n; i++){
            int val = A[i] > 0? A[i]:-A[i];
            if(val-1 < n){
                A[val-1] = A[val-1] >0?-A[val-1]:A[val-1];
            }
        }
        for(int i=0;i<n;i++){
            if(A[i] > 0){
                System.out.println("missing int :"+(i+1));
                return;
            }
        }
        System.out.println("missing :"+(n+1));
    }

    /* Question: Rain Water trapped
    * Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1,
    *  compute how much water it is able to trap after raining.
    * */
    public static void trap(final int[] A) {
        /*
        * we need two points for every index that one left and one right
        * the min of left and right max is the trap water
        * 6 2 4 1 6 0 1 5
        * */
        int n = A.length;
        if(n < 3){
            return;
        }
        int maxLeft = A[0], maxRight = A[n-1], trappedWater = 0;
        int left = 1, right = n-2;
        while(left <= right){
            if(maxLeft < maxRight) {
                if (A[left] >= maxLeft) {
                    maxLeft = A[left];
                } else {
                    trappedWater += maxLeft - A[left];
                }
                left++;
            }else {
                if (A[right] >= maxRight) {
                    maxRight = A[right];
                } else {
                    trappedWater += maxRight - A[right];
                }
                right--;
            }
            System.out.println("trap :"+trappedWater);
        }
        System.out.println("trapped water :"+trappedWater);
    }

    /* Question: Minimum Number of Jumps
    * Given an array of non-negative integers A where each element represents your maximum jump length at that position.
    * The initial position is the first index of the array, and the goal is to reach the last index of the array with the minimum number of jumps.
    * Note: If it is not possible to reach the last index, return -1 instead.
    * */
    public static void minimumJumps(int[] A) {

        // 1,3,2,3,0,0,0
        int n = A.length;
        if(n==1){
            return;
        }
        for(int i=0; i<n; i++){
            int val = A[i];
            System.out.println("val :"+val);
            int k=1;
            while(val > 0){
                if(A[i+k] >= (n-1) - (i+k)){
                    System.out.println("jumps :"+(i+2));
                    return;
                }
                k++;
                val--;
            }
        }
        System.out.println("jump :"+(-1));

    }

}
