package eu.yadev.storeme.services;

import eu.yadev.storeme.models.Record;
import eu.yadev.storeme.models.dao.RecordDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
	private final RecordDao recordDao;

	public RecordService(RecordDao dao) {
		this.recordDao = dao;
	}

	public List<Record> getAllRecords() {
		return recordDao.findAll();
	}
}
