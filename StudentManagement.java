
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class StudentManagement {

	
	static String url = "jdbc:mysql://localhost:3306/studentdata";
	static String userName = "root";
	static String password = "root";
	static String driverClassPath = "com.mysql.jdbc.Driver";

	public static Connection getDataBaseConnetion() {
		Connection con = null;
		try {
			Class.forName(driverClassPath);
			con = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
  }
	
	public static void saveStudent(StudentData stdf) {

		int affetctedRow = 0;

		Connection con = getDataBaseConnetion();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("insert into studentdata (id,firstname,lastname,marks) values(?,?,?,?)");
			stmt.setInt(1, stdf.getId());
			stmt.setString(2, stdf.getLastname());
			stmt.setString(3, stdf.getLastname());
			stmt.setInt(4, stdf.getMarks());
			affetctedRow = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		if(affetctedRow == 0){
			System.out.println("Student information can not be saved ... !!! : affected Rows are = "+affetctedRow);
		}else{

			System.out.println("Student information saved succesfully : affected Rows are = "+affetctedRow);
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int updateStudent(int id,String fname) {

		int affetctedRow = 0;

		Connection con = getDataBaseConnetion();
		PreparedStatement stmt;
		try {
			String query = "UPDATE studentData SET firstname = ? WHERE id = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(2, id);
			stmt.setString(1, fname);
			affetctedRow = stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		if(affetctedRow == 0){
			System.out.println("Student information can not be Update ... !!! : affected Rows are = "+affetctedRow);
		}else{

			System.out.println("Student information updated succesfully : affected Rows are = "+affetctedRow);
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return affetctedRow;
	}
	
	public static void deleteStudent(int id) {

		int affetctedRow = 0;

		Connection con = getDataBaseConnetion();
		PreparedStatement stmt;
		try {
			String query = "delete from studentdata where id = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			affetctedRow = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		if(affetctedRow == 0){
			System.out.println("Student information can not be Deleted ... !!! : affected Rows are = "+affetctedRow);
		}else{

			System.out.println("Student information Deleted succesfully : affected Rows are = "+affetctedRow);
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getStudent(int id) {


		Connection con = getDataBaseConnetion();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String query = "select * from studentdata where id ="+id;
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("Student with Id : "+id+"is =>");
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void getTopperStudent() {


		Connection con = getDataBaseConnetion();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select max(marks) as marks from studentdata");
			System.out.println("maximun marks is =>");

			while(rs.next()){
				System.out.println(rs.getInt("marks"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}