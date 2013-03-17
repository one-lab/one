package com.sinosoft.one.monitor.test.osAgentTest;

public class StringTest {
	public static void main(String[] args) {
		String str = "addr:192.168.18.218";
		str = str.split(":")[1];
		System.out.println(str);
	}
}
