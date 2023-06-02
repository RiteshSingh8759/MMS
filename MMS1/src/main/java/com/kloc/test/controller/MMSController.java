package com.kloc.test.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.kloc.test.entities.BillItems;
import com.kloc.test.entities.BillModule;
import com.kloc.test.entities.CustomerModule;
import com.kloc.test.entities.DrugModule;
import com.kloc.test.entities.Inventory;
import com.kloc.test.entities.OrderDetails;
import com.kloc.test.entities.VendorModule;
import com.kloc.test.service.BillItemService;
import com.kloc.test.service.Billservice;
import com.kloc.test.service.CustomerService;
import com.kloc.test.service.DrugService;
import com.kloc.test.service.InventoryService;
import com.kloc.test.service.OrderDetailsService;
import com.kloc.test.service.VendorService;

@RestController()
@CrossOrigin("*")
@RequestMapping("/api")
public class MMSController {
	private BillItemService billItemService;
	private Billservice billService;
	private CustomerService customerService;
	private DrugService drugService;
	private VendorService vendorService;
	private OrderDetailsService orderDetailsService;
	private InventoryService inventoryService;
	
	
	public MMSController(BillItemService billItemService, Billservice billService, CustomerService customerService,
			DrugService drugService, VendorService vendorService, OrderDetailsService orderDetailsService,
			InventoryService inventoryService) {
		super();
		this.billItemService = billItemService;
		this.billService = billService;
		this.customerService = customerService;
		this.drugService = drugService;
		this.vendorService = vendorService;
		this.orderDetailsService = orderDetailsService;
		this.inventoryService = inventoryService;
	}
	// VendorModule
	@PostMapping("/saveVendor")
	public ResponseEntity<VendorModule> postVmModule(@RequestBody VendorModule vm){
		return new ResponseEntity<VendorModule> (vendorService.postvmModule(vm),HttpStatus.CREATED);
	}
	@GetMapping("/getAllVendor")
	public ResponseEntity<List<VendorModule>> getAllVmModule(){
		return new ResponseEntity<List<VendorModule>>(vendorService.getAllVmModule(),HttpStatus.ACCEPTED) ;
		
	}
	
	@GetMapping("/getVendorById/{id}")
	public ResponseEntity<VendorModule> getByVid(@PathVariable("id")int id)
	{
		return new ResponseEntity<VendorModule>(vendorService.getById(id),HttpStatus.OK);
	}
	@GetMapping("/getVendorByName/{vname}")
	public ResponseEntity<VendorModule> getVendorByName(@PathVariable("vname") String vname)
	{
		return new ResponseEntity<VendorModule>(vendorService.getByName(vname),HttpStatus.OK);
	}
	
