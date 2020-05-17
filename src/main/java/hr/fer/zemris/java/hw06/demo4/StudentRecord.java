package hr.fer.zemris.java.hw06.demo4;

/**
 * Class represents one student record that contains
 * jmbag, surname, first name, midterm, final and lab points and his grade.
 * 
 * @author Ante Gazibarić
 * @version 1.0
 *
 */
public class StudentRecord {
	
	private String jmbag;
	private String surname;
	private String firstName;
	private Double midtermPoints;
	private Double finalPoints;
	private Double labPoints;
	private int grade;
	
	/**
	 * Constructor that creates new {@link StudentRecord} object.
	 * 
	 * @param jmbag			student's jmbag
	 * @param surname		student's surname
	 * @param firstName		student's first name
	 * @param midtermPoints student's midterm exam points
	 * @param finalPoints   student's final exam points
	 * @param labPoints     student's points from laboratory exams
	 * @param grade			student's grade
	 */
	public StudentRecord(String jmbag, String surname, String firstName, Double midtermPoints, Double finalPoints,
			Double labPoints, int grade) {
		this.jmbag = jmbag;
		this.surname = surname;
		this.firstName = firstName;
		this.midtermPoints = midtermPoints;
		this.finalPoints = finalPoints;
		this.labPoints = labPoints;
		this.grade = grade;
	}
	
	/**
	 * Method returns student's jmbag
	 * @return student's jmbag
	 */
	public String getJmbag() {
		return jmbag;
	}
	
	/**
	 * Method returns student's surname
	 * @return student's surname
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * Method returns student's first name
	 * @return student's first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Method returns student's midterm points
	 * @return student's midterm points
	 */
	public Double getMidtermPoints() {
		return midtermPoints;
	}
	
	/**
	 * Method returns student's final exam points
	 * @return final exam points
	 */
	public Double getFinalPoints() {
		return finalPoints;
	}
	
	/**
	 * Method returns student's laboratory exam points
	 * @return student's laboratory exam points
	 */
	public Double getLabPoints() {
		return labPoints;
	}
	
	/**
	 * Method returns student's grade
	 * @return student's grade
	 */
	public int getGrade() {
		return grade;
	}
	
	/**
	 * Method returns student's sum of all points
	 * @return student's sum of all points
	 */
	public Double getAllPoints() {
		return midtermPoints + finalPoints + labPoints;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s %f %f %f %d",
				jmbag, surname, firstName,
				midtermPoints, finalPoints, labPoints, grade);
	}

}
