package daten;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

public class Student extends Person implements Comparable<Student> {

	public Student(String firstName, String lastName) {
		this(firstName, lastName, false);
	}
	
	public Student(String firstName, String lastName, GregorianCalendar birthdate) {
		this(firstName, lastName);
		setBirthDate(birthdate);
	}


	public Student(String firstName, String lastName, boolean selfEntitled) {
		super(firstName, lastName);
		setSelfEntitled(selfEntitled);
	}

	public GregorianCalendar getBirthDate() {
		return birthDate;
	}
	
	public String getStringBirthDate()  {
		String s = "" + getBirthDate().get(Calendar.YEAR);
		s += "" + getBirthDate().get(Calendar.MONTH);
		s+= "" + getBirthDate().get(Calendar.DAY_OF_MONTH);
		return s;
	}

	public void setBirthDate(GregorianCalendar birthDate) {
		if(birthDate == null){
			throw new IllegalArgumentException("BirthDate is null!");
		}
		GregorianCalendar calandar = new GregorianCalendar();
		if(birthDate.getTimeInMillis()<=calandar.getTimeInMillis())
		this.birthDate = birthDate;
	}

	private boolean selfEntitled;
	private GregorianCalendar birthDate; // TODO add getter,setter,Constructors

	public void setSelfEntitled(boolean selfEntitled) {
		this.selfEntitled = selfEntitled;
	}

	@Override
	public int compareTo(Student o) {
		int result = 0;

		// TODO implement meaningful unit tests
		if ((result = getLastName().compareTo(o.getLastName())) == 0) {
			if ((result = getFirstName().compareTo(o.getFirstName())) == 0) {
				result = birthDate.compareTo(o.birthDate); // TODO change to
															// getter after
															// implementation
			}
		}
		return result;
	}

	@Override
	public String toString() {
		
		String s = String.format("%s {firstName=%s, lastName=%s, birthDate=%s}", getClass()
				.getSimpleName(), getFirstName(), getLastName(), getStringBirthDate());
		System.out.println(s);
		return s;
		}
	
	public ArrayList<Student> sortBirthdate(ArrayList<Student> al){
		Collections.sort(al, new Comparator<Student>(){
			@Override
			public int compare(Student s1, Student s2) {
				if(s1.getBirthDate().YEAR == s2.getBirthDate().YEAR){
					if(s1.getBirthDate().MONTH == s2.getBirthDate().MONTH) {
						if(s1.getBirthDate().DAY_OF_MONTH == s2.getBirthDate().DAY_OF_MONTH) {
							return 0;
						} else if(s1.getBirthDate().DAY_OF_MONTH > s2.getBirthDate().DAY_OF_MONTH){
							return 1;
						}
					} else if(s1.getBirthDate().MONTH > s2.getBirthDate().MONTH){
						return 1;
					}
				} else if(s1.getBirthDate().YEAR > s2.getBirthDate().YEAR){
					return 1;
				}
				return -1;
			}
			
		});
		return al;
	}
}
