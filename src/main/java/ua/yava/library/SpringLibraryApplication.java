package ua.yava.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "ua.yava.library")
public class SpringLibraryApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringLibraryApplication.class, args);

	}
}
