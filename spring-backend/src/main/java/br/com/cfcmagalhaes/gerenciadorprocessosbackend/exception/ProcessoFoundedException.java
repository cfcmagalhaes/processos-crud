package br.com.cfcmagalhaes.gerenciadorprocessosbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ProcessoFoundedException extends RuntimeException
{
    public ProcessoFoundedException( String mensagem )
    {
        super( mensagem );
    }
}
