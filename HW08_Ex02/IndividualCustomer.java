package bg.swift.HW08_Ex02;

public class IndividualCustomer {
	private String name;

	protected IndividualCustomer(String name) {
			this.name = name;
	}
	
	protected String getName() {
		return this.name;
	}
}
