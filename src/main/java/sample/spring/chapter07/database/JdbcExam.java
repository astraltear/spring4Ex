package sample.spring.chapter07.database;

import java.util.Date;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcExam {
	
	private static Logger logger = LoggerFactory.getLogger(JdbcExam.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext_chapter07_database.xml");
		
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		logger.info(dataSource.toString());
		
		BankAccountService bankAccountService = context.getBean(BankAccountService.class);
		
		BankAccountDetails bankAccountDetails = new BankAccountDetails();
		bankAccountDetails.setBalanceAmount(1000);
		bankAccountDetails.setLastTransactionTimestamp(new Date());
		
		int bankAccountId = bankAccountService.createBankAccount(bankAccountDetails);
		
		logger.info("bankAccountService.bankAccountId : "+bankAccountId);
		
//		FixedDepositService fixedDepositService = (FixedDepositService) context.getBean("fixedDepositService");
		FixedDepositService fixedDepositService = context.getBean(FixedDepositService.class);
//		logger.info(fixedDepositService.toString());
		
		FixedDepositDetails fdd = new FixedDepositDetails();
		fdd.setActive("Y");
		fdd.setBankAccountId(bankAccountId);
		fdd.setFdCreationDate(new Date());
//		fdd.setFdAmount(500);
		fdd.setFdAmount(2000); // rollback test code
		fdd.setTenure(12);
		try {
			int fixedDepositId = fixedDepositService.createFixedDeposit(fdd);
			logger.info("fixedDepositId:"+fixedDepositId);
			
//			FixedDepositDetails details = fixedDepositService.getFixedDeposit(fixedDepositId);
//			logger.info(details.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
