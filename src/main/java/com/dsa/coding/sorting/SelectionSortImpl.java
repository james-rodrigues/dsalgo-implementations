package com.dsa.coding.sorting;

import com.dsa.coding.util.ArrayUtils;

public class SelectionSortImpl {

	public static void main(String[] args) {
		int array[] = { 10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8 };

		System.out.println("User entered Array: ");
		ArrayUtils.printArray(array);

		selectionSort(array);

		System.out.println("\n\nAfter sorting: ");
		ArrayUtils.printArray(array);
	}

	static void selectionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int minimumIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[minimumIndex]) // find which is the smallest element to right of 'i'
					minimumIndex = j;
			} // end of inner loop
			if (minimumIndex != i) { // if i is not minimum index then swap
				int temp = a[i];
				a[i] = a[minimumIndex];
				a[minimumIndex] = temp;
			}
		}
	}

}