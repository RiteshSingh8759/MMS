package com.kloc.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kloc.test.entities.BillItems;
import com.kloc.test.entities.BillModule;
import com.kloc.test.entities.CustomerModule;
import com.kloc.test.entities.DrugModule;
import com.kloc.test.entities.Inventory;
import com.kloc.test.entities.OrderDetails;
import com.kloc.test.entities.VendorModule;
import com.kloc.test.exception.DataNotFoundException;
import com.kloc.test.repository.BIRepository;
import com.kloc.test.repository.BMRepository;
import com.kloc.test.repository.CMRepository;
import com.kloc.test.repository.DMRepository;
import com.kloc.test.repository.INRepository;
import com.kloc.test.repository.ODRepository;
import com.kloc.test.repository.VMRepository;
import com.kloc.test.service.BillItemService;
import com.kloc.test.service.Billservice;
import com.kloc.test.service.CustomerService;
import com.kloc.test.service.DrugService;
import com.kloc.test.service.InventoryService;
import com.kloc.test.service.OrderDetailsService;
import com.kloc.test.service.VendorService;
@Service
public class MedicalserviceImpl implements VendorService,DrugService,CustomerService,BillItemService,Billservice,OrderDetailsService,InventoryService {

	private BIRepository biRepository;
	private BMRepository bmRepository;
	private CMRepository cmRepository;
	private DMRepository dmRepository;
	private VMRepository vmRepository;
	private ODRepository odRepository;
	private INRepository inRepository;
	
	

	public MedicalserviceImpl(BIRepository biRepository, BMRepository bmRepository, CMRepository cmRepository,
			DMRepository dmRepository, VMRepository vmRepository, ODRepository odRepository,
			INRepository inRepository) {
		super();
		this.biRepository = biRepository;
		this.bmRepository = bmRepository;
		this.cmRepository = cmRepository;
		this.dmRepository = dmRepository;
		this.vmRepository = vmRepository;
		this.odRepository = odRepository;
		this.inRepository = inRepository;
	}

	@Override
	public VendorModule postvmModule(VendorModule vm) {
		return  vmRepository.save(vm);
	}

	@Override
	public List<VendorModule> getAllVmModule() {
		return vmRepository.findAll();
	}

	@Override
	public VendorModule getById(int id) {
		return vmRepository.findById(id).orElseThrow(()-> new DataNotFoundException("VendorModule", "Id", id));
	}
	@Override
	public VendorModule getByName(String vname)
	{
		List<VendorModule> vm=vmRepository.findAll().stream().filter(e->(e.getVname()==vname)).collect(Collectors.toList());		
		if(vm.equals(null)) {
			throw new DataNotFoundException("VendorModule","vname", vname);
		}
		return vmRepository.findByVname(vname);
	}

	@Override
	public VendorModule updateById(VendorModule vm, int id) {
		VendorModule existing =vmRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Vendormodule", "Id", id));
		existing.setVaddress(vm.getVaddress());
		existing.setVemail(vm.getVemail());
		existing.setVphoneNo(vm.getVphoneNo());
		existing.setTinNo(vm.getTinNo());
		existing.setVname(vm.getVname());
		existing.setGstNo(vm.getGstNo());
		vmRepository.save(existing);
		return existing;
	}

	@Override
	public void deleteVendorById(int id) {
		vmRepository.findById(id).orElseThrow(()->new DataNotFoundException("VendorModule","id", id));
	    List<DrugModule> li=dmRepository.findAll().stream().filter(e->e.getVm().getVendorId()==id).collect(Collectors.toList());
	    dmRepository.deleteAll(li);
		 vmRepository.deleteById(id);
	}
	// Drug Module
	@Override
	public List<DrugModule> postDrugmodule(List<DrugModule> dm,String vname) 
	{
		VendorModule vm=vmRepository.findByVname(vname);
		if(vm.equals(null)) { throw new DataNotFoundException("vendormodule","vname", vname);}
		dm.forEach(e->e.setVm(vm));
		return dmRepository.saveAll(dm);
	}

	@Override
	public List<DrugModule> getAllDrug() {
		return dmRepository.findAll();
	}
	@Override
	public List<DrugModule> getAllDrugByVname(String Vname) {
		 VendorModule v=vmRepository.findByVname(Vname);
		if(vmRepository.existsById(v.getVendorId())) {
		 List<DrugModule> li= dmRepository.findAll().stream().filter(e->e.getVm().getVname()==v.getVname()).collect(Collectors.toList());
		 return li;
		}
		else {
			throw new DataNotFoundException("vendorModule", "vname", Vname);
		}
	}

	@Override
	public DrugModule getBydrugId(int id) {
		return dmRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Drugmodule", "Id", id));
	}

