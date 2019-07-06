class LesserRight
{
    public static int[] lesserRight(int[] orig)
    {
        for(int i = 0; i < orig.length; i++)
        {
            int lessers = 0;
            for(int j = i + 1; j < orig.length; j++)
            {
                if(orig[j] < orig[i])
                {
                    lessers++;
                }//end if
            }//end for
            orig[i] = lessers;
        }//end for

        return orig;
    }//end lesserRight
}//end LesserRight

class TestApp
{
    public static void main(String[] args)
    {
        int[] arr = {3, 4, 9, 6, 1, 0, 10};

        arr = LesserRight.lesserRight(arr);

        System.out.print("[");
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print("" + arr[i] + "");
            if(i != arr.length -1)
            {
                System.out.print(", ");
            }
        }//end for
        System.out.println("]");
    }//end main
}