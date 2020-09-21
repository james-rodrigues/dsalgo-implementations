package com.dsa.coding.algo.dynamicprog.topdown;

public class Number_Factors {

	public int waysToGetN(int n) {
		int dp[] = new int[n + 1];
		return waysToGetN_TopDown(dp, n);
	}

	public int waysToGetN_TopDown(int[] dp, int n) {
		if ((n == 0) || (n == 1) || (n == 2)) // { }, {1}, {1,1}
			return 1;
		if (n == 3)
			return 2; // {1,1,1}, {3}

		if (dp[n] == 0) {
			int subtract1 = waysToGetN_TopDown(dp, n - 1);// if we subtract 1, we will be left with 'n-1'
			int subtract3 = waysToGetN_TopDown(dp, n - 3);// if we subtract 3, we will be left with 'n-3'
			int subtract4 = waysToGetN_TopDown(dp, n - 4);// if we subtract 4, we will be left with 'n-4'

			dp[n] = subtract1 + subtract3 + subtract4;
		}

		return dp[n];
	}

	public static void main(String[] args) {
		Number_Factors en = new Number_Factors();
		System.out.println(en.waysToGetN(4));
		System.out.println(en.waysToGetN(5));
		System.out.println(en.waysToGetN(6));
	}
}