package ModularArthematic;

public class Modular_Class_1 {
    public static void main(String[] args) {
        // abModulo(5,10);
        // primeModuloInverse(7,2);
        System.out.println("Very Large Number :"+veryLargePower(3,3));

    }

    /* Question: A, B and Modulo
     * Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.
    * */
    public static void abModulo(int A, int B) {
        System.out.println("Answer :"+(Math.abs(A-B)));
    }

    /* Question : Prime Modulo Inverse
     * Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.
    * A-1 mod B is also known as modular multiplicative inverse of A under modulo B.
    * */
    public static void primeModuloInverse(int A, int B) {
        //A = 19, B = 7
        if(B == 1){
            System.out.println("Answer : "+0);
            return;
        }
        for(int x = 1; x<B; x++){
            if((A*x)%B ==1 ){
                System.out.println("Answer :"+x);
                return;
            }
        }

    }

    /* Question : very large power
    * Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
    * "^" means power,"%" means "mod", and"!" means factorial.
    * */
    public static int veryLargePower(int A, int B) {
        long mod = (long)(1e9 + 7);
        System.out.println("mod ::: "+(mod-1));
        long factB = fact(B,  (mod-1));
        System.out.println("fact B :"+factB);
        long powA = pow(A,factB,mod) % mod;
        System.out.println("pow A :"+powA);
        return (int) powA;
    }

    private static long pow(long a, long b, long mod) {
        if( b == 0) return 1;
        if( b == 1) return a%mod;

        long half = pow(a,b/2,mod) % mod;
        if(b%2 == 0){
            long x = (half * half) % mod;
            return x % mod;
        }else {
            long y = (half * half) % mod;
            y = (y * a%mod) % mod;
            return y % mod;
        }

    }

    private static long fact(int b, long mod) {
        if(b == 0) return 1;
        return ((b%mod) * fact(b-1,mod)%mod) % mod;
    }


}
