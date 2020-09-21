package com.dsa.coding.ds.linkedlist;

import com.dsa.coding.ds.common.SingleNode;

import lombok.Data;

@Data
class SingleCircularLinkedList<T> {

	private SingleNode<T> head;

	private SingleNode<T> tail;

	private int size;// denotes size of list

	SingleNode<T> createSingleLinkedList(T nodeValue) {
		head = new SingleNode<T>();
		SingleNode<T> node = new SingleNode<T>();
		node.setValue(nodeValue);
		node.setNext(node);
		head = node;
		tail = node;
		size = 1;// size =1
		return head;
	}

	void insertInLinkedList(T nodeValue, int location) {
		SingleNode<T> node = new SingleNode<T>();
		node.setValue(nodeValue);
		System.out.println("Inserting new node at location: " + location);
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return; // Linked List does not exists
		} else if (location == 0) {// insert at first position
			node.setNext(head);
			head = node;
			tail.setNext(node); // update tail
		} else if (location >= size) {// insert at last position
			tail.setNext(node);
			tail = node; // to keep track of last node
			tail.setNext(head); // update tail to circularly point head
		} else // insert at specified location
		{
			SingleNode<T> tempNode = head;
			int index = 0;
			while (index < location - 1) {// loop till we reach specified node
				tempNode = tempNode.getNext();
				index++;
			} // insert new node after tempNode
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
		}
		size++;
	}

	public boolean existsLinkedList() {
		// if head is not null return true otherwise return false
		return head != null;
	}

	// Traverse Linked List
	void traverseLinkedList() {
		if (existsLinkedList()) {
			SingleNode<T> tempNode = head;
			for (int i = 0; i < size; i++) {

				System.out.print(tempNode.getValue());
				if (i != size - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
			System.out.println("\n");
		} else {
			System.out.println("\nLinked List does not exists !");
		}
	}

	// Traverse Linked List
	void printHeadUsingTail() {
		if (existsLinkedList()) {
			System.out.println("Printing Tail...");
			System.out.println(tail.getValue());

			System.out.println("Printing Head using Head reference...");
			System.out.println(head.getValue());

			System.out.println("Printing Head using Tail reference...");
			System.out.println(tail.getNext().getValue());

		} else {
			System.out.println("Linked List does not exists");
		}
	}

	// Delete linked list
	void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		head = null;
		if (tail == null) {
			System.out.println("Linked List is already deleted, nothing to delete !");
			return;
		} else {
			tail.setNext(null);
			tail = null;
			System.out.println("Linked List deleted successfully !");
		}
	}

	// Search given value in Linked List
	boolean searchNode(T nodeValue) {
		if (existsLinkedList()) {
			SingleNode<T> tempNode = head;
			for (int i = 0; i < size; i++) {

				// System.out.print(tempNode.value);
				if (tempNode.getValue() == nodeValue) {
					System.out.print("Found the node at location: " + i);
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.print("Node not found!! ");

		return false;
	}

	public void deletionOfNode(int location) {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");// Linked List does not exists
			return;
		} else if (location == 0) { // we want to delete first element
			head = head.getNext();
			tail.setNext(head);
			setSize(getSize() - 1);
			if (getSize() == 0) { // if there are no more nodes in this list
				tail = null;
			}
		} else if (location >= getSize()) { // If location is not in range or equal, then delete last node
			SingleNode<T> tempNode = head;
			for (int i = 0; i < size - 1; i++) {
				tempNode = tempNode.getNext(); // temp node points to 2nd last node
			}
			if (tempNode == head) { // if this is the only element in the list
				tail = head = null;
				setSize(getSize() - 1);
				return;
			}
			tempNode.setNext(head);
			tail = tempNode;
			setSize(getSize() - 1);

		} else { // if any inside node is to be deleted
			SingleNode<T> tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // we need to traverse till we find the location
			}
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			setSize(getSize() - 1);
		}

	}

}

public class SingleCircularLinkedListImpl {

	public static void main(String[] args) {
		SingleCircularLinkedList<Integer> list = new SingleCircularLinkedList<Integer>();
		list.createSingleLinkedList(5);
		list.insertInLinkedList(10, 1);
		list.insertInLinkedList(20, 2);
		list.insertInLinkedList(30, 3);
		list.insertInLinkedList(40, 4);

		System.out.println("Linked List now: ");
		list.traverseLinkedList();

		list.insertInLinkedList(35, 4);
		list.traverseLinkedList();

		list.insertInLinkedList(1, 0);
		list.traverseLinkedList();

		list.insertInLinkedList(100, 10);
		list.traverseLinkedList();

		list.printHeadUsingTail();

		System.out.println("Searching the node having value 40: ");
		list.searchNode(40);

		System.out.println("\n\nSearching the node having value 200: ");
		list.searchNode(200);

		System.out.println("\n\nDeleting the node having location = 2: ");
		System.out.println("Before deletion...");
		list.traverseLinkedList();
		list.deletionOfNode(2);
		System.out.println("After deletion...");
		list.traverseLinkedList();

		System.out.println("\n\nDeleting the node having location = 0: ");
		System.out.println("Before deletion...");
		list.traverseLinkedList();
		list.deletionOfNode(0);
		System.out.println("After deletion...");
		list.traverseLinkedList();

		System.out.println("\n\nDeleting the node having location = 15: ");
		System.out.println("Before deletion...");
		list.traverseLinkedList();
		list.deletionOfNode(15);
		System.out.println("After deletion...");
		list.traverseLinkedList();

		System.out.println("\n\nDeleting the node having location = 15: ");
		System.out.println("Before deletion...");
		list.traverseLinkedList();
		list.deletionOfNode(15);
		System.out.println("After deletion...");
		list.traverseLinkedList();

		list.deleteLinkedList();
		list.traverseLinkedList();

	}
}