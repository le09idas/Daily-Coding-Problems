import javax.lang.model.util.ElementScanner6;

///kPalindromeTest.java
class kPalindrome{

    public static boolean isKPalindrome(int k, String palindrome)
    {
        
        char[] palindromeArr = palindrome.toCharArray();
        int start = 0;
        int end = palindromeArr.length - 1;

        if(palindromeArr.length == 0)
            return false;

        while(start < end)
        {
            if(palindromeArr[start] == palindromeArr[end])
            {
                start++;
                end--;
            }
            else
            {
                return false;
            }
        }

        return true;
    }
}

class TestApp
{
    public static void main(String[] args)
    {
        System.out.println(kPalindrome.isKPalindrome(1, "alba"));
    }
}