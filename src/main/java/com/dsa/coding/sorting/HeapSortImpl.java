package com.dsa.coding.sorting;

import com.dsa.coding.ds.heap.HeapArrayImpl;
import com.dsa.coding.util.ArrayUtils;

public class HeapSortImpl {

	public static void main(String[] args) {

		int arr[] = { 10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8 };

		System.out.println("User entered Array: ");
		ArrayUtils.printArray(arr);
		System.out.println("\n");

		heapsort(arr);

		System.out.println("\n\nAfter sorting: ");
		ArrayUtils.printArray(arr);
	}

	static void heapsort(int[] arr) {
		HeapArrayImpl hba = new HeapArrayImpl(arr.length); // We will reuse HeapByArray class to do sorting
		for (int i = 0; i < arr.length; i++) { // Insert in Heap
			hba.insertInHeap(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) { // Extract from Heap and insert sorted data in current Array
			arr[i] = hba.extractHeadOfHeap();
		}
	}
}