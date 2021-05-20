
public class SaveStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentData s = new StudentData(2, "Prathamesh", "Varote", 95);

	    StudentManagement.saveStudent(s);
	    StudentManagement.updateStudent(5, "DEE");
	    StudentManagement.deleteStudent(9);
		StudentManagement.getStudent(3);
		StudentManagement.getTopperStudent();
		
		
		
	}

}
