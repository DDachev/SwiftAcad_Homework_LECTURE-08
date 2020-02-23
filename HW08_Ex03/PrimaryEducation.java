package bg.swift.HW08_Ex03;

import java.time.LocalDate;

public class PrimaryEducation extends Education{

	protected PrimaryEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName) {
		super(enrollmentDate, graduationDate, institutionName);
	}

	@Override
	protected String getDegree() {
		return "primary";
	}

	@Override
	protected boolean gotGraduated() {
		return false;
	}
}
