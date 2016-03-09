class MergeSortTester {
    public static void timeMerge (int size) 
    {
	int[] l1 = new int[size];
	for(int i = 0; i < size; i++) {
	    l1[i] = (int)(Math.random()*size);
	}
        long start = System.nanoTime();
	MergeSort.sort(l1);
	long stop = System.nanoTime();
        System.out.println(size + " elements: " + (stop - start) + " ns, " + (stop - start) / 1000000. + " ms.");
    }
    
    public static void main(String[] args){
	timeMerge(1000);
	timeMerge(10000);
	timeMerge(100000);
	timeMerge(1000000);
	timeMerge(10000000);
	timeMerge(100000000);
	timeMerge(1000000000);
	
    }
}
