package Hashing;

import java.util.*;

public class Class_1 {
    public static void main(String[] args) {
        //System.out.println("Largest Consecutive Sequence :"+longestConsecutive(new int[]{100,4,200,1,2,3}));
        //System.out.println("Shaggy And Distances :"+shaggyAndDistances(new int[]{1,1}));
        //System.out.println("SubArray Sum exists Zero :"+subArraySum(new int[]{1,-1}));
        //System.out.println("ls zero :"+ Arrays.toString(lszero(new int[]{-19, 2, 1, 38, 2, -8, 19, 5, -2, -23 })));
        //System.out.println("dNums :: "+Arrays.toString(dNums(new int[]{1, 2, 1, 3, 4, 3},3)));
        //System.out.println("Sort in Order : "+Arrays.toString(sortInOrder(new int[]{10, 2, 18, 16, 16, 16 },new int[]{3, 13, 2, 16, 4, 19})));
        //System.out.println("Colorful Number :"+colorful(12));
        System.out.println("Check Palindrome :"+checkPalindrome("abcde"));

    }

    /* Question : Largest Consecutive Sequence
    * Given an unsorted integer array A of size N.
    * Find the length of the longest set of consecutive elements from array A.
    * */
    public static int longestConsecutive(final int[] A) {
        HashSet<Integer> hashSet = new HashSet<>();
        int ans = 0;
        for(int i = 0; i<A.length;i++){
            hashSet.add(A[i]);
        }

        for(int i = 0;i<A.length;i++){
            if(!hashSet.contains(A[i]-1)){
                int j = A[i];
                while(hashSet.contains(j)){
                    j++;
                }

                if(ans < (j - A[i])){
                    ans = j-A[i];
                }
            }
        }

        return ans;
    }

