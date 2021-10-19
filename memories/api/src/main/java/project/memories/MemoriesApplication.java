package project.memories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("project.memories.properties")
public class MemoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoriesApplication.class, args);
	}

}
