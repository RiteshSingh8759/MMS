package com.kloc.test.entities;

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
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table
public class BillItems {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int billitemsId;
	private int drug_id;
	private int quantity;
	private int unit_price;
	private int net_price;
	private String bill_Date;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="billno",referencedColumnName = "billno")
	@JsonBackReference
	private BillModule bm;
}
