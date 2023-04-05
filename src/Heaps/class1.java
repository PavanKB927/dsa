package Heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class class1 {
    public static void main(String[] args) {
        // nchoc(5,new int[]{2,4,6,8,10});
       // minCostRopes(new int[]{1,2,3,4,5});
        // productOfThree(new int[]{10,2,13,4});
        minimumNagations(new int[]{24, -68, -29, -9, 84},4);

    }

    //max chocolates one child can eat
    public static void nchoc(int A, int[] B) {
        int mod = 1000000000+7;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int maxChoc = 0;
        for (int i=0; i<B.length;i++){
            pq.add(B[i]);
        }
        System.out.println(" pq :"+Arrays.toString(pq.toArray()));
        while(A > 0){
            A--;
            maxChoc = (maxChoc%mod + pq.peek()%mod)%mod;
            int val = pq.poll();
            pq.add((int) Math.floor(val/2));
        }
        System.out.println("remaining pq :"+Arrays.toString(pq.toArray()));
        System.out.println("max choc : "+maxChoc%mod);
    }

    //min cost for joining ropes
    public static void minCostRopes(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int minCost = 0;
        for(int i=0;i<A.length;i++){
            pq.add(A[i]);
        }
        while(pq.size() > 1){
            int val1 = pq.poll();
            int val2 = pq.poll();
            int cost = val1+val2;
            pq.add(cost);
            minCost += cost;
        }
        System.out.println("pq :"+Arrays.toString(pq.toArray()));
        System.out.println("min cost : "+minCost);
    }

    //Product of 3
    // A = [1, 2, 3, 4, 5]
    public static void productOfThree(int[] A) {
        int[] B = new int[A.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int maxSum = 1;
        for(int i = 0; i<A.length;i++){
            if(i <= 2){
                pq.add(A[i]);
                maxSum *= A[i];
                if(i < 2) B[i] = -1;
                else{
                    B[i] = maxSum;
                    maxSum = 1;
                }
            } else{
                PriorityQueue<Integer> tempPq = new PriorityQueue<>(Collections.reverseOrder());
                int j = 0;
                while(j < 2){
                    int val = pq.poll();
                    maxSum *= val;
                    tempPq.add(val);
                    j++;
                }
                int val = pq.poll();
                if(A[i] > val){
                    maxSum *= A[i];
                    B[i] = maxSum;
                    tempPq.add(A[i]);
                }else{
                    maxSum *= val;
                    B[i] = maxSum;
                    tempPq.add(val);
                }
                maxSum = 1;
                pq = tempPq;
            }

        }
        System.out.println("array B :"+Arrays.toString(B));
        System.out.println("current pq :"+Arrays.toString(pq.toArray()));

    }

    // Minimum array sum after B negations
    //A = [24, -68, -29, -9, 84]
    // B = 4
    public static void minimumNagations(int[] A, int B) {
        int maxSum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<A.length;i++){
            pq.add(A[i]);
        }
        while(!pq.isEmpty()){
            int val = pq.poll();
            if(B > 0 && val < 0){
                maxSum += Math.abs(val);
                B--;
            }else{
                maxSum += val;
            }
        }
        System.out.println("max sum :"+maxSum);
    }
}
