package com.meusprojetos.locacao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LocacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocacaoApplication.class, args);
	}

	/*
	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("crip 123456 "+encoder.encode("123456"));
	}

	 */
}
