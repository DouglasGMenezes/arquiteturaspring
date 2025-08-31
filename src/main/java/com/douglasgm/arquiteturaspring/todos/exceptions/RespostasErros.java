package com.douglasgm.arquiteturaspring.todos.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class RespostasErros extends RuntimeException {

    public RespostasErros(String message) {
        super(message);
    }

}
