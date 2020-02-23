package bg.swift.HW08_Ex02;

public class DepositAccount extends OpenAccount {

	public DepositAccount(String name, int owner, double balance, double monthlyInterestRate) {
		super(name, owner, balance, monthlyInterestRate);
	}

	protected void withdraw(double amount) {
		if (amount < super.getBalance()) {
			super.setBalance(super.getBalance() - amount);
		}
	}
}
