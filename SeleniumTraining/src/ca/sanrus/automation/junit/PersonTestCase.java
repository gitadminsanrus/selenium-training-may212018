package ca.sanrus.automation.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonTestCase {
	
	@BeforeClass
	public static void setUp() {
		System.out.println("setUp() method");
	} 
	
	@AfterClass
	public static void tearDown() {
		System.out.println("tearDown() method");
	}
	
	@Test
	public void testPersonConstructor() {
		Person p = new Person("AA", "BB", 18);
		
		Assert.assertEquals("First Name is not saved in Person object", true, "AA".equals(p.getFirstName()));
		Assert.assertEquals("Last name is not saved in Person object", true, "BB".equals(p.getLastName()));
		Assert.assertEquals("Age is not saved in Person object", true, 18 == p.getAge());
	}
	
	@Test
	public void testPersonConstructor_NoFirstName() {
		try {
			Person p = new Person(null, "BB", 18);
		} catch (RuntimeException e) {
			Assert.assertEquals(true, "First name is required.".equals(e.getMessage()));
		}
	}
	
	@Test
	public void testPersonConstructor_NoLastName() {
		try {
			Person p = new Person("AA12", null, 18);
		} catch (RuntimeException e) {
			Assert.assertEquals(true, "Last name is required.".equals(e.getMessage()));
		}
	}
	
	@Test
	public void testPersonConstructor_FirstNameWithDigits() {
		
		try {
			Person p = new Person("123", "BB", 18);
			Assert.fail("Person object must not be created with firstname digits.");
		} catch (RuntimeException e) {
			Assert.assertEquals(true, "Invalid first name. Must be of alphabets".equals(e.getMessage()));
		}
	}

}
