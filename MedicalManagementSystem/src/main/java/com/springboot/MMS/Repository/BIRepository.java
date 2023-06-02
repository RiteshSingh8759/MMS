package com.springboot.MMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.MMS.Entity.BillItems;
public interface BIRepository extends JpaRepository<BillItems, Integer>
{

}
