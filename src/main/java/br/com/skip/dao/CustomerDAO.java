package br.com.skip.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import br.com.skip.exception.BusinessException;
import br.com.skip.model.Customer;

public class CustomerDAO extends AbstractDAO<Customer> {

	public boolean checkAuthentication(Customer user) throws BusinessException {
		
		String sql = "SELECT * FROM CUSTOMER WHERE EMAIL = ? AND PASSWORD = ? ";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			
			
			if (rs.next()) {
				return true;
			}
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage(), e);
		}
		return false;
		
		
	}


	public void saveToken(Customer user, String generateUniqueToken, int defaultExpirationMinutes) throws BusinessException {

		String sql = "INSERT INTO TOKENS (ID_CUSTOMER, LAST_USE_TIME, EXPIRE_TIME, TOKEN) VALUES (?,?,?, ?) ";
		
		try {
		
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setTimestamp(2, new java.sql.Timestamp(Date.from(Instant.now()).getTime()));
			
			Instant future = Instant.now().plus(defaultExpirationMinutes, ChronoUnit.MINUTES);
			
			ps.setTimestamp(3, new java.sql.Timestamp(Date.from(future).getTime()));
			ps.setString(4, generateUniqueToken);
			
			ps.execute();
			
			ps.close();
			
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage(), e);
		}
		
	}


	public Customer getByLogin(String login) throws BusinessException {

		String sql = "SELECT * FROM CUSTOMER WHERE EMAIL = ?";
		
		try {
		
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			
			Customer user = new Customer();
			if (rs.next()) {
				user.setId(rs.getInt("ID"));
				user.setEmail(rs.getString("EMAIL"));
				user.setName(rs.getString("NAME"));
			} else {
				return null;
			}
			
			rs.close();
			ps.close();
				
			return user;
			
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage(), e);
		}
		
		
	}


	public Customer getById(int id) throws BusinessException {
		String sql = "SELECT * FROM CUSTOMER WHERE id = ?";
		
		try {
		
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			Customer user = new Customer();
			if (rs.next()) {
				user.setId(rs.getInt("ID"));
				user.setEmail(rs.getString("EMAIL"));
				user.setName(rs.getString("NAME"));
			} else {
				return null;
			}
			
			rs.close();
			ps.close();
				
			return user;
			
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage(), e);
		}
	}

	
	
}
