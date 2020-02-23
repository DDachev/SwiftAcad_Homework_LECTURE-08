package bg.swift.HW08_Ex03;

import java.time.LocalDate;

public abstract class GradedEducation extends Education {
	private double finalGrade;

	protected GradedEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName,
			double finalGrade) {
		super(enrollmentDate, graduationDate, institutionName);
		if (super.isGraduated()) {
			this.finalGrade = finalGrade;
		}
	}

	protected void gotGraduated(float finalGrade) {
		this.finalGrade = finalGrade;
	}

	protected double getFinalGrade() {
		if (this.finalGrade >= 3 && this.finalGrade <= 6) {
			return this.finalGrade;
		}
		return -1;
	}
}
