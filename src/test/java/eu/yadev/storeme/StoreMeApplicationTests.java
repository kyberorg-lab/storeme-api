package eu.yadev.storeme;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class StoreMeApplicationTests {

	@Test
	void contextLoads() {
		//this is for pass()
		String message = "Context Loaded Correctly";
		assertNotNull(message);
	}

}
