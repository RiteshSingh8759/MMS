package com.springboot.MMS.Service.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.MMS.Entity.BillItems;
import com.springboot.MMS.Entity.BillModule;
import com.springboot.MMS.Entity.CustomerModule;
import com.springboot.MMS.Entity.DrugModule;
import com.springboot.MMS.Entity.VendorModule;
import com.springboot.MMS.Exception.DataNotFoundException;
import com.springboot.MMS.Repository.BIRepository;
import com.springboot.MMS.Repository.BMRepository;
import com.springboot.MMS.Repository.CMRepository;
import com.springboot.MMS.Repository.DMRepository;
import com.springboot.MMS.Repository.VMRepository;
import com.springboot.MMS.Service.BillItemsService;
import com.springboot.MMS.Service.BillService;
import com.springboot.MMS.Service.CustomerService;
import com.springboot.MMS.Service.DrugService;
import com.springboot.MMS.Service.VendorService;

@Service
public class MedicalServiceImpl implements BillItemsService,BillService,CustomerService,DrugService,VendorService
{
	private BIRepository biRepository;
	private BMRepository bmRepository;
	private CMRepository cmRepository;
	private DMRepository dmRepository;
	private VMRepository vmRepository;
	
	public MedicalServiceImpl(BIRepository biRepository, BMRepository bmRepository, CMRepository cmRepository,
			DMRepository dmRepository, VMRepository vmRepository) {
		super();
		this.biRepository = biRepository;
		this.bmRepository = bmRepository;
		this.cmRepository = cmRepository;
		this.dmRepository = dmRepository;
		this.vmRepository = vmRepository;
	}
	@Override
	public VendorModule postVmModule(VendorModule vm) {
		
		return vmRepository.save(vm);
	}
	@Override
	public List<VendorModule> getAllVmModule() {
		
		return vmRepository.findAll();
	}
	@Override
	public VendorModule getByVname(String vname)
	{
		VendorModule vm=vmRepository.findByVname(vname);
		return vm;
	}
	@Override
	public VendorModule getByVid(int id) {
		
		return vmRepository.findById(id).orElseThrow(()->new DataNotFoundException("VendorModule","Id",id));
	}
	@Override
	public VendorModule updateById(VendorModule uvm,int id)
	{
		VendorModule existing=vmRepository.findById(id).orElseThrow(()->new DataNotFoundException("VendorModule","Id", id));
		existing.setV_address(uvm.getV_address());
		existing.setV_email(uvm.getV_email());
		existing.setGst_no(uvm.getGst_no());
		existing.setV_phoneno(uvm.getV_phoneno());
		existing.setTin_no(uvm.getTin_no());
		existing.setVendor_id(uvm.getVendor_id());
		existing.setVname(uvm.getVname());
		vmRepository.save(existing);
		
		return existing;
	}
	@Override
	public void deleteVendorById(int id) {
	    vmRepository.findById(id).orElseThrow(()->new DataNotFoundException("VendorModule","id", id));
	    List<DrugModule> li=dmRepository.findAll().stream().filter(e->e.getVendor_id()==id).collect(Collectors.toList());
	    dmRepository.deleteAll(li);
		 vmRepository.deleteById(id);
	}
	//Drugmodule-----------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public DrugModule postDrugModule(DrugModule dm) {
		vmRepository.findById(dm.getVendor_id()).orElseThrow(()->new DataNotFoundException("Drugmodule","in vendorModule with this id", dm.getVendor_id()));
		return dmRepository.save(dm);
	}
	@Override
	public List<DrugModule> getAllDrug() {
		
		return dmRepository.findAll();
	}
	@Override
	public DrugModule getByDrugId(int id) {
		return dmRepository.findById(id).orElseThrow(()->new DataNotFoundException("DrugModule","Id", id)); 
	}
	@Override
	public DrugModule updateDrugModule(DrugModule dm, int id) {
		DrugModule exist=dmRepository.findById(id).orElseThrow(()->new DataNotFoundException("DrugModule","Id", id));
		exist.setBatch_no(dm.getBatch_no());
		exist.setCompany(dm.getCompany());
		exist.setD_name(dm.getD_name());
		exist.setDose(dm.getDose());
		exist.setDrug_id(dm.getDrug_id());
		exist.setExp_date(dm.getExp_date());
		exist.setMfg_date(dm.getMfg_date());
		exist.setQuantity(dm.getQuantity());
		exist.setUnit_price(dm.getUnit_price());
		dmRepository.save(exist);
		return exist;
	}
	@Override
	public void deleteByDid(int id) 
	{
		dmRepository.findById(id).orElseThrow(()->new DataNotFoundException("DrugModule", "Id", id));
		dmRepository.deleteById(id);
	}
	// customer module-----------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public CustomerModule postCustomerModule(CustomerModule cm) 
	{
		
		return cmRepository.save(cm);
	}
	@Override
	public List<CustomerModule> getAllCustomerModule() {
		
		return cmRepository.findAll();
	}
	@Override
	public CustomerModule getCustomerModuleById(int id) {
		
		return cmRepository.findById(id).orElseThrow(()->new DataNotFoundException("CustomerModule", "Id", id));
	}
	@Override
	public CustomerModule updateById(CustomerModule cm,int id) {
		CustomerModule existing=cmRepository.findById(id).orElseThrow(()->new DataNotFoundException("CustomerModule","Id", id));
		existing.setC_address(cm.getC_address());
		existing.setC_email(cm.getC_email());
		existing.setC_name(cm.getC_name());
		existing.setC_phoneno(cm.getC_phoneno());
		existing.setCustomer_id(cm.getCustomer_id());
		cmRepository.save(existing);
		return existing;
	}
