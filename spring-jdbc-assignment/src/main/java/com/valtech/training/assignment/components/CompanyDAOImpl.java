package com.valtech.training.assignment.components;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.valtech.training.assignment.components.CompanyDAOImpl.CompnayRowMapper;

@Component
public class CompanyDAOImpl implements CompanyDAO{
	
	public class CompnayRowMapper implements RowMapper<Company> {

		@Override
		public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Company company=new Company();
			company.setC_id(rs.getInt(1));
			company.setName(rs.getString(2));
			company.setStreet(rs.getString(3));
			company.setTown(rs.getString(4));
			company.setState(rs.getString(5));
			company.setZipcode(rs.getInt(6));
			
;			return company;
		}

	}

	private String addCompany=
			"INSERT INTO COMPANY(NAME,STREET,TOWN,STATE,ZIPCODE) VALUES(?,?,?,?,?)";
	private String countCompany="SELECT COUNT(C_ID) FROM COMPANY";
	private String updateCompany=
			"UPDATE COMPANY SET NAME=?,STREET=?,TOWN=?,STATE=?,ZIPCODE=? WHERE C_ID=?";
	private String deleteCompany="DELETE FROM COMPANY WHERE C_ID=?";
	private String getByIdCompany="SELECT *FROM COMPANY WHERE C_ID=?";
	
	@Autowired
	DataSource dataSource;

	@Override
	public void addCompany(Company company) {
		// TODO Auto-generated method stub
	new JdbcTemplate(dataSource).update(addCompany,company.getName(),
			company.getStreet(),company.getTown(),company.getState(),company.getZipcode());
		
	}

	@Override
	public void updateCompany(Company company, int c_id) {
		// TODO Auto-generated method stub
		new JdbcTemplate(dataSource).update(updateCompany,company.getName(),company.getStreet(),
				company.getTown(),company.getState(),company.getZipcode(),c_id);
		
		
	}

	@Override
	public void deleteCompany(int c_id) {
		// TODO Auto-generated method stub
		new JdbcTemplate(dataSource).update(deleteCompany,c_id);
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		
		return new JdbcTemplate(dataSource).queryForObject(countCompany,Integer.class);
	}

	@Override
	public Company getById(int id) {
		new JdbcTemplate(dataSource).query(getByIdCompany, new CompnayRowMapper());
		return null;
	}
	
	

}
