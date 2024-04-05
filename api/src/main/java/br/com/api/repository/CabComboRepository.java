package br.com.api.repository;

import br.com.api.model.CabCombo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabComboRepository extends JpaRepository<CabCombo, Long> {
}