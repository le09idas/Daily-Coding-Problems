//flipsTest.java
class Flips
{
    public static int roundsNeeded(int n)
    {
        int rounds = 0;

        while(n != 1)
        {
            n = n/2;
            rounds++;
        }

        return rounds;
    }
} //end class Flips

class TestApp
{
    public static void main(String[] args)
    {
        int n = 20;
        System.out.println("The number of rounds needed to get to 1 quarter for " + n + " coins is: " + Flips.roundsNeeded(n));
    }
}
