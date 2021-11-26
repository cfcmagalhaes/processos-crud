package br.com.cfcmagalhaes.gerenciadorprocessosbackend.repository;

import br.com.cfcmagalhaes.gerenciadorprocessosbackend.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

        import java.util.Optional;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long>
{
    void deleteProcessById( Long id );

    Optional<Processo> findProcessoById( Long id );

    Processo findProcessoByNumero( String numero );
}
