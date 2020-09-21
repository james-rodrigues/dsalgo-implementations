package com.dsa.coding.ds.graph;

import java.util.ArrayList;
import java.util.Stack;

import com.dsa.coding.ds.common.GraphNode;

class DFSIterative {

	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	public DFSIterative(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}

	/**
	 * Dfs.
	 */
	void dfs() {
		// if a node is unvisited then run dfs on it
		for (GraphNode node : nodeList) {
			if (!node.isVisited())
				dfsVisit(node);
		}
	}

	// dfs traversal by a source node
	void dfsVisit(GraphNode node) {
		// make an empty stack
		Stack<GraphNode> stack = new Stack<>();
		// add source node to stack
		stack.push(node);
		// while queue is not empty
		while (!stack.isEmpty()) {
			// pop a node from stack
			GraphNode presentNode = stack.pop();
			// mark node as visited
			presentNode.setVisited(true);
			// print the node
			System.out.print(presentNode.getName() + " ");
			// for each neighbor of present node
			for (GraphNode neighbor : presentNode.getNeighbors()) {
				// if neighbor is not visited then add it to queue
				if (!neighbor.isVisited()) {

					stack.add(neighbor);
					neighbor.setVisited(true);
				}
			}

		}
	}

	// add an undirected edge between two nodes
	public void addUndirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i - 1);
		GraphNode second = nodeList.get(j - 1);
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
	}

}

public class DFSIterativeApproach {

	public static void main(String[] args) {

		ArrayList<GraphNode> nodeList = new ArrayList<>();

		// create 10 nodes: v1-v10
		for (int i = 1; i < 11; i++) {
			nodeList.add(new GraphNode("V" + i));
		}

		// Constructor
		DFSIterative graph = new DFSIterative(nodeList);

		// add edges following graph in graph.docx
		graph.addUndirectedEdge(1, 2);
		graph.addUndirectedEdge(1, 4);
		graph.addUndirectedEdge(2, 3);
		graph.addUndirectedEdge(2, 5);
		graph.addUndirectedEdge(3, 6);
		graph.addUndirectedEdge(3, 10);
		graph.addUndirectedEdge(4, 7);
		graph.addUndirectedEdge(5, 8);
		graph.addUndirectedEdge(6, 9);
		graph.addUndirectedEdge(7, 8);
		graph.addUndirectedEdge(8, 9);
		graph.addUndirectedEdge(9, 10);

		// dfs from v1
		System.out.println("Printing DFS from source: V1");
		graph.dfs();
	}

}
