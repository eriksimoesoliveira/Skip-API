package br.com.skip.business;

import java.util.List;
import java.util.stream.Collectors;

import br.com.skip.dao.StoreDAO;
import br.com.skip.exception.BusinessException;
import br.com.skip.model.Store;

public class StoreBusiness extends AbstractBusiness<StoreDAO> {

	public StoreBusiness() {
		super(StoreDAO.class);
	}

	public List<Store> list(int cousineId) throws BusinessException {
		List<Store> ret = defaultDao().list().stream()
				.filter(s -> s.getCousine().getId() == cousineId)
				.collect(Collectors.toList());
		return ret;
	}

}
