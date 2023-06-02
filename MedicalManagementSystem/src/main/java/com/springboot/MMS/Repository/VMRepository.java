package com.springboot.MMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.MMS.Entity.VendorModule;

public interface VMRepository extends JpaRepository<VendorModule, Integer>
{
	public VendorModule findByVname(String vname);
}
