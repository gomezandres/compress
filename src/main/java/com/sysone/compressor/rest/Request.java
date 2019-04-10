package com.sysone.compressor.rest;

import javax.validation.constraints.Pattern;

import com.sysone.compressor.util.Constantes;

public class Request {

	@Pattern(regexp = Constantes.REGEX_LETTERS, message = "Request invalido. Solo se aceptan letras")
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
