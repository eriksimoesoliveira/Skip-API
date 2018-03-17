package br.com.skip.dao;

import java.sql.Connection;

import br.com.skip.exception.BusinessException;

public interface DAOInterface<T> {

	T getById(int id) throws BusinessException;
	
	Connection getConnection();
	
}
