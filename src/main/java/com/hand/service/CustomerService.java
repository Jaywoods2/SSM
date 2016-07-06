package com.hand.service;

import com.hand.pojo.Customer;
import com.hand.util.PageUtil;

public interface CustomerService {
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	public boolean login(String username,String password) throws Exception;
	
	/**
	 * 分页查询客户信息
	 * @param curpage
	 * @return
	 */
	public PageUtil<Customer> queryCustomerByPage(int curpage) throws Exception;
	
	
	public boolean updateCustomerByid(int id,Customer customer) throws Exception;

	public boolean insertCustomer(Customer customer) throws Exception;

	public Customer queryCustomerById(int customerId) throws Exception;
	
	public boolean deleteCustomerById(int customerId) throws Exception;
}
