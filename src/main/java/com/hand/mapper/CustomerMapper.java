package com.hand.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hand.pojo.Customer;
import com.hand.pojo.CustomerExample;

public interface CustomerMapper {
    int countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Short customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Short customerId);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    List<Customer> customerlogin(String first_name);
    
    List<Customer> queryCustomerByPage(int first_pages);
    
    int getRows();
    
    int deletePaymentBycusid(int customerId);
    
    int deleteRentalBycusid(int customerId);
}