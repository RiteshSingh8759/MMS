package com.kloc.test.service;

import java.util.List;

import com.kloc.test.entities.DrugModule;

public interface DrugService {
	List<DrugModule> postDrugmodule(List<DrugModule> dm,String vname);
	List<DrugModule> getAllDrugByVname(String Vname);
	List<DrugModule> getAllDrug();
	List<DrugModule> getAllDrugToOrder(int Quantity);
	DrugModule getBydrugId(int id);
	DrugModule updateDrugModule(DrugModule dm,int id);
}
