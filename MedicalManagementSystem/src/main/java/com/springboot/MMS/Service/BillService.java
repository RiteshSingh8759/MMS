package com.springboot.MMS.Service;

import java.util.List;

import com.springboot.MMS.Entity.BillModule;

public interface BillService 
{
	BillModule postBillmodule(BillModule bm);
	List<BillModule> getAllBillModule();
	BillModule getBillModuleById(int id);
	BillModule updateBillmoduleById(BillModule bm,int id);
	void deleteBillModule(int id);
}
