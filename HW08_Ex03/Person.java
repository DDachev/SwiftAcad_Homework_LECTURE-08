package bg.swift.HW08_Ex03;

import java.time.LocalDate;

public class Person {

	private String firstName;
	private String middleName;
	private String lastName;
	private char gender;
	private LocalDate dateOfBirth;
	private short height;
	private char codeOfEducation;
	protected Education ed;
	protected Address address;

	protected Person(String firstName, String middleName, String lastName, char gender, LocalDate dateOfBirth,
			char codeOfEducation, short height, String country, String city, String municipality, int postalCode,
			String street, int number, int floor, int apartamentNo, LocalDate enrollmentDate, LocalDate graduationDate,
			String institutionName, double finalGrade) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.codeOfEducation = codeOfEducation;
		this.height = height;
		this.address = new Address(country, city, municipality, postalCode, street, number, floor, apartamentNo);
		if (this.codeOfEducation == 'P') {
			this.ed = new PrimaryEducation(enrollmentDate, graduationDate, institutionName);
		} else if (this.codeOfEducation == 'S') {
			this.ed = new SecondaryEducation(enrollmentDate, graduationDate, institutionName, finalGrade);
		} else if (this.codeOfEducation == 'B' || this.codeOfEducation == 'M' || this.codeOfEducation == 'D') {
			this.ed = new HigherEducation(enrollmentDate, graduationDate, institutionName, finalGrade);
		}
	}

	@Override
	public String toString() {
		if (this.gender == 'M') {
			String firstLine = String.format("%s %s %s is %d years old. He was born in %d.%n", this.firstName,
					this.middleName, this.lastName, this.getAgeOfPerson(), this.getDateOfBirth().getYear());
			if (!this.isUnderAge(dateOfBirth)) {
				String isUnderAged = String.format("%s %s %s is under-aged.%n", this.firstName, this.middleName,
						this.lastName);
				firstLine = firstLine + isUnderAged;
			}
			String secondLine = String.format("He " + this.address.toString() + "He started %s degree in %s on "
					+ this.ed.getEnrollmentData() + " and ", this.getDegree(), this.ed.getInstutionName());
			firstLine = firstLine + secondLine;
			if (this.ed.isGraduated()) {
				String lastLine = String.format("finished on " + this.ed.getGraduationDate() + ". His grade was %.3f.",
						((GradedEducation) this.ed).getFinalGrade());
				firstLine = firstLine + lastLine;
			} else {
				String lastLine = String.format("is supposed to graduate on " + this.ed.getGraduationDate() + ".");
				firstLine = firstLine + lastLine;
			}
			return firstLine;
		}
		String firstLine = String.format("%s %s %s is %d years old. She was born in %d.%n", this.firstName,
				this.middleName, this.lastName, this.getAgeOfPerson(), this.getDateOfBirth().getYear());
		if (!this.isUnderAge(dateOfBirth)) {
			String isUnderAged = String.format("%s %s %s is under-aged.%n", this.firstName, this.middleName,
					this.lastName);
			firstLine = firstLine + isUnderAged;
		}
		String secondLine = String.format("She " + this.address.toString() + "She started %s degree in %s on "
				+ this.ed.getEnrollmentData() + " and ", this.getDegree(), this.ed.getInstutionName());
		firstLine = firstLine + secondLine;
		if (this.ed.isGraduated()) {
			String lastLine = String.format("finished on " + this.ed.getGraduationDate() + ". Her grade was %.3f.",
					((GradedEducation) this.ed).getFinalGrade());
			firstLine = firstLine + lastLine;
		} else {
			String lastLine = String.format("is supposed to graduate on " + this.ed.getGraduationDate() + ".");
			firstLine = firstLine + lastLine;
		}
		return firstLine;
	}

	public boolean isUnderAge(LocalDate dateOfBirth) {
		LocalDate dateNow = LocalDate.now();
		if (dateNow.minusYears(18).compareTo(dateOfBirth) >= 0) {
			return true;
		}
		return false;
	}

	public int getAgeOfPerson() {
		LocalDate dateNow = LocalDate.now();
		int ageOfPerson = dateNow.compareTo(this.dateOfBirth);
		boolean yearIsAfter = this.dateOfBirth.plusYears(dateNow.getYear() - this.dateOfBirth.getYear())
				.isAfter(dateNow);

		if (yearIsAfter) {
			return ageOfPerson - 1;
		}
		return ageOfPerson;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public char getGender() {
		return gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public short getHeight() {
		return height;
	}

	public char getCodeOfEducation() {
		return this.codeOfEducation;
	}

	public String getDegree() {
		char code = getCodeOfEducation();
		if (code == 'P') {
			return "primary";
		} else if (code == 'S') {
			return "secondary";
		} else if (code == 'B') {
			return "bachelor";
		} else if (code == 'M') {
			return "master";
		} else if (code == 'D') {
			return "doctorate";
		}
		return null;
	}
}
