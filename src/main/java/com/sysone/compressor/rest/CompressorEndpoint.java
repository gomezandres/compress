package com.sysone.compressor.rest;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.sysone.compressor.rest.response.Candidate;
import com.sysone.compressor.rest.response.Compressor;
import com.sysone.compressor.rest.response.Echo;
import com.sysone.compressor.rest.response.ErrorResponse;
import com.sysone.compressor.service.CompressorService;
import com.sysone.compressor.util.Constantes;
import com.sysone.compressor.util.Util;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CompressorEndpoint {

	@Autowired
	private CompressorService compressorService;

	@GetMapping("/echo")
	@ApiOperation(value = "Test de conectividad")
	public Echo echo() {
		return new Echo("hello word!!");
	}

	@GetMapping("/candidate")
	@ApiResponses(@ApiResponse(code = 200, message = "Obtiene el nombre del candidato", response = Candidate.class))
	public Candidate getCandidate() {
		return new Candidate(Constantes.CANDIDATE);
	}

	@PostMapping("/compress")
	@ApiResponses({ @ApiResponse(code = 200, message = "Comprime una cadena de texto", response = Compressor.class),
			@ApiResponse(code = 500, message = "Error generico", response = ErrorResponse.class) })
	public Compressor compress(@Valid @RequestBody Request request) {
		String result = compressorService.calculate(Util.convertToArray(request.getValue()), 0);
		return new Compressor(result);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public final ResponseEntity<ErrorResponse> MethodArgumentNotValidException(Exception ex, WebRequest request) {
		ErrorResponse error = new ErrorResponse(new Date(), Constantes.ERROR_STRING_FORMAT);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
