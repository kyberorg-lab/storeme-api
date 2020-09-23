package eu.yadev.storeme.models.dao;

import eu.yadev.storeme.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordDao extends JpaRepository<Record, Long> {
	Record findByTitle(String title);
}
