package eu.yadev.storeme.models.dao;

import eu.yadev.storeme.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecordDao extends JpaRepository<Record, Long> {
	Optional<Record> findSingleByTitle(String title);
}