    /* Question: Shaggy and Distances
    * Shaggy has an array A consisting of N elements.
    *  We call a pair of distinct indices in that array a special if elements at those indices in the array are equal.
    * Shaggy wants you to find a special pair such that the distance between that pair is minimum.
    *  Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1.
    * */
    public static int shaggyAndDistances(int[] A) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i< A.length;i++){
            if(!hashMap.containsKey(A[i])){
                hashMap.put(A[i],i);
            }
        }

        for(int i = 0; i< A.length; i++){
            if(hashMap.containsKey(A[i]) && hashMap.get(A[i]) != i){
                int dist = Math.abs(hashMap.get(A[i]) - i);
                ans = Math.min(ans,dist);
            }
        }

        if(ans != Integer.MAX_VALUE){
            return ans;
        }else{
            return -1;
        }

    }

    /* Question : Subarray with Sum 0
    * Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
    * If the given array contains a sub-array with sum zero return 1, else return 0
    * */
    public static int subArraySum(int[] A) {
        System.out.println("A :"+Arrays.toString(A));
        HashSet<Long> hashSet = new HashSet<>();
        long sum = 0;
        for(int i=0;i<A.length;i++){
           sum += A[i];
           if(A[i] == 0 || sum == 0 || hashSet.contains(sum)){
               return 1;
           }
           hashSet.add(sum);
        }

        return 0;
    }

    /* Question : Largest Continuous sequence zero sum
    * Given an array A of N integers.
    * Find the largest continuous sequence in a array which sums to zero.
    * */
    public static int[] lszero(int[] A) {
        System.out.println("in A :"+Arrays.toString(A));
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int n = A.length, maxDist = 0,l=-1,r=-1,sum=0;
        for(int i=0;i<n;i++){
            sum += A[i];
            System.out.println("sum :"+sum +" ::: maxDist :"+maxDist);
            System.out.println("hashMap :"+Arrays.deepToString(hashMap.entrySet().toArray()));
            if(A[i] == 0 && maxDist < 1){
                l=i;
                r=i;
                maxDist = 1;
            }
            if(sum == 0 && maxDist < (i+1)){
                l = 0;
                r = i;
                maxDist = i+1;
            }
            if(hashMap.containsKey(sum) && maxDist < Math.abs(hashMap.get(sum)-i)){
                l = hashMap.get(sum)+1;
                r = i;
                maxDist = Math.abs(hashMap.get(sum) - i);
            }
            if(!hashMap.containsKey(sum)) {
                hashMap.put(sum, i);
            }
        }
        System.out.println("start idx :"+l+" :: end idx :"+r+" :: max Dist :"+maxDist );
        int len = Math.abs(r-l);
        int[] ans = new int[len+1];
        if(l == 1) return new int[]{};
        for(int i = l,j=0;i<=r;i++,j++){
            ans[j] = A[i];
        }
        return ans;
    }

    /* Question: Distinct Numbers in the Window
    * You are given an array of N integers, A1, A2 ,..., AN and an integer B.
    *  Return the of count of distinct numbers in all windows of size B.
    * Formally, return an array of size N-B+1 where i'th element in this array contains
    *  number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
    * NOTE: if B > N, return an empty array.
    * */
    public static int[] dNums(int[] A, int B) {
        System.out.println("in A :"+Arrays.toString(A));
        int n = A.length;
        if(B > n){
            return new int[]{};
        }
        int len = (n-B)+1;
        int[] ans = new int[len];
       HashMap<Integer,Integer> hashMap = new HashMap<>();
       for(int i=0;i<B;i++){
           if(hashMap.containsKey(A[i])){
               hashMap.merge(A[i],1,Integer::sum);
           }else{
               hashMap.put(A[i],1);
           }
       }
       ans[0] = hashMap.size();
       System.out.println("hashMap starting :: "+Arrays.toString(hashMap.entrySet().toArray()));
       int start = 1,j=1;
       int end = B;
       while(end < n){
           if(A[start-1] != A[end]){
               if(hashMap.get(A[start-1]) >1){
                   hashMap.replace(A[start-1],hashMap.get(A[start-1]),(hashMap.get(A[start-1])-1));
               }else{
                   hashMap.remove(A[start-1]);
               }
               if(hashMap.containsKey(A[end])){
                   hashMap.replace(A[end],hashMap.get(A[end]),(hashMap.get(A[end])+1));
               }else{
                   hashMap.put(A[end],1);
               }
           }
           System.out.println("hashMap ---- :: "+Arrays.toString(hashMap.entrySet().toArray()));
           ans[j] = hashMap.size();
           start++;
           end++;
           j++;
       }
        System.out.println("answer :: "+Arrays.toString(ans));
       return ans;
    }

    /* Question: Sort Array in given order
    * Given two arrays of integers A and B, Sort A in such a way that the relative order
    *  among the elements will be the same as those are in B.
    * For the elements not present in B, append them at last in sorted order.
    * Return the array A after sorting from the above method
    * NOTE: Elements of B are unique.
    * */
    public static int[] sortInOrder(int[] A, int[] B) {
        Arrays.sort(A);
        HashMap<Integer,Integer> hmA = new HashMap<>();
        HashSet<Integer> hsB = new HashSet<>();
        int[] ans = new int[A.length];
        int k = 0;
        for(int i= 0;i<B.length;i++){
            hsB.add(B[i]);
        }
        for(int i=0;i<A.length;i++){
           if(hmA.containsKey(A[i])){
               hmA.replace(A[i],hmA.get(A[i]),(hmA.get(A[i]))+1);
           }else{
               hmA.put(A[i],1);
           }
        }
        for(int i=0;i<B.length;i++){
            if(hmA.containsKey(B[i])){
                int val = hmA.get(B[i]);
                while(val > 0) {
                    ans[k] = B[i];
                    k++;
                    val--;
                }
            }
        }

        for(int i=0;i<A.length;i++){
            if(!hsB.contains(A[i])){
                ans[k] = A[i];
                k++;
            }
        }

        return ans;
    }

    /* Question: Colourful Number
    * Given a number A, find if it is COLORFUL number or not.
    * If number A is a COLORFUL number return 1 else, return 0.
    * What is a COLORFUL Number:
    * A number can be broken into different contiguous sub-subsequence parts.
    * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
    * And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.
    * */
    public static int colorful(int A) {
        String s = String.valueOf(A);
        HashMap<Integer,Integer> proCount = new HashMap<>();
        int val = getProduct(A);
        proCount.put(val,1);
        for(int i=0;i<s.length();i++){
            for(int j=i; j<s.length();j++){
                int k = Integer.parseInt(s.substring(i,j+1));
                if(k != A){
                    int p = getProduct(k);
                    System.out.println("product :"+p+" ::: passed val :"+k);
                    if(proCount.containsKey(p)){
                        return 0;
                    }else{
                        proCount.put(p,1);
                    }
                }
            }
        }
        return 1;
    }

    private static int getProduct(int k) {
        int product  = 1;
        while(k > 0){
            product *= k%10;
            k /= 10;
        }
        return product;
    }

    /* Question : Check Palindrome - II
    * Given a string A consisting of lowercase characters.
    * Check if characters of the given string can be rearranged to form a palindrome.
    * Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
    * */
    public static int checkPalindrome(String A) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int n = A.length();
        for(int i =0;i<A.length();i++){
            if(hm.containsKey(A.charAt(i))){
                hm.replace(A.charAt(i),hm.get(A.charAt(i)), (hm.get(A.charAt(i)))+1);
            }else{
                hm.put(A.charAt(i),1);
            }
        }
        Collection<Integer> values = hm.values();
        if(n%2 == 0){
           for (int val: values){
               if(val %2 != 0){
                   return 0;
               }
           }
           return 1;
        }else{
            int count = 0;
            for(int val : values){
                if(val%2 != 0){
                    count++;
                }
                if(count > 1){
                    return 0;
                }
            }
            return 1;
        }
    }
}
