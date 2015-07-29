package com.iglu.util;

public class Password {

	static String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-_";

	public static String genPass() {
		String passwd = "";
		for (int i = 0; i < 9; i++) {
			passwd += (base.charAt((int) (Math.random() * base.length())));
		}
		return passwd;

	}

}
