package br.com.cfcmagalhaes.gerenciadorprocessosbackend.controller;

import br.com.cfcmagalhaes.gerenciadorprocessosbackend.model.Processo;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.exception.ProcessoNotFoundException;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.service.ProcessoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("processo")
public class ProcessoController
{
    private final ProcessoService processoService;

    public ProcessoController( ProcessoService processoService )
    {
        this.processoService = processoService;
    }

    @GetMapping( "/all" )
    public ResponseEntity<List<Processo>> getAllProcess( )
    {
        List<Processo> processos = processoService.findAllProcess( );
        return new ResponseEntity<>( processos, HttpStatus.OK );
    }

    @GetMapping( "/find/{id}" )
    public ResponseEntity<Processo> getProcessById( @PathVariable Long id ) throws ProcessoNotFoundException
    {
        Processo processo = processoService.findProcessById( id );
        return new ResponseEntity<>( processo, HttpStatus.OK );
    }

    @PostMapping( "/add" )
    public ResponseEntity<Processo> addProcess( @RequestBody Processo processo )
    {
        Processo newProcess = processoService.addProcess( processo );
        return new ResponseEntity<>( newProcess, HttpStatus.CREATED );
    }

    @PutMapping( "/update")
    public ResponseEntity<Processo> updateProcess( @RequestBody Processo processo )
    {
        Processo updateProcess = processoService.updateProcess( processo );
        return new ResponseEntity<>( updateProcess, HttpStatus.OK );
    }

    @DeleteMapping( "/delete/{id}" )
    public ResponseEntity<?> deleteProcess( @PathVariable ("id") Long id )
    {
        processoService.deleteProcess( id );
        return new ResponseEntity<>( HttpStatus.OK );
    }
}
