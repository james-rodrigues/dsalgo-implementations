package com.dsa.coding.ds.common;

import lombok.Data;

@Data
public class DoubleNode<T> {

	private T value;

	private DoubleNode<T> next;

	private DoubleNode<T> prev;

}
