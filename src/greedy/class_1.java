package greedy;

import java.util.Arrays;

public class class_1 {
    public static void main(String[] args) {
        candy(new int[]{1,5,2,1,3});
    }

    public static void candy(int[] A) {
        Arrays.sort(A);
        int answer = 1, k = 1;
        for(int i = 1;i<A.length;i++){
            if(A[i] != A[i-1]){
                k++;
                answer += k;
            }else{
                answer += k;
            }
        }
        System.out.println("answer :"+answer);
    }
}
