package br.com.skip.business;

import br.com.skip.dao.AbstractDAO;

public interface BusinessInterface<T extends AbstractDAO> {

	T defaultDao();
	
}
