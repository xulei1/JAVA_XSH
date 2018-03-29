package com.ldyp.util;
import java.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64Util {
	public static String decode(String str) throws UnsupportedEncodingException {
		Decoder decoder = Base64.getDecoder();
		Encoder encoder = Base64.getEncoder();
		byte[] newStr = str.getBytes("UTF-8");
		//±àÂë
		return encoder.encodeToString(newStr);
	}
}
