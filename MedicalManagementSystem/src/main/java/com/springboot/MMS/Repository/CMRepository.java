package com.springboot.MMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.MMS.Entity.CustomerModule;

public interface CMRepository extends JpaRepository<CustomerModule, Integer>
{

}
