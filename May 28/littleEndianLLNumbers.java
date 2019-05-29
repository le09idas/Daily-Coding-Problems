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
    	
    	this.lowAddr = null;
    	for(int i = text.length() - 1; i >=0; i--)
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
    	while(ptr.next != null)
    	{
    		num.concat(ptr.toString());
    		
    		if(this.lowAddr.next != null)
    		{
    			num.concat("->");
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
		LEInteger num = new LEInteger(8);
		System.out.println(num.toString());
	}
}
