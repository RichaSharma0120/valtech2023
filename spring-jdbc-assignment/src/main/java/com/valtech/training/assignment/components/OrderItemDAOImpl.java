package com.valtech.training.assignment.components;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.training.assignment.components.OrderItemDAOImpl.OrderItemRowMapper;

@Component
public class OrderItemDAOImpl implements OrderItemDAO {

	public class OrderItemRowMapper implements RowMapper<OrderItems> {

		@Override
		public OrderItems mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrderItems items=new OrderItems();
			items.setItemId(rs.getInt(1));
			items.setOrderId(rs.getInt(2));
			items.setQuantity(rs.getInt(3));
			items.setProductId(rs.getInt(4));
			items.setAmount(rs.getDouble(5));
			return null;
		}

		

	}

	@Autowired
	private DataSource dataSource;
	
//	int orderId, int quantity, int productId, double amount
	private String insertQuery=
			"INSERT INTO ORDER_ITEMS(ORDER_ID,QUANTITY,PRODUCT_ID,AMOUNT) VALUES(?,?,?,?)";
	private String countQuery="SELECT COUNT(*) FROM ORDER_ITEMS ";
	private String updateQury="UPDATE ORDER_ITEMS SET ORDER_ID=?,QUANTITY=?,"
			+ "PRODUCT_ID=?,AMOUNT=? WHERE ITEM_ID=?";
	private String deleteQuery="DELETE FROM ORDER_ITEMS WHERE ITEM_ID=?";
	private String getById="SELECT *FROM ORDER_ITEMS WHERE ITEM_ID=?";
	@Override
	public void addOrderItems(OrderItems items) {
		// TODO Auto-generated method stub
		new JdbcTemplate(dataSource).update(insertQuery,items.getOrderId(),items.getQuantity(),
				items.getProductId(),items.getAmount());

	}

	@Override
	public void updateOrderItems(OrderItems items, int itemId) {
		// TODO Auto-generated method stub
		new JdbcTemplate(dataSource).update(updateQury,items.getOrderId(),items.getQuantity(),
		items.getProductId(),items.getAmount(),itemId);

	}

	@Override
	public void deleteOrderItems(int itemId) {
		// TODO Auto-generated method stub
		new JdbcTemplate(dataSource).update(deleteQuery,itemId);

	}

	@Override
	public int countOrderItem() {
		// TODO Auto-generated method stub
		return new JdbcTemplate(dataSource).queryForObject(countQuery,Integer.class);
	}

	@Override
	public OrderItems getById(int itemId) {
		// TODO Auto-generated method stub
		return (OrderItems) new JdbcTemplate(dataSource).query(getById, new OrderItemRowMapper());
	}

}
