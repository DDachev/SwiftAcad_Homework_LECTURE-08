package bg.swift.HW08_Ex02;

public class MortageAccount extends OpenAccount{

	public MortageAccount(String name, int owner, double balance, double monthlyInterestRate) {
		super(name, owner, balance, monthlyInterestRate);
	}

	@Override
	protected double getInterest(int period) {
		if (period > 0 && super.getOwner() == 1) {
			if (period > 6) {
				return (super.getBalance() * super.getMonthlyInterestRate() * (period - 6)) / 100;
			}
			return 0;
		} else if (period > 0 && super.getOwner() == 2) {
			if (period > 12) {
				double interestForFirstYear = (super.getBalance() * (super.getMonthlyInterestRate() / 2) * 12) / 100;
				return ((super.getBalance() * super.getMonthlyInterestRate() * (period - 12)) / 100
						+ interestForFirstYear);
			}
			return (super.getBalance() * (super.getMonthlyInterestRate() / 2) * period) / 100;
		}
		return -1;
	}
}
