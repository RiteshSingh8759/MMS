package com.springboot.MMS.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.MMS.Entity.BillItems;
import com.springboot.MMS.Entity.BillModule;
import com.springboot.MMS.Entity.CustomerModule;
import com.springboot.MMS.Entity.DrugModule;
import com.springboot.MMS.Entity.VendorModule;
import com.springboot.MMS.Service.BillItemsService;
import com.springboot.MMS.Service.BillService;
import com.springboot.MMS.Service.CustomerService;
import com.springboot.MMS.Service.DrugService;
import com.springboot.MMS.Service.VendorService;
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MMSController 
{
	private BillItemsService billitemService;
	private BillService billService;
	private CustomerService customerService;
	private DrugService drugService;
	private VendorService vendorService;
	public MMSController(BillItemsService billitemService, BillService billService, CustomerService customerService,
			DrugService drugService, VendorService vendorService) {
		super();
		this.billitemService = billitemService;
		this.billService = billService;
		this.customerService = customerService;
		this.drugService = drugService;
		this.vendorService = vendorService;
	}
	// Vendor Module-------------------------------------------------------------------------------------------------------------------------------------------------------
	@PostMapping("/saveVendor")
	public ResponseEntity<VendorModule> postVmModule(@RequestBody VendorModule vm)
	{
		return new ResponseEntity<VendorModule>(vendorService.postVmModule(vm),HttpStatus.CREATED);
	}
	@GetMapping("/getAllVendor")
	public ResponseEntity<List<VendorModule>> getAllVmModule()
	{
		return new ResponseEntity<List<VendorModule>>(vendorService.getAllVmModule(),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getVendorById/{Id}")
	public ResponseEntity<VendorModule> getByVid(@PathVariable("id")int id)
	{
		return new ResponseEntity<VendorModule>(vendorService.getByVid(id),HttpStatus.OK);
	}
	@GetMapping("/getVendorByName/{vname}")
	public ResponseEntity<VendorModule> findByVname(@PathVariable("vname") String vname)
	{
		return new ResponseEntity<VendorModule>(vendorService.getByVname(vname),HttpStatus.OK);
	}
	@PutMapping("/updateVendor/{id}")
	public ResponseEntity<VendorModule> updateById(@RequestBody VendorModule uvm,@PathVariable("id") int id)
	{
		return new ResponseEntity<VendorModule>(vendorService.updateById(uvm, id),HttpStatus.OK);
	}
	@DeleteMapping("deleteVendorById/{id}")
	public void deleteById(@PathVariable("id") int id)
	{
		vendorService.deleteVendorById(id);
	}
	// DrugModule----------------------------------------------------------------------------------------------------------------------------------------------------------
	@PostMapping("/saveDrug")
	public ResponseEntity<DrugModule> postDrugModule(@RequestBody DrugModule dm)
	{
		return new ResponseEntity<DrugModule>(drugService.postDrugModule(dm),HttpStatus.OK);
	}
	@GetMapping("/getAllDrug")
	public ResponseEntity<List<DrugModule>> getAllDrug()
	{
		return new ResponseEntity<List<DrugModule>>(drugService.getAllDrug(),HttpStatus.OK);
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<DrugModule> getDrugById(@PathVariable("id") int id)
	{
		return new ResponseEntity<DrugModule>(drugService.getByDrugId(id),HttpStatus.FOUND);
	}
	@PutMapping("/updateByID/{id}")
	public ResponseEntity<DrugModule> updateDrugModule(@RequestBody DrugModule dm,@PathVariable int id)
	{
		return new ResponseEntity<DrugModule>(drugService.updateDrugModule(dm, id),HttpStatus.OK);
	}
	@DeleteMapping("/deleteById/{id}")
	public void deleteByDid(@PathVariable("id") int id)
	{
		drugService.deleteByDid(id);
	}
	// CustomerModule------------------------------------------------------------------------------------------------------------------------------------------------------
	@PostMapping("/postCustomer")
	public ResponseEntity<CustomerModule> postCustomerModule(@RequestBody CustomerModule cm)
	{
		return new ResponseEntity<CustomerModule>(customerService.postCustomerModule(cm),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<CustomerModule>> getAllCustomerModule()
	{
		return new ResponseEntity<List<CustomerModule>>(customerService.getAllCustomerModule(),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getCustomerModuleById/{id}")
	public ResponseEntity<CustomerModule> getCustomerModuleById(@PathVariable("id") int id)
	{
		return new ResponseEntity<CustomerModule>(customerService.getCustomerModuleById(id),HttpStatus.FOUND);
	}
	@PutMapping("updateCustomer/{id}")
	public ResponseEntity<CustomerModule> updateById(@RequestBody CustomerModule cm,@PathVariable("id") int id)
	{
		return new ResponseEntity<CustomerModule>(customerService.updateById(cm, id),HttpStatus.OK);
	}
//	@DeleteMapping("deleteCustomer/{id}")
//	public void deleteByCid(@PathVariable int id)
//	{
//		customerService.deleteByCid(id);
//	}
	//BillitemsModule------------------------------------------------------------------------------------------------------------------------------------------------------
	@PostMapping("/postBillItems")
	public ResponseEntity<BillItems> postBillItems(@RequestBody BillItems bi)
	{
		return new ResponseEntity<BillItems>(billitemService.postBillItems(bi),HttpStatus.OK);
	}
	@GetMapping("/getAllBillItems")
	public ResponseEntity<List<BillItems>> getAllBillItems()
	{
		return new ResponseEntity<List<BillItems>>(billitemService.getAllBillItems(),HttpStatus.OK);
	}
	@GetMapping("/getBillItemsById/{id}")
	public ResponseEntity<BillItems> getBillItemsById(@PathVariable("id") int id)
	{
		return new ResponseEntity<BillItems>(billitemService.getBillItemsById(id),HttpStatus.OK);
	}
	@PutMapping("/updateBillItemsById/{id}")
	public ResponseEntity<BillItems> updateBillItemsById(@RequestBody BillItems bi,@PathVariable("id") int id)
	{
		return new ResponseEntity<BillItems>(billitemService.updateBillItemsById(bi, id),HttpStatus.OK);
	}
	@DeleteMapping("/deletebillItemsById/{id}")
	public void deleteBillItemsById(@PathVariable("id") int id)
	{
		billitemService.deleteBillItemsById(id);
	}
	@GetMapping("/getBillItemsByBillNumber/{billno}")
	public ResponseEntity<List<BillItems>> getBillItemsByBillNo(@PathVariable("billno") int billno)
	{
		return new ResponseEntity<List<BillItems>>(billitemService.getAllBillitemsByBillNo(billno),HttpStatus.OK);
	}
	// BillModule----------------------------------------------------------------------------------------------------------------------------------------------------------
	@PostMapping("/postBillModule")
	public ResponseEntity<BillModule> postBillModule(@RequestBody BillModule bm)
	{
		return new ResponseEntity<BillModule>(billService.postBillmodule(bm),HttpStatus.OK);
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
		return new ResponseEntity<BillModule>(billService.updateBillmoduleById(bm, id),HttpStatus.OK);
	}
	
}
