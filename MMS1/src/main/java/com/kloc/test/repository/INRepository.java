package com.kloc.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kloc.test.entities.Inventory;

public interface INRepository extends JpaRepository<Inventory, Integer>
{

}
