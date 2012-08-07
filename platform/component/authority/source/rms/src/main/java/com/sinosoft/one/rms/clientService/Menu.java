package com.sinosoft.one.rms.clientService;

import java.util.List;

public class Menu {
	
	private final String url;
	
	private final String id;
	
	private final String name;
	
	private List<Menu> children;
	
	public  Menu(final String id,final String url,final String name){
		this.url=url;
		this.id=id;
		this.name=name;
	}

	public void setChildren(final List<Menu> children) {
		if(this.children==null)
			this.children = children;
	}

	public String getUrl() {
		return url;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Menu> getChildren() {
		return children;
	}
}
