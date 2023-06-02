package com.springboot.MMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.MMS.Entity.DrugModule;

public interface DMRepository extends JpaRepository<DrugModule, Integer>
{

}
