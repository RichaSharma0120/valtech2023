package firstWebNEW;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	
	void deleteEmployee(int id)throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void createEmployee(Employee emp) throws SQLException;

	List<Employee> getAllEmployees() throws SQLException;
	
	public long count() throws SQLException;
	
	public void getListOfEmployeeinEachDepartment() throws SQLException;
	
	List<Employee> getEmployeeByDeptLocation(String name) throws SQLException;

	int firstId() throws SQLException;

	int lastId() throws SQLException;

	int nextId(int current) throws SQLException;

	int previousId(int current) throws SQLException;

	//Employee getEmployee(long current) throws SQLException;

	Employee getEmployee(int id) throws SQLException;

	List<Employee> getEmployeeSalaryGreaterThan(int amount) throws SQLException;

	List<Employee> getEmployeeSalaryLesserThan(int amount) throws SQLException;

}
