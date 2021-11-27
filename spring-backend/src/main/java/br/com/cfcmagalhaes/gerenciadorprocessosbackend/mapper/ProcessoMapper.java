package br.com.cfcmagalhaes.gerenciadorprocessosbackend.mapper;

import br.com.cfcmagalhaes.gerenciadorprocessosbackend.dto.ProcessoDTO;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.model.Processo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProcessoMapper
{
    ProcessoMapper INSTANCE = Mappers.getMapper( ProcessoMapper.class );

    Processo toModel( ProcessoDTO processoDTO );

    ProcessoDTO toDTO( Processo processo );
}
