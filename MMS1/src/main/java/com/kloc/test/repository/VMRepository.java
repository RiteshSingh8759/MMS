package com.kloc.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kloc.test.entities.VendorModule;

public interface VMRepository extends JpaRepository<VendorModule, Integer> 
{
	public VendorModule findByVname(String vname);
}
