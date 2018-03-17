package br.com.skip.business;

import br.com.skip.dao.AbstractDAO;

public abstract class AbstractBusiness<T extends AbstractDAO> implements BusinessInterface<T> {

	private T dao;
	
	public AbstractBusiness(Class<T> clazz) {
		try {
			dao = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public T defaultDao() {
		return dao;
	}
}
