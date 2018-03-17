package br.com.skip.business;

import br.com.skip.dao.OrderDAO;
import br.com.skip.exception.BusinessException;
import br.com.skip.model.Order;

public class OrderBusiness extends AbstractBusiness<OrderDAO> {

	public OrderBusiness() {
		super(OrderDAO.class);
	}

	public Order getById(int orderId) throws BusinessException {
		return defaultDao().getById(orderId);
	}

}
