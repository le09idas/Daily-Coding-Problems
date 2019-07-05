class PigeonList
{
    public boolean[] ints;

    public PigeonList(int size)
    {
        this.ints = new boolean[size];
        
        for(int i = 0; i<size; i++)
        {
            this.ints[i] = false;
        }

    }//end constructor

    public void addItem(int item)
    {
        this.ints[item] = true;
        return;
    }//end addItem

    public int findDuplicate(int[] list)
    {
        for(int i = 0; i < this.ints.length; i++)
        {
            if(this.ints[list[i]-1])
            {
                return list[i];
            }
            else
            {
                this.ints[list[i]-1]=true;
            }
        }

        return -1;
    }
}//end PigeonList

class TestApp
{
    public static void main(String[] args)
    {
        int[] array = {3, 11, 5, 4, 2, 8, 10, 9, 6, 7, 1, 1};
        PigeonList list = new PigeonList(array.length);
        int dup = list.findDuplicate(array);

        if(dup > 0)
        {
            if(dup > list.ints.length)
            {
                System.out.println("Item exceeds range of list"); 
                return;
            }
            System.out.println("The duplicate is: " + dup);
        }
        else
        {
            System.out.println("There are no duplicates");
        }
    }
}//end TestApp