//	@Override
//	public void deleteByCid(int id) 
//	{
//		cmRepository.findById(id).orElseThrow(()->new DataNotFoundException("CustomerModule","Id",id));
//		cmRepository.deleteById(id);
//		List<Integer> li=bmRepository.findAll().stream().filter(e->e.getCustomer_id()==id).map(a->a.getBill_no()).collect(Collectors.toList());
//		bmRepository.deleteAllById(li);
//		li.forEach(e->
//		{
//			List<BillItems> ar=biRepository.findAll().stream().filter(a->a.getBill_no()==e).collect(Collectors.toList());
//			ar.forEach(d->{
//				DrugModule dm=dmRepository.findById(d.getDrug_id()).get();
//				dm.setQuantity(dm.getQuantity()+d.getQuantity());
//				dmRepository.save(dm);
//			});
//			biRepository.deleteAll(ar);
//		});
//	}
	// bill items----------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public BillItems postBillItems(BillItems bi) 
	{
		BillModule bm=bmRepository.findById(bi.getBill_no()).orElseThrow(()->new DataNotFoundException("BillModule", "billno", bi.getBill_no()));
		DrugModule dm=dmRepository.findById(bi.getDrug_id()).orElseThrow(()->new DataNotFoundException("DrugModule","drug_id", bi.getDrug_id()));
		if(dm.getQuantity()>bi.getQuantity()&&dm.getUnit_price()==bi.getUnit_price()&&dm.getDrug_id()==bi.getDrug_id()&&bi.getNet_price()==(bi.getUnit_price()*bi.getQuantity()))
		{
			return biRepository.save(bi);
		}
		else {
			throw new DataNotFoundException("BillItems","drug_id",bi.getDrug_id());
		}

	}
	@Override
	public List<BillItems> getAllBillItems() {
		
		return biRepository.findAll();
	}
	@Override
	public BillItems getBillItemsById(int id) {
		
		return biRepository.findById(id).orElseThrow(()->new DataNotFoundException("BillItems", "bill_items_id", id));
	}
	@Override
	public BillItems updateBillItemsById(BillItems bi,int id) {
		     BillItems exist=biRepository.findById(id).orElseThrow(()->new DataNotFoundException("BillItems","bill_items_id",id));
		     exist.setBill_items_id(bi.getBill_items_id());
		     exist.setBill_no(bi.getBill_no());
		     exist.setDrug_id(bi.getDrug_id());
		     exist.setNet_price(bi.getNet_price());
		     exist.setQuantity(bi.getQuantity());
		     exist.setUnit_price(bi.getUnit_price());
		     biRepository.save(exist);
		     return exist;
	}
	@Override
	public void deleteBillItemsById(int id) 
	{	
		biRepository.findById(id).orElseThrow(()->new DataNotFoundException("BillItems","bill_items-id", id));
		biRepository.deleteById(id);
	}
	@Override
	public List<BillItems> getAllBillitemsByBillNo(int billno) 
	{
		bmRepository.findById(billno).orElseThrow(()->new DataNotFoundException("BillModule","billno", billno));
		List<BillItems> bi=biRepository.findAll().stream().filter(e->e.getBill_no()==billno).collect(Collectors.toList());
		return bi;
	}
	// BillModule----------------------------------------------------------------------------------------------------------------------------------------------------------
		@Override
		public BillModule postBillmodule(BillModule bm) 
		{
			cmRepository.findById(bm.getCustomer_id()).orElseThrow(()->new DataNotFoundException("customerModule", "custId", bm.getCustomer_id()));
			return bmRepository.save(bm);
		}
		@Override
		public List<BillModule> getAllBillModule() {
			
			return bmRepository.findAll();
		}
		@Override
		public BillModule getBillModuleById(int id) {
			
			return bmRepository.findById(id).orElseThrow(()->new DataNotFoundException("BillModule","Id", id));
		}
		@Override
		public BillModule updateBillmoduleById(BillModule bm,int id) {
			
			BillModule b=bmRepository.findById(id).orElseThrow(()->new DataNotFoundException("BillModule","Id", id));
			b.setBill_amount(bm.getBill_amount());
			b.setBill_no(bm.getBill_no());
			b.setCustomer_id(bm.getCustomer_id());
			b.setModeofPayment(bm.getModeofPayment());
			b.setCancellation_options(bm.getCancellation_options());
			bmRepository.save(b);
			// checking the payment option
	        if(!bm.getModeofPayment().isEmpty()||!bm.getModeofPayment().equals("cancelled"))
	        {
	    		int g=0;
	    		List<BillItems> ar=biRepository.findAll().stream().filter(e->(e.getBill_no()==bm.getBill_no())).collect(Collectors.toList());
	    	    for(int i=0;i<ar.size();i++)
	    	    {
	    	    	g=g+ar.get(i).getNet_price();
	    	    }
	    		
	    		if(cmRepository.existsById(bm.getCustomer_id())&&g==bm.getBill_amount()) 
	    		{
	    			 ar.forEach(bi->{ 
	    			  DrugModule dm=dmRepository.findById(bi.getDrug_id()).get();
	    			  dm.setQuantity(dm.getQuantity()-bi.getQuantity());
	    			  dmRepository.save(dm);
	    			 });
	    		      return bmRepository.save(bm);
	    		}			
	        }
	        // checking the cancellation option
			if(bm.getCancellation_options().contains("yes")) {
				List<BillItems> ar=biRepository.findAll().stream().filter(a->a.getBill_no()==bm.getBill_no()).collect(Collectors.toList());
				ar.forEach(d->{
					DrugModule dm=dmRepository.findById(d.getDrug_id()).get();
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
		
	
}
