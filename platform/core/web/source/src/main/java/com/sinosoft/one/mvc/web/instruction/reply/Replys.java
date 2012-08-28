package com.sinosoft.one.mvc.web.instruction.reply;

public final class Replys {
	private Replys() {}
	public static final Reply NO_REPLY = Replys.saying();
	
	public static final String NO_REPLY_ATTR = "sb_no_reply";
	/**
	   * Convenience method to make a reply without any entity or body. Example, to send a redirect:
	   * <pre>
	   *   return Reply.saying().redirect("/other");
	   * </pre>
	   */
	  public static UriReply saying() {
	    return new UriReplyMaker();
	  }

	  /**
	   * Returns a reply with an entity that is sent back to the client via the specified
	   * transport.
	   *
	   * @param entity An entity to send back for which a valid transport exists (see
	   *   {@link #as(Class)}).
	   */
	  public static <E> EntityReply<E> with(E entity) {
	    return new EntityReplyMaker<E>(entity);
	  }
	  
	  public static SimpleJsonReply simple() {
		  return new SimpleJsonReplyMaker();
	  }
}
