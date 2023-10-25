package firstWeb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Override
	public int firstId() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select min(empId) from employee");
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int id1 = rs.getInt(1);
			con.close();
			return id1;
		}
//		con.close();
		return 0;
			}
	@Override
	public int lastId() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select max(empId) from employee");
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int id = rs.getInt(1);
			con.close();
			return id;
		}
//		con.close();
		return 0;
	}
	
	@Override
	public int nextId(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select min(empId) from employee where empId>?");
		ps.setInt(1, (int) id);
		ResultSet rs = ps.executeQuery();
		int id1=0;
		if(rs.next()) {
			id1 = rs.getInt(1);
			con.close();
		}
		con.close();
		return id1 == 0? lastId() : id1;
	}
	
	@Override
	public int previousId(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT MIN(EMPID) FROM EMPLOYEE WHERE EMPID < ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		int id1=0;
		if (rs.next()) {
			id1= rs.getInt(1);
			con.close();
		}
		con.close();
		return id1 == 0? lastId(): id1;
	}

		@Override
		public long count() throws SQLException{
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(EMPID) FROM EMPLOYEE");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				long result = rs.getLong(1);
				return result;
			}else {
				return 0;
			}
			}

		// CRUD operations - create read update delete

		@Override
		public void deleteEmployee(int id) throws SQLException {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE EMPID = ?");
			ps.setInt(1, id);
			int rowsUpdated = ps.executeUpdate();
			System.out.println("Rows updated: " + rowsUpdated);
			conn.close();
		}

		@Override
		public void updateEmployee(Employee emp) throws SQLException {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE EMPLOYEE SET NAME=?, AGE=? , EXPERIENCE=? , SENIORITY=? , SALARY=? WHERE ID = ?");
			populatePreparedStatementFromEmployee(emp, ps);
			ps.setInt(6, emp.getId());
			int rowsUpdated = ps.executeUpdate();
			System.out.println("Rows updated: " + rowsUpdated);
			conn.close();
		}

		@Override
		public void createEmployee(Employee emp) throws SQLException {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,EXPERIENCE,SENIORITY,SALARY) VALUES (?,?,?,?,?)");
			populatePreparedStatementFromEmployee(emp, ps);
			int rowsUpdated = ps.executeUpdate();
			System.out.println("Rows updated: " + rowsUpdated);
			conn.close();
		}

		private void populatePreparedStatementFromEmployee(Employee emp, PreparedStatement ps) throws SQLException {
			System.out.println(emp);
			ps.setString(1, emp.getName());
			ps.setInt(2, emp.getAge());
			ps.setInt(3, emp.getExperience());
			ps.setInt(4, emp.getSeniority());
			ps.setInt(5, (int) emp.getSalary());
			ps.setInt(6, emp.getDeptId());
		}

		@Override
		public List<Employee> getAllEmployees() throws SQLException {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT EMPID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPTID FROM EMPLOYEE ");
			ResultSet rs = ps.executeQuery();
			List<Employee> emps = new ArrayList<Employee>();
			while (rs.next()) {
				emps.add(mapRowToEmployee(rs));
			}
			conn.close();
			return emps;
		}

		public Employee getEmployee(int id) throws SQLException {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY FROM EMPLOYEE WHERE EMPID = ?");
			ps.setInt(1, id);
			// result of the execution of the query
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Employee e = mapRowToEmployee(rs);
				conn.close();
				return e;

			} else {
				System.out.println("No row with id = " + id + "found...");
				return null;
			}

		}

		private Employee mapRowToEmployee(ResultSet rs) throws SQLException {
			Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setAge(rs.getInt(3));
			e.setExperience(rs.getInt(4));
			e.setSeniority(rs.getInt(5));
			e.setSalary(rs.getInt(6));
			e.setDeptId(rs.getInt(7));
			return e;
		}

		static {
			try {
				Class.forName("com.mysql.jdbc.Driver"); // loads the driver. automatically loads itself to driver manager
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private Connection getConnection() throws SQLException {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSl=false", "root", "root");
		}


		@Override
		public void getListOfEmployeeinEachDepartment() throws SQLException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public List<Employee> getEmployeeByDeptLocation(String name) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
//		@Override
//		public Employee getEmployee(long l) throws SQLException {
//			Connection con = getConnection();
//			PreparedStatement ps = con
//					.prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPTID FROM EMPLOYEE WHERE EMPID=?");
//			ps.setInt(1, empId); // now it's gonna be where id=1,2,3,4 and so on
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				Employee e = mapRowToEmployee(rs);
//				con.close();
//				return e;
//			} else {
//				System.out.println("no row with id - " + empId + " found....");
//				return null;
//			}
//		}
//		@Override
//		public Employee getEmployee(long l) throws SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
		
		
		public static void main(String[] args) throws Exception {

			EmployeeDAO dao = new EmployeeDAOImpl();
			System.out.println(dao.count());
			System.out.println(dao.getAllEmployees());

		}

//		@Override
//		public void getListOfEmployeeinEachDepartment() throws SQLException {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public List<Employee> getEmployeeByDeptLocation(String name) throws SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public List<Employee> getEmployeeByDeptName(String name) throws SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public List<Employee> getEmployeeAgeBetween(int min, int max) throws SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public List<Employee> getEmployeeBySeniority(int limitVal) throws SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public List<Employee> getEmployeeSalaryGreater(int amount) throws SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public List<Employee> getEmployeeSalaryLesser(int amount) throws SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public long countEmployee() throws SQLException {
//			// TODO Auto-generated method stub
//			return 0;
//}

	}



