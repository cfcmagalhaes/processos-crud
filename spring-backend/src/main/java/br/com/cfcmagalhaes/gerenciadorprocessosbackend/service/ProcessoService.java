package br.com.cfcmagalhaes.gerenciadorprocessosbackend.service;

import br.com.cfcmagalhaes.gerenciadorprocessosbackend.dto.MessageResponseDTO;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.dto.ProcessoDTO;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.exception.ProcessoDuplicateException;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.mapper.ProcessoMapper;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.model.Processo;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.exception.ProcessoNotFoundException;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.repository.ProcessoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor( onConstructor = @__( @Autowired ) )
public class ProcessoService
{
    private ProcessoRepository processoRepository;

    private final ProcessoMapper processoMapper = ProcessoMapper.INSTANCE;

    public List<ProcessoDTO> getAll( )
    {
        List<Processo> processos = processoRepository.findAll();
        return processos.stream()
                .map( processoMapper::toDTO )
                .collect( Collectors.toList( ) );
    }

    public ProcessoDTO findById( Long id ) throws ProcessoNotFoundException
    {
        Processo processo = verificaSeExiste( id );

        return processoMapper.toDTO( processo );
    }

    public MessageResponseDTO add(ProcessoDTO processoDTO ) throws ProcessoDuplicateException
    {
        Processo processoToSave = processoMapper.toModel( processoDTO );

        verificaSeExiste( processoToSave.getNumero( ) );

        Processo processoSaved = processoRepository.save( processoToSave );

        return createMessageResponse( processoSaved.getId( ), "Processo nº "
                + processoSaved.getNumero( ) + " criado com sucesso." );
    }

    public MessageResponseDTO update( Long id, ProcessoDTO processoDTO ) throws ProcessoNotFoundException
    {
        Processo processoToUpdate = processoMapper.toModel( processoDTO );

        verificaSeExiste( id );

        Processo processoUpdated = processoRepository.save( processoToUpdate );

        return createMessageResponse( processoUpdated.getId( ), "Processo nº "
                + processoUpdated.getNumero( ) + " foi alterado com sucesso.");
    }

    public void delete( Long id ) throws ProcessoNotFoundException
    {
        verificaSeExiste( id );

        processoRepository.deleteById( id );
    }

// Métodos úteis
    private Processo verificaSeExiste( Long id )
    {
        return processoRepository.findById( id )
                .orElseThrow( ( ) -> new ProcessoNotFoundException( "Processo não encontrado." ) );
    }

    private void verificaSeExiste( String numero )
    {
        Processo processo = processoRepository.findProcessoByNumero( numero );

        if( processo != null )
            throw new RuntimeException( "Processo já existe na base." );
    }

    private MessageResponseDTO createMessageResponse( Long id, String message )
    {
        return MessageResponseDTO
                .builder( )
                .message( message + " (#" + id + ")" )
                .build( );
    }
}
