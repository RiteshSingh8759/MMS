package com.kloc.test.service;

import java.util.List;

import com.kloc.test.entities.OrderDetails;

public interface OrderDetailsService 
{
	OrderDetails postOrderDetails(OrderDetails od,String vname);
	List<OrderDetails> getAllOrderDetails();
	OrderDetails getOrderDetailsById(int id);
	List<OrderDetails> getAllOrderDetailsByVname(String vname);
	List<OrderDetails> getAllOrderDetailsByStatus(String status);
	OrderDetails updateOrderDetails(OrderDetails od,int id);
	OrderDetails updateOrderDetailsByStatus(int id,String status);
	void deleteOrderDetailsById(int id);
	void deleteOrderDetailsByVname(String vname);
}
