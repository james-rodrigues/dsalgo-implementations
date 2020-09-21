package com.dsa.coding.ds.graph;

import java.util.ArrayList;
import java.util.Stack;

import com.dsa.coding.ds.common.GraphNode;

class TopologicalSort {

	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	// Constructor
	public TopologicalSort(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}

	/**
	 * Topological sort.
	 */
	void topologicalSort() {
		Stack<GraphNode> stack = new Stack<>();
		for (GraphNode node : nodeList) { // if a node is unvisited then run topologicalSort on it
			if (!node.isVisited())
				topologicalVisit(node, stack);
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().getName() + " ");
		}
	}

	// Topological visit by a source node
	void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
		for (GraphNode neighbor : node.getNeighbors()) { // if neighbor is not visited then recursive call to it
			if (!neighbor.isVisited()) {
				topologicalVisit(neighbor, stack);
			}
		}
		node.setVisited(true);
		stack.push(node);
	}

	// add a directed edge between two nodes
	public void addDirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i - 1);
		GraphNode second = nodeList.get(j - 1);
		first.getNeighbors().add(second);
	}

}

public class TopologicalSortImpl {
	public static void main(String[] args) {
		// Initialize a Arraylist for storing all the graph nodes
		ArrayList<GraphNode> nodeList = new ArrayList<>();

		// create 10 nodes: v1-v10
		for (int i = 1; i < 9; i++) {
			nodeList.add(new GraphNode("V" + i));
		}

		// Constructor
		TopologicalSort graph = new TopologicalSort(nodeList);

		// add edges
		graph.addDirectedEdge(1, 3);
		graph.addDirectedEdge(2, 4);
		graph.addDirectedEdge(2, 3);
		graph.addDirectedEdge(3, 5);
		graph.addDirectedEdge(4, 6);
		graph.addDirectedEdge(5, 6);
		graph.addDirectedEdge(6, 7);
		graph.addDirectedEdge(5, 8);

		// Performing Topologically sort
		graph.topologicalSort();

	}
}
