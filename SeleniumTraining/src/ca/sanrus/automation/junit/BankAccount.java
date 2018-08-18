package ca.sanrus.automation.junit;

public class BankAccount {
	
	private static final int MIN_BALANCE = 50;

	private double balance;
	
	public BankAccount(double balance) throws RuntimeException {
		if (balance < MIN_BALANCE) {
			throw new RuntimeException(MIN_BALANCE + " balance is required for the bank account.");
		}
		this.balance = balance;
	}
	
	public void debit(double amount) {
		balance = balance - amount;
	}
	
	public void credit(double amount) {
		balance = balance + amount;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
