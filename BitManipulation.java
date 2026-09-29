//bit manipulation

import java.util.Arrays;

public class BitManipulation 
{
    /* checking bit manipulation from pen and paper exercise
    outputs 481!
    public static void main(String[] args)
    {
        System.out.println(~6&19^((42|30)<<3));
    }
    */

    public static void main(String args[]) 
    {

        int arr1[] = countBits(2);
        int arr2[] = countBits(5);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static int[] countBits(int n) 
    {

        //need 0 to n inclusive so n+1
        int[] ans = new int[n + 1];

        //fill values from 1 to n
        for (int i = 1; i <= n; i++) 
        {
            // i/2 shifts binary right by one bit (i>>1)
            // i%2 checks if last bit is 1 or 0 (even ends in 0, odd ends in 1)
            ans[i] = ans[i/2] + (i % 2);
        }
        return ans;
    }
}

//test: 2 outputs [0, 1, 1] and 5 outputs [0, 1, 1, 2, 1, 2]
