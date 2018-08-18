package ca.sanrus.automation.junit;

import org.junit.Test;

import junit.framework.Assert;

public class BankAccountTestCase {
	
	private static final int MIN_BALANCE = 50;
	
	@Test
	public void testBankAccountConstructor() {
		BankAccount account = new BankAccount(MIN_BALANCE);
		
		Assert.assertEquals(true, account.getBalance() == MIN_BALANCE);
	}
	
	@Test
	public void testBankAccountConstructor_WithNegativeBalance() {
		
		try {
			BankAccount account = new BankAccount(-1);
			Assert.fail("Bank account with negative balance is not allowed.");
		} catch (RuntimeException e) {
			Assert.assertEquals(true, (MIN_BALANCE + " balance is required for the bank account.").equals(e.getMessage()));
		}
		
	}
	
	@Test
	public void testCredit() {

		BankAccount account = new BankAccount(MIN_BALANCE);
		account.credit(10);
		
		Assert.assertEquals(true, (MIN_BALANCE + 10) == account.getBalance());
		
	}

}
