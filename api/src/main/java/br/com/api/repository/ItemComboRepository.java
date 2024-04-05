package br.com.api.repository;

import br.com.api.model.ItemCombo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ItemComboRepository extends JpaRepository<ItemCombo, Long> {
	@Modifying
	@Transactional
	@Query(value = "delete from item_combo c where c.combo = :combo", nativeQuery = true)
	void deleteByCombo(long combo);
}