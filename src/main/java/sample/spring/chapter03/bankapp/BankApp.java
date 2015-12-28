package sample.spring.chapter03.bankapp;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.spring.chapter03.bankapp.dao.FixedDepositDao;
import sample.spring.chapter03.bankapp.dao.PersonalBakingDao;
import sample.spring.chapter03.bankapp.service.FixedDepositService;

public class BankApp {
	private static Logger logger = Logger.getLogger(BankApp.class);
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext_chapter03_inherit.xml");
		
		FixedDepositDao fixedDepositDao = (FixedDepositDao) context.getBean("fixedDepositDao");
		PersonalBakingDao personalBakingDao = (PersonalBakingDao) context.getBean("personalBankingDao");
		
		logger.info(fixedDepositDao);
		logger.info(personalBakingDao);
		
		FixedDepositService fixedDepositService = (FixedDepositService) context.getBean("fixedDepositService");
		
		logger.info(fixedDepositService);
	}

}
