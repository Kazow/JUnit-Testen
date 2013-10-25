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
	
	public Student(String firstName, String lastName, Date birthdate) {
		this(firstName, lastName);
		setBirthDate(birthdate);
	}


	public Student(String firstName, String lastName, boolean selfEntitled) {
		super(firstName, lastName);
		setSelfEntitled(selfEntitled);
	}

	public Date getBirthDate() {
		return birthDate;
	}
	
	public String getStringBirthDate()  {
		String s = "" + getBirthDate().getYear();
		s += "" + getBirthDate().getMonth();
		s+= "" + getBirthDate().getDate();
		return s;
	}

	public void setBirthDate(Date birthDate) {
		if(birthDate == null){
			throw new IllegalArgumentException("BirthDate is null!");
		}
		this.birthDate = birthDate;
	}

	private boolean selfEntitled;
	private Date birthDate; // TODO add getter,setter,Constructors

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
//		System.out.println(s);
		return s;
		}
	
	public ArrayList<Student> sortBirthdate(ArrayList<Student> al){
		Collections.sort(al, new Comparator<Student>(){
			@Override
			public int compare(Student s1, Student s2) {
				if(s1.getBirthDate().getYear() == s2.getBirthDate().getYear()){
					System.out.println("getYear() =="+s1.getBirthDate().getYear()+"=="+s2.getBirthDate().getYear());
					if(s1.getBirthDate().getMonth() == s2.getBirthDate().getMonth()) {
						System.out.println("getMonth() ==");
						if(s1.getBirthDate().getDate() == s2.getBirthDate().getDate()) {
							System.out.println("getDate() ==");
							return 0;
						} else if(s1.getBirthDate().getDate() > s2.getBirthDate().getDate()){
							System.out.println("getDate() >");
							return 1;
						}
					} else if(s1.getBirthDate().getMonth() > s2.getBirthDate().getMonth()){
						System.out.println("getMonth() >");
						return 1;
					}
				} else if(s1.getBirthDate().getYear() > s2.getBirthDate().getYear()){
					System.out.println("getYear() >");
					return 1;
				}
				return -1;
			}
		});
		for(Student s : al) {
			System.out.println(s);
		}
		return al;
	}
}