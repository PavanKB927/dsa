package Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Class_1 {
    public static void main(String[] args) {
        System.out.println("perfect numbers :"+perfectNumbers(4));
    }

    /* Question: Perfect Numbers
    * Given an integer A, you have to find the Ath Perfect Number.
    * A Perfect Number has the following properties:
    * It comprises only 1 and 2.The number of digits in a Perfect number is even.
    * It is a palindrome number.
    * For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
    * */
    public static String perfectNumbers(int A) {
        ArrayList<String> queue = new ArrayList<>();
        if(A ==1) return "11";
        if(A == 2) return "22";
        queue.add("11");
        queue.add("22");
        int i = 0;
        while(queue.size() < A){
            String s = queue.get(i);
            int len = s.length();
            String l = s.substring(0,len/2);
            String r = s.substring(len/2);

            queue.add(l+"11"+r);
            queue.add(l+"22"+r);
            i++;
        }

        return queue.get(A-1);

    }

}
