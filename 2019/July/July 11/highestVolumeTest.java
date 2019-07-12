//file highestVolumeTest.java

/*
    The Period object holds the volume 
    of people in the building between 
    time entries.  
*/

class Period
{
    int vol;            //amount of people in building
    long fluxStamp1;     //when people entered/exited at start of period
    long fluxStamp2;    //when people entered/exit at end of Period

    public Period(int v, long flux1, long flux2)
    {
        this.vol = v;
        this.fluxStamp1 = flux1;
        this.fluxStamp2 = flux2;
    }//end constructor

    /*
        Works like compareTo for Strings.
    */
    public int compareTo(Period comparee)
    {
        if(this.vol < comparee.vol)     //less people
        {
            return -1;
        }
        if(this.vol > comparee.vol)     //more people
        {
            return 1;
        }
        if(thsi.vol == comparee.vol)    //same number of people
        {
            return 0;
        }
    }//end comparTo()
}