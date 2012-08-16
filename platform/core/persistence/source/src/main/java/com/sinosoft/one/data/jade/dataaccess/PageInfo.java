package com.sinosoft.one.data.jade.dataaccess;

import java.util.List;

public class PageInfo<T> {
	private List<T> content;
	private Long total;
	public PageInfo(List<T> content,Long total) {
		this.content = content;
		this.total = total;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<?> getContent() {
		return content;
	}
	public Long getTotal() {
		return total;
	}
}
