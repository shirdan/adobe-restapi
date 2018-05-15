package com.adobe.crudrev.dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adobe.crudrev.dao.IAdobeRestDao;
import com.adobe.crudrev.dao.entity.CustomerEntity;


@Repository("AdobeDaoImpl")
@Transactional
public class AdobeDaoImpl extends JdbcDaoSupport implements IAdobeRestDao {

	/**
	 * Set DataSource in Super
	 * 
	 * @param dataSource
	 */
	@Autowired
	@Qualifier("sdatasource")
	public void setDataSourceInSuper(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public String persistCustomer(CustomerEntity customerEntity) {
		Object data[] = new Object[] {customerEntity.getId(),
									  customerEntity.getFirstName(),
							          customerEntity.getLastName(),
							          customerEntity.getAge(),
							          customerEntity.getEmail(),
							          customerEntity.getCountry(),
							          customerEntity.getPhoneNumber(),
							          customerEntity.getCreated_at(),
							          customerEntity.getAddress()};
		
		
		int dataTye[] = new int[] { Types.INTEGER, 
									Types.VARCHAR, 
									Types.VARCHAR, 
									Types.INTEGER,
									Types.VARCHAR, 
									Types.VARCHAR,
									Types.VARCHAR,
									Types.DATE,
									Types.VARCHAR};
		
		String query = "INSERT INTO customer_tbl values(?,?,?,?,?,?,?,?,?)";
	
		super.getJdbcTemplate().update(query, data, dataTye);
		return "SUCCESS";

	}



	@Override
	public String updateCustomer(CustomerEntity customerEntity) {
		Object data[] = new Object[] {customerEntity.getFirstName(),
		          customerEntity.getLastName(),
		          customerEntity.getAge(),
		          customerEntity.getEmail(),
		          customerEntity.getCountry(),
		          customerEntity.getPhoneNumber(),
		          customerEntity.getCreated_at(),
		          customerEntity.getAddress()};


				int dataTye[] = new int[] {  Types.VARCHAR, 
								Types.VARCHAR, 
								Types.INTEGER,
								Types.VARCHAR, 
								Types.VARCHAR,
								Types.VARCHAR,
								Types.DATE,
								Types.VARCHAR};
		
		String query = "UPDATE customer_tbl SET firstName=?,lastName=?,age=?,email=?,country=?,phoneNumber=?,created_at=?,address=? "
						+ "WHERE cust_id="+customerEntity.getId();
		
		super.getJdbcTemplate().update(query, data, dataTye);
		return "SUCCESS";
	}



	@Override
	public String deleteCustomerById(int cust_id) {
		String query = "DELETE a" + 
						"      FROM customer_tbl a" + 
						" WHERE a.cust_id ="+cust_id;
		
		super.getJdbcTemplate().update(query);
		return "SUCCESS";
	}



	@Override
	public CustomerEntity findCustomerById(int cust_id) {
		CustomerEntity customerEntity = null;
		String sql = "SELECT * from customer_tbl a WHERE a.cust_id = ?";
		try {
			customerEntity = (CustomerEntity) super.getJdbcTemplate().queryForObject(sql,new Object[] { cust_id },
																						new BeanPropertyRowMapper<CustomerEntity>(CustomerEntity.class));
		} catch (Exception e) {
			//TODO : Remove exception . throw custom DB Exception.
			e.printStackTrace();
		}
		return customerEntity;
	}

}