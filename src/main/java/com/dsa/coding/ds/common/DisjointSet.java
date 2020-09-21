package com.dsa.coding.ds.common;

import java.util.ArrayList;

import lombok.Data;

@Data
public class DisjointSet {

	/** The nodes. */
	private ArrayList<WeightedNode> nodes = new ArrayList<>();

	public static void driver(ArrayList<WeightedNode> nodeList) {
		makeSet(nodeList); // Create Disjoint Sets for each node in this list.
		for (int i = 0; i < nodeList.size() - 1; i++) {
			WeightedNode firstNode = nodeList.get(i);
			WeightedNode secondNode = nodeList.get(i + 1);
			System.out.println("Checking if node " + firstNode.getName() + " and " + secondNode.getName()
					+ " belongs to different set, if yes, will Union them...");
			System.out.println("\nFirst Set name is: " + firstNode.getName());
			firstNode.getSet().printAllNodesOfThisSet();
			System.out.println("\nSecond Set name is: " + secondNode.getName());
			secondNode.getSet().printAllNodesOfThisSet();
			if (!findSet(firstNode).equals(findSet(secondNode))) {
				System.out.println("\nMaking union " + firstNode.getName() + " and " + secondNode.getName());
				DisjointSet unionedSet = union(firstNode, secondNode);
				unionedSet.printAllNodesOfThisSet();
			}
			System.out.println("\n**************************************\n");
		}
	}

	public static void makeSet(ArrayList<WeightedNode> nodeList) {
		// for each node in list, create a disjoint set
		for (WeightedNode node : nodeList) {
			DisjointSet set = new DisjointSet();
			set.getNodes().add(node);
			node.setSet(set);// Storing the reference of this Disjoint set in Node class
		}
	}

	public static DisjointSet getSet(WeightedNode node) {
		return node.getSet();
	}

	public static DisjointSet findSet(WeightedNode node) {
		return node.getSet();
	}

	public static DisjointSet union(WeightedNode node1, WeightedNode node2) {
		if (node1.getSet().equals(node2.getSet())) { // if two nodes are of same set then no union needed
			return null;
		} else {
			// get set object of two nodes
			DisjointSet set1 = node1.getSet();
			DisjointSet set2 = node2.getSet();
			// if first set is bigger then update each node of second set to merge to set1
			if (set1.getNodes().size() > set2.getNodes().size()) {
				ArrayList<WeightedNode> nodeSet2 = set2.getNodes();
				for (WeightedNode node : nodeSet2) { // update each node of second set to merge to set1
					node.setSet(set1);
					set1.getNodes().add(node);
				}
				return set1;
			} else {
				// if second set is bigger/equal then update each node of first set to merge to
				// set2
				ArrayList<WeightedNode> nodeSet1 = set1.getNodes();
				for (WeightedNode node : nodeSet1) {// update each node of first set to merge to set2
					node.setSet(set2);
					set2.getNodes().add(node);
				}
				return set2;
			}
		}
	}

	public void printAllNodesOfThisSet() {
		System.out.println("Printing all nodes of the set: ");
		for (WeightedNode node : nodes) {
			System.out.print(node.getName() + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		// Constructor for ArrayList
		ArrayList<WeightedNode> nodeList = new ArrayList<>();

		// create 10 nodes: 1-10
		for (int i = 0; i < 10; i++) {
			nodeList.add(new WeightedNode("" + (char) (65 + i)));
		}

		// Calling DisjointSet
		driver(nodeList);

	}

}