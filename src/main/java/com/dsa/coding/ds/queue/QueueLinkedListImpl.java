package com.dsa.coding.ds.queue;

import com.dsa.coding.ds.linkedlist.SingleLinkedList;

class QueueByLinkedList<T> {

	SingleLinkedList<T> list;

	// constructor
	public QueueByLinkedList() {
		list = new SingleLinkedList<T>();
	}

	public void enQueue(T value) {
		if (list.getHead() == null) {
			list.createSingleLinkedList(value);
		} else {
			// push a value on last of queue, update list tail too
			list.insertInLinkedList(value, list.getSize());
		}
	}

	public T deQueue() {
		T value = null;
		if (isQueueEmpty()) {
			System.out.println("Queue underflow error!!");
		} else {
			value = (T) list.getHead().getValue();
			list.deletionOfNode(0);
		}
		return value;
	}

	public T peek() {
		if (!isQueueEmpty())
			return (T) list.getHead().getValue();
		else {
			System.out.println("The queue is empty!!");
			return null;
		}
	}

	public boolean isQueueEmpty() {
		if (list.getHead() == null)
			return true;
		else
			return false;
	}

	public void deleteStack() {
		list.setHead(null);
	}

}

public class QueueLinkedListImpl {

	public static void main(String[] args) {

		System.out.println("Creating a queue");
		QueueByLinkedList<Integer> queue = new QueueByLinkedList<Integer>();

		System.out.println("Enqueueing 6 values into queue");
		for (int i = 1; i <= 6; i++) {
			queue.enQueue(i * 10);
		}
		System.out.println();

		System.out.println("Peeking value");
		System.out.println(queue.peek());
		System.out.println();

		System.out.println("Dequeueing 6 values into queue");
		for (int i = 0; i < 6; i++) {
			System.out.println(queue.deQueue());
		}

	}

}
