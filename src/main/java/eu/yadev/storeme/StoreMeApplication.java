package eu.yadev.storeme;

import eu.yadev.storeme.models.Record;
import eu.yadev.storeme.models.dao.RecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class StoreMeApplication implements CommandLineRunner {

	private final RecordDao recordDao;

	public StoreMeApplication(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(StoreMeApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Record recordOne = Record.create().setTitle("Story One").setBody("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		Record recordTwo = Record.create().setTitle("Story Two").setBody("Donec tempor tempor ex.");
		Record recordThree = Record.create().setTitle("Story Three").setBody(" Quisque laoreet volutpat felis in vulputate.");

		Optional<Record> storyOne = recordDao.findSingleByTitle(recordOne.getTitle());
		Optional<Record> storyTwo = recordDao.findSingleByTitle(recordTwo.getTitle());
		Optional<Record> storyThree = recordDao.findSingleByTitle(recordThree.getTitle());

		if (storyOne.isEmpty()) {
			recordDao.save(recordOne);
		}
		if (storyTwo.isEmpty()) {
			recordDao.save(recordTwo);
		}
		if (storyThree.isEmpty()) {
			recordDao.save(recordThree);
		}
	}
}
