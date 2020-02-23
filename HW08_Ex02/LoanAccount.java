package bg.swift.HW08_Ex02;

public class LoanAccount extends OpenAccount{

	public LoanAccount(String name, int owner, double balance, double monthlyInterestRate) {
		super(name, owner, balance, monthlyInterestRate);
	}

	@Override
	protected double getInterest(int period) {
		if(period > 0 && super.getOwner() == 1) {
			if(period > 3) {
				return (super.getBalance() * super.getMonthlyInterestRate() * (period - 3))/100;
			}
			return 0;
		} else if(period > 0 && super.getOwner() == 2) {
			if (period > 2) {
				return (super.getBalance() * super.getMonthlyInterestRate() * (period - 2))/100;
			}
			return 0;
		}
		return -1;
	}
}
