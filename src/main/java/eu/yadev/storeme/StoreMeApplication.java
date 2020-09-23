package eu.yadev.storeme;

import eu.yadev.storeme.models.Record;
import eu.yadev.storeme.models.dao.RecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		Record storyOne = Record.create().setTitle("Story One").setBody("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		Record storyTwo = Record.create().setTitle("Story Two").setBody("Donec tempor tempor ex.");
		Record storyThree = Record.create().setTitle("Story Three").setBody(" Quisque laoreet volutpat felis in vulputate.");

		storyOne = recordDao.findByTitle(storyOne.getTitle());
		storyTwo = recordDao.findByTitle(storyTwo.getTitle());
		storyThree = recordDao.findByTitle(storyThree.getTitle());

		recordDao.save(storyOne);
		recordDao.save(storyTwo);
		recordDao.save(storyThree);
	}
}
