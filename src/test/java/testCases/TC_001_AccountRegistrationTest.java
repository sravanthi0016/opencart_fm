package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;
import pageObjects.AccountRegistrationPage;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups= {"Regression","Master"})
	public void test_account_Registration() throws InterruptedException {
		logger.debug("application logs....");
		logger.info("***** Starting TC_001_AccountRegistrationTest");
		try {
		
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on my account link");
		
		hp.clickRegister();
		logger.info("Clicked on register link");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer data");
		regpage.setFirstName(randomString().toLowerCase());
		regpage.setLastName(randomString().toLowerCase());
		//regpage.setEmail(randomString()+"@gmail.com");
		regpage.setPassword(randomAlphaNumaric());
		regpage.setPrivacyPolicy();
	
		regpage.clickContinue();
		logger.info("Clicked on on continue");
		String confmsg=regpage.getConfirmationMsg();
		logger.info("validating expected message");
		Thread.sleep(3000);
		Assert.assertEquals(confmsg, "your Account has been created!","not getting expected message");
		}
	
	
		catch(Exception e) {
			logger.error("test failed");
			//Assert.fail();
		}
		
		logger.info("***** finished TC_001_AccountRegistrationTest");
	
	

	}
}

