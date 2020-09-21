package com.dsa.coding.algo.dynamicprog.bottomup;

public class MinCostToReachLastCell {

	public int findMinCost(int[][] array, int row, int col) {
		int[][] dp = new int[row + 1][col + 1];// This 2D array will store all the results. This Array has 1 extra Row
												// and 1 extra Col
		for (int i = 0; i <= col; i++) { // Initialize default value
			dp[0][i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i <= row; i++) { // Initialize default value
			dp[i][0] = Integer.MAX_VALUE;
		}
		dp[0][1] = 0; // This is done to make sure that first comparison goes through successfully
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				dp[i][j] = Integer.min(dp[i - 1][j], dp[i][j - 1]) + array[i - 1][j - 1];
			}
		}
		return dp[row][col];
	}

	public static void main(String[] args) {
		int[][] array = { { 4, 7, 8, 6, 4 }, { 6, 7, 3, 9, 2 }, { 3, 8, 1, 2, 4 }, { 7, 1, 7, 3, 7 },
				{ 2, 9, 8, 9, 3 } };
		MinCostToReachLastCell mctrlc = new MinCostToReachLastCell();
		System.out.print("The minimum cost is " + mctrlc.findMinCost(array, array.length, array[0].length));
	}
}