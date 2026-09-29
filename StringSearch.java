//string search using Knuth-Morris-Pratt (KMP)
import java.util.*;

public class StringSearch 
{

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = in.nextLine();

        System.out.print("Enter pattern: ");
        String pattern = in.nextLine();

        KMPSearch(text, pattern);

        in.close();
    }

    
    // KMP search
    public static void KMPSearch(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        // if pattern is empty
        if (m == 0) 
        {
            System.out.println(0);
            return;
        }

        int[] lps = computeLPS(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern

        boolean found = false;

        while (i < n) 
        {
            // characters match → move both pointers
            if (text.charAt(i) == pattern.charAt(j)) 
            {
                i++;
                j++;
            }

            // full match found
            if (j == m) 
            {
                System.out.println(i - j); // starting index
                found = true;
                j = lps[j - 1]; // continue searching
            }

            // mismatch after some matches
            else if (i < n && text.charAt(i) != pattern.charAt(j)) 
            {
                if (j != 0) 
                {
                    // use LPS to skip comparisons
                    j = lps[j - 1]; 
                } 
                else 
                {
                    i++;
                }
            }
        }

        if (!found) 
        {
            System.out.println(-1);
        }
    }

    //LPS array
    public static int[] computeLPS(String pattern) 
    {

        int m = pattern.length();
        int[] lps = new int[m];

        // length of previous longest prefix suffix
        int len = 0; 
        int i = 1;

        // first value is always 0
        // single character has no prefix or suffix
        lps[0] = 0; 

        while (i < m) 
        {
            if (pattern.charAt(i) == pattern.charAt(len)) 
            {
                len++;
                lps[i] = len;
                i++;
            } 
            else 
            {
                if (len != 0) {
                    len = lps[len - 1];
                } 
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
