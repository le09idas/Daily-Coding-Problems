//class twoDIterator
/*
    This file contains the classes for NoElenetException,
    TwoDIterator, and TestApp.
*/

/*
    Custom exception class to handle a situation
    where you're at the end of a iteratable list of 
    lists.
*/
class NoElementException extends Exception
{
    public NoElementException()
    {

    }//end constructor

    public String toString()
    {
        return "No more elements";
    }//end toString
}

/*
    TwoDIterator uses an inner class
    to keep track of where in the 2D 
    array.  Has next() and has_next()
    methods to iterate and check for 
    a next element respectively
*/
class TwoDIterator
{
    class Pointer
    {
        int x;              //Notes which list we are currently in
        int y;              //Notes which index of the current list we're in

        public Pointer()
        {
            this.x = 0;
            this.y = 0;
        }//end constructor

        /*
            This is a class to test out the 
            usage of inner classes; can be done
            with a simple this.x++ statment
            in the subsequent functions.
            Increments x coordinate.
        */
        public void increaseX()
        {
            this.x++;
        }//end increaseX()

        /*
            This is a class to test out the 
            usage of inner classes; can be done
            with a simple this.y++ statment
            in the subsequent functions.
            Increments y coordinate.
        */
        public void increaseY()
        {
            this.y++;
        }//end increaseY()

        /*
            toString for the coordinates
        */
        public String toString()
        {
            return "" + this.x + ", " + this.y + "";
        }
    }//end Pointer nested class

    Pointer ptr;            //Pointer object for TwoDIterator
    int[][] arrayList;      //The list lists

    public TwoDIterator(int[][] arrList)
    {
        this.ptr = new Pointer();
        this.arrayList = arrList;
    }// end constructor

    /*
        next() returns a the item currently pointed
        to by ptr.  It then sets up the next item to 
        be returned.  If the end of the final list is reached,
        or if there is no more items to return, the x coordinate
        of ptr is set so that next() throws the NoElementException.
    */
    public int next() throws NoElementException
    {
        if(this.ptr.x >= this.arrayList.length) //went through all lists?
        {
            throw new NoElementException();     //indicate there is no more
        }//end if

        int item = this.arrayList[this.ptr.x][this.ptr.y];  //this item is verified and thus will always yield a value

        if(this.ptr.y < this.arrayList[this.ptr.x].length)  //Still have more indices to visit?
        {
            this.ptr.increaseY();   //set up next item
            if(this.ptr.y == this.arrayList[this.ptr.x].length) //end of current list?
            {
                this.ptr.increaseX(); //move to next list
                this.ptr.y = 0;       //start from beginning of that list

                if(this.ptr.x == this.arrayList.length) //no more lists?
                {
                    ;   //set up for exception throw
                }//end if
                else
                {
                    while(this.arrayList[this.ptr.x].length < 1)    //find next list that has elements to return
                    {   
                        this.ptr.increaseX();   //move to next list if current list is empty

                        if(this.ptr.x == this.arrayList.length) //check if we have no more lists
                        {
                            break;
                        }// end if
                    }//end while
                }//end else
            }//end if
        }//end if
        return item;
    }

    /*
        has_next() just checks if there is an upcoming item.
        It starts with seeing if there are still indices
        to check in the current list. If not, then we go ahead
        and check for the next available non-empty list.
    */
    public boolean has_next()
    {
        if(this.ptr.x >= this.arrayList.length) // are we out of lists?
        {
            return false;   //yes
        }//end if
        if(this.ptr.y < this.arrayList[this.ptr.x].length - 1)// are we out of indices?
        {
            return true;        //no
        }
        else //yes
        {
            for(int i = this.ptr.x; i<this.arrayList.length; i++)//for every list
            {
                if(this.arrayList[i] != null && this.arrayList[i].length > 0)//is the list non-empty?
                {
                    return true;//yes
                }
            }
        }

        return false;// no more items
    }

}

class TestApp
{
    public static void main(String[] args)
    {
        int[][] array = {{1, 2}, {3}, {}, {4, 5, 6}};

        TwoDIterator iter = new TwoDIterator(array);

        while(true)
        {
            try
            {
                System.out.println(iter.has_next());
                System.out.println(iter.next());
                
            }
            catch (NoElementException e)
            {
                System.out.println("This is the end of the list!");
                break;
            }
        }
        
    }
}