package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class Class_2 {
    public static void main(String[] args) {
        prevSmaller(new int[]{1,2,3});
    }

    /* Question : Nearest Smallest Element
    * Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
    * More formally,G[i] for an element A[i] = an element A[j] such that
    * j is maximum possible AND j < i AND A[j] < A[i]
    * Elements for which no smaller element exist, consider the next smaller element as -1.
    * */
    public static int[] prevSmaller(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n;i++){
            while(stk.size() > 0){
                if(stk.peek() < A[i]){
                    ans[i] = stk.peek();
                    stk.push(A[i]);
                    break;
                }else{
                    stk.pop();
                }
            }
            if(stk.size() == 0){
                ans[i] = -1;
                stk.push(A[i]);
            }
        }
        System.out.println("answer : "+ Arrays.toString(ans));
        return ans;
    }
}
