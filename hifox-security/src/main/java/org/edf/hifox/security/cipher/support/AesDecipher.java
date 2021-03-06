package org.edf.hifox.security.cipher.support;

import java.security.SecureRandom;

import org.edf.hifox.security.cipher.AbstractDecipher;

public class AesDecipher extends AbstractDecipher {
	
	private static final String ALGORITHM = "AES";
	private String mode = "ECB";
	private String padding = "PKCS5Padding";
	private SecureRandom secureRandom = new SecureRandom(new byte[]{});
	
	@Override
	protected String obtainAlgorithm() {
		return ALGORITHM;
	}
	@Override
	protected String obtainMode() {
		return mode;
	}
	@Override
	protected String obtainPadding() {
		return padding;
	}
	@Override
	protected SecureRandom obtainSecureRandom() {
		return secureRandom;
	}
	
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	public void setPadding(String padding) {
		this.padding = padding;
	}
	public void setSecureRandom(SecureRandom secureRandom) {
		this.secureRandom = secureRandom;
	}

}
