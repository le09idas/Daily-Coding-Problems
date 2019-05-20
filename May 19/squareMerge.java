import java.util.Arrays;

import javax.lang.model.util.ElementScanner6;
//squareMearge.java
class SquareMerge
{
    /*
    Takes 
    */
    public static void squareMergeSort(int[] arr, int low, int high)
    {
        if(low == high) //one index?
        {
            arr[low] = arr[low]*arr[low];//square the index's value
            return;
        }
        else //multiple indices
        {
            //recursively call function to manipulate and sort values
            squareMergeSort(arr, low, (low + high)/2);//first half of subarray
            squareMergeSort(arr, (low+high)/2+1, high);//second half of subarray
            squareMerge(arr, low, (low+high)/2, high);//actual sorting
        }
    }

    public static void squareMerge(int[] arr, int low, int mid, int high)
    {
        //set the size of the temp array to be the range from high to low, plus one for index decrement
        int [] temp = new int[high - low + 1];
        int i =low, j=mid + 1, k=0;
        
        /*
        gist of sorting: have separate pointers for each subarray.
        Choose the lowest one to save to the temp array and 
        increment pointers accordingly.  If one interval 
        finishes, then fill the temp array with the rest of the 
        other subarray, which should be sorted.  
        */
        while(i <= mid && j <= high)
        {
            if(arr[i] < arr [j])
            {
                temp[k] = arr[i];
                k++;i++;
            }
            else
            {
                temp[k] = arr[j];
                k++;j++;
            }
        }

        //fin in if second subarray empties
        while(i <= mid)
        {
            temp[k] = arr[i];
            k++;i++;
        }

        //fill in if first subarray empties
        while(j <= high)
        {
            temp[k] = arr[j];
            k++;j++;
        }

        //this segment replaces the values in the original array
        //with the sorted values of the temp
        k = 0;
        for(i = low; i<=high; i++)
        {
            arr[i] = temp[k];
            k++; 
        }

    }
}
class TestSquareMerge
{
    //code block to test squareMergeSort
    public static void main(String[] args)
    {
        int[] arr = {-9,-2,0,2,3};
        System.out.println(Arrays.toString(arr));
        SquareMerge.squareMergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}