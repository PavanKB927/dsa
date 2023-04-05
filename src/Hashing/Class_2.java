package Hashing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Class_2 {
    public static void main(String[] args) {

    }

    /* Question:  Replicating Substring
     * Given a string B, find if it is possible to re-order the characters of the string B
    * so that it can be represented as a concatenation of A similar strings.
    * Eg: B = aabb and A = 2, then it is possible to re-arrange the string
    * as "abab" which is a concatenation of 2 similar strings "ab".
    * If it is possible, return 1, else return -1.
    * */
    public static int replacingSubstring(int A, String B) {
        int n = B.length();
        HashMap<Character,Integer> hm = new HashMap<>();
         for(int i=0; i<n;i++){
             if(hm.containsKey(B.charAt(i))){
                 hm.replace(B.charAt(i),hm.get(B.charAt(i)),(hm.get(B.charAt(i)))+1);
             }else{
                 hm.put(B.charAt(i),1);
             }
         }

        Collection<Integer> values = hm.values();
         for(int val: values){
             if(val%A != 0){
                 return -1;
             }
         }

         return 1;
    }
}
