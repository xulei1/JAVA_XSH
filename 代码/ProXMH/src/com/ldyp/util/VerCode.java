package com.ldyp.util;

import java.util.UUID;

public class VerCode {   //ÑéÖ¤Âë
	private String code;

	public VerCode() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr = str.replace("-", "");
		this.code = uuidStr.substring(0, 6);
	}

	public String getCode() {
		return code;
	}
	
	
}