	@Override
	public DrugModule updateDrugModule(DrugModule dm, int id) {
	DrugModule	exist =dmRepository.findById(id).orElseThrow(()-> new DataNotFoundException("DrugModule", "Id", id));
		exist.setBatchNo(dm.getBatchNo());
		exist.setCompany(dm.getCompany());
		exist.setDname(dm.getDname());
		exist.setDose(dm.getDose());
//		exist.setDrugId(dm.getDrugId());
		exist.setExpdate(dm.getExpdate());
		exist.setMfgdate(dm.getMfgdate());
		exist.setQuantity(dm.getQuantity());
		exist.setUnitPrice(dm.getUnitPrice());		
		dmRepository.save(exist);
		return exist;
	}
	@Override
	public List<DrugModule> getAllDrugToOrder(int Quantity)
	{
		List<DrugModule> li=dmRepository.findAll().stream().filter(e->e.getQuantity()<=Quantity).collect(Collectors.toList());
		return li;
	}

//	@Override
//	public void deleteById(int id) {
//		dmRepository.findById(id).orElseThrow(()-> new DataNotFoundException("DrugModule", "Id", id));
//		dmRepository.deleteById(id);
//	}
	 // Customer Module
	@Override
	public CustomerModule postCustomerModule(CustomerModule cm) {
		
		
		return cmRepository.save(cm);
	}

	@Override
	public List<CustomerModule> getAllCustomerModule() {
		
		return cmRepository.findAll();
	}

	@Override
	public CustomerModule getCustomerModuleById(int id) {

		
		return cmRepository.findById(id).orElseThrow(()-> new DataNotFoundException("CustomerModule", "Id", id));
	}

	@Override
	public CustomerModule updateById(CustomerModule cm, int id) {
		CustomerModule existing=cmRepository.findById(id).orElseThrow(()->new DataNotFoundException("CustomerModule","Id", id));
		existing.setCaddress(cm.getCaddress());
		existing.setCemail(cm.getCemail());
		existing.setCname(cm.getCname());
		existing.setCphoneNo(cm.getCphoneNo());
//		existing.setCid(cm.getCid());
		cmRepository.save(existing);
		return existing;
	}

	@Override
	public void deleteByCid(int id) {
		
	}
	// billItems
	@Override
	public List<BillItems> postBillItems(List<BillItems> e,int billno) 
	{   
		
		BillModule bm=bmRepository.findById(billno).orElseThrow(()->new DataNotFoundException("BillModule","billno", billno));
		List<BillItems> li=new ArrayList<BillItems>();
		int amount=bm.getBillAmount();
		for(int i=0;i<e.size();i++)
		{
			BillItems bi=e.get(i);
			bi.setBm(bm);
			DrugModule dm=dmRepository.findById(bi.getDrug_id()).get();
			if(dm.getQuantity()>bi.getQuantity()&&dm.getUnitPrice()==bi.getUnit_price()&&dm.getDrugId()==bi.getDrug_id()&&bi.getNet_price()==(bi.getUnit_price()*bi.getQuantity()))
			{
				li.add(bi);
				amount+=bi.getNet_price();
			}
		}
		bm.setBillAmount(amount);
		bmRepository.save(bm);
			
		return biRepository.saveAll(li);		
	}

	@Override
	public List<BillItems> getAllBillItems() {
		return biRepository.findAll();
	}

	@Override
	public BillItems updateBillItemsById(BillItems bi, int id) {
		BillItems exist = biRepository.findById(id).orElseThrow(()-> new DataNotFoundException("BillItems", "BillItemsId", id));
		exist.setBillitemsId(bi.getBillitemsId());
//		exist.setBill_No(bi.getBill_No());
		exist.setDrug_id(bi.getDrug_id());
//		exist.setNet_price(bi.getBill_No());
		exist.setQuantity(bi.getQuantity());
		exist.setUnit_price(bi.getUnit_price());
		biRepository.save(exist);
		return exist;
	}

	@Override
	public void deleteBillItemsById(int id) {
		biRepository.findById(id).orElseThrow(()-> new DataNotFoundException("BillItems", "bill_Items_id", id));
		biRepository.deleteById(id);
		
	}
 // BillModule crude operations
	@Override
	public BillModule postBillModule(BillModule bm,String cname) 
	{
		
		CustomerModule cm=cmRepository.findByCname(cname);
		if(cm.equals(null))
		{
			throw new DataNotFoundException("customer module", "cname", cm);
		}
		bm.setCm(cm);
		return bmRepository.save(bm);
		
	}

	@Override
	public List<BillModule> getAllBillModule() {
		return bmRepository.findAll();
	}

	@Override
	public BillModule getBillModuleById(int id) {
		return bmRepository.findById(id).orElseThrow(()-> new DataNotFoundException("BillModule", "id", id));
	}

