//numberTest.java
class Number
{
    String number;
    String type = "";

    public Number(String num)
    {
        this.number = num;
    }

    public void defineType()
    {
        int i;

        if(this.number.charAt(0) == '-')
        {

        }
        else if(Character.isDigit(this.number.charAt(0)) && this.number.charAt(0) != '0')
        {

        }
        else if(this.number.charAt(0) == '.')
        {
            for(i=1; i< this.number.length(); i++)
            {
                if(!Character.isDigit(this.number.charAt(i)))
                {
                    this.type = "Invalid value";
                }
            }
            this.type = "PosDec";
        }
        else
        {
            this.type = "Invalid value";
        }

    }
}// end class Number

class TestApp
{
    public static void main(String[] args)
    {
        Number[] numbers = new Number[16];
        numbers[0] = new Number("1234");
        numbers[1] = new Number("-1234");
        numbers[2] = new Number("10.1234");
        numbers[3] = new Number("-10.1234");
        numbers[4] = new Number(".1234");
        numbers[5] = new Number("-.1234");
        numbers[6] = new Number("1e10");
        numbers[7] = new Number("-1e10");
        numbers[8] = new Number("1e-12");
        numbers[9] = new Number("10.2e1.2");
        numbers[10] = new Number("3.34e1.2");

        numbers[11] = new Number("1*adf");
        numbers[12] = new Number("-1..3");
        numbers[13] = new Number("*)&#");
        numbers[14] = new Number("-..1");
        numbers[15] = new Number("1e1.3.");

        for(int i = 0; i<numbers.length; i++)
        {
            numbers[i].defineType();
            System.out.println("" + numbers[i].number + " is a(n)  " + numbers[i].type);
        }
        
    }
}