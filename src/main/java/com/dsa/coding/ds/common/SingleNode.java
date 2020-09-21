package com.dsa.coding.ds.common;

import lombok.Data;

@Data
public class SingleNode<T> {

	private T value;

	private SingleNode<T> next;

}
