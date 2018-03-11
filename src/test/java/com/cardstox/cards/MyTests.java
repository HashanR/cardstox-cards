package com.cardstox.cards;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testcontainers.containers.MySQLContainer;

public class MyTests extends abstractTest{
	
	@Autowired
	test test;
	
	@Test
	public void simple() {
		
		testingDao dao = new testingDao();
		dao.setName("data");
		
		testingDao dao2 = new testingDao();
		dao2.setName("data");
		
		test.save(dao);
		test.save(dao2);
		
		assertEquals(2,test.findAll().size());
		
	}
	
	@Test
	public void simple2() {
		
		testingDao dao = new testingDao();
		dao.setName("data");
		
		
		test.save(dao);
		
		assertEquals(3,test.findAll().size());
		
	}

}
