package com.sysone.compressor.rest.response;

public class Compressor {
	private String compressed;

	public Compressor(String compressed) {
		super();
		this.compressed = compressed;
	}

	public String getCompressed() {
		return compressed;
	}

	public void setCompressed(String compressed) {
		this.compressed = compressed;
	}

}
