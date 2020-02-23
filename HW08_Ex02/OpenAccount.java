package bg.swift.HW08_Ex02;

public abstract class OpenAccount {
	private String iBAN;
	private int owner;
	private double balance;
	private double monthlyInterestRate;
	private static int numberOfAccount = 1;
	
	
	public OpenAccount(String name, int owner, double balance, double monthlyInterestRate) {
		if(isValidAll(owner, name, balance, monthlyInterestRate)) {
		this.owner = owner;
		if(this.owner == 1) {
			IndividualCustomer iC = new IndividualCustomer(name);
		} else {
			CompanyCustomer cC = new CompanyCustomer(name);
		}
		this.balance = balance;
		this.monthlyInterestRate = monthlyInterestRate;
		this.iBAN = String.format("%08d", numberOfAccount);
		numberOfAccount++;
		}
	}
	
	private static boolean isValidAll(int owner, String name, double balance, double interestRate) {
		if(isValidOwner(owner) && isValidName(name) && isValidBalance(balance) && isValidMonthlyInterestRate(interestRate)) {
			return true;
		}
		return false;
	}
	
	private static boolean isValidOwner(int owner) {
		if (owner >= 1 && owner <=2) {
			return true;
		}
		return false;
	}
	
	private static boolean isValidName(String name) {
		if (name != null && !name.trim().isEmpty()) {
			return true;
		}
		return false;
	}
	
	private static boolean isValidBalance(double balance) {
		if(balance > 0) {
			return true;
		}
		return false;
	}
	
	private static boolean isValidMonthlyInterestRate(double interestRate) {
		if(interestRate > 0 && interestRate < 1) {
			return true;
		}
		return false;
	}
	
	protected void payIn(double amount) {
		if(amount > 0) {
			this.balance += amount;
		}
	}
	
	protected double getInterest(int period) {
		if(period > 0) {
			return (this.balance * this.monthlyInterestRate * period)/100;
		}
		return -1;
	}
	
	protected int getOwner() {
		return this.owner;
	}
	
	protected double getBalance() {
		return this.balance;
	}
	
	protected double getMonthlyInterestRate() {
		return this.monthlyInterestRate;
	}
	
	protected String getIBAN() {
		return this.iBAN;
	}
	
	void setBalance(double amount) {
		this.balance = amount;
	}
}
