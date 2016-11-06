/**
 * Trung Vo
 * email: trung.vo@stonybrook.edu
 * ID # 109845485
 * CSE 214 R03
 * Homework 3
 */
package cse214hw3_javascriptFormatter;

public class JSStack {
	/**
	 * JSStacj implements the functions of Stack:
	 * push, pop, peek, size, isEmpty
	 */
	private Node top;
	
	public JSStack() {top = null;}
	public Node getTop() {return top;}
	
	public void push(BlockType b){
		/*
		 * @param BlockType b
		 * 		push a BlockType into stack
		 * 		set the top pointer to the newest element
		 */
		Node node = new Node(b);
		node.setNext(top);
		top = node;
	}
	
	public BlockType pop(){
		/*
		 * @EmptyStackException
		 * 		throws when stack is empty
		 * Pop the top element out of the stack and reset the top pointer
		 */
		try {
			if (top == null)
				throw new EmptyStackException("Stack is empty");
			BlockType ans = top.getData();
			top = top.getNext();
			return ans;
		} catch(EmptyStackException ex) {
			//System.out.println("Stack is empty");
			return null;
		}
	}
	
	public BlockType peek(){
		/*
		 * @return BlockType
		 * 		return the BlockType element on top of stack
		 * @EmptyStackException
		 * 		throws when stack is empty
		 * Return top element but not remove
		 */
		try {
			if (top == null)
				throw new EmptyStackException("Stack is empty");
			return top.getData();
		} catch(EmptyStackException ex) {
			//System.out.println("Stack is empty");
			return null;
		}
	}
	
	public int size() {
		/*
		 * @return int
		 * 		return the size of the stack
		 */
		int n = 0;
		Node nodeStart = top;
		while (nodeStart != null) {
			n++;
			nodeStart = nodeStart.getNext();
		}
		return n;
	}
	
	public boolean isEmpty(){
		/*
		 * @return boolean
		 * 		return a boolean value indicate whether stack is empty or not
		 */
		return (top==null);
	}
}

class EmptyStackException extends Exception {
	public EmptyStackException(String s) {
		super(s);
	}
}
