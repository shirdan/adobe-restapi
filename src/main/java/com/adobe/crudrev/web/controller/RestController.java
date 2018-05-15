package com.adobe.crudrev.web.controller;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.adobe.crudrev.web.controller.vo.Customer;
import com.adobe.crudrev.web.service.IAdobeRestService;


@org.springframework.web.bind.annotation.RestController
@RequestMapping(value="v1", 
				consumes = MediaType.APPLICATION_JSON,
				produces= MediaType.APPLICATION_JSON, 
				method = {RequestMethod.GET, 
						  RequestMethod.POST,
						  RequestMethod.PUT, 
						  RequestMethod.DELETE})
public class RestController {

	public static final Logger logger = Logger.getLogger(RestController.class);

	@Autowired
	@Qualifier("AdobeRestServiceImpl")
	private IAdobeRestService adobeRestService;
	
	// -------------------Fetch a Customer Record------------------------------------------
	@RequestMapping(value = "/customer/get/{cust_id}", method = RequestMethod.GET)
	public ResponseEntity<?> fetchCustomer(@PathVariable("cust_id") String cust_id) {
		logger.info("Fetching Customer with id {}"+cust_id);
		Customer customer = adobeRestService.findCustomerById(Integer.parseInt(cust_id));
        if (customer.getFirstName() == null) {
            logger.error("Customer with id {} not found."+cust_id);
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	}
	
	// -------------------Create a Customer Record------------------------------------------
	@RequestMapping(value = "/customer/post", method = RequestMethod.POST)
	public ResponseEntity<?> insertCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Customer : {}" + customer);
		if (adobeRestService.isCustomerExist(customer)) {
			logger.error("Unable to create. A customer with name {} already exist " + customer.getFirstName());
			return new ResponseEntity<Customer>(HttpStatus.CONFLICT);
		}
		adobeRestService.persistCustomer(customer);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/v1/customer/post").buildAndExpand(customer.getCust_id()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}
	
	// -------------------update a Customer Record------------------------------------------
	@RequestMapping(value = "/customer/put/{cust_id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCustomer(@PathVariable("cust_id") String cust_id, @RequestBody Customer customer) {
	    logger.info("Updating Customer with id {}"+cust_id);
	    Customer customerU = adobeRestService.findCustomerById(Integer.parseInt(cust_id));
        if ( customerU.getLastName() == null ) {
            logger.error("Customer with id {} not found."+cust_id);
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        
        customerU.setCust_id(Integer.parseInt(cust_id));
        adobeRestService.updateCustomer(customer);
        return new ResponseEntity<Customer>(HttpStatus.OK);

	}

	// -------------------delete a Customer Record------------------------------------------
	@RequestMapping(value = "/customer/delete/{cust_id}", method = RequestMethod.DELETE )
	public ResponseEntity<?> deleteCustomer(@PathVariable("cust_id") String cust_id) {
		logger.info("Deleting Customer with id {}"+cust_id);
		Customer customerD = adobeRestService.findCustomerById(Integer.parseInt(cust_id));
		if (customerD.getLastName() == null) {
            logger.error("Customer with id {} not found."+cust_id);
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
 
		adobeRestService.deleteCustomerById(Integer.parseInt(cust_id));
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
	}

}
