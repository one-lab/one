package com.sinosoft.one.mvc.crypto.wapper;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: Morgan
 * Date: 12-11-12
 * Time: 下午4:30
 */
public class CryptoResponseWapper extends HttpServletResponseWrapper {
	/**
	 * Constructs a response adaptor wrapping the given response.
	 *
	 * @throws IllegalArgumentException if the response is null
	 */
	public CryptoResponseWapper(HttpServletResponse response) {
		super(response);
	}
	//@todo 解决ajax的返回加密

	@Override
	public PrintWriter getWriter() throws IOException {
		return super.getWriter();
	}
}
