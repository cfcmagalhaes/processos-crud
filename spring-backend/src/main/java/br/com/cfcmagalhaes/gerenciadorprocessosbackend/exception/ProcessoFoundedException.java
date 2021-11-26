package br.com.cfcmagalhaes.gerenciadorprocessosbackend.exception;

public class ProcessoFoundedException extends RuntimeException
{
    public ProcessoFoundedException( String mensagem )
    {
        super( mensagem );
    }
}
