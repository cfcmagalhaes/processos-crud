package br.com.cfcmagalhaes.gerenciadorprocessosbackend.controller;

import br.com.cfcmagalhaes.gerenciadorprocessosbackend.dto.MessageResponseDTO;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.dto.ProcessoDTO;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.exception.ProcessoDuplicateException;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.exception.ProcessoNotFoundException;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.service.ProcessoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping( "/processo")
@AllArgsConstructor( onConstructor = @__( @Autowired ) )
public class ProcessoController
{
    private ProcessoService processoService;

    @GetMapping
    public List<ProcessoDTO> getAll( )
    {
        return processoService.getAll( );
    }

    @GetMapping( "/{id}" )
    public ProcessoDTO getById( @PathVariable Long id ) throws ProcessoNotFoundException
    {
        return processoService.findById( id );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO add( @RequestBody @Valid ProcessoDTO processoDTO ) throws ProcessoDuplicateException
    {
        return processoService.add( processoDTO );
    }

    @PutMapping( "/{id}")
    public MessageResponseDTO update( @PathVariable Long id, @RequestBody @Valid ProcessoDTO processoDTO ) throws ProcessoNotFoundException
    {
        return processoService.update( id, processoDTO );
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Long id ) throws ProcessoNotFoundException
    {
        processoService.delete( id );
    }
}
