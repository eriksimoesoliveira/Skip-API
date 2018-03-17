package br.com.skip.business;

import java.util.UUID;

import br.com.skip.dao.CustomerDAO;
import br.com.skip.exception.BusinessException;
import br.com.skip.exception.ValidationException;
import br.com.skip.model.Customer;

public class CustomerBusiness extends AbstractBusiness<CustomerDAO> {

	public CustomerBusiness() {
		super(CustomerDAO.class);
	}
	
	private static final int DEFAULT_TOKEN_EXPIRATION_TIME = 30;

	public boolean checkAuthentication(Customer user) throws BusinessException {
		return defaultDao().checkAuthentication(user);
	}

	public String issueToken(Customer user) throws BusinessException {
		Customer u = defaultDao().getByLogin(user.getEmail());
		String token = generateUniqueToken();
		defaultDao().saveToken(u, token, DEFAULT_TOKEN_EXPIRATION_TIME);
		return token;
	}
	
	public String issueToken(Customer user, int expiration) throws BusinessException {
		Customer u = defaultDao().getByLogin(user.getEmail());
		String token = generateUniqueToken();
		defaultDao().saveToken(u, token, expiration);
		return token;
	}
	
	private String generateUniqueToken() {
		return UUID.randomUUID().toString();
	}

	public void validateCustomer(Customer customer) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

	public void save(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public boolean checkToken(String token) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
