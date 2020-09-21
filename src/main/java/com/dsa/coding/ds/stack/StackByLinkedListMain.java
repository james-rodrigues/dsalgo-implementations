package com.dsa.coding.ds.stack;

import com.dsa.coding.ds.linkedlist.SingleLinkedList;

class StackByLinkedList<T> {

	SingleLinkedList<T> list;

	// constructor
	public StackByLinkedList() {
		list = new SingleLinkedList<T>();
	}

	public void push(T value) {
		if (list.getHead() == null) {
			list.createSingleLinkedList(value);
		} else {
			list.insertInLinkedList(value, 0);
		}
		System.out.println("Inserted " + value + " in Stack !");
	}

	public T pop() {
		T value = null;
		if (isEmpty()) {
			System.out.println("Stack underflow error!!");
		} else {
			value = (T) list.getHead().getValue();
			list.deletionOfNode(0);
		}
		return value;
	}

	public boolean isEmpty() {
		if (list.getHead() == null)
			return true;
		else
			return false;
	}

	public T peek() {
		if (!isEmpty())
			return (T) list.getHead().getValue();
		else {
			System.out.println("The stack is empty!!");
			return null;
		}
	}

	public void deleteStack() {
		list.setHead(null);
	}
}

public class StackByLinkedListMain {

	public static void main(String[] args) {

		StackByLinkedList<Integer> stack = new StackByLinkedList<Integer>();

		System.out.println("Pushing 10 values into stack");
		for (int i = 1; i <= 10; i++) {
			stack.push(i * 10);
		}
		System.out.println();

		System.out.println("Peeking value");
		System.out.println(stack.peek());
		System.out.println();

		System.out.println("Poping 11 values from stack");
		for (int i = 1; i <= 11; i++) {
			System.out.println(stack.pop());
		}
		System.out.println();

	}

}