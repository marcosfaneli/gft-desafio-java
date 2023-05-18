package com.mfaneli.usuarios.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class HandleAdviceException {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroCampo> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return exception.getFieldErrors().stream()
                .map(e -> new ErroCampo(e.getField(), e.getDefaultMessage()))
                .toList();

    }
}
