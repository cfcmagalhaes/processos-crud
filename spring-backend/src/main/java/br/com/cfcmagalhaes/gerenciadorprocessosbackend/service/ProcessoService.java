package br.com.cfcmagalhaes.gerenciadorprocessosbackend.service;

import br.com.cfcmagalhaes.gerenciadorprocessosbackend.exception.ProcessoFoundedException;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.model.Processo;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.exception.ProcessoNotFoundException;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProcessoService
{
    private final ProcessoRepository processoRepository;

    @Autowired
    public ProcessoService( ProcessoRepository processRepository )
    {
        this.processoRepository = processRepository;
    }

    public List<Processo> findAllProcess( )
    {
        return processoRepository.findAll( );
    }

    public Processo findProcessoById( Long id )
    {
        return processoRepository.findProcessoById( id )
                .orElseThrow( ( ) -> new ProcessoNotFoundException( "Processo não encontrado" ) );
    }

    public Processo addProcess( Processo processo )
    {
        Processo proc = processoRepository.findProcessoByNumero( processo.getNumero( ) );

        if( proc == null )
            return processoRepository.save( processo );

        throw new ProcessoFoundedException( "Processo já cadastrado" );

    }

    public Processo updateProcess( Long id, Processo processo )
    {
        Processo updatedProcesso = processoRepository.findProcessoById( id )
                        .orElseThrow( ( ) -> new ProcessoNotFoundException( "Processo não encontrado" ) );

        updatedProcesso.setNumero( processo.getNumero( ) );
        updatedProcesso.setTitulo( processo.getTitulo( ) );

        return processoRepository.save( updatedProcesso );
    }

    public void deleteProcess(Long id )
    {
        Processo processo = processoRepository.findProcessoById( id )
                .orElseThrow( ( ) -> new ProcessoNotFoundException( "Processo não encontrado" ) );

        processoRepository.delete( processo );
    }
}
