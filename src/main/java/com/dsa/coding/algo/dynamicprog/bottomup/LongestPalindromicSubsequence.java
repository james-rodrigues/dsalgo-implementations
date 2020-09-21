package com.dsa.coding.algo.dynamicprog.bottomup;

public class LongestPalindromicSubsequence {

	public int findLPSLength(String st) {
		int[][] dp = new int[st.length()][st.length()];
		for (int col = 0; col < st.length(); col++) {
			for (int row = st.length() - 1; row >= 0; row--) {
				if (row > col) { // BASE CASE - If we have traversed more than 1/2 of string then return 0 as we
									// dont need to process it
					dp[row][col] = 0;
				} else if (row == col) { // BASE CASE - If both the index are at same position then its a palindrome as
											// its 1 character.
					dp[row][col] = 1;
				} else {
					if (st.charAt(row) == st.charAt(col)) {
						dp[row][col] = Math.max(2 + dp[row + 1][col - 1], Math.max(dp[row][col - 1], dp[row + 1][col]));
					} else {
						dp[row][col] = Math.max(dp[row][col - 1], dp[row + 1][col]);
					}
				}
			}
		}
		return dp[0][st.length() - 1];
	}

	public static void main(String[] args) {
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		System.out.println("Longest Palindromic Substring: " + lps.findLPSLength("elrmenmet"));
	}
}