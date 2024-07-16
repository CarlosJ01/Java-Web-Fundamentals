package com.alfacentauri.springboot.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alfacentauri.springboot.springboot.dao.Dao;

@Component
public class Service {
	
	Dao dao;
	
	@Autowired // Injeccion por constructor
	public Service(Dao dao) {
		System.out.println("Service Bean Created");
		this.dao = dao;
	}
	
	public void save() {
		dao.create();
	}
}
