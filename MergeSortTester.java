class MergeSortTester {
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
	long t10000 = timeMerge(10000);
	long t100000 = timeMerge(100000);
	long t1000000 = timeMerge(1000000);
	long t10000000 = timeMerge(10000000);
	long t20000000 = timeMerge(20000000);
	long t40000000 = timeMerge(40000000);
	
	System.out.println("Time multiplier btw 100,000 and 10,000: " + (double)t100000 / t10000);
	System.out.println("Expected for O(n): 10");
	System.out.println("Expected for O(nlogn): " + 10 * (Math.log(100000) / Math.log(10000)));
	System.out.println("Expected for O(n^2): 100");
	
	System.out.println("Time multiplier btw 1,000,000 and 100,000: " + (double)t1000000 / t100000);
	System.out.println("Expected for O(n): 10");
	System.out.println("Expected for O(nlogn): " + 10 * (Math.log(1000000) / Math.log(100000)));
	System.out.println("Expected for O(n^2): 100");
	
	System.out.println("Time multiplier btw 10,000,000 and 1,000,000: " + (double)t10000000 / t1000000);
	System.out.println("Expected for O(n): 10");
	System.out.println("Expected for O(nlogn): " + 10 * (Math.log(10000000) / Math.log(1000000)));
	System.out.println("Expected for O(n^2): 100");

	System.out.println("Time multiplier btw 20,000,000 and 10,000,000: " + (double)t20000000 / t10000000);
	System.out.println("Expected for O(n): 2");
	System.out.println("Expected for O(nlogn): " + 2 * (Math.log(20000000) / Math.log(10000000)));
	System.out.println("Expected for O(n^2): 4");

	System.out.println("Time multiplier btw 40,000,000 and 20,000,000: " + (double)t40000000 / t20000000);
	System.out.println("Expected for O(n): 2");
	System.out.println("Expected for O(nlogn): " + 2 * (Math.log(40000000) / Math.log(20000000)));
	System.out.println("Expected for O(n^2): 4");
    }
}
