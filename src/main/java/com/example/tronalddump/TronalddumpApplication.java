package com.example.tronalddump;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TronalddumpApplication {

	public static void main(String[] args) {


		SpringApplication.run(TronalddumpApplication.class, args);

	}

	@GetMapping()
	public String hello() {
		return "Hier gibt's tolle Donald Trump Zitate.";
	}
}
