package com.valtech.training.assignment.components;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.training.assignment.components.ProductDAOImpl.ProductRowMApper;

@Component
public class ProductDAOImpl implements ProductDAO {
	
	public class ProductRowMApper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Product product=new Product();
			product.setpId(rs.getInt(1));
			product.setUnitPrice(rs.getInt(2));
			product.setDescription(rs.getString(3));
			product.setCompanyId(rs.getInt(4));
			return null;
		}

	}

	@Autowired
	DataSource dataSource;
	
	
	private String insertQuery="INSERT INTO PRODUCT(UNIT_PRICE,DESCRIPTION,COMPANY_ID) VALUES(?,?,?)";
	private String countQuery="SELECT COUNT(*) FROM PRODUCT";
	private String updateQuery="UPDATE PRODUCT SET UNIT_PRICE=?,DESCRIPTION=? WHERE P_ID=?";
	private String deleteQuery="DELETE FROM PRODUCT WHERE P_ID=?";
	private String getById="SELECT *FROM PRODUCT WHERE P_ID=?";

	@Override
	public void addProduct(Product product) {
		new JdbcTemplate(dataSource).update(insertQuery,product.getUnitPrice(),product.getDescription(),
				product.getCompanyId());
		
	}

	@Override
	public void updateProduct(Product product, int pId) {
		// TODO Auto-generated method stub
		new JdbcTemplate(dataSource).update(updateQuery,product.getUnitPrice(),product.getDescription(),pId);
		
		
	}

	@Override
	public void deleteProduct(int pId) {
		// TODO Auto-generated method stub\
		new JdbcTemplate(dataSource).update(deleteQuery,pId);
		
	}

	@Override
	public int countProduct() {
		// TODO Auto-generated method stub
		return new JdbcTemplate(dataSource).queryForObject(countQuery,Integer.class);
	}

	@Override
	public void getById(int pId) {
		// TODO Auto-generated method stub
		new JdbcTemplate(dataSource).query(getById,new  ProductRowMApper());
		
	}

}
