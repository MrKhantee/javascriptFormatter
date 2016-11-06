/**
 * Trung Vo
 * email: trung.vo@stonybrook.edu
 * ID # 109845485
 * CSE 214 R03
 * Homework 3
 */
package cse214hw3_javascriptFormatter;

public class BlockType implements Cloneable{
	/*
	 * BlockType class is used for implementation of Block level
	 * in formatting javascript code.
	 */
	private BlockType BRACE;		//use for curly braces
	private BlockType PAREN;		//use for parenthesis
	private BlockType FOR;			//use for "for" loop
	
	public BlockType() {
		/*
		 * Constructor initializes 3 types of block
		 */
		BRACE = null;
		PAREN = null;
		FOR = null;
	}
	
	/*
	 * Mutators for setting three data fields above
	 */
	public void setBrace(BlockType BRACE){this.BRACE = BRACE;}
	public void setParen(BlockType PAREN){this.PAREN = PAREN;}
	public void setFor(BlockType FOR){this.FOR = FOR;}
	
	/*
	 * @return BlockType
	 * 		return a type of block
	 * Accessors for getting three data fields above
	 */
	public BlockType getBrace() {return BRACE;}
	public BlockType getParen() {return PAREN;}
	public BlockType getFor() {return FOR;}
	
	@Override
	public Object clone() {
		/*
		 * Deep copy three data fields of BlockType
		 * @return Object
		 * 		return an object of type of BlockType with brace, parenthesis, for loop
		 * @CloneNotSupportedException
		 * 		throws when errors occured in cloning
		 */
		try {
			BlockType blocktype = (BlockType)(super.clone());
			if (getBrace() != null)
				blocktype.setBrace(getBrace());
			if (getParen() != null)
				blocktype.setParen(getParen());
			if (getFor() != null)
				blocktype.setFor(getFor());
			return blocktype;
		} catch (CloneNotSupportedException ex) {
			System.out.println("Errors in clone.");
			return null;
		}
	}
}
