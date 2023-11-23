package com.valtech.training.assignment.components;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerAddressDAOImpl implements CustomerAddressDAO{
	
	private String insertQuery="INSERT INTO CUSTOMER_ADDRESS(C_ID,STREET,TOWN,STATE,ZIPCODE) VALUES(?,?,?,?,?)";
	private String countQuery="SELECT COUNT(C_ID) FROM CUSTOMER_ADDRESS";
	private String upadateQuery="UPDATE CUSTOMER_ADDRESS SET STREET=?,TOWN=?,STATE=?,ZIPCODE=? WHERE C_ID=?";
	private String deleteQuery="DELETE FROM CUSTOMER_ADDRESS WHERE C_ID=?";
	@Autowired
	DataSource dataSource;
	@Override
	public void setAddress(CustomerAddress address) {
		new JdbcTemplate(dataSource).update(insertQuery,address.getC_id(),address.getStreet(),address.getTown(),address.getState(),address.getZipcode());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAddress(CustomerAddress address,int c_id) {
		// TODO Auto-generated method stub
		new JdbcTemplate(dataSource).update(upadateQuery,address.getStreet(),address.getTown(),address.getState(),address.getZipcode(),c_id);
		
		
	}

	@Override
	public void deleteAddress(int c_id) {
		new JdbcTemplate(dataSource).update(deleteQuery,c_id);
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		
		return new JdbcTemplate(dataSource).queryForObject(countQuery,Integer.class);
	}

}
