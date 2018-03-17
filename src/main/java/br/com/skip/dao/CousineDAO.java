package br.com.skip.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.skip.exception.BusinessException;
import br.com.skip.model.Cousine;

public class CousineDAO extends AbstractDAO<Cousine> {

	public Collection<Cousine> list() throws BusinessException {
		
		List<Cousine> results = new ArrayList<>();
		
		try {
			
			String sql = "SELECT * FROM COUSINE";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				Cousine c = new Cousine();
				c.setId(rs.getInt("ID"));
				c.setName(rs.getString("NAME"));
				results.add(c);
			}
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage(),e);
		}
		return results;
	}

	public Cousine getById(int id) throws BusinessException {
		
		try {
			
			String sql = "SELECT * FROM COUSINE WHERE ID = ?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			Cousine c = new Cousine();
			
			if (rs.next()) {
				c.setId(rs.getInt("ID"));
				c.setName(rs.getString("NAME"));
			} else {
				c = null;
			}
			
			rs.close();
			ps.close();
			
			return c;
			
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage(),e);
		}
	}

//	public List<Cousine> list(String searchText) throws BusinessException {
//		List<Cousine> results = new ArrayList<>();
//		
//		try {
//			
//			String sql = "SELECT * FROM COUSINE WHERE NAME LIKE ?";
//			PreparedStatement ps = getConnection().prepareStatement(sql);
//			ps.setString(1, "%" + searchText + "%");
//			ResultSet rs = ps.executeQuery();
//			
//			
//			while (rs.next()) {
//				Cousine c = new Cousine();
//				c.setId(rs.getInt("ID"));
//				c.setName(rs.getString("NAME"));
//				results.add(c);
//			}
//			
//			rs.close();
//			ps.close();
//			
//		} catch (SQLException e) {
//			throw new BusinessException(e.getMessage(),e);
//		}
//		return results;
//	}

	
	
}
