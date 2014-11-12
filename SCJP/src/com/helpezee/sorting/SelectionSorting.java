package com.helpezee.sorting;

public class SelectionSorting {
	public static int[] doSelectionSort(int[] arr){
        
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                  if (arr[j] < arr[index])
                    index = j;
             
            }
            int smallerNumber = arr[index]; 
            arr[index] = arr[i];
            arr[i] = smallerNumber;
            for(int p=0;p<arr.length;p++){
            	System.out.println(arr[p]);
        }
            System.out.println("-----");
        }
        return arr;
    }
     
    public static void main(String a[]){
         
        int[] arr1 = {5,1,12,-5,16};
        int[] arr2 = doSelectionSort(arr1);
        for(int i:arr2){
            System.out.print(i);
            System.out.print(", ");
        }
    }
}

/*
 * Selecting the lowest element requires scanning all n elements (this takesn − 1 comparisons) and 
 * then swapping it into the first position. Finding the next lowest element requires scanning the remaining 
 * n − 1 elements and so on, for (n − 1) + (n − 2) + ... + 2 + 1 = n(n − 1) / 2 ∈ Θ(n2) comparisons. Each of these scans requires one swap for n − 1 elements.
 */
