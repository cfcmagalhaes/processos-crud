package br.com.cfcmagalhaes.gerenciadorprocessosbackend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoParte
{
    AUTOR( "Autor" ),
    REU( "Reu" );

    private final String description;
}
