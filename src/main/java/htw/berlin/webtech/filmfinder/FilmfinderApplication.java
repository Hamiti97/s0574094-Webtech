package htw.berlin.webtech.filmfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FilmfinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmfinderApplication.class, args);
	}


	@GetMapping
	public String hello() {
		return "Hello World";
	}
}
