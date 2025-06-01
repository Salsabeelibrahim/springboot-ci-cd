package com.example.payroll;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(properties = "spring.profiles.active=test")
class PayrollApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("Test context loaded!");
	}

}
