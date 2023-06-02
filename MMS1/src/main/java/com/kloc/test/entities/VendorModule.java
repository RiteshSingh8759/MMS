package com.kloc.test.entities;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "VendorModule")
public class VendorModule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendorId")
	private int vendorId;
	@Column(name = "vname")
	private String vname;
	@Column(name = "vphoneNo")
	private long vphoneNo;
	@Column(name = "vaddress")
	private String vaddress;
	@Column(name = "tinN0")
	private int tinNo;
	@Column(name = "gstNo")
	private long gstNo;
	@Column(name = "vemail")
	private String vemail;	
//	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "vm")
//	@JsonManagedReference
//	private List<DrugModule> drugModules;
//	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "v")
//	@JsonManagedReference
//	private List<OrderDetails> orderlist;
	public VendorModule(int vendorId, String vname, long vphoneNo, String vaddress, int tinNo, long gstNo,
			String vemail) {
		super();
		this.vendorId = vendorId;
		this.vname = vname;
		this.vphoneNo = vphoneNo;
		this.vaddress = vaddress;
		this.tinNo = tinNo;
		this.gstNo = gstNo;
		this.vemail = vemail;
	}
	public VendorModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
