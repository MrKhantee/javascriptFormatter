/**
 * Trung Vo
 * email: trung.vo@stonybrook.edu
 * ID # 109845485
 * CSE 214 R03
 * Homework 3
 */
package cse214hw3_javascriptFormatter;

public class Node {
	/*
	 * Node class is used for implementing a single node in a linked list of stack
	 */
	private BlockType data;		//type of block
	private Node next;			//link to next node
	
	public Node(BlockType data) {
		/*
		 * Constructor for Node class
		 * @param data
		 * 		type of block
		 * @IllegalArgumentException
		 * 		throws when data is null
		 */
		try {
			if (data == null)
				throw new IllegalArgumentException("This initial stop can't be null.");
			this.data = data;
			next = null;
		} catch (IllegalArgumentException ex) {
			System.out.println("This initial stop can't be null.");
		}
	}
	
	public void setNext(Node newNext) {next = newNext;}		//mutator for next (link)
	public Node getNext() {return next;}					//accessor for next (link)
	public void setData(BlockType data) throws CloneNotSupportedException {		//mutator for data 
		/*
		 * @param data
		 * 		type of block
		 * @IllegalArgumentException
		 * 		throws when data is null
		 */
		try {
			if (data == null)
				throw new IllegalArgumentException("This new stop can't be null.");
			this.data = (BlockType)(data.clone());
		} catch (IllegalArgumentException ex) {
			System.out.println("This new stop can't be null.");
		}
	}
	public BlockType getData() {return data;}				//accessor for data
}
