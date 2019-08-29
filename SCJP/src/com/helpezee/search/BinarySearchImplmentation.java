package com.helpezee.search;

//Java implementation of recursive Binary Search 
class BinarySearchImplmentation 
{ 
	// Returns index of element if it is present in arr[startIndex.. endIndex], else return -1 
	int binarySearch(int arr[], int startIndex, int endIndex, int element) 
	{ 
		
		if (endIndex>=startIndex) 
		{ 
			int mid = startIndex + (endIndex - startIndex)/2; 

			// If the element is present at the middle itself 
			if (element == arr[mid]) 
			return mid; 

			// If element is smaller than mid, then it can only be present in left subarray 
			if ( element < arr[mid] ) 
			return binarySearch(arr, startIndex, mid-1, element); 

			// Else the element can only be present in right subarray 
			return binarySearch(arr, mid+1, endIndex, element); 
		} 

		// We reach here when element is not present  in array 
		return -1; 
	} 

	// Driver method to test above 
	public static void main(String args[]) 
	{ 
		BinarySearchImplmentation ob = new BinarySearchImplmentation(); 
		int arr[] = {2,3,4,10,40}; 
		int startIndex = 0;
		int endIndex = arr.length; 
		int element = 10; 
		int result = ob.binarySearch(arr,startIndex,endIndex-1,element); 
		if (result == -1) 
			System.out.println("Element not present"); 
		else
			System.out.println("Element found at index " + 	result); 
	} 
} 



/*
What if input is not sorted?
If input list is not sorted, the results are undefined.

What if there are duplicates?
If there are duplicates, there is no guarantee which one will be found.

How does Collections.binarySearch work for LinkedList?
This method runs in log(n) time for a “random access” list like ArrayList. 
If the specified list does not implement the RandomAccess interface and is large, this method will do an iterator-based binary search that 
performs O(n) link traversals and O(log n) element comparisons.

What is significant value of negative value returned by both functions?
The function returns an index of the search key, if it is contained in the array; otherwise, (-(insertion point) – 1).
 The insertion point is defined as the point at which the key would be inserted into the array: 
 the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key. 
 Note that this guarantees that the return value will be >= 0 if and only if the key is found.
*/