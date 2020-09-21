package com.dsa.coding.algo.dynamicprog.topdown;

/**
 * The Class House_Thieft_TopDown.
 */
public class House_Thief {

	public int maxMoney(int[] HouseNetWorth) {
		int dp[] = new int[HouseNetWorth.length];
		return maxMoney_TopDown(dp, HouseNetWorth, 0);
	}

	private int maxMoney_TopDown(int[] dp, int[] HouseNetWorth, int currentIndex) {
		if (currentIndex >= HouseNetWorth.length)
			return 0;

		if (dp[currentIndex] == 0) {
			int stealCurrent = HouseNetWorth[currentIndex] + maxMoney_TopDown(dp, HouseNetWorth, currentIndex + 2);
			int skipCurrent = maxMoney_TopDown(dp, HouseNetWorth, currentIndex + 1);
			dp[currentIndex] = Math.max(stealCurrent, skipCurrent);
		}
		return dp[currentIndex];
	}

	public static void main(String[] args) {
		House_Thief ht = new House_Thief();
		int[] HouseNetWorth = { 6, 7, 1, 30, 8, 2, 4 };
		System.out.println(ht.maxMoney(HouseNetWorth));
		HouseNetWorth = new int[] { 20, 5, 1, 13, 6, 11, 40 };
		System.out.println(ht.maxMoney(HouseNetWorth));
	}
}
