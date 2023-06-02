package com.springboot.MMS.Service;

import java.util.List;

import com.springboot.MMS.Entity.CustomerModule;

public interface CustomerService
{
	CustomerModule postCustomerModule(CustomerModule cm);
	List<CustomerModule> getAllCustomerModule();
	CustomerModule getCustomerModuleById(int id);
	CustomerModule updateById(CustomerModule cm,int id);
//	void deleteByCid(int id);
}
