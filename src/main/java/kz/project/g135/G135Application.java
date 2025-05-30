package kz.project.g135;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class G135Application {

	public static void main(String[] args) {
		SpringApplication.run(G135Application.class, args);
	}
}