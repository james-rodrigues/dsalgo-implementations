package com.dsa.coding.ds.graph;

import java.util.ArrayList;

import com.dsa.coding.ds.common.WeightedNode;

class BellmanFord {

	// Will store all the vertices
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

	// Constructor
	public BellmanFord(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
		for (WeightedNode aNode : nodeList) {
			aNode.setDistance(Integer.MAX_VALUE / 10);
		}
	}

	// BellmanFord from a source node
	void bellmanFord(WeightedNode sourceNode) {
		sourceNode.setDistance(0); // set source distance to zero

		for (int i = 1; i < nodeList.size(); i++) { // repeat n-1 times
			for (WeightedNode presentNode : nodeList) { // for each Vertex
				for (WeightedNode neighbor : presentNode.getNeighbors()) { // for each Neighbor
					// if distance of neighbor is greater than tentative new path then
					// update distance of neighbor with new parent as presentNode
					if (neighbor
							.getDistance() > (presentNode.getDistance() + presentNode.getWeightMap().get(neighbor))) {
						neighbor.setDistance((presentNode.getDistance() + presentNode.getWeightMap().get(neighbor)));
						neighbor.setParent(presentNode);
					}
				}
			}
		}

		System.out.println("Checking for Negative Cycle ...");

		for (WeightedNode presentNode : nodeList) {
			for (WeightedNode neighbor : presentNode.getNeighbors()) {
				// if distance of neighbor is greater than tentative new path then we have a
				// negative cycle, return from here..
				if (neighbor.getDistance() > (presentNode.getDistance() + presentNode.getWeightMap().get(neighbor))) {
					System.out.println("Negative cycle found: \n");
					System.out.println("Vertex Name: " + neighbor.getName());
					System.out.println("Old Distance: " + neighbor.getDistance());
					int newDistance = presentNode.getDistance() + presentNode.getWeightMap().get(neighbor);
					System.out.println("New distance: " + newDistance);
					return;
				}
			}
		}
		System.out.println("Negative cycle not found !");

		System.out.println("\n\nPrinting Paths now: ");
		for (WeightedNode nodeToCheck : nodeList) {
			if (nodeToCheck.getDistance() != Integer.MAX_VALUE / 10) {
				System.out.print(
						"Node " + nodeToCheck.getName() + ", distance: " + nodeToCheck.getDistance() + ", Path: ");
				pathPrint(nodeToCheck);
			} else {
				System.out.print("No path for node " + nodeToCheck.getName());
			}
			System.out.println();
		}
	}

	// Printing path
	private static void pathPrint(WeightedNode node) {
		if (node.getParent() != null) {
			pathPrint(node.getParent());
			System.out.print("->" + node.getName());
		} else
			System.out.print(node.getName());
	}

	// add a weighted edge between two nodes
	public void addWeightedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i - 1);
		WeightedNode second = nodeList.get(j - 1);
		first.getNeighbors().add(second);
		first.getWeightMap().put(second, d);
	}

}

public class SSSPBellmanFord {

	public static void main(String[] args) {

		ArrayList<WeightedNode> nodeList = new ArrayList<>();

		// create 5 nodes: A,B,C,D,E
		for (int i = 0; i < 5; i++) {
			nodeList.add(new WeightedNode("" + (char) (65 + i)));
		}

		// Constructor
		BellmanFord graph = new BellmanFord(nodeList);

		graph.addWeightedEdge(1, 3, 6); // Add A-> C , weight 6
		graph.addWeightedEdge(2, 1, 3); // Add B-> A , weight 3
		graph.addWeightedEdge(1, 4, 6); // Add A-> D , weight 6
		// graph.addWeightedEdge(1,4,-6); //Add A-> D , weight -6 TEST NEGATIVE WEIGHT
		// HERE
		graph.addWeightedEdge(4, 3, 1); // Add D-> C , weight 1
		graph.addWeightedEdge(3, 4, 2); // Add C-> D , weight 2
		graph.addWeightedEdge(4, 2, 1); // Add D-> B , weight 1
		graph.addWeightedEdge(5, 4, 2); // Add E-> D , weight 2
		graph.addWeightedEdge(5, 2, 4); // Add E-> B , weight 4

		graph.bellmanFord(nodeList.get(4));

	}
}