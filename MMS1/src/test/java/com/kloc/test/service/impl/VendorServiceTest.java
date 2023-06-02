package com.kloc.test.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kloc.test.entities.CustomerModule;
import com.kloc.test.entities.DrugModule;
import com.kloc.test.entities.VendorModule;
import com.kloc.test.repository.BIRepository;
import com.kloc.test.repository.BMRepository;
import com.kloc.test.repository.CMRepository;
import com.kloc.test.repository.DMRepository;
import com.kloc.test.repository.INRepository;
import com.kloc.test.repository.ODRepository;
import com.kloc.test.repository.VMRepository;

@ExtendWith(MockitoExtension.class)
public class VendorServiceTest 
{
	@Mock
	private VMRepository vmRepository;
	@Mock
	private ODRepository odRepository;
	@Mock
	private INRepository inRepository;
	@Mock
	private DMRepository dmRepository;
	@Mock
	private CMRepository cmRepository;
	@Mock
	private BMRepository bmRepository;
	@Mock
	private BIRepository biRepository; 
	private MedicalserviceImpl medicalServiceImpl;
	 @BeforeEach
	void setUp()
	{
		this.medicalServiceImpl=new MedicalserviceImpl(this.biRepository,this.bmRepository, this.cmRepository, this.dmRepository, this.vmRepository,this.odRepository,this.inRepository);
	}
	@Test
	public void getAllVendor()
	{
		List<VendorModule> vendors = List.of(
                new VendorModule(1,"ritesh",8340720814l,"gaya",101,1001l,"ritesh8759@gmail.com"),
                new VendorModule(3,"ritesh",8340720814l,"gaya",101,1001l,"ritesh8759@gmail.com"),
                new VendorModule(2,"ritesh",8340720814l,"gaya",101,1001l,"ritesh8759@gmail.com")
        );
        when(vmRepository.findAll()).thenReturn(vendors);
        List<VendorModule> result = medicalServiceImpl.getAllVmModule();
        verify(vmRepository).findAll();
        assertEquals(vendors, result);
	}
	@Test
	public void getVendorByName()
	{
		medicalServiceImpl.getByName("ritesh");
		verify(vmRepository).findByVname("ritesh");
	}
	@Test
	public void getVendorByid()
	{
		   Optional<VendorModule> vendor = Optional.of(new VendorModule(3,"ritesh",8340720814l,"gaya",101,1001l,"ritesh8759@gmail.com")); 
		    when(vmRepository.findById(3)).thenReturn(vendor);
//		    System.out.println(medicalServiceImpl.getById(3).toString());
		medicalServiceImpl.getById(3);
		verify(vmRepository).findById(3);

	}
	@Test
	public void getDrugAllModule()
	{
		List<DrugModule> drugModule=List.of(new DrugModule(1,"Dolo",2,"sunPharma",1001,"17-fab-2023","17-june-2023",5000,3),
				new DrugModule(2,"Dolo",2,"sunPharma",1001,"17-fab-2023","17-june-2023",5000,3),
				new DrugModule(3,"Dolo",2,"sunPharma",1001,"17-fab-2023","17-june-2023",5000,3),
				new DrugModule(4,"Dolo",2,"sunPharma",1001,"17-fab-2023","17-june-2023",5000,3)
				);
		when(dmRepository.findAll()).thenReturn(drugModule);
		List<DrugModule> li=medicalServiceImpl.getAllDrug();
		assertEquals(drugModule, li);
	}
	@Test
	public void getAllDrugById()
	{
		Optional<DrugModule> dm=Optional.of(new DrugModule(4,"Dolo",2,"sunPharma",1001,"17-fab-2023","17-june-2023",5000,3));
		when(dmRepository.findById(4)).thenReturn(dm);
		medicalServiceImpl.getBydrugId(4);
		verify(dmRepository).findById(4);
	}
//	@Test
//	public void getAllCustomer()
//	{
//		List<CustomerModule> l=List.of(new CustomerModule(),);
//	}
}
