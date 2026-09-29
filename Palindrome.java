//Making Palindromes 
import java.util.Scanner;

public class Palindrome
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string to check: ");
        String input = scanner.nextLine();
        String output = getOutput(input);
        System.out.println(output);
    }

    public static String getOutput(String input) 
    {
        String alph = "abcdefghijklmnopqrstuvwxyz";

        //try at every possible position
        for(int i=0; i<=input.length(); i++)
        {   
            //try every possible lowercase letter
            for(int j=0; j<=alph.length()-1; j++)
            {
                //create new string with inserted character
                String newstring = input.substring(0, i) + alph.charAt(j) + input.substring(i);

                //check if new string is a palidrome
                //return if it is
                if(isPalindrome(newstring))
                {
                    return newstring;
                }
            }
        }
        //if not possible to make a palindrome by
        //adding any one lowercase letter anywhere
        return "NONE";
    }

    public static boolean isPalindrome(String str)
    {
        String reverse = "";

        for(int p=str.length()-1; p>=0; p--)
        {
            reverse += str.charAt(p);
        }

        if(str.equals(reverse))
        {
            return true;
        }
        return false;
    }
}
