package firstWebNEW;
import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {


	void createDepartment(Department dept) throws SQLException;
	
	void updateDepartment(Department dept) throws SQLException;

	void deleteDepartment(int id) throws SQLException;

	List<Department> getDepartments() throws SQLException;

	Department getDepartment(int id) throws SQLException;
	
	public long count() throws SQLException;

	List<Employee> getEmployeesByDepartment(int deptId) throws SQLException;

	List<Employee> getEmployeesByLocation(String location) throws SQLException;

	int firstId() throws SQLException;

	int lastId() throws SQLException;

	int nextId(int current) throws SQLException;

	int previousId(int current) throws SQLException;


}
