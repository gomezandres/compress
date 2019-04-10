package com.sysone.compressor.exception;

import lombok.ToString;

@ToString(callSuper = false, includeFieldNames = true)
public class CompressorException extends Exception {

	private static final long serialVersionUID = -3620940546216386160L;

	private String mensaje;

	public CompressorException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
