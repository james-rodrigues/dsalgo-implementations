package com.dsa.coding.algo.divideconquer;

public class Fibonacci {

	public int CalculateFibonacci(int n) {
		if (n < 1) {
			System.out.println("Please enter a positive number");
			return Integer.MIN_VALUE;
		} else if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		} else {
			return CalculateFibonacci(n - 1) + CalculateFibonacci(n - 2);
		}
	}

	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
		System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
	}

}
