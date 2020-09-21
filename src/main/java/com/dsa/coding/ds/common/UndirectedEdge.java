package com.dsa.coding.ds.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UndirectedEdge {
	private WeightedNode first;
	private WeightedNode second;
	private int weight;
}
