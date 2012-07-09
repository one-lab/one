package net.paoding.rose.web.instruction.reply;

import java.io.IOException;

import javax.servlet.ServletException;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.instruction.AbstractInstruction;

public class ReplyInstruction extends AbstractInstruction {
	private final Reply<?> reply;
	public ReplyInstruction() {reply = Reply.NO_REPLY;}
	public ReplyInstruction(Reply<?> reply) {
		this.reply = reply;
	}
	@Override
	protected void doRender(Invocation inv) throws IOException,
			ServletException, Exception {
		reply.populate(inv);
	}

}