	@Override
	public BillModule updateBillModuleById(BillModule bm, int id) 
	{
		BillModule b= bmRepository.findById(id).orElseThrow(()-> new DataNotFoundException("BillModule", "Id", id));
		b.setBillAmount(bm.getBillAmount());		
		b.setModeOfPayment(bm.getModeOfPayment());
		b.setCancellationOption(bm.getCancellationOption());
		b.setCm(bm.getCm());
		bmRepository.save(b);
		if(!bm.getModeOfPayment().isEmpty())
		{
			List<BillItems> bi=biRepository.findAll().stream().filter(e->e.getBm().getBillNo()==b.getBillNo()).collect(Collectors.toList());
			bi.forEach(e->
				{
					int j=e.getQuantity();
					int z=dmRepository.findById(e.getDrug_id()).get().getQuantity();
					DrugModule d=dmRepository.findById(e.getDrug_id()).get();
					d.setQuantity(z-j);
					dmRepository.save(d);
				});	
		}
		if(bm.getCancellationOption().contains("yes")) {
		List<BillItems>	 ar =biRepository.findAll().stream().filter(a-> a.getBm().getBillNo()==bm.getBillNo()).
				collect(Collectors.toList());
		 ar.forEach(d-> { DrugModule dm=dmRepository.findById(d.getDrug_id()).get();
		 dm.setQuantity(dm.getQuantity()+d.getQuantity());
		 dmRepository.save(dm);
		 
		 });
		 biRepository.deleteAll(ar);
		 }
		return b;
	
		}
	@Override
	public void deleteBillModule(int id) 
	{
			
	}
	// OrderDetails Module

	@Override
	public OrderDetails postOrderDetails(OrderDetails od, String vname) 
	{
		VendorModule vm=vmRepository.findByVname(vname);
		if(vm.equals(null)) {throw new DataNotFoundException("VendorModule", "vname", vname);}
		od.setV(vm);	
		return odRepository.save(od);
	}

	@Override
	public List<OrderDetails> getAllOrderDetails() {
		
		return odRepository.findAll();
	}

	@Override
	public OrderDetails getOrderDetailsById(int id) 
	{
		return odRepository.findById(id).orElseThrow(()->new DataNotFoundException("OrderDetails","id",id));
	}
	@Override
	public List<OrderDetails> getAllOrderDetailsByVname(String vname) 
	{
		List<OrderDetails> od=odRepository.findAll().stream().filter(e->e.getV().getVname()==vname).collect(Collectors.toList());
		if(od.equals(null))
		{
			throw new DataNotFoundException("OrderDetails","VendorMOdule",vname);
		}
		return od;
	}

	@Override
	public List<OrderDetails> getAllOrderDetailsByStatus(String status) 
	{
		return odRepository.findAll().stream().filter(e->e.getStatus()==status).collect(Collectors.toList());
	}

	@Override
	public OrderDetails updateOrderDetails(OrderDetails od,int id) 
	{
		OrderDetails ord=odRepository.findById(id).orElseThrow(()->new DataNotFoundException("OrderDetails","order_id", id));
		ord.setDate(od.getDate());
		ord.setStatus(od.getStatus());
		return odRepository.save(ord);
		
	}
	@Override
	public OrderDetails updateOrderDetailsByStatus(int id, String status) 
	{
		OrderDetails od=odRepository.findById(id).orElseThrow(()-> new DataNotFoundException("OrderDetails","order_id", id));
		od.setStatus(status);
		if(status.equals("received")||status.equals("completed"))
		{
			
			List<Inventory> li=inRepository.findAll().stream().filter(e->e.getOrder().getOrder_id()==id).collect(Collectors.toList());
			li.forEach(e->{
				DrugModule dm=dmRepository.findById(e.getDrug_id()).get();
				int a=dm.getQuantity();
				dm.setQuantity(a+e.getQuantity());
				dmRepository.save(dm);
			});
		}
		return odRepository.save(od);
		
	}
	@Override
	public void deleteOrderDetailsById(int id) 
	{
		odRepository.findById(id).orElseThrow(()->new DataNotFoundException("OrderDetails","order_id",id));	
	}

	@Override
	public void deleteOrderDetailsByVname(String vname) 
	{
		List<OrderDetails> l=odRepository.findAll().stream().filter(e->e.getV().getVname()==vname).collect(Collectors.toList());
		if(l.isEmpty()) {
			throw new DataNotFoundException("OrderDetails","vname", vname);
			}
		odRepository.deleteAll(l);
	}
	//Inventory module

	@Override
	public List<Inventory> postInventory(List<Inventory> in,int order_id) 
	{
		OrderDetails od=odRepository.findById(order_id).orElseThrow(()->new DataNotFoundException("OrderDetails","order_id",order_id));
		in.forEach(e->{
			if(dmRepository.existsById(e.getDrug_id())==false)
			{
				throw new DataNotFoundException("orderDetails","order_id",order_id);
			}
			e.setOrder(od);
			});
	 return inRepository.saveAll(in);
	 }

	@Override
	public List<Inventory> getAllInventory() {
		return inRepository.findAll();
	}

	@Override
	public List<Inventory> getAllInventoryByOrderId(int id) 
	{
		List<Inventory> li=inRepository.findAll().stream().filter(e->e.getOrder().getOrder_id()==id).collect(Collectors.toList());
		return li;
	}
	@Override
	public Inventory getAllInventoryByInventoryId(int id) 
	{
		return inRepository.findById(id).orElseThrow(()->new DataNotFoundException("Inventory","inventory_id",id));
	}
	@Override
	public Inventory updateInventoryById(int id) 
	{
		return null;
	}
	@Override
	public void deleteInventoryById(int id) {
		inRepository.deleteById(id);
	}	
}
