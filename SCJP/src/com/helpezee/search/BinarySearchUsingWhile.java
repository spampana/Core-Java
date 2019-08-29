package com.helpezee.search;

public class BinarySearchUsingWhile {

	int binarySearch(int Arr[], int arrLength, int element) {
		int startIndex = 0;
		int endIndex = arrLength - 1;

		while (startIndex <= endIndex) {

			int mid = (startIndex + endIndex) / 2;

			if (element == Arr[mid]) {
				return mid;
			} else if (element < Arr[mid]) {
				endIndex = mid - 1;
			} else {
				startIndex = mid + 1;
			}
		}
		return -1;

	}
	
	// Driver method to test above 
    public static void main(String args[]) 
    { 
    	BinarySearchUsingWhile ob = new BinarySearchUsingWhile(); 
        int arr[] = {2,3,4,10,40}; 
        int n = arr.length; 
        int x = 10; 
        int result = ob.binarySearch(arr,n,x); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result); 
    } 
}