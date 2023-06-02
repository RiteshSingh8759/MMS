package com.kloc.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kloc.test.entities.BillModule;

public interface BMRepository extends JpaRepository<BillModule, Integer>{

}
