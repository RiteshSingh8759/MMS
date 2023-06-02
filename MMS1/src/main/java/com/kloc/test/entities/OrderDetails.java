package com.kloc.test.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="Order_Details")
public class OrderDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	private String date;
	private String status;
//	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "order")
//	@JsonManagedReference
//	private List<Inventory> inventorylist;	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="v_id",referencedColumnName = "vendorId")
	@JsonBackReference
	private VendorModule v;
}
