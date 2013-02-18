package com.sinosoft.one.test.rule.model;

public enum ComboFlag {
	
	/**
	 * 选中
	 */
	CHECKED("1"),
	
	/**
	 * 序列号头部标识
	 */
	SERIALNO_HEAD("PACK");
	

	private final String value;
	
	private ComboFlag(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	/**
	 * 状态
	 * @author qc
	 *
	 */
	public enum Statue{
		
		/**
		 * 初始
		 */
		INIT ("00"),
		
		/**
		 * 待检查
		 */
		WAITPASS("01"),
		
		/**
		 * 检查不通过
		 */
		NOPASS("02"),
		
		/**
		 * 检查通过
		 */
		PASS("03"),
		
		/**
		 * 发布
		 */
		PUBLISH("04");
		private String value;
		private Statue(String value){
			this.value = value;
		}
		public String toString(){
			return this.value;
		}
	}
	
	/**
	 * 续保
	 * @author qc
	 *
	 */
	public enum Renew{
		/**
		 * 是
		 */
		YES("01"),
		/**
		 * 非
		 */
		NO("00");
		private String value;
		private Renew(String value){
			this.value = value;
		}
		public String toString(){
			return this.value;
		}
	}
	
	public enum Type{
		/**
		 * 普通
		 */
		POP("01"),
		/**
		 * 自选
		 */
		CUSTOM("00");
		private String value;
		private Type(String value){
			this.value = value;
		}
		public String toString(){
			return this.value;
		}
	}
	

}
