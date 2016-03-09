/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 

  Merge function: 
  Compares the two elements of the list specified by two indexes. The smaller element is added to the final list, and the index value of the list whose element is smalleris incremented. This continues until either list is out of elements, at which point the rest of elements in the other list are appended to the final list.

  Sort function:
  The base case is if the list size is 1, so if it is return the list. Otherwise, split the list in two parts, do the sort function on each, and then return the result of a merge on those two lists.
  ======================================*/

public class MergeSort
{
    /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
        int aN = 0;
        int bN = 0;
        int[] fin = new int[a.length+b.length]; 
        //adding on stuff with thing
        while(aN < a.length || bN < b.length)
        {
            if(aN == a.length)
            {
                fin[aN + bN] = b[bN];
                bN += 1;
            }
            else if(bN == b.length)
            {
                fin[aN + bN] = a[aN];
                aN += 1;
            }
            else
            {
                if(b[bN] < a[aN])
                {
                    fin[aN + bN] = b[bN];
                    bN += 1;
                }
                else
                {
                    fin[aN + bN] = a[aN];
                    aN += 1;
                }
            }
        }
        return fin;		
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 

    {
        if(arr.length <= 1) return arr;
        else
        {
            //splits list in two almost equal parts
            int[] firsthalf = new int[arr.length / 2];
            for(int i = 0; i < arr.length / 2; i++)
            {
                firsthalf[i] = arr[i];
            } 
            int[] secondhalf = new int[arr.length - arr.length / 2];
            for(int i = arr.length / 2; i < arr.length; i++)
            {
                secondhalf[i - arr.length / 2] = arr[i];
            }
            return merge(sort(firsthalf),sort(secondhalf)); //merges sorted versions of first and scond haalves
        }

    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a )
    {
        for( int i = 0 ; i<a.length; i++ )
            a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a )
    {
        System.out.print("[");
        for( int i : a )
            System.out.print( i + ",");
        System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args )
    {
        int[] arr0 =
        {0};
        int[] arr1 =
        {1};
        int[] arr2 =
        {1,2};
        int[] arr3 =
        {3,4};
        int[] arr4 =
        {1,2,3,4};
        int[] arr5 =
        {4,3,2,1};
        int[] arr6 =
        {9,42,17,63,0,512,23};
        int[] arr7 =
        {9,42,17,63,0,9,512,23,9};

        System.out.println("\nTesting mess-with-array method...");
        printArray( arr3 );
        mess(arr3);
        printArray( arr3 );

        System.out.println("\nMerging arr1 and arr0: ");
        printArray( merge(arr1,arr0) );

        System.out.println("\nMerging arr4 and arr6: ");
        printArray( merge(arr4,arr6) );

        System.out.println("\nSorting arr4-7...");
        printArray( sort( arr4 ) );
        printArray( sort( arr5 ) );
        printArray( sort( arr6 ) );
        printArray( sort( arr7 ) );
    }//end main()
}//end class MergeSort
