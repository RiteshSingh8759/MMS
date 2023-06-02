package com.kloc.test.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kloc.test.entities.OrderDetails;

public interface ODRepository extends JpaRepository<OrderDetails,Integer>
{

}
