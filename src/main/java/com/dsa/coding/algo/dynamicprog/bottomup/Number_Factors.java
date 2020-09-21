package com.dsa.coding.algo.dynamicprog.bottomup;

/**
 * The Class Number_Factors_BottomUp.
 */
public class Number_Factors {

	public int waysToGetN(int n) {
		int dp[] = new int[n + 1];
		dp[0] = dp[1] = dp[2] = 1; // BaseCases
		dp[3] = 2; // BaseCases

		for (int i = 4; i <= n; i++)
			dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];

		return dp[n];
	}

	public static void main(String[] args) {
		Number_Factors en = new Number_Factors();
		System.out.println(en.waysToGetN(4));
		System.out.println(en.waysToGetN(5));
		System.out.println(en.waysToGetN(6));
	}
}