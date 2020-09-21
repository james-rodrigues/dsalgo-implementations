package com.dsa.coding.sorting;

import com.dsa.coding.util.ArrayUtils;

/**
 * The Class BubbleSortMain.
 */
public class BubbleSortImpl {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		int arr[] = { 10, 5, 30, 15, 50, 6 };
		System.out.println("Array to be sorted...");
		ArrayUtils.printArray(arr);

		bubbleSort(arr);

		System.out.println("Sorted Array...");
		ArrayUtils.printArray(arr);

	}

	static void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) { // run from first cell to last cell
			for (int j = 0; j < n - i - 1; j++) {// run from first cell to "last cell - iteration"
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}