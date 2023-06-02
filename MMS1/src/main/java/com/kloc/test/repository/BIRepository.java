package com.kloc.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kloc.test.entities.BillItems;

public interface BIRepository extends JpaRepository<BillItems, Integer> {

}
