package br.com.cfcmagalhaes.gerenciadorprocessosbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    private String titulo;

    @Column( nullable = false, unique = true )
    private String numero;

    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private List<Parte> partesProcesso;

}
