///doubletonTest.java
class Doubleton
{
    static private Doubleton instance1;
    static private Doubleton instance2;
    static private int turn;
    static private Doubleton[] pair;

    private Doubleton(){};

    public static Doubleton getInstance()
    {
        if(instance1 == null && instance2 == null)
        {
            pair = new Doubleton[2];
            instance1 = new Doubleton();
            System.out.println("This is the creation of the first instance with hashcode " + System.identityHashCode(instance1));
            instance2 = new Doubleton();
            System.out.println("This is the creation of the second instance with hashchode " + System.identityHashCode(instance2));
            pair[0] = instance1;
            pair[1] = instance2;
            
        }
        
        Doubleton temp = pair[0];
        pair[0] = pair[1];
        pair[1] = temp;
        return pair[0];
    }
}//end Doubleton
class TestApp{

    public static void main(String[] args)
    {
        for(int i = 0; i < 10; i++)
        {
            System.out.println("This is the " + i + "th invocation of this instance:");
            System.out.println(System.identityHashCode(Doubleton.getInstance()));
        }
       
    }
}