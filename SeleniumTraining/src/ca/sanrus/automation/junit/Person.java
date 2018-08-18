package ca.sanrus.automation.junit;

public class Person {
	
	private String firstName;
	private String lastName;
	private int age;

	
	/**
	 * @param firstName
	 * @param lastName
	 * @param age
	 */
	public Person(String firstName, 
					String lastName, 
					int age) throws RuntimeException {
		if (firstName == null || firstName.equals("")) {
			throw new RuntimeException("First name is required.");
		} else if (lastName == null || lastName.equals("")) {
			throw new RuntimeException("Last name is required.");
		} else if (age <= 0) {
			throw new RuntimeException("Age is required.");
		} else if (firstName.length() < 2 || firstName.length() > 25) {
			throw new RuntimeException("First name must be of 2 to 25 character length.");
		} else if (firstName.matches("\\d+")) {
			throw new RuntimeException("Invalid first name. Must be of alphabets");
		}
		
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
