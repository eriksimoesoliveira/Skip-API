package br.com.skip.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.skip.exception.BusinessException;
import br.com.skip.model.Store;

public class StoreDAO extends AbstractDAO<Store> {

	
	public Collection<Store> list() throws BusinessException {
		
		List<Store> results = new ArrayList<>();
		
		try {
			
			String sql = "SELECT * FROM STORES";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				Store c = new Store();
				c.setId(rs.getInt("ID"));
				c.setName(rs.getString("NAME"));
				c.setAddress(rs.getString("ADDRESS"));
				c.setCousine(new CousineDAO().getById(rs.getInt("ID_COUSINE")));
				results.add(c);
			}
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage(),e);
		}
		return results;
	}

	public Store getById(int id) throws BusinessException {
		
		try {
			
			String sql = "SELECT * FROM STORES where id = ?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			Store c = null;
			
			if (rs.next()) {
				c = new Store();
				c.setId(rs.getInt("ID"));
				c.setName(rs.getString("NAME"));
				c.setAddress(rs.getString("ADDRESS"));
				c.setCousine(new CousineDAO().getById(rs.getInt("ID_COUSINE")));
			}
			
			rs.close();
			ps.close();
			
			return c;
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage(),e);
		}
	}

}
