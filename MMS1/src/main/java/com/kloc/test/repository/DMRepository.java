package com.kloc.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kloc.test.entities.DrugModule;

public interface DMRepository extends JpaRepository<DrugModule, Integer> {

}
