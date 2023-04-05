package BitManipulation;

public class BitManipulation_1 {
    public static void main(String[] args) {
        //singleNumber(new int[]{1,2,2,3,1,4});
        // numSetBits(11);
        // addBinary("111","11");
        // cntBits(new int[]{1,3,5});
        // solveInterestingArray(new int[]{9,17});
        divide(214783648,-1);

    }

    /* Question : Single Number
    * Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
    * NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
    * */
    public static void singleNumber(final int[] A) {
        int ans = 0;
        for(int i =0;i<A.length;i++){
            ans = ans ^ A[i];
        }
        System.out.println("ans :"+ans);

    }

    /* Question : Number of 1 Bits
     * Write a function that takes an integer and returns the number of 1 bits it has.
     */
    public static void numSetBits(int A) {
        int count = 0;
        /*for(int i = 0;i<=30;i++){
            if(checkBit(A,i)){
                count++;
            }
        }*/
        while(A > 0){
            A = A & (A-1);
            count++;
        }
        System.out.println("count :"+count);

    }
    private static boolean checkBit(int a, int i) {
        if(((a>>i)&1)==1){
            return true;
        }
        return false;
    }

    /* Question : Add Binary Strings
    * Given two binary strings, return their sum (also a binary string).
    * */
    public static void addBinary(String A, String B) {
        int n = Math.max(A.length(),B.length());
        int i = 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i <= n){
            int a = (A.length()-i >= 0)? Integer.parseInt(String.valueOf(A.charAt(A.length()-i))): 0;
            int b = (B.length()-i >=0) ? Integer.parseInt(String.valueOf(B.charAt(B.length()-i))): 0;
            int sum = (a+b+carry)%2;
            carry = (a+b+carry)/2;
            System.out.println("a:"+a+" :: b:"+b+" :: sum :"+sum+" :: carry :"+carry);
            sb = new StringBuilder(sum + sb.toString());
            i++;
        }
        if(carry ==1){
            sb = new StringBuilder(carry + (sb.toString()));
        }
        System.out.println("answer :"+sb);
    }

    /* Question :
    * We define f(X, Y) as the number of different corresponding bits in the binary representation of X and Y.
    * For example, f(2, 7) = 2, since the binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.
    * You are given an array of N positive integers, A1, A2,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.
    * */
    public static void cntBits(int[] A) {
        int mod = 1000000007;
        int n = A.length;
        long count = 0;
        /*for(int i =0; i<n; i++){
            for(int j = i; j<n; j++){
                int xor = A[i] ^ A[j];
                System.out.println("xor :"+xor);
                int cnt = countSumBits(xor);
                count += 2*cnt;
            }
        }*/
        for(int i =0; i< 32; i++){
            int cnt = 0;
            for(int j = 0; j<n; j++){
                if((A[j] & (1 << i)) != 0){
                    cnt++;
                }
            }
            count += (cnt * (n-cnt))*2;
        }
        count = count%mod;
        count = (int) count % mod;
        System.out.println("count : "+count);
        return;

    }

    private static int countSumBits(int xor) {
        int cnt = 0;
        while(xor > 0){
            xor = xor & (xor-1);
            cnt += 1;
        }
        return cnt;
    }

    /* Question: Interesting Array
     * You have an array A with N elements. We have two types of operation available on this array :
    * We can split an element B into two elements, C and D, such that B = C + D.
    * We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
    * You have to determine whether it is possible to convert array A to size 1, containing a single element equal to 0 after several splits and/or merge?
    * */
    public static void solveInterestingArray(int[] A) {
        String ans = "";
        int n = A.length;
        int xor = 0;
        for(int i =0; i<n; i++){
            xor = xor ^ A[i];
        }

        System.out.println("val :"+xor);
        if(xor%2 == 0){
            ans = "YES";
        }else{
            ans = "NO";
        }
        System.out.println("answer :"+ans);
    }

    /* Question :
    * Divide two integers without using multiplication, division and mod operator.
    * Return the floor of the result of the division.
    * Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.
    * NOTE: INT_MAX = 2^31 - 1
    * */
    public static void divide(int A, int B) {
        System.out.println("A :"+A+" :: B:"+B);
        int res = 0;
        if(A == 1 << 31 && B == -1){
            System.out.println("Answer :"+((1 << 31)-1));
            return;
        }
        int signA = A > 0 ? 0:1;
        int signB = B > 0 ? 0:1;
        A = A > 0 ? A : -A;
        B = B > 0 ? B: -B;

        while(A - B >= 0){
            int x = 0;
            while(A - (B << 1 << x) >= 0){
                x++;
            }
            res += 1<<x;
            A = A - (B << x);
            System.out.println("ch A:"+A);
            System.out.println("res :"+res);
        }
        if(signA == signB){
            System.out.println("result :"+res);
            return;
        }else{
            System.out.println("result :"+(-res));
            return;
        }



    }
}
