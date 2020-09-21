package com.dsa.coding.sorting;

import com.dsa.coding.util.ArrayUtils;

public class InsertionSortImpl {

	public static void main(String[] args) {

		int array[] = { 10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8 };

		System.out.println("User entered Array: ");
		ArrayUtils.printArray(array);

		long start = System.nanoTime();
		insertionSort(array);
		long end = System.nanoTime();
		System.out.println("\n\nTime to execute this algo: " + (end - start));

		System.out.println("\nAfter sorting: ");
		ArrayUtils.printArray(array);
	}

	static void insertionSort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			int tmp = A[i], j = i;
			while (j > 0 && A[j - 1] > tmp) {
				A[j] = A[j - 1];
				j--;
			}
			A[j] = tmp;
		}
	}

}