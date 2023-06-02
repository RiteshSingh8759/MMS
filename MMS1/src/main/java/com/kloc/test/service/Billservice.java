package com.kloc.test.service;

import java.util.List;

import com.kloc.test.entities.BillModule;

public interface Billservice {
	BillModule postBillModule(BillModule bm,String cname);
	List<BillModule> getAllBillModule();
	BillModule getBillModuleById(int id);
	BillModule updateBillModuleById(BillModule bm,int id);
	void deleteBillModule(int id);
}
