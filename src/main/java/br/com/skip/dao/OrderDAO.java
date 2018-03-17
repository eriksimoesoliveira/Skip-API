package br.com.skip.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.skip.exception.BusinessException;
import br.com.skip.model.Order;

public class OrderDAO extends AbstractDAO<Order> {

	public Order getById(int orderId) throws BusinessException {

		try {
			String sql = "SELECT * FROM ORDERS WHERE ID = ?";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			
			Order order = null;
			CustomerDAO customerDAO = new CustomerDAO();
			StoreDAO storeDAO = new StoreDAO();
			
			
			if (rs.next()) {
				order = new Order();
				order.setContact(rs.getString("CONTACT"));
				order.setCustomer(customerDAO.getById(rs.getInt("CUSTOMER_ID")));
				order.setDate(rs.getDate("ORDER_DATE"));
				order.setDeliveryAddress(rs.getString("DELIVERY_ADDRESS"));
				order.setId(rs.getInt("ID"));
				order.setLastUpdate(rs.getDate("LAST_UPDATE"));
				order.setStatus(rs.getString("STATUS"));
				order.setStore(storeDAO.getById(rs.getInt("STORE_ID")));
				order.setTotal(rs.getDouble("TOTAL"));
			}
			
			rs.close();
			ps.close();
			
			return order;
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage(), e);
		}
		
		

	}

}
