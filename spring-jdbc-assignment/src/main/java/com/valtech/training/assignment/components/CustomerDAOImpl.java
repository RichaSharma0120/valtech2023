package com.valtech.training.assignment.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.mapping.JdbcSimpleTypes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.valtech.training.assignment.components.CustomerDAOImpl.CustomerRowMapper;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	public class CustomerRowMapper implements RowMapper<Customer> {

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Customer cus=new Customer();
			cus.setC_id(rs.getInt(1));
			cus.setC_name(rs.getString(2));
			cus.setPhone(rs.getString(3));
			cus.setEmail(rs.getString(4));
			
			return cus;
		}

	}

	@Autowired
	private DataSource dataSource;

	private String inserQuery = "INSERT INTO CUSTOMER(C_ID,C_NAME,PHONE,EMAIL) VALUES(?,?,?,?)";
	private String updateQuery = "UPDATE CUSTOMER SET C_NAME=?,PHONE=?,EMAIL=? WHERE C_ID=?";
	private String deleteQuery = "DELETE FROM CUSTOMER WHERE C_ID=?";
	private String getByIDQuery = "SELECT *FROM CUSTOMER WHERE C_ID=?";
	private String countQuery="SELECT COUNT(C_ID) FROM CUSTOMER";
	private String getAllCus="SELECT *FROM CUSTOMER";
	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		new JdbcTemplate(dataSource).update(inserQuery, customer.getC_id(), customer.getC_name(), customer.getPhone(),
				customer.getEmail());
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer ,int id) {
		// TODO Auto-generated method stub
		new JdbcTemplate(dataSource).update(updateQuery, customer.getC_name(), customer.getPhone(), customer.getEmail(),
				id);

		return customer;
	}
	

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		new JdbcTemplate(dataSource).update(deleteQuery, id);

	} 

	@Override
	public Customer getById(int id) {
		// TODO Auto-generated method stub

		return (Customer) new JdbcTemplate().query(getByIDQuery, new CustomerRowMapper());
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		
		return (List<Customer>)new JdbcTemplate(dataSource).query(getAllCus, new CustomerRowMapper());
	}
//
//	public static void main(String[] args) {
//		CustomerDAO dao=new CustomerDAOImpl();
//		System.err.println(dao.saveCustomer(new Customer("kartik",89512,"kartikdandooti")));
//	}

	@Override
	public long countCustomer() {
		
		return new JdbcTemplate(dataSource).queryForObject(countQuery, Long.class);
	}

}
 