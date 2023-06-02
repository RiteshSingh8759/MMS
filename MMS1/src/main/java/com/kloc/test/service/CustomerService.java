package com.kloc.test.service;

import java.util.List;

import com.kloc.test.entities.CustomerModule;

public interface CustomerService {
	CustomerModule postCustomerModule(CustomerModule cm);
	List<CustomerModule> getAllCustomerModule();
	CustomerModule getCustomerModuleById(int id);
	CustomerModule updateById(CustomerModule cm,int id);
	void deleteByCid(int id);
}
