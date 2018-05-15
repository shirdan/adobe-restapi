package com.adobe.crudrev.web.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adobe.crudrev.dao.IAdobeRestDao;
import com.adobe.crudrev.dao.entity.CustomerEntity;
import com.adobe.crudrev.web.controller.vo.Customer;
import com.adobe.crudrev.web.service.IAdobeRestService;


@Service("AdobeRestServiceImpl")
@Transactional
public class AdobeRestServiceImpl implements IAdobeRestService {

	@Autowired
	@Qualifier("AdobeDaoImpl")
	private IAdobeRestDao adoberestDao;

	@Override
	public String persistCustomer(Customer customerForm) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setId(customerForm.getCust_id());
		customerEntity.setAddress(customerForm.getAddress());
		customerEntity.setAge(customerForm.getAge());
		customerEntity.setCountry(customerForm.getCountry());
		customerEntity.setCreated_at(customerForm.getCreated_at());
		customerEntity.setEmail(customerForm.getEmail());
		customerEntity.setFirstName(customerForm.getFirstName());
		customerEntity.setLastName(customerForm.getLastName());
		customerEntity.setPhoneNumber(customerForm.getPhoneNumber());
		return adoberestDao.persistCustomer(customerEntity);
	}

	@Override
	public String updateCustomer(Customer customerForm) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setId(customerForm.getCust_id());
		customerEntity.setAddress(customerForm.getAddress());
		customerEntity.setAge(customerForm.getAge());
		customerEntity.setCountry(customerForm.getCountry());
		customerEntity.setCreated_at(customerForm.getCreated_at());
		customerEntity.setEmail(customerForm.getEmail());
		customerEntity.setFirstName(customerForm.getFirstName());
		customerEntity.setLastName(customerForm.getLastName());
		customerEntity.setPhoneNumber(customerForm.getPhoneNumber());
		return adoberestDao.updateCustomer(customerEntity);
	}

	@Override
	public String deleteCustomerById(int cust_id) {
		return adoberestDao.deleteCustomerById(cust_id);
	}

	@Override
	public Customer findCustomerById(int cust_id) {
		CustomerEntity customerEntity = adoberestDao.findCustomerById(cust_id);
		Customer customerForm = new Customer();
		if (null != customerEntity) {
			customerForm.setCust_id(customerEntity.getId());
			customerForm.setAddress(customerEntity.getAddress());
			customerForm.setAge(customerEntity.getAge());
			customerForm.setCountry(customerEntity.getCountry());
			customerForm.setCreated_at(customerEntity.getCreated_at());
			customerForm.setEmail(customerEntity.getEmail());
			customerForm.setFirstName(customerEntity.getFirstName());
			customerForm.setLastName(customerEntity.getLastName());
			customerForm.setPhoneNumber(customerEntity.getPhoneNumber());
		}
		return customerForm;	
	}

	@Override
	public boolean isCustomerExist(Customer customer) {
		 Customer cust = findCustomerById(customer.getCust_id());
		 return cust.getCust_id() != 0;
	}

}
