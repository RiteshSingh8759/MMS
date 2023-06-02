package com.kloc.test.service;
import java.util.List;
import com.kloc.test.entities.Inventory;

public interface InventoryService 
{
	List<Inventory> postInventory(List<Inventory> in,int order_id);
	List<Inventory> getAllInventory();
	Inventory getAllInventoryByInventoryId(int id);
	List<Inventory> getAllInventoryByOrderId(int order_id);
	Inventory updateInventoryById(int id);
	void deleteInventoryById(int id);
}
