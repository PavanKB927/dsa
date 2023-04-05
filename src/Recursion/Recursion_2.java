package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Recursion_2 {
    static int pointer = 0;
    public static void main(String[] args) {
        //findToHSteps(2);
        System.out.println("Gray Code :\n"+Arrays.deepToString(grayCode(2).toArray()));

    }

    // Question : Tower of Hanoi
    public static void findToHSteps(int A){
        int val = 0;
        int len = 0;
        while (val < A){
            len = (len*2) + 1;
            val++;
        }
        System.out.println("len :"+len);
        int[][] answer = new int[len][3];
        toh(A,1,2,3,answer);
        System.out.println(" Answer :: \n"+ Arrays.deepToString(answer));

    }

    public static void toh(int n, int s, int t, int d,int[][] ans){

        if(n == 0){
            return;
        }
        toh(n-1,s,d,t,ans);
        System.out.println("n :"+n+" :: s:"+s+" :: d:"+d);
        ans[pointer][0] = n;
        ans[pointer][1] = s;
        ans[pointer][2] = d;
        pointer++;
        toh(n-1,t,s,d,ans);
    }

    /* Question : Gray Code
    * The gray code is a binary numeral system where two successive values differ in only one bit.
    * Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.
    * A gray code sequence must begin with 0.
    * */
    public static ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (a == 0) return null;
        if (a == 1) {
            ans.add(0);
            ans.add(1);
            return ans;
        }
        ArrayList<Integer> codes = grayCode(a - 1);
        System.out.println("codes from 0 :\n"+Arrays.deepToString(codes.toArray()));
        System.out.println("a : "+a);
        int x = codes.size();
        for (int i = 0; i < x; i++)
            ans.add(codes.get(i));
        for (int i = x - 1; i >= 0; i--)
            ans.add(codes.get(i) + (1 << (a - 1)));

        return ans;
    }
}
