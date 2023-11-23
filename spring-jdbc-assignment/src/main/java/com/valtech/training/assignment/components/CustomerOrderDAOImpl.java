package com.valtech.training.assignment.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerOrderDAOImpl implements CustomerOrderDAO{
	

	public class OrderRowMapper implements RowMapper<CustomerOrder> {

		@Override
		public CustomerOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			CustomerOrder order=new CustomerOrder();
			order.setOrder_id(rs.getInt(1));
			order.setOrder_date(rs.getDate(2));
			order.setC_id(rs.getInt(3));
			return order;
		}

		
	}

	@Autowired
	private DataSource dataSource;
	
	private String insertQuery="INSERT INTO CUSTOMERORDER(ORDER_DATE,C_ID) VALUES(?,?)";
	
	private String countQuery="SELECT COUNT(ORDER_ID) FROM CUSTOMERORDER";
	
	private String updateQuery="UPDATE CUSTOMERORDER SET ORDER_DATE=?,C_ID=? WHERE ORDER_ID=?";
	
	private String deleteQuery="DELETE FROM CUSTOMERORDER WHERE ORDER_ID=?";
	
	private String getByIdquery="SELECT *FROM CUSTOMERORDER WHERE ORDER_ID=?";
	
	@Override
	public void createOrder(CustomerOrder customerOrder) {
		// TODO Auto-generated method stub
		
		 new JdbcTemplate(dataSource).update(insertQuery,customerOrder.getOrder_date(),customerOrder.getC_id());
	}

	@Override
	public CustomerOrder updateOrder(CustomerOrder customerOrder, int order_id) {
		new JdbcTemplate(dataSource).update(updateQuery,customerOrder.getOrder_date(),customerOrder.getC_id(), order_id);
		return null;
	}

	@Override
	public void deleteOrder(int order_id) {
		new JdbcTemplate(dataSource).update(deleteQuery,order_id);
	}

	@Override
	public CustomerOrder getById(int order_id) {
//		new JdbcTemplate(dataSource).query(getByIdquery, new OrderRowMapper());
		// TODO Auto-generated method stub
		return (CustomerOrder) new JdbcTemplate(dataSource).query(getByIdquery, new OrderRowMapper());
	}

	@Override
	public List<CustomerOrder> getAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countOrder() {
		
		return new JdbcTemplate(dataSource).queryForObject(countQuery, Integer.class);
	}
	

}
