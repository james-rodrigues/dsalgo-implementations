package com.dsa.coding.ds.common;

import java.util.ArrayList;

import lombok.Data;

@Data
public class GraphNode {

	private String name;

	private int index; // index is used to map this Node's name with index of Adjacency Matrix' cell#

	private ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();

	private boolean isVisited = false;

	private GraphNode parent;

	public GraphNode(String name) {
		super();
		this.name = name;
	}

	public GraphNode(String name, int index) {
		super();
		this.name = name;
		this.index = index;
	}

}
