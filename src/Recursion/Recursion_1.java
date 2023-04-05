package Recursion;

public class Recursion_1 {
    public static void main(String[] args) {
        // System.out.println("Natural numbers Sum : "+naturalSum(5));
        // System.out.println("Factorial of a Number :"+fact(5));
        // System.out.println("Fibonacci of a number :"+fib(5));
        // System.out.println("Power : "+power(2,5,1000000007));
        // System.out.println(sumOfDigits(11));
        // System.out.println(isMagicNumber(83557));
        System.out.println(solveAnotherSequence(20));
    }

    //Question : Sum of n Natural numbers
    public static int naturalSum(int n){
        if(n == 1){
            return 1;
        }
        return naturalSum(n-1) + n;
    }

    // Question: Factorial of a number
    public static int fact(int n){
        if(n == 0){
            return 1;
        }
        return n*fact(n-1);
    }

    //Question: Fibonocaii
    public static int fib(int n){
        if(n == 0){
            return 0;
        }
        if(n ==1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    // Question : Power of A^B % P
    public static int power(int A,int B,int C){
        if(A == 0) return 0;
        if(B == 0) return 1;

        long half = power(A,B/2,C)%C;

        if(B%2 == 0){
            return (int)((half* half)% C + C)% C;
        }else {
            return (int)((((half*half)%C)*(A%C))%C+C)%C;
        }
    }

    // Question : Sum Of Digits
    public static int sumOfDigits(int A){
        if(A == 0){
            return A;
        }
        return (A%10) + sumOfDigits(A/10);
    }

    /* Question : Is Magic
    * Given a number A, check if it is a magic number or not.
    * A number is said to be a magic number if the sum of its digits is calculated till a single digit
    * recursively by adding the sum of the digits after every addition. If the single digit comes out to be 1,
    *  then the number is a magic number.
    * */
    public static int isMagicNumber(int A) {
        if(A ==1 ){
            return 1;
        }
        if(A <= 9){
            return 0;
        }
        int val = A;
        int tempA = 0;
        while(val > 0){
            tempA += val%10;
            val /= 10;
        }
        return isMagicNumber(tempA);
    }

    /* Question: Another sequence problem
    * Given a sequence f(A) = f(A-1) + f(A-2) + f(A-3) + A . Calculate the Ath term of the sequence.
    * Given f(0)=1; f(1)=1; f(2)=2;
    * */
    public static int solveAnotherSequence(int A) {
        if(A == 0 || A == 1){
            return 1;
        }
        if(A == 2 ){
            return A;
        }
        int a = solveAnotherSequence(A-1);
        int b = solveAnotherSequence(A-2);
        int c = solveAnotherSequence(A-3);

        return a + b + c + A;
    }
}
