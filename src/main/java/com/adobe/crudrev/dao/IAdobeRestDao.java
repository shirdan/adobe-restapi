package com.adobe.crudrev.dao;

import org.springframework.stereotype.Component;

import com.adobe.crudrev.dao.entity.CustomerEntity;

@Component
public interface IAdobeRestDao {
	
	public String persistCustomer(CustomerEntity customerForm);

	public String updateCustomer(CustomerEntity customerForm);

	public String deleteCustomerById(int cust_id);

	public CustomerEntity findCustomerById(int id);

}
