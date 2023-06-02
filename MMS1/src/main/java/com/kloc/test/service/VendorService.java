package com.kloc.test.service;

import java.util.List;

import com.kloc.test.entities.VendorModule;

public interface VendorService {
	VendorModule postvmModule(VendorModule vm);
	List<VendorModule> getAllVmModule();
	VendorModule getById(int id);
	VendorModule updateById(VendorModule vm,int id);
	void deleteVendorById(int id);
	VendorModule getByName(String vname);
}
