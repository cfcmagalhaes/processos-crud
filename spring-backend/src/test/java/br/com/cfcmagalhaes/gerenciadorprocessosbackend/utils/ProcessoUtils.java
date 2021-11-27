package br.com.cfcmagalhaes.gerenciadorprocessosbackend.utils;

import br.com.cfcmagalhaes.gerenciadorprocessosbackend.dto.ProcessoDTO;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.model.Processo;

public class ProcessoUtils {

    private static final String NUMERO = "1234567-12.1234.1.12.1234";
    private static final String TITULO = "Fred x Fabiana";
    private static final String AUTOR  = "Frederico";
    private static final String REU    = "Fabiana";

    public static ProcessoDTO createFakeDTO( )
    {
        return ProcessoDTO.builder( )
                .id( 1l )
                .numero( NUMERO )
                .titulo( TITULO )
                .autor( AUTOR )
                .reu( REU )
                .build( );
    }

    public static Processo createFakeEntity( )
    {
        return Processo.builder( )
                .id( 1l )
                .numero( NUMERO )
                .titulo( TITULO )
                .autor( AUTOR )
                .reu( REU )
                .build( );
    }
}
