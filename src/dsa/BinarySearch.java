package dsa;

public class BinarySearch {
//	Recursive Binary Search - Tail Recursion
	public static int binarySearch(int arr[],int low,int high,int elem){
		if(low <= high)
		{
			int mid = (low + high)/2;
			if( elem == arr[mid]) {
				return mid;
			}
			else if(elem < arr[mid]) {
				high = mid -1;
				return binarySearch(arr,low,high,elem);
			}
			else {
				low = mid + 1; 
				return binarySearch(arr,low,high,elem);		
			}
		}
		// If no match found returning index -1
		return -1;
	}
//	Iterative Binary Search
	public static int binarySearch(int[] arr,int elem){
		int low = 0,high = arr.length-1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(elem == arr[mid]) {
				return mid;
			}
			
			else if(elem < arr[mid]){
				high = mid - 1;
			}
			else{
				low = mid + 1;
			}
		}
		// If no match found returning index -1
		return -1;
	}
	/* Iterative Binary Search approach has a better Space Complexity than Recursive one,
	 * As the recursive solution uses stack & is indeed TAIL RECUSRION, it can easily 
	 * be implemented Iteratively.
	 */
	public static void main(String[] args) {
//		Taking a sample Sorted array
		int arr[] = {1,2,3,4,5};
//		Running Iterative Version
		System.out.println(BinarySearch.binarySearch(arr,9));
//		Running Recursive version
		System.out.println(BinarySearch.binarySearch(arr,0,arr.length-1,2));
	}

}
