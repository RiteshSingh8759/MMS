package com.kloc.test.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
public class DrugModule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="drugId")
	private int drugId;
	@Column(name="dname")
	private String dname;
	@Column(name="dose")
	private int dose;
	@Column(name="company")
	private String company;
	@Column(name="batchNo")
	private int batchNo;
	@Column(name="mfgdate")
	private String mfgdate;
	@Column(name="expdate")
	private String expdate;
	@Column(name="quantity")
	private int quantity;
	@Column(name="unitPrice")
	private int unitPrice;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="vendor_id",referencedColumnName = "vendorId")
	@JsonBackReference
	private VendorModule vm;
	public DrugModule(int drugId, String dname, int dose, String company, int batchNo, String mfgdate, String expdate,
			int quantity, int unitPrice) {
		super();
		this.drugId = drugId;
		this.dname = dname;
		this.dose = dose;
		this.company = company;
		this.batchNo = batchNo;
		this.mfgdate = mfgdate;
		this.expdate = expdate;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		
	}
	public DrugModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
