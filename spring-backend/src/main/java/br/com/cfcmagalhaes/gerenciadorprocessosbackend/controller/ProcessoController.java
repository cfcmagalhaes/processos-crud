package br.com.cfcmagalhaes.gerenciadorprocessosbackend.controller;

import br.com.cfcmagalhaes.gerenciadorprocessosbackend.model.Processo;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.exception.ProcessoNotFoundException;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.service.ProcessoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("processo")
public class ProcessoController
{
    private final ProcessoService processoService;

    public ProcessoController( ProcessoService processoService )
    {
        this.processoService = processoService;
    }

    @GetMapping( "" )
    public ResponseEntity<List<Processo>> getAllProcess( )
    {
        List<Processo> processos = processoService.findAllProcess( );
        return new ResponseEntity<>( processos, HttpStatus.OK );
    }

    @GetMapping( "/find/{id}" )
    public ResponseEntity<Processo> getProcessById( @PathVariable Long id ) throws ProcessoNotFoundException
    {
        Processo processo = processoService.findProcessoById( id );
        return new ResponseEntity<>( processo, HttpStatus.OK );
    }

    @PostMapping( "/add" )
    public ResponseEntity<Processo> addProcess( @Valid @RequestBody Processo processo )
    {
        Processo newProcess = processoService.addProcess( processo );
        return new ResponseEntity<>( newProcess, HttpStatus.CREATED );
    }

    @PutMapping( "/update/{id}")
    public ResponseEntity<Processo> updateProcess( @PathVariable Long id, @RequestBody Processo processo )
    {
        Processo updateProcess = processoService.updateProcess( id, processo );
        
        return new ResponseEntity<>( updateProcess, HttpStatus.OK );
    }

    @DeleteMapping( "/delete/{id}" )
    public ResponseEntity<Map<String, Boolean>> deleteProcess( @PathVariable ("id") Long id )
    {
        processoService.deleteProcess( id );

        return new ResponseEntity<>( HttpStatus.OK );
    }
}
