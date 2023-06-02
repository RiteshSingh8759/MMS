package com.kloc.test.entities;

import java.util.List;

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
public class CustomerModule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cid")
	private int cid;
	@Column(name="cname")
	private String cname;
	@Column(name="cphoneNo")
	private long cphoneNo;
	@Column(name="caddress")
	private String caddress;
	@Column(name="cemail")
	private String cemail;
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "cm")
//	@JsonManagedReference
//	private List<BillModule> bm;
	public CustomerModule(int cid, String cname, long cphoneNo, String caddress, String cemail) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cphoneNo = cphoneNo;
		this.caddress = caddress;
		this.cemail = cemail;
	}
	public CustomerModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
