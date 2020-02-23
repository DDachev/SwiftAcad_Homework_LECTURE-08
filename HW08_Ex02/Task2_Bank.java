package bg.swift.HW08_Ex02;

import java.util.Scanner;

public class Task2_Bank {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		OpenAccount[] accounts = new OpenAccount[100];
		String[] nameOfCustomers = new String[100];
		String[] iBANOfCustomers = new String[100];
		int countOfAccount = 0;

		while (!"END".equals(line)) {
			String[] command = line.split(" ");
			if (command[0].equals("OPEN")) {
				if (command[3].equals("1")) {
					accounts[countOfAccount] = new DepositAccount(command[1], Integer.parseInt(command[2]),
							Double.parseDouble(command[4]), Double.parseDouble(command[5]));
					System.out.println(accounts[countOfAccount].getIBAN());
					nameOfCustomers[countOfAccount] = command[1];
					iBANOfCustomers[countOfAccount] = accounts[countOfAccount].getIBAN();
					countOfAccount++;
				} else if (command[3].equals("2")) {
					accounts[countOfAccount] = new LoanAccount(command[1], Integer.parseInt(command[2]),
							Double.parseDouble(command[4]), Double.parseDouble(command[5]));
					System.out.println(accounts[countOfAccount].getIBAN());
					nameOfCustomers[countOfAccount] = command[1];
					iBANOfCustomers[countOfAccount] = accounts[countOfAccount].getIBAN();
					countOfAccount++;
				} else if (command[3].equals("3")) {
					accounts[countOfAccount] = new MortageAccount(command[1], Integer.parseInt(command[2]),
							Double.parseDouble(command[4]), Double.parseDouble(command[5]));
					System.out.println(accounts[countOfAccount].getIBAN());
					nameOfCustomers[countOfAccount] = command[1];
					iBANOfCustomers[countOfAccount] = accounts[countOfAccount].getIBAN();
					countOfAccount++;
				}
			}
			if (command[0].equals("PUT")) {
				if (command[1].charAt(0) != '0') {
					accounts[getIndexOfCustomers(nameOfCustomers, command[1])]
							.payIn(Double.parseDouble(command[2]));
				} else {
					accounts[getIndexOfCustomers(iBANOfCustomers, command[1])]
							.payIn(Double.parseDouble(command[2]));
				}
			}
			if (command[0].equals("GET")) {
				if (command[1].charAt(0) != '0') {
					if (accounts[getIndexOfCustomers(nameOfCustomers, command[1])] instanceof DepositAccount) {
						((DepositAccount) accounts[getIndexOfCustomers(nameOfCustomers, command[1])])
								.withdraw(Double.parseDouble(command[2]));
					}
				} else {
					if (accounts[getIndexOfCustomers(iBANOfCustomers, command[1])] instanceof DepositAccount) {
						((DepositAccount) accounts[getIndexOfCustomers(iBANOfCustomers, command[1])])
								.withdraw(Double.parseDouble(command[2]));
					}
				}
			}
			if (command[0].equals("INFO")) {
				if (command[1].charAt(0) != '0') {
					if (accounts[getIndexOfCustomers(nameOfCustomers, command[1])] instanceof DepositAccount) {
						System.out.println(
								((DepositAccount) accounts[getIndexOfCustomers(nameOfCustomers, command[1])])
										.getInterest(Integer.parseInt(command[2])));
					} else if (accounts[getIndexOfCustomers(nameOfCustomers,
							command[1])] instanceof LoanAccount) {
						System.out.println(
								((LoanAccount) accounts[getIndexOfCustomers(nameOfCustomers, command[1])])
										.getInterest(Integer.parseInt(command[2])));
					} else {
						System.out.println(
								((MortageAccount) accounts[getIndexOfCustomers(nameOfCustomers, command[1])])
										.getInterest(Integer.parseInt(command[2])));
					}
				} else {
					if (accounts[getIndexOfCustomers(iBANOfCustomers, command[1])] instanceof DepositAccount) {
						System.out.println(
								((DepositAccount) accounts[getIndexOfCustomers(iBANOfCustomers, command[1])])
										.getInterest(Integer.parseInt(command[2])));
					} else if (accounts[getIndexOfCustomers(iBANOfCustomers,
							command[1])] instanceof LoanAccount) {
						System.out.println(
								((LoanAccount) accounts[getIndexOfCustomers(iBANOfCustomers, command[1])])
										.getInterest(Integer.parseInt(command[2])));
					} else {
						System.out.println(
								((MortageAccount) accounts[getIndexOfCustomers(iBANOfCustomers, command[1])])
										.getInterest(Integer.parseInt(command[2])));
					}
				}
			}
			line = sc.nextLine();
		}
		sc.close();
	}

	private static int getIndexOfCustomers(String[] customers, String str) {
		for (int i = 0; i < customers.length; i++) {
			if (customers[i].equals(str)) {
				return i;
			}
		}
		return -1;
	}
}