	@PutMapping("/updateVendor/{id}")
	public ResponseEntity<VendorModule> updateById(@RequestBody VendorModule vm,@PathVariable("id") int id){
		return new ResponseEntity<VendorModule>(vendorService.updateById(vm, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteVendorById/{id}")
	 public void deleteById(@PathVariable("id") int id) {
		 vendorService.deleteVendorById(id);
	 }
	
	// Drug Module
	@PostMapping("/saveDrug/{vname}")
	public ResponseEntity<List<DrugModule>> postDrugModule(@RequestBody List<DrugModule> dm,@PathVariable("vname") String vname)
	{
		return new ResponseEntity<List<DrugModule>>(drugService.postDrugmodule(dm,vname),HttpStatus.OK);
	}
	@GetMapping("/getAllDrug")
	public ResponseEntity<List<DrugModule>> getAllDrug()
	{
		return new ResponseEntity<List<DrugModule>>(drugService.getAllDrug(),HttpStatus.OK);
	}
	@GetMapping("/getAllDrugByVname/{vname}")
	public ResponseEntity<List<DrugModule>> getAllDrugByVname(@PathVariable("vname") String vname)
	{
		return new ResponseEntity<List<DrugModule>>(drugService.getAllDrugByVname(vname),HttpStatus.OK);
	}
	@GetMapping("/getDrugById/{id}")
	public ResponseEntity<DrugModule> getDrugById(@PathVariable("id") int id)
	{
		return new ResponseEntity<DrugModule>(drugService.getBydrugId(id),HttpStatus.FOUND);
	}
	@GetMapping("/getAllDrugToOrder/{Quantity}")
	public ResponseEntity<List<DrugModule>> getAllDrugToOrder(@PathVariable("Quantity") int Quantity)
	{
		return  new ResponseEntity<List<DrugModule>>(drugService.getAllDrugToOrder(Quantity),HttpStatus.OK);
	}
	@PutMapping("/updateDrugById/{id}")
	public ResponseEntity<DrugModule> updateDrugModule(@RequestBody DrugModule dm,@PathVariable int id)
	{
		return new ResponseEntity<DrugModule>(drugService.updateDrugModule(dm, id),HttpStatus.OK);
	}
//	@DeleteMapping("/deleteDrugById/{id}")
//	public void deleteByDid(@PathVariable("id") int id)
//	{
//		drugService.deleteById(id);
//	}
	// Customer Module
	
	@PostMapping("/postCustomer")
	public ResponseEntity<CustomerModule> postCustomerModule(@RequestBody CustomerModule cm){
		return new ResponseEntity<CustomerModule>(customerService.postCustomerModule(cm),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<CustomerModule>> getAllCustomerModule()
	{
		return new ResponseEntity<List<CustomerModule>>(customerService.getAllCustomerModule(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getCustomerById/{id}")
	public ResponseEntity<CustomerModule> getCustomerModuleById(@PathVariable("id") int id)
	{
		return new ResponseEntity<CustomerModule>(customerService.getCustomerModuleById(id),HttpStatus.FOUND);
	}
	@PutMapping("updateCustomer/{id}")
	public ResponseEntity<CustomerModule> updateById(@RequestBody CustomerModule cm,@PathVariable("id") int id)
	{
		return new ResponseEntity<CustomerModule>(customerService.updateById(cm, id),HttpStatus.OK);
	}
   // billItems module
	@PostMapping("/postBillItems/{billno}")
	public ResponseEntity<List<BillItems>> postBillItems(@RequestBody List<BillItems> bi,@PathVariable("billno") int billno){
		return new ResponseEntity<List<BillItems>>(billItemService.postBillItems(bi,billno),HttpStatus.OK);
	}
	
	@GetMapping("/getAllBillItems")
	public ResponseEntity<List<BillItems>> getAllBookItems(){
		return new ResponseEntity<List<BillItems>>(billItemService.getAllBillItems(),HttpStatus.OK);
	}
	
	@PutMapping("/updateBillItemsById/{id}")
	public ResponseEntity<BillItems> updateBillItemsById(@RequestBody BillItems bi,@PathVariable("id")int id){
		return new ResponseEntity<BillItems>(billItemService.updateBillItemsById(bi, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/deletebillItemsById/{id}")
	public void deleteBillItemsById(@PathVariable("id") int id) {
		billItemService.deleteBillItemsById(id);
	}
	
	
//Bill Module
	@PostMapping("/postBillModule/{cname}")
	public ResponseEntity<BillModule> postBillModule(@RequestBody BillModule bm,@PathVariable("cname") String cname)
	{
		return new ResponseEntity<BillModule>(billService.postBillModule(bm,cname),HttpStatus.OK);
	}
	@GetMapping("/getAllBillModule")
	public ResponseEntity<List<BillModule>> getAllBillModule()
	{
		return new ResponseEntity<List<BillModule>>(billService.getAllBillModule(),HttpStatus.FOUND);
	}

	@GetMapping("/getBillModuleById/{id}")
	public ResponseEntity<BillModule> getBillModuleById(@PathVariable("id") int id)
	{
		return new ResponseEntity<BillModule>(billService.getBillModuleById(id),HttpStatus.FOUND);
	}
	@PutMapping("/updateBillModuleById/{id}")
	public ResponseEntity<BillModule> updateBillmoduleById(@RequestBody BillModule bm,@PathVariable("id") int id)
	{
		return new ResponseEntity<BillModule>(billService.updateBillModuleById(bm, id),HttpStatus.OK);
	}
	// OrderDetails Module
	@PostMapping("/postOrder/{vname}")
	public ResponseEntity<OrderDetails> postOrderDetails(@RequestBody OrderDetails od,@PathVariable("vname") String vname)
	{
		return new ResponseEntity<OrderDetails>(orderDetailsService.postOrderDetails(od, vname),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAllOrderDetails")
	public ResponseEntity<List<OrderDetails>> getAllOrderDetails()
	{
		return new ResponseEntity<List<OrderDetails>>(orderDetailsService.getAllOrderDetails(),HttpStatus.OK);
	}
	@GetMapping("/getOrderDetails/{id}")
	public ResponseEntity<OrderDetails> getOrderDetails(@PathVariable("id") int id)
	{
		return new ResponseEntity<OrderDetails>(orderDetailsService.getOrderDetailsById(id),HttpStatus.OK);
	}
	@GetMapping("/getAllODByVname/{vname}")
	public ResponseEntity<List<OrderDetails>> getAllOrderDetailsByVname(@PathVariable("vname") String vname)
	{
		return new ResponseEntity<List<OrderDetails>>(orderDetailsService.getAllOrderDetailsByVname(vname),HttpStatus.OK);
	}
	@GetMapping("/getAllODByStatus/{status}")
	public ResponseEntity<List<OrderDetails>> getAllODByStatus(@PathVariable("status") String status)
	{
		return new ResponseEntity<List<OrderDetails>>(orderDetailsService.getAllOrderDetailsByStatus(status),HttpStatus.OK);
	}
	@PutMapping("/updateOD/{id}")
	public ResponseEntity<OrderDetails> updateOrderDetailsById(@RequestBody OrderDetails od,@PathVariable("id") int id)
	{
		return new ResponseEntity<OrderDetails>(orderDetailsService.updateOrderDetails(od, id),HttpStatus.OK);
	}
	@PutMapping("/updateODByStatus/{id}/{status}")
	public ResponseEntity<OrderDetails> updateOrderDetailsByStatus(@PathVariable("id") int id,@PathVariable("status") String status)
	{
		return new ResponseEntity<OrderDetails>(orderDetailsService.updateOrderDetailsByStatus(id, status),HttpStatus.OK);
	}
	@DeleteMapping("/deleteODById/{id}")
	public void deleteODById(@PathVariable("id") int id)
	{
		orderDetailsService.deleteOrderDetailsById(id);
	}
	@DeleteMapping("/deleteODByVname/vname")
	public void deleteOrderDetailsByVname(@PathVariable("vname") String vname)
	{
		orderDetailsService.deleteOrderDetailsByVname(vname);
	}
	// Inventory Module
	@PostMapping("/postInventory/{id}")
	public ResponseEntity<List<Inventory>> postInventory(@RequestBody List<Inventory> in,@PathVariable("id") int id)
	{
		return new ResponseEntity<List<Inventory>>(inventoryService.postInventory(in, id),HttpStatus.OK);
	}
	@GetMapping("/getAllInventory")
	public ResponseEntity<List<Inventory>> getAllInventory()
	{
		return new ResponseEntity<List<Inventory>>(inventoryService.getAllInventory(),HttpStatus.OK);
	}
	@GetMapping("/getInventoryByIid/{id}")
	public ResponseEntity<Inventory> getAllIid(@PathVariable("id") int id)
	{
		return new ResponseEntity<Inventory>(inventoryService.getAllInventoryByInventoryId(id),HttpStatus.OK);
	}
	@GetMapping("getAllInventoryByOrderid/{id}")
	public ResponseEntity<List<Inventory>> getAllInventoryByOrderId(@PathVariable("id") int id)
	{
		return new ResponseEntity<List<Inventory>>(inventoryService.getAllInventoryByOrderId(id),HttpStatus.OK);
	}
	@PutMapping("UpdateInventoryById/{id}")
	public ResponseEntity<Inventory> updateInventoryById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Inventory>(inventoryService.updateInventoryById(id),HttpStatus.OK);
	}
	@DeleteMapping("deleteInventoryBYid/{id}")
	public void deleteInventoryById(@PathVariable("id") int id)
	{
		inventoryService.deleteInventoryById(id);
	}
}
