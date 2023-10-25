package firstWebNEW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

	// Create Operation
	@Override
	public void createDepartment(Department dept) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO DEPARTMENT (DEPTID,DEPT_NAME,DEPT_LOCATION) VALUES(?,?,?)");
		populatePreparedStatment(dept, ps);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows update:" + rowsUpdated);
		con.close();
	}

	// Update Operation
	@Override
	public void updateDepartment(Department dept) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("UPDATE DEPARTMENT SET DEPTID=?,DEPT_NAME=?,DEPT_LOCATION=? WHERE DEPTID=? ");
		populatePreparedStatment(dept, ps);
		ps.setInt(4, dept.getDeptId());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows update:" + rowsUpdated);
		con.close();
	}

	// Delete Operation
	@Override
	public void deleteDepartment(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM DEPARTMENT WHERE DEPTID=?");
		ps.setInt(1, id);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows update:" + rowsUpdated);
		con.close();
	}
	
	@Override
	public long count() throws SQLException {
		
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT COUNT(DEPTID) FROM DEPARTMENT");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
		long result = rs.getLong(1);
		return result;
		}else {
		return 0;
		}

	}

	// Read Operation
	@Override
	public List<Department> getDepartments() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM DEPARTMENT");
		ResultSet rs = ps.executeQuery();
		List<Department> dept = new ArrayList<>();
		while (rs.next()) {
			dept.add(mapSingleRow(rs));
		}
		con.close();
		return dept;
	}

	@Override
	public Department getDepartment(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM DEPARTMENT WHERE DEPTID=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Department dept = mapSingleRow(rs);
			con.close();
			return dept;
		} else {
			System.out.println("No DeptId found " + id + " ,Couldn't fetch data");
			return null;
		}
	}

	private Department mapSingleRow(ResultSet rs) throws SQLException {
		Department dept = new Department();
		dept.setDeptId(rs.getInt(1));
		dept.setDeptName(rs.getString(2));
		dept.setDeptLoc(rs.getString(3));
		return dept;
	}

	private void populatePreparedStatment(Department dept, PreparedStatement ps) throws SQLException {
		ps.setInt(1, dept.getDeptId());
		ps.setString(2, dept.getDeptName());
		ps.setString(3, dept.getDeptLoc());
	}

	// Static methods are initialized as soon as an object instance is created
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/valtech2023?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
	}
	
	private Department mapRowToDepartment(ResultSet rs) throws SQLException {
		Department d = new Department();
		 // INDEX STARTS FROM 1
		d.setDeptId(rs.getInt(1));
		d.setDeptName(rs.getString(2));
		d.setDeptLoc(rs.getString(3));
		return d;
	}
	
	@Override
	public List<Employee> getEmployeesByDepartment(int deptId) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("select * from employee where deptId in (select deptId from department where deptId=?)");
		ps.setInt(1, deptId);
		ResultSet rs = ps.executeQuery();
		List<Employee> empList = new ArrayList<>();
		while (rs.next()) {
			empList.add(mapRowToEmployee(rs));
		}
		con.close();
		return empList;
	}
	
	@Override
	public List<Employee> getEmployeesByLocation(String location) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("select * from employee where deptId in (select deptId from department where location=?)");
		ps.setString(1, location);
		ResultSet rs = ps.executeQuery();
		List<Employee> empList = new ArrayList<>();
		while (rs.next()) {
			empList.add(mapRowToEmployee(rs));
		}
		con.close();
		return empList;
	}

	private Employee mapRowToEmployee(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		 // INDEX STARTS FROM 1
		e.setName(rs.getString(1));
		e.setAge(rs.getInt(2));
		e.setExperience(rs.getInt(3));
		e.setSeniority(rs.getInt(4));
		e.setSalary(rs.getInt(5));
		e.setId(rs.getInt(6));
		e.setDeptId(rs.getInt(7));
		return e;
	}
	
	@Override
	public int firstId() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select min(deptId) from department");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int id1 = rs.getInt(1);
			con.close();
			return id1;
		}
//			con.close();
		return 0;
	}

	@Override
	public int lastId() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select max(deptId) from DEPARTMENT");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int id = rs.getInt(1);
			con.close();
			return id;
		}
//			con.close();
		return 0;
	}

	@Override
	public int nextId(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select min(deptId) from DEPARTMENT where deptId>?");
		ps.setInt(1, (int) id);
		ResultSet rs = ps.executeQuery();
		int id1 = 0;
		if (rs.next()) {
			id1 = rs.getInt(1);
			con.close();
		}
		con.close();
		return id1 == 0 ? lastId() : id1;
	}

	@Override
	public int previousId(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT MIN(deptId) FROM DEPARTMENT WHERE deptId < ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		int id1 = 0;
		if (rs.next()) {
			id1 = rs.getInt(1);
			con.close();
		}
		con.close();
		return id1 == 0 ? lastId() : id1;
	}

	public static void main(String[] args) throws SQLException {
		DepartmentDAO deptdao = new DepartmentDAOImpl();
		System.out.println(deptdao.count());
//		System.out.println(deptdao.getDepartments());
		System.out.println(deptdao.getEmployeesByDepartment(102));
	}


}
