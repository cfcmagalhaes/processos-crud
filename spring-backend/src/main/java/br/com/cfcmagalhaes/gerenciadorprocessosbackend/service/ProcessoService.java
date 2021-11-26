package br.com.cfcmagalhaes.gerenciadorprocessosbackend.service;

import br.com.cfcmagalhaes.gerenciadorprocessosbackend.exception.ProcessoFoundedException;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.model.Processo;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.exception.ProcessoNotFoundException;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public Processo updateProcess( Processo processo )
    {
        Processo proc = processoRepository.findProcessoById( processo.getId( ) )
                        .orElseThrow( ( ) -> new ProcessoNotFoundException( "Processo não encontrado" ) );

        return processoRepository.save( processo );
    }

    public void deleteProcess( Long id )
    {
        processoRepository.deleteProcessById( id );
    }
}
