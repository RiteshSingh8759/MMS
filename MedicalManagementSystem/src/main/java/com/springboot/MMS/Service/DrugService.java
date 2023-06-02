package com.springboot.MMS.Service;

import java.util.List;

import com.springboot.MMS.Entity.DrugModule;

public interface DrugService 
{
	DrugModule postDrugModule(DrugModule dm);
	List<DrugModule> getAllDrug();
	DrugModule getByDrugId(int id);
	DrugModule updateDrugModule(DrugModule dm,int id);
	void deleteByDid(int id);
	
}
