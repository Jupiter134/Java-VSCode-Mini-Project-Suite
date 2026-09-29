//Huffman Encoding/Compression

import java.util.Scanner;

public class SuperCrusher {

    // main SuperCrusher method
    // returns best possible compression ratio as string
    public static String superCrusher(String input) 
    {
        int originalLength = input.length();
        //can delete max half of characters
        int maxDelete = originalLength / 2;
        //start at max so compressed result will be smaller
        int bestCompressedLength = Integer.MAX_VALUE;

        // try deleting 0 up to maxDelete
        for (int deleteSize = 0; deleteSize <= maxDelete; deleteSize++) 
        {
            // try every possible consecutive deletion for that deletion size
            for (int start = 0; start <= (originalLength - deleteSize); start++) 
            {
                String remaining = input.substring(0, start) + input.substring(start + deleteSize);

                int compressedLength = rleLength(remaining);

                if (compressedLength < bestCompressedLength) 
                {
                    bestCompressedLength = compressedLength;
                }
            }
        }

        // calculate percentage ratio
        int ratio = (bestCompressedLength * 100) / originalLength;

        return ratio + "%";
    }

    // returns length of RLE compressed string
    public static int rleLength(String str) {

        //empty string, length is 0
        if (str.length() == 0) 
        {
            return 0;
        }

        int length = 0;
        int count = 1;

        for (int i=1; i<str.length(); i++) 
        {

            if (str.charAt(i) == str.charAt(i - 1)) 
            {
                count++;
            } 
            //not same consecutive
            else 
            {
                // add digits in count + 1 character
                length += String.valueOf(count).length() + 1;
                count = 1;
            }
        }

        // last group
        length += String.valueOf(count).length() + 1;

        return length;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string to be compressed: ");
        String input = scanner.nextLine();

        scanner.close();

        System.out.println("Compression ratio: " + superCrusher(input));
    }
}
