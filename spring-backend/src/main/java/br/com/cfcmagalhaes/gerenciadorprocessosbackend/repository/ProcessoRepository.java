package br.com.cfcmagalhaes.gerenciadorprocessosbackend.repository;

import br.com.cfcmagalhaes.gerenciadorprocessosbackend.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long>
{
    Processo findProcessoByNumero( String numero );
}
