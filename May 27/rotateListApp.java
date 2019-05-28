import java.util.Arrays;

// rotateListApp.java
class TestNode
{
    String name;
    int value;

    public TestNode(String name, int val)
    {
        this.name = name;
        this.value = val;
    }

    public String toString()
    {
        return this.name + "," +Integer.toString(this.value);
    }
}
class RotateList
{
    public static void rotateList(Object[] list, int k) //list is set of numbers; k is number to rotate
    {
        int i = 0;
        while(i < k)
        {
            Object temp = list[0]; //save reference to first item
            
            for(int j = 0; j < list.length - 1; j++)//for each item
            {
                list[j] = list[j+1]; //replace it with the next item
            }

            list[list.length - 1] = temp; //set the last element to be the initial item
            i++;
        }
    }
}

class TestApp
{
    public static void main(String[] args)
    {
        TestNode node = new TestNode("testnode1", 3);
        Object[] list = {1, 'g', "stop", node};

        System.out.println(Arrays.toString(list));

        RotateList.rotateList(list, 2);

        System.out.println(Arrays.toString(list));
    }
}