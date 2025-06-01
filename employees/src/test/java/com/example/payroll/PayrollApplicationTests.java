package com.example.payroll;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest

class PayrollApplicationTests {

	@Test
	void contextLoads() {
		try {
            System.out.println("Trying to load context...");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
