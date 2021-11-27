package br.com.cfcmagalhaes.gerenciadorprocessosbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessoDTO
{
    private Long id;

    @NotEmpty
    private String titulo;

    @NotEmpty
    private String numero;

    @NotEmpty
    private String autor;

    private String reu;
}
