package br.com.cfcmagalhaes.gerenciadorprocessosbackend.repository;

import br.com.cfcmagalhaes.gerenciadorprocessosbackend.model.Parte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParteRepository extends JpaRepository<Parte, Long>
{
}
