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
    
    DigitNode lowAddr;
    
    public LEInteger(int number)
    {
        String text = Integer.toString(number);
        this.lowAddr = new DigitNode(Character.getNumericValue(text.charAt(text.length()-1)));
        
    	for(int i = text.length() - 2; i > -1; i--)
    	{
            DigitNode temp = this.lowAddr;
            this.lowAddr = new DigitNode(Character.getNumericValue(text.charAt(i)));
            this.lowAddr.next = temp;
        }
    }
    
    public String toString()
    {
        String num = "";
        DigitNode ptr = this.lowAddr;
    
        while(ptr != null)
    	{
    		num += ptr.toString();
    		if(ptr.next != null)
    		{
    			num += "->";
    		}
    		
    		ptr = ptr.next;
    	}
    	return num;
    }
}

class TestApp
{
	public static void main(String[] args)
	{
        LEInteger num = new LEInteger(128);
		System.out.println(num.toString());
	}
}
