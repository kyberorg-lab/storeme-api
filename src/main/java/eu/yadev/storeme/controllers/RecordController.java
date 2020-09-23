package eu.yadev.storeme.controllers;

import eu.yadev.storeme.models.Record;
import eu.yadev.storeme.services.RecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("records")
public class RecordController {

	public final RecordService recordService;

	public RecordController(RecordService service) {
		this.recordService = service;
	}

	@GetMapping("/")
	public List<Record> allRecords() {
		return recordService.getAllRecords();
	}
}
