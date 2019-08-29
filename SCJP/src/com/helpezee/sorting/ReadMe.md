Previously,Java’s Arrays.sort method used Quicksort for arrays of primitives  and Merge sort for arrays of objects. 
In the latest versions of Java, Arrays.sort method and Collection.sort() uses Timsort.

QuickSort
=========

QuickSort is a Divide and Conquer algorithm. 

It picks an element as pivot and partitions the given array around the picked pivot. 

There are many different versions of quickSort that pick pivot in different ways.
1)Always pick first element as pivot.
2)Always pick last element as pivot (implemented below)
3)Pick a random element as pivot.
4)Pick median as pivot.

/* 
low  --> Starting index,  
high  --> Ending index 
*/
quickSort(arr[], low, high)
{
    if (low < high)
    {
        /* pi is partitioning index, arr[p] is now at right place */
        pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);  // Before pi
        quickSort(arr, pi + 1, high); // After pi
    }
}