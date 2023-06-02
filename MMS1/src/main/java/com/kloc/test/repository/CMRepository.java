package com.kloc.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kloc.test.entities.CustomerModule;
import com.kloc.test.entities.VendorModule;

public interface CMRepository extends JpaRepository<CustomerModule, Integer> {
	public CustomerModule findByCname(String cname);
}
