import java.util.ArrayList;

//palindromePairsTest.java

/*
    Palindrom includes an isPalindrome verification
    method.  It contains an additional inner class PalinPair
    to store the results in the list given by getPalinPairs.
*/
class Palindrome
{
    /*
        This is more or less a dummy just to get the arraylist
        whilst using the inner class
    */
    public Palindrome()
    {}//end consctructor

    /*
        Encapsulates the idea of a pair of words that can make a palindrome.
    */
    class PalinPair
    {
        int word_pos_1;     //the index of the first word in a PalinPair
        int word_pos_2;     //the index of the second word in a PalinPair

        public PalinPair(int word1_pos, int word2_pos)
        {
            this.word_pos_1 = word1_pos;
            this.word_pos_2 = word2_pos;
        }//end constructor

        public String toString()
        {
            return "(" + this.word_pos_1 + ", " + this.word_pos_2 + ")";
        }
    }//end of inner class PalinPair

    /*
        Regular, old-fashioned palindrome validator.
    */
    public static boolean isPalindrome(String word)
    {
        int i = 0, j = word.length()-1;

        while(i < j)                                //while the indicies are juxtaposed
        {
            if(word.charAt(i) != word.charAt(j))    //indices are now reversely juxtaposed
            {
                return false;
            }
            i++; j--;
        }
        return true;
    }//end isPalindrome()

    /*
        getPalinPairs() does just that; it is brute force
        and combines each word and sees with isPalindrome()
        if the given combination is a palindrome
    */
    public ArrayList<String> getPalinPairs(String[] words)
    {
        ArrayList<String> pairs = new ArrayList<String>();  //list of pairs to populate

        for(int i = 0; i < words.length; i++)                   //for each word in words
        {
            int j = i + 1;

            while(j < words.length)                             //while there are other words in the list
            {
                if(Palindrome.isPalindrome(words[i] + words[j]))    //can I get a palindrome with this combo?
                {
                    PalinPair palpair = new PalinPair(i, j);
                    String pair = palpair.toString();
                    pairs.add(pair);
                }//end if
                if(Palindrome.isPalindrome(words[j] + words[i]))    //can I get a palindrome with the revers of the combo?
                {
                    PalinPair palpair = new PalinPair(j, i);
                    String pair = palpair.toString();
                    pairs.add(pair);
                }//end if

                j++;
            }//end while
        }//end for

        return pairs;
    }//end getPalinPairs()
}

class TestApp
{
    public static void main(String[] args)
    {
        String[] words = {"code", "edoc", "da", "d", "d"};
        Palindrome p = new Palindrome();
        ArrayList<String> list = p.getPalinPairs(words);

        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
}