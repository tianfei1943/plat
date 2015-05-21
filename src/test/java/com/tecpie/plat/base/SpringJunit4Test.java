package com.tecpie.plat.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.tecpie.plat.HomeController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-base.xml"})
//@Transactional
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class SpringJunit4Test {
	
	protected static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Test
	public void test(){
		logger.info("000000");
		
	}
	
}
