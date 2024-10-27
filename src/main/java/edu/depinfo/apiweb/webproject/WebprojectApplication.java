package edu.depinfo.apiweb.webproject;

import edu.depinfo.apiweb.webproject.database.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class WebprojectApplication {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		SpringApplication.run(WebprojectApplication.class, args);
	}

}
