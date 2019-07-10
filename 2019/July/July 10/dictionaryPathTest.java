import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//file dictionaryPatTest.java

class Dictionary
{
    public static boolean sameLetterAtIndex(String string1, String string2, int index)
    {
        if(string1.charAt(index) == string2.charAt(index))
        {
            return true;
        }
        return false;
    }

    public static int diff(String string1, String string2)
    {
        int diff = 0;
        for(int i = 0; i < string1.length(); i++)
        {
            if(string1.charAt(i) != string2.charAt(i))
            {
                diff++;
            }
        }
        return diff;
    }
    public static ArrayList<String> getShortestPath(String start, String end, String[] dictionary)
    {
        ArrayList<String> dict = new ArrayList<String>(Arrays.asList(dictionary));
        ArrayList<String> path = new ArrayList<String>();

        if(dict.size() < Dictionary.diff(start, end))
        {
            return null;
        }
        if(!dict.contains(end))
        {
            return null;
        }
        
        path.add(start);

        int diff = Dictionary.diff(start, end);
        int j = 1;
        int i = 0;

        while(j <= diff)
        {
            for(int k = 0; k < dict.size(); k++)
            {
                if(Dictionary.diff(path.get(i), dict.get(k)) ==  1 && Dictionary.diff(dict.get(k), end) == diff - j)
                {
                    path.add(dict.get(k));
                    break;
                }
            }
            j++;
            i++;
        }

        return path;
    }
}

class TestApp
{
    public static void main(String[] args)
    {
        String[] dict = {"dop", "dot", "dat", "cat"};
        String start = "dog";
        String end = "cat";

        ArrayList<String> list = Dictionary.getShortestPath(start, end, dict);

        System.out.println(list.toString());
    }
}