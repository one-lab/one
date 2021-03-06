/* Generated By:JJTree: Do not edit this line. ASTFunNode.java */
package com.sinosoft.one.data.jade.parsers.sqljep;


import com.sinosoft.one.data.jade.parsers.sqljep.function.PostfixCommandI;

/**
 * Function Node
 */
public class ASTFunNode extends SimpleNode {
	
	/** The function class used to evaluate the node */
	private PostfixCommandI pfmc;
	
	/** Name of the function */
	private String name;
	
	/**
	 * Creates a new ASTFunNode
	 */
	public ASTFunNode(int id) {
		super(id);
	}
	
	/**
	 * Creates a new ASTFunNode
	 */
	public ASTFunNode(Parser p, int id) {
		super(p, id);
	}
	
	/**
	 * Accept the visitor.
	 */
	public Object jjtAccept(ParserVisitor visitor, Object data) throws ParseException {
		return visitor.visit(this, data);
	}

	/**
	 * Sets the function for a node. A name and function class must
	 * be specified.
	 */	
	public void setFunction(String name_in, PostfixCommandI pfmc_in) {
		name = name_in;
		pfmc = pfmc_in;
	}

	/**
	 * Returns a string containing the function name.
	 */
	public String toString() {
		return "Function \"" + name + "\"";
	}

	/**
	 * Returns the math command class associated with this node.
	 */
	public PostfixCommandI getPFMC() {
		return pfmc;
	}
	
	/**
	 * Returns the name of the node (operator symbol or function name).
	 */
	public String getName() {
		return name;
	}
}
