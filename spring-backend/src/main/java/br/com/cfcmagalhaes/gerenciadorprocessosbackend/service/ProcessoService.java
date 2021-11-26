package br.com.cfcmagalhaes.gerenciadorprocessosbackend.service;

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

    public Processo findProcessById( Long id )
    {
        return processoRepository.findProcessById( id )
                .orElseThrow(() -> new ProcessoNotFoundException( "Processo de id " + id + " não encontrado" ) );
    }

    public Processo addProcess( Processo processo )
    {
        return processoRepository.save( processo );
    }

    public Processo updateProcess( Processo processo )
    {
        return processoRepository.save( processo );
    }

    public void deleteProcess( Long id )
    {
        processoRepository.deleteProcessById( id );
    }
}
