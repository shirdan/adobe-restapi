package com.adobe.crudrev.web.service;


import org.springframework.stereotype.Component;

import com.adobe.crudrev.web.controller.vo.Customer;

@Component
public interface IAdobeRestService {

	public String persistCustomer(Customer customerForm);

	public String updateCustomer(Customer customerForm);

	public String deleteCustomerById(String name);

	public Customer findCustomerById(String id);

	public boolean isCustomerExist(Customer customer);

}
