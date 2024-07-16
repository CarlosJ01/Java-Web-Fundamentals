package com.alfacentauri.springboot.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.alfacentauri.springboot.springboot.service.Service;

@SpringBootTest
class SpringbootApplicationTests {
	
	@Autowired
	ApplicationContext context;
	
	@Test
	void contextLoads() {
		Service service = context.getBean(Service.class);
		service.save();
	}
	
}
