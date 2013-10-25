import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import daten.Person;
import daten.Student;


public class StudentTest {

	private ArrayList<Student> al1, al2;
	GregorianCalendar cal = new GregorianCalendar(1993,12,28);
	private Student s = new Student("Alex", "Mueller", cal);
	
	
	@Before
	public void setUp() throws Exception {
		al1 = new ArrayList<Student>();
		al2 = new ArrayList<Student>();
		
		Student s1 = new Student("Alex", "Müller", new GregorianCalendar(1993,12,28));
		Student s2 = new Student("Peter", "Müller", new GregorianCalendar(1992,12,28));
		Student s3 = new Student("Franz", "Müller", new GregorianCalendar(1995,12,28));
		Student s4 = new Student("Heinz", "Müller", new GregorianCalendar(1991,12,28));
		Student s5 = new Student("Karl", "Müller", new GregorianCalendar(1999,12,28));
		
		al1.add(s1);
		al1.add(s2);
		al1.add(s3);
		al1.add(s4);
		al1.add(s5);
		
		al2.add(s4);
		al2.add(s2);
		al2.add(s1);
		al2.add(s3);
		al2.add(s5);
		
	}
	
	@Test
	public void constructorWithValidArguments() {
		Student s = new Student("Peter", "Lustig");
		assertSame("Peter", s.getFirstName());
		assertSame("Lustig", s.getLastName());

		s = new Student("Peter   ", "Lustig   ");
		assertEquals("Peter", s.getFirstName());
		assertEquals("Lustig", s.getLastName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructorWithNullArgumentForFirstName() {
		Student s = new Student(null, "Lustig", cal);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructorWithEmptyArgumentForFirstName() {
		Student s = new Student("", "Lustig");
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructorWithWhiteSpaceArgumentForFirstName() {
		Student s = new Student(" ", "Lustig");
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructorWithNullArgumentForLastName() {
		Student s = new Student("Peter", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructorWithEmptyArgumentForLastName() {
		Student s = new Student("Peter", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructorWithWhiteSpaceArgumentForLastName() {
		Student s = new Student("Peter", " ");
	}

	@Test
	public void testToString() {
		Student s1 = new Student("Alex", "Müller", new GregorianCalendar(1993,11,28));
		Student student = new Student("Alex", "Müller", new GregorianCalendar(1993,12,28));
		assertEquals("Student {firstName=Alex, lastName=Müller, birthDate=19931128}",
				s1.toString());
	}
	
	
	@Test
	public void testSortBirthdate() {
	assertEquals(al2, s.sortBirthdate(al1));
	}
}
