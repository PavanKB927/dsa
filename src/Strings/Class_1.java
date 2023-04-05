package Strings;

public class Class_1 {
    public static void main(String[] args) {
        System.out.println("period :"+periodOfString("ababab"));

    }

    /* Question : Period of a String
    * You are given a string A of length N consisting of lowercase alphabets.
    *  Find the period of the string.
    * Period of the string is the minimum value of k (k >= 1),
    * that satisfies A[i] = A[i % k] for all valid i.
    * */
    public static int periodOfString(String A) {
        char[] Ar=A.toCharArray();
        int k=1;
        int i=1;
        while(i<Ar.length){
            if(Ar[i]==Ar[i%k]){
                i++;
            }else if(k!=i){
                k=i;
            }else{
                i++;
                k=i;
            }
        }
        return k;
    }

    /* Question : Cyclic Permuatations
    * Given two binary strings A and B, count how many cyclic shift of B when taken XOR with A give 0.
    * NOTE: If there is a string, S0, S1, ... Sn-1 , then it is a cyclic shift is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1
    * where k can be any integer from 0 to N-1.
    * */
//    public static int cyclicPermutations(String A, String B) {
//
//    }
}
