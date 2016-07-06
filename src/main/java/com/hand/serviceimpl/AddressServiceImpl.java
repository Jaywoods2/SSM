package com.hand.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hand.mapper.AddressMapper;
import com.hand.pojo.Address;
import com.hand.service.AddressService;

public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressMapper addressMapper;
	public List<Address> getAllAddress() throws Exception {
		List<Address> addresslist=addressMapper.getAllAddress();
		return addresslist;
	}

}
