//numberTest.java
class Number 
{
    String number;      //the body of the given number, if it is
    String type = "";   //Type of number; can be PosInt, NegInt, 
                        //PosRat, NegRat, PosDec, NegDec, PosSciNot, 
                        //NegSciNot, Invalid value

    public Number(String num) 
    {
        this.number = num;
    }

    public void defineType() //Grand function that decides type of string
    {
        int i;

        if (this.number.charAt(0) == '-')                               //answer is negative?
        {
            if (this.number.charAt(1) == '.')                     //negative decimal?
            {
                if(this.number.length() == 2)
                {
                    this.type = "Invalid value";
                    return;
                }
                for (i = 2; i < this.number.length(); i++) 
                {
                    if (!Character.isDigit(this.number.charAt(i)))
                    {
                        this.type = "Invalid value";
                        return;
                    }
                }   
                this.type = "NegDec";                                //answer is negDec
                return;
            }
            if (Character.isDigit(this.number.charAt(1)))               //integer? 
            {
                if (this.number.charAt(1) == '0')                       //dec?
                {
                    if (Character.isDigit(this.number.charAt(1)))       //can't have 0[0-9]*
                    {
                        this.type = "Invalid value";
                        return;
                    } 
                    else if (this.number.charAt(2) == '.')              //has decimal
                    {
                        for (i = 3; i < this.number.length(); i++) 
                        {
                            if (!Character.isDigit(this.number.charAt(i))) 
                            {
                                this.type = "Invalid Value";
                                return;
                            }
                            this.type = "NegDec";                      //answer is negative decimal
                            return;
                        }
                    }
                } 
                else                                                   //answer is integer?
                {
                    for(i=2; i<this.number.length(); i++)
                    {
                        if(this.number.charAt(i) == 'e')               //is this a negative scinot?
                        {
                            if(i+1 == this.number.length())             // no
                            {
                                this.type = "Invalid Value";
                                return;
                            }
                            for(i = i+1; i<this.number.length(); i++)   
                            {
                                if(this.number.charAt(i) == '-')        // decimal moved right
                                {
                                    for(i = i+1; i<this.number.length(); i++)
                                    {
                                        if(!Character.isDigit(this.number.charAt(i)))
                                        {
                                            this.type = "Invalid value";
                                            return;
                                        }
                                    }
                                }
                                else                                    // decimal moved left
                                {
                                    if(!Character.isDigit(this.number.charAt(i)))
                                    {
                                        this.type = "Invalid value";
                                        return;
                                    }
                                }
                            }
                            this.type = "NegSciNot";                    // answer is negative scinot
                            return;

                        }
                        else if(this.number.charAt(i) == '.')           // answer is negative rational number?
                        {
                            for(i = i+1; i<this.number.length(); i++)
                            {
                                if(!Character.isDigit(this.number.charAt(i)))
                                {
                                    this.type = "Invalid value";
                                    return;
                                }
                            }
                            this.type = "NegRat";                       //answer is negrat
                            return;
                        }
                        else if(!Character.isDigit(this.number.charAt(i)))  // invalid value
                        {
                            this.type = "Invalid value";
                            return;
                        }
                    }
                    this.type = "NegInt";                              //answer is negative integer
                    return;
                }
            }   
            else if (this.number.charAt(1) == '.')                     //negative decimal?
            {
                for (i = 2; i < this.number.length(); i++) 
                {
                    if (!Character.isDigit(this.number.charAt(i)))
                    {
                        this.type = "Invalid value";
                        return;
                    }
                }   
                this.type = "NegDec";                                //answer is negDec
                return;
            }
            
        } 
        else if (Character.isDigit(this.number.charAt(0)))          //positive answers
        {
            if (this.number.charAt(0) == '0')                       //positive dec?
            {
                
                if (Character.isDigit(this.number.charAt(1))) 
                {
                    this.type = "Invalid value";
                    return;
                } 
                else if (this.number.charAt(1) == '.')              //yes
                {
                    for (i = 2; i < this.number.length(); i++) 
                    {
                        if (!Character.isDigit(this.number.charAt(i))) 
                        {
                            this.type = "Invalid Value";
                            return;
                        }
                        this.type = "PosDec";                       //answer is positive decimal
                    }
                }
            } 
            else 
            {
                for(i=1; i<this.number.length(); i++)
                {
                    if(this.number.charAt(i) == 'e')               //positive scinot?
                    {
                        if(i+1 == this.number.length())
                        {
                            this.type = "Invalid value";
                            return;
                        }
                        for(i = i+1; i<this.number.length(); i++)
                        {
                            if(this.number.charAt(i) == '-')        //decimal moved right
                            {
                                for(i = i+1; i<this.number.length(); i++)
                                {
                                    if(!Character.isDigit(this.number.charAt(i)))
                                    {
                                        this.type = "Invalid value";
                                        return;
                                    }
                                }
                            }
                            else                                    //decimal moved left
                            {   
                                if(!Character.isDigit(this.number.charAt(i)))
                                {
                                    this.type = "Invalid value";
                                    return;
                                }
                            }
                        }
                        this.type = "PosSciNot";                    //answer is posscinot
                        return;

                    }
                    else if(this.number.charAt(i) == '.')           //rational number?
                    {
                        for(i = i+1; i<this.number.length(); i++)
                        {
                            if(!Character.isDigit(this.number.charAt(i)))
                            {
                                this.type = "Invalid value";
                                return;
                            }
                        }
                        this.type = "PosRat";                       //answer is positive rational
                        return;
                    }
                    else if(!Character.isDigit(this.number.charAt(i)))
                    {
                        this.type = "Invalid value";
                        return;
                    }
                }
                this.type = "PosInt";                               //answer is positive integer
            }
        } 
        else if (this.number.charAt(0) == '.')                      //positive decimal?
        {
            if(this.number.length() == 1)                             // single decimal?
            {
                this.type = "Invalid value";
                return;
            }
            for (i = 1; i < this.number.length(); i++) 
            {
                if (!Character.isDigit(this.number.charAt(i)))
                {
                    this.type = "Invalid value";
                    return;
                }
            }
            this.type = "PosDec";                                   //answer is a positive integer
        } 
        else 
        {
            this.type = "Invalid value";
            return;
        }

    }
}// end class Number

class TestApp 
{
    public static void main(String[] args) 
    {
        Number[] numbers = new Number[17];
        numbers[0] = new Number("1234");
        numbers[1] = new Number("-1234");
        numbers[2] = new Number("104.1234");
        numbers[3] = new Number("-10.1234");
        numbers[4] = new Number(".1234");
        numbers[5] = new Number("-.");
        numbers[6] = new Number("1e10");
        numbers[7] = new Number("-1e10");
        numbers[8] = new Number("1e-12");
        numbers[9] = new Number("10.");
        numbers[10] = new Number("3.34e1.2");

        numbers[11] = new Number("1*adf");
        numbers[12] = new Number("-1..3");
        numbers[13] = new Number("*)&#");
        numbers[14] = new Number("-..1");
        numbers[15] = new Number("1e1.3.");
        numbers[16] = new Number("0.1234");

        for (int i = 0; i < numbers.length; i++) 
        {
            numbers[i].defineType();
            System.out.println("" + numbers[i].number + " is a(n)  " + numbers[i].type);
        }

    }
}

