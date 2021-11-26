package br.com.cfcmagalhaes.gerenciadorprocessosbackend.model;

import br.com.cfcmagalhaes.gerenciadorprocessosbackend.enums.TipoParte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Parte implements Serializable
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false )
    private String nome;

    @Column( nullable = false )
    private String identificacaoOficial;

    @Enumerated( EnumType.STRING )
    private TipoParte tipo;
}
