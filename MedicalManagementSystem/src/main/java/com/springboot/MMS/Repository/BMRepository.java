package com.springboot.MMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.MMS.Entity.BillModule;

public interface BMRepository extends JpaRepository<BillModule,Integer>
{

}
