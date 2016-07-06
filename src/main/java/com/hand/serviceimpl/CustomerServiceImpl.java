package com.hand.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hand.mapper.CustomerMapper;
import com.hand.pojo.Customer;
import com.hand.service.CustomerService;
import com.hand.util.PageUtil;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	public boolean login(String username, String password) throws Exception {
		List<Customer> customer=customerMapper.customerlogin(username);
		if(customer!=null){
			if(customer.size()>0){
				return true;
			}
		}
		return false;
	}
	public PageUtil<Customer> queryCustomerByPage(int curpage)  throws Exception {
		PageUtil<Customer> pages=new PageUtil<Customer>();
		pages.setCurPage(curpage);
		pages.setROW(10);
		int rows=customerMapper.getRows();
		pages.setRows(rows);
		List<Customer> data=customerMapper.queryCustomerByPage((curpage-1)*10);
		pages.setData(data);
		return pages;
	}
	
	public boolean updateCustomerByid(int customerId, Customer customer) throws Exception {
		customer.setCustomerId((short)customerId);
		int i=customerMapper.updateByPrimaryKeySelective(customer);
		if(i>0){
			return true;
		}
		return false;
	}

	public boolean insertCustomerById(int customerId,Customer customer)throws Exception {
		customer.setCustomerId((short)customerId);
		int i=customerMapper.insert(customer);
		if(i>0){
			return true;
		}
		return false;
	}
	public boolean insertCustomer(Customer customer) throws Exception {
		int i=customerMapper.insertSelective(customer);
		if(i>0){
			return true;
		}
		return false;
	}
	
	public Customer queryCustomerById(int customerId) throws Exception {
		Customer customer=customerMapper.selectByPrimaryKey((short)customerId);
		return customer;
	}
	
	public boolean deleteCustomerById(int customerId) throws Exception {
	
		customerMapper.deletePaymentBycusid(customerId);
		customerMapper.deleteRentalBycusid(customerId);
		int i=customerMapper.deleteByPrimaryKey((short)customerId);
		if(i>0){
			return true;
		}
		return false;
	}
}
