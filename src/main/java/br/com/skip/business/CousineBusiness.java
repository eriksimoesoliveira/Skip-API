package br.com.skip.business;

import java.util.List;
import java.util.stream.Collectors;

import br.com.skip.dao.CousineDAO;
import br.com.skip.exception.BusinessException;
import br.com.skip.model.Cousine;

public class CousineBusiness extends AbstractBusiness<CousineDAO> {

	public CousineBusiness() {
		super(CousineDAO.class);
	}

	public List<Cousine> list() throws BusinessException {
		return (List<Cousine>) defaultDao().list();
	}

	public List<Cousine> list(String searchText) throws BusinessException {
		List<Cousine> ret = defaultDao().list().stream()
				.filter(c -> c.getName().contains(searchText))
				.collect(Collectors.toList());
		return ret;
	}

	
	
}
