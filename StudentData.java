
public class StudentData {

	private int id;
	private String firstname;
	private String lastname;
	private int marks;
	
	
	
	public StudentData(int id, String firstname, String lastname, int marks) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.marks = marks;
	}




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public int getMarks() {
		return marks;
	}



	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	
	
}
