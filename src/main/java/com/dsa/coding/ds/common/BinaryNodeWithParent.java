package com.dsa.coding.ds.common;

import lombok.Data;

@Data
public class BinaryNodeWithParent {

	private int value;

	private BinaryNodeWithParent parent;

	private BinaryNodeWithParent left;

	private BinaryNodeWithParent right;

}
