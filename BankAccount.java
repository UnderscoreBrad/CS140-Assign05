package assignment05;
//package exam01;
/**
A bank account has a balanceInCents that can be changed by 
deposits and withdrawals.
 */
public class BankAccount {  
	private long balanceInCents;

	/**
	 * Constructs a bank account with a zero balanceInCents.
	 */
	public BankAccount() {    
	} // balanceInCentsInCents is 0 automatically

	/**
	 * Constructs a bank account with a given balanceInCents.
	 * The initial amount is in dollars and that is converted to cents
	 * @param initialbalance the initial balance in dollars
	 */
	public BankAccount(int initialbalance) {   
		balanceInCents = 100*initialbalance;
	}

	/**
	 * Deposits money into the bank account in dollars.
	 * The amount is converted to cents before being added to the
	 * balance
	 * @param amount the amount in dollars to deposit
	 */
	public void deposit(int amount) {  
		balanceInCents += 100*amount;
	}

	/**
	 * Deposits money into the bank account from a check with dollars and cents.
	 * @param dollars the amount of dollars on the check to deposit
	 * @param cents the amount of cents on the check to deposit
	 */
	public void depositCheck(int dollars, int cents) {  
		balanceInCents += 100*dollars + cents;
	}

	/**
	 * Withdraws money from the bank account in dollars.
	 * The amount is converted to cents before being subtracted from the
	 * balance
	 * @param amount the amount in dollars to withdraw
	 */
	public void withdraw(int amount) {   
		balanceInCents -= 100*amount;
	}

	/**
	 * Gets the current balanceInCents of the bank account in Cents.
	 * @return the current balanceInCents
	 */
	public long getBalanceInCents() {
		return balanceInCents;
	}

	@Override
	public String toString() {
		return String.format("BankAccount with balance $%.2f", balanceInCents/100.0);
	}
}
