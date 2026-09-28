//ElGamal
import java.util.Scanner;

public class ElGamal 
{
    public static long hack(int p, int g, int gxmodp, int c1, int c2) 
    {
        //check everything is parsing correctly
        /* 
        System.out.println("p=" + p);
        System.out.println("g=" + g);
        System.out.println("gxmodp=" + gxmodp);
        System.out.println("c1=" + c1);
        System.out.println("c2=" + c2);
        */

        // brute-force private key x
        // try all possible values until g^x mod p = g^x modp
        int x = -1;

        long value = 1; // g^0 mod p

        for (int i = 1; i < p; i++) {

            value = (value * g) % p; // now value = g^i mod p
            //check if value matches public key
            if (value == gxmodp) 
            {
                x = i;
                break;
            }
        }

        System.out.println("x found = " + x);

        // m = c2 * c1^(p-1-x) mod p
        long m = ((long)c2 * modpow(c1, p - 1 - x, p)) % p;

        return m;
    }
    //computes exponential squares
    public static long modpow(long base, long exp, long mod)
    {
        long result = 1;
        //make base small first 
        base = base % mod;

        //process exp in binary
        while (exp > 0) 
        {
            if ((exp & 1) == 1) 
            {
                result = (result * base) % mod;
            }
            //square base for next bit
            base = (base * base) % mod;
            //move to next bit
            exp >>= 1;
        }
        return result;
    }
    

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Read input line and split by spaces
        System.out.println("Enter the public key to hack: ");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");

        // Parse numbers
        int p = Integer.parseInt(numbers[0]);
        int g = Integer.parseInt(numbers[1]);
        int gxmodp = Integer.parseInt(numbers[2]);
        System.out.println("Now enter the ciphertext: ");
        input = scanner.nextLine();
        numbers = input.split(" ");
        int c1 = Integer.parseInt(numbers[0]);
        int c2 = Integer.parseInt(numbers[1]);

        System.out.println("The message is: "+hack(p,g,gxmodp,c1,c2));
    }
    
}
