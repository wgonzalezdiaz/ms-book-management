package com.book.management.msbookmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MsBookManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBookManagementApplication.class, args);
	}

}
