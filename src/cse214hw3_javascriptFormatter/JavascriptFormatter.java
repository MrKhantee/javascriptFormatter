/**
 * Trung Vo
 * email: trung.vo@stonybrook.edu
 * ID # 109845485
 * CSE 214 R03
 * Homework 3
 */
package cse214hw3_javascriptFormatter;

public class JavascriptFormatter {
	/*
	 * Main function for javascript formatter.
	 * Detection of parenthesis, braces, indent level are managed by this class.
	 */
	private JSStack stack;
	private int indentLevel;
	private String s;
	private BlockType blocktype;
	private BlockType BRACE;
	private BlockType PAREN;
	private BlockType FOR;
	private int f; 				//used for detecting "for()" blocktype 
	private BlockType type;
	
	public JavascriptFormatter() {
		//constructor
		
		stack = new JSStack();
		indentLevel = 0;
		s = "";
		blocktype = new BlockType();
		BRACE = new BlockType();
		PAREN = new BlockType();
		FOR = new BlockType();
	}
	
	public String format(String input) {
		/*
		 * implementation in formatting javascript file.
		 * @param input
		 * 		unformatted input string is passed in to process
		 * @return String
		 * 		a formatted input string
		 */
		for (int i=0; i<input.length(); i++) {
			if (input.charAt(i)=='f'&&input.charAt(i+1)=='o'&&input.charAt(i+2)=='r') {
				f = i+3;
				while (input.charAt(f) != '(') {f++;}
				blocktype.setFor(FOR);
				stack.push(blocktype.getFor());
			}
			if (input.charAt(i) == '{' || input.charAt(i) == '}') {
				if (input.charAt(i) == '{') {
					s += "{\n";
					blocktype.setBrace(BRACE);
					stack.push(blocktype.getBrace());
				} 
				indentLevel += (input.charAt(i)=='{')? 1:-1;
				
				for (int j=1; j<= indentLevel; j++)
					s += "\t";
				
				s += (input.charAt(i)=='{')? "":"}\n";
				
				if (input.charAt(i) == '}') {
					if (stack.isEmpty()) {
						s += "\n\n //ERROR: Extra curly brace found.";
						break;
					} else {
						if (stack.peek() != (BlockType)BRACE) {
							s += "\n\n//ERROR: Extra curly brace found.";
							break;
						} else
							stack.pop();
					}
				} 
			} else if (input.charAt(i) == '(' || input.charAt(i) == ')') {
				if (input.charAt(i) == '(') {
					if (stack.peek() != (BlockType)FOR) {
						blocktype.setParen(PAREN);
						stack.push(blocktype.getParen());
					}
					s += "(";
				} else {
					s += ")";
					if (stack.isEmpty()) {
						s += "\n\n//ERROR: Extra parenthesis found.";
						break;
					} else {
						if (stack.peek() != (BlockType)FOR && stack.peek() != (BlockType)PAREN) {
							s += "\n\n//ERROR: Extra parenthesis found.";
							break;
						} else 
							stack.pop();
					}
				}
			} else if (input.charAt(i) == ';') {
				s += ";";
				if (stack.peek() != (BlockType)FOR)
					s += "\n";
			} else {
				if (!stack.isEmpty() && i>0 && (input.charAt(i-1)==';' || 
									input.charAt(i-1)=='}') && stack.peek() != (BlockType)FOR) {
					for (int j=1; j<=indentLevel; j++)
						s += "\t";
				}
				s += Character.toString(input.charAt(i));
			}
		}
		return toString();
	}
	
	public String toString() {
		return s + "\n--Thank you for making your code readable!---";
	}
	
}
