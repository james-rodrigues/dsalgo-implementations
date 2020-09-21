package com.dsa.coding.ds.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.dsa.coding.ds.common.WeightedNode;

class Prims {

	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

	// Constructor
	public Prims(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}

	// Prim's algorithm from source node
	void prims(WeightedNode node) {
		for (int counter = 0; counter < nodeList.size(); counter++) {
			nodeList.get(counter).setDistance(Integer.MAX_VALUE);
		}
		node.setDistance(0); // Setting '0' distance for Source Vertex

		PriorityQueue<WeightedNode> queue = new PriorityQueue<>();

		queue.addAll(nodeList);
		while (!queue.isEmpty()) {
			WeightedNode presentNode = queue.remove(); // Remove vertex which has min distance

			for (WeightedNode neighbor : presentNode.getNeighbors()) {
				if (queue.contains(neighbor)) {// If vertex is not processed, only then enter in if-else
					// If known weight of this �adjacent vertex� is more than current edge,
					// then update �adjacent vertex�s� distance and parent
					if (neighbor.getDistance() > presentNode.getWeightMap().get(neighbor)) {
						neighbor.setDistance(presentNode.getWeightMap().get(neighbor));
						neighbor.setParent(presentNode);
						queue.remove(neighbor); // Refresh the priority queue
						queue.add(neighbor);
					}
				}
			}
		}

		int cost = 0;
		// print table of node with minimum distance and shortest path from source
		System.out.println("Printing the path taken for minimum spanning tree from node " + node.getName());
		for (WeightedNode nodeToCheck : nodeList) {
			System.out.println("Node " + nodeToCheck.getName() + ", Distance: " + nodeToCheck.getDistance()
					+ ", Parent: " + (null == nodeToCheck.getParent() ? null : nodeToCheck.getParent().getName()));
			cost = cost + nodeToCheck.getDistance();
		}

		System.out.println("\nTotal cost of MST: " + cost);
	}

	// add a weighted undirected edge between two nodes
	public void addWeightedUndirectedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i - 1);
		WeightedNode second = nodeList.get(j - 1);
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
		first.getWeightMap().put(second, d);
		second.getWeightMap().put(first, d);
	}

}

public class PrimsMST {

	public static void main(String[] args) {
		ArrayList<WeightedNode> nodeList = new ArrayList<>();

		// Create 5 nodes: A,B,C,D,E
		for (int i = 0; i < 5; i++) {
			nodeList.add(new WeightedNode("" + (char) (65 + i)));
		}

		Prims graph = new Prims(nodeList);
		graph.addWeightedUndirectedEdge(1, 2, 10); // Add undirected Edge between A-B with Weight 10
		graph.addWeightedUndirectedEdge(1, 3, 20); // Add undirected Edge between A-C with Weight 20
		graph.addWeightedUndirectedEdge(2, 3, 30); // Add undirected Edge between B-C with Weight 30
		graph.addWeightedUndirectedEdge(2, 4, 5); // Add undirected Edge between B-D with Weight 5
		graph.addWeightedUndirectedEdge(3, 4, 15); // Add undirected Edge between C-D with Weight 15
		graph.addWeightedUndirectedEdge(3, 5, 6); // Add undirected Edge between C-E with Weight 6
		graph.addWeightedUndirectedEdge(4, 5, 8); // Add undirected Edge between D-E with Weight 8

		System.out.println("Printing Prim's Algo from source: A");
		graph.prims(nodeList.get(0));

	}

}