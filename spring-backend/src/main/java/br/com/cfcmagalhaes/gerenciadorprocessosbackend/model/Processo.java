package br.com.cfcmagalhaes.gerenciadorprocessosbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Processo implements Serializable
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( nullable = false, updatable = false )
    private Long id;

    @Column( nullable = false )
    @NotBlank( message = "O título do processo é obrigatório.")
    private String titulo;

    @Column( nullable = false, unique = true )
    @NotBlank( message = "O numero do processo é obrigatório.")
    private String numero;

    @Column( nullable = false )
    private String autor;

    @Column( nullable = true )
    private String reu;

}
