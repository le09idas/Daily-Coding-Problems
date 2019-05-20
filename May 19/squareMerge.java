import java.util.Arrays;
//squareMearge.java
class SquareMerge
{
    public static int[] squareMerge(int[] arr)
    {
        int[] smList = arr;

        if(smList.length == 1)
        {
            smList[0] = smList[0]*smList[0];
        }
        else if(smList.length == 2)
        {
           
            smList[0] = smList[0]*smList[0];
            smList[1] = smList[1]*smList[1];
            if(smList[0] > smList[1])
            {
                int temp = smList[0];
                smList[0] = smList[1];
                smList[1] = temp;
            }
            
        }
        else
        {
            int subSMList1[] = Arrays.copyOfRange(arr, 0, arr.length/2 + 1);
            int subSMList2[] = Arrays.copyOfRange(arr, arr.length/2 + 1, arr.length);

           
            //subSMList1 = squareMerge(subSMList1);
            System.out.print(Arrays.toString(subSMList1) + ", ");
            //subSMList2 = squareMerge(subSMList2);
            System.out.print(Arrays.toString(subSMList2) + "; ");
         
            int i, s1=0,s2=0;

            for(i=0;i<subSMList1.length;i++)
                smList[i] = subSMList1[s1];
                s1++;
            for(int j = i; j<subSMList1.length + subSMList2.length; j++)
                smList[j] = subSMList2[s2];
                s2++;

            System.out.println(Arrays.toString(smList) + " !");

        }
        return smList;
    }
}
class TestSquareMerge
{

    public static void main(String[] args)
    {
        int[] arr = {-9, -1, 0 , 1, 2};
        System.out.println(Arrays.toString(arr));
        arr = SquareMerge.squareMerge(arr);
        System.out.println(Arrays.toString(arr));
    }

}