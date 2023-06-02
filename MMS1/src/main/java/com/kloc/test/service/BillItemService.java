package com.kloc.test.service;

import java.util.List;

import com.kloc.test.entities.BillItems;

public interface BillItemService {
	List<BillItems> postBillItems(List<BillItems> bi,int billno);
	List<BillItems> getAllBillItems();
	BillItems updateBillItemsById(BillItems bi,int id);
	void deleteBillItemsById(int id);
}
