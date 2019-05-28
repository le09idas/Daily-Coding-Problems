//littleEndianLLNumbers.java

class LEInteger
{
    class DigitNode
    {
        int numeral;
        DigitNode next;

        public DigitNode(int number)
        {
            this.numeral = number;
            this.next = null;
        }

        public String toString()
        {
            return Integer.toString(this.numeral);
        }
    }
}
