///kPalindromeTest.java
class kPalindrome{

    public static boolean isKPalindrome(int k, String palindrome)
    {
        
        char[] palindromeArr = palindrome.toCharArray();
        int start;
        int end;
        int middle = palindrome.length()/2;

        if(palindrome.length()%2 == 0)
        {
            
            start = middle - 1;
            end = middle;
        }
        else
        {
            start = middle;
            end = middle;
        }

        if(palindromeArr.length == 0)
            return false;

        while(start >= 0 && end < palindrome.length())
        {
            if(palindromeArr[start] == palindromeArr[end])
            {
                start--;
                end++;
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
        System.out.println(kPalindrome.isKPalindrome(1, "baaab"));
    }
}