package com.cardstox.cards;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MySQLContainer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringJUnit4ClassRunner.class)
	@SpringBootTest(classes = CardsApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
	@ContextConfiguration(initializers = abstractTest.Initializer.class)
	public abstract class abstractTest {

	    @ClassRule
	    public static MySQLContainer mysql = new MySQLContainer();

	    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	        @Override
	        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
	            EnvironmentTestUtils.addEnvironment("testcontainers", configurableApplicationContext.getEnvironment(),
	                    "spring.datasource.url="+mysql.getJdbcUrl(),
	            			"spring.datasource.username=" + mysql.getUsername(),
	            			"spring.datasource.password=" + mysql.getPassword()
	                   
	            );
	        }
	    }

	}

