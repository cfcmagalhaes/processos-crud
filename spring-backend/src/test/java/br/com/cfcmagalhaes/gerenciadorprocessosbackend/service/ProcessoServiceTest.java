package br.com.cfcmagalhaes.gerenciadorprocessosbackend.service;

import br.com.cfcmagalhaes.gerenciadorprocessosbackend.dto.ProcessoDTO;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.dto.MessageResponseDTO;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.model.Processo;
import br.com.cfcmagalhaes.gerenciadorprocessosbackend.repository.ProcessoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.cfcmagalhaes.gerenciadorprocessosbackend.utils.ProcessoUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith( MockitoExtension.class )
public class ProcessoServiceTest {

    @Mock
    private ProcessoRepository processoRepository;

    @InjectMocks
    private ProcessoService processoService;

    @Test
    void testGivenProcessoDTOThenReturnSavedMessage( )
    {
        ProcessoDTO processoDTO = createFakeDTO( );

        Processo expectedSavedProcesso = createFakeEntity();

        when( processoRepository.save( any( Processo.class ) ) ).thenReturn( expectedSavedProcesso );

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse( expectedSavedProcesso.getId( ), "Processo nº "
                + expectedSavedProcesso.getNumero( ) + " criado com sucesso." );

        MessageResponseDTO succesMessage = processoService.add(processoDTO);

        assertEquals( expectedSuccessMessage, succesMessage );
    }

    private MessageResponseDTO createExpectedMessageResponse( Long id, String message )
    {
        return MessageResponseDTO
                .builder( )
                .message( message + " (#" + id + ")" )
                .build( );
    }
}
