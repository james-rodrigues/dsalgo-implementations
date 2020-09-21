package com.dsa.coding.algo.divideconquer;

public class ZeroOneKnapsack {

	public int knapsack(int[] profits, int[] weights, int capacity) {
		return this.knapsackAux(profits, weights, capacity, 0);
	}

	private int knapsackAux(int[] profits, int[] weights, int capacity, int currentIndex) {
		if (capacity <= 0 || currentIndex < 0 || currentIndex >= profits.length)// Base case
			return 0;

		int profit1 = 0;
		if (weights[currentIndex] <= capacity) // Taking current element
			profit1 = profits[currentIndex]
					+ knapsackAux(profits, weights, capacity - weights[currentIndex], currentIndex + 1);

		int profit2 = knapsackAux(profits, weights, capacity, currentIndex + 1); // Not taking current element
		return Math.max(profit1, profit2);
	}

	public static void main(String[] args) {
		ZeroOneKnapsack ks = new ZeroOneKnapsack();
		int[] profits = { 31, 26, 72, 17 };
		int[] weights = { 3, 1, 5, 2 };
		int maxProfit = ks.knapsack(profits, weights, 7);
		System.out.println(maxProfit);
	}
}