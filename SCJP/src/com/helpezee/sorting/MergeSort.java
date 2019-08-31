package com.helpezee.sorting;

/* Java program for Merge Sort */
class MergeSort 
{ 
	// Merges two subarrays of arr[]. 
	// First subarray is arr[low..mid] 
	// Second subarray is arr[mid+1..high] 
	void merge(int arr[], int low, int mid, int high) 
	{ 
		// Find sizes of two subarrays to be merged 
		int n1 = mid - low + 1; 
		int n2 = high - mid; 

		/* Create temp arrays */
		int L[] = new int [n1]; 
		int R[] = new int [n2]; 

		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i) 
			L[i] = arr[low + i]; 
		for (int j=0; j<n2; ++j) 
			R[j] = arr[mid + 1+ j]; 


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays 
		int i = 0, j = 0; 

		// Initial index of merged subarry array 
		int k = low; 
		while (i < n1 && j < n2) 
		{ 
			if (L[i] <= R[j]) 
			{ 
				arr[k] = L[i]; 
				i++; 
			} 
			else
			{ 
				arr[k] = R[j]; 
				j++; 
			} 
			k++; 
		} 

		/* Copy remaining elements of L[] if any */
		while (i < n1) 
		{ 
			arr[k] = L[i]; 
			i++; 
			k++; 
		} 

		/* Copy remaining elements of R[] if any */
		while (j < n2) 
		{ 
			arr[k] = R[j]; 
			j++; 
			k++; 
		} 
	} 

	// Main function that sorts arr[low..high] using  merge() 
	void mergeSort(int arr[], int low, int high) 
	{ 
		if (low < high) 
		{ 
			// Find the middle point 
			int mid = (low+high)/2; 

			// Sort first and second halves 
			mergeSort(arr, low, mid); 
			mergeSort(arr , mid+1, high); 

			// Merge the sorted halves 
			merge(arr, low, mid, high); 
		} 
	} 

	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 

	// Driver method 
	public static void main(String args[]) 
	{ 
		int arr[] = {12, 11, 13, 5, 6, 7}; 

		System.out.println("Given Array"); 
		printArray(arr); 

		MergeSort ob = new MergeSort(); 
		ob.mergeSort(arr, 0, arr.length-1); 

		System.out.println("\nSorted array"); 
		printArray(arr); 
	} 
} 
