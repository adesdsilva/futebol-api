package br.com.sunsystem.partida_futebolapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbbidenException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ForbbidenException() {
		super();
	}

	public ForbbidenException(String msg) {
		super(msg);
	}

	public ForbbidenException(Throwable cause) {
		super(cause);
	}

	public ForbbidenException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
