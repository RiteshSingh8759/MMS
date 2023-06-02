package com.springboot.MMS.Service;

import java.util.List;

import com.springboot.MMS.Entity.VendorModule;

public interface VendorService 
{
	 VendorModule postVmModule(VendorModule vm);
	 List<VendorModule> getAllVmModule();
	 VendorModule getByVname(String vname);
	 VendorModule getByVid(int id);
	 VendorModule updateById(VendorModule uvm,int id);
	 void deleteVendorById(int id);
}
