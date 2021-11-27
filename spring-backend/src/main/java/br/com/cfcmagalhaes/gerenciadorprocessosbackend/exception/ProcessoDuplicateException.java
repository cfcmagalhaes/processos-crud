package br.com.cfcmagalhaes.gerenciadorprocessosbackend.exception;

public class ProcessoDuplicateException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public ProcessoDuplicateException( String mensagem )
    {
        super( mensagem );
    }
}
