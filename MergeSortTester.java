/*======================================
  class MergeSortTester
  ALGORITHM:
  1. List contains one element, return the list.
  2. Split list in half(if odd numbered elements, extra card may be
     on either side, as long as consistency is observed.
  3. Recursively call merge sort algorithm on the two halves.
  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(n*log(n))
  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 0.358ms
  n=10      time: 0.009ms
  n=100     time: 0.070ms
  ...
  n=1000000  time: 0.487ms
  ANALYSIS:
  Our assumption was correct!
  ======================================*/

public class MergeSortTester 
{

    /******************************
     * execution time analysis 
     * Create a list of n elements, each element is a random number between 0 and size - 1.
     * Start time, sort, stop time, and return difference between stop/start time.
     ******************************/
    public static long timeMerge (int size) 
    {
	int[] l1 = new int[size];
	for(int i = 0; i < size; i++) {
	    l1[i] = (int)(Math.random()*size);
	}
        long start = System.nanoTime();
	MergeSort.sort(l1);
	long stop = System.nanoTime();
        System.out.println(size + " elements: " + (stop - start) + " ns, " + (stop - start) / 1000000. + " ms.");
	return stop - start;
    }
    
    public static void main(String[] args){
	long t1 = timeMerge(1);
	long t10 = timeMerge(10);
	long t100 = timeMerge(100);
	long t1000 = timeMerge(1000);
	long t1000000 = timeMerge(1000000);
	
	System.out.println("Time multiplier btw 1 and 10: " + (double)t10 / t1);
	System.out.println("Time multiplier btw 10 and 100: " + (double)t100 / t10);
	System.out.println("Time multiplier btw 100 and 1000: " + (double)t1000 / t100);
	System.out.println("Time multiplier btw 1000 and 1000000: " + (double)t1000000 / t1000);

    }//end main

}//end class
