
/* Generated By:JJTree: Do not edit this line. ASTInteger.java */
package com.sinosoft.one.data.jade.parsers.sqljep;


/**
 * Constant Node
 */
class ASTConstant extends SimpleNode {
	Comparable value;
	
	public ASTConstant(int id) {
		super(id);
	}
	
	public ASTConstant(Parser p, int id) {
		super(p, id);
	}
	
	/** Accept the visitor. **/
	public Object jjtAccept(ParserVisitor visitor, Object data)  throws ParseException
	{
		return visitor.visit(this, data);
	}
	
	public String toString() {
		return "Constant: " + value;
	}
}
