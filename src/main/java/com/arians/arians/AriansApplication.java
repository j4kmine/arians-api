package com.arians.arians;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//This annotation is used at the class level
// and allows the class to handle the requests made by the client
public class AriansApplication {

	public static void main(String[] args) {
		SpringApplication.run(AriansApplication.class, args);
	}

}
