package com.kloc.test.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table
public class BillModule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="billNo")
	private int billNo;
	@Column(name="billAmount")
	private int billAmount;
	@Column(name="modeOfPayment")
	private String modeOfPayment;
	@Column(name="cancellationOption")
	private String cancellationOption;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="cid",referencedColumnName = "cid")
	@JsonBackReference
	private CustomerModule cm;
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "bm")
//	@JsonManagedReference
//	private List<BillItems> bi;
}
