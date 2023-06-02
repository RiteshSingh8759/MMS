package com.springboot.MMS.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customermodule")
public class CustomerModule 
{
	@Id
	@Column(name="customer_id")
	private int customer_id;
	@Column(name="c_name")
	private String c_name;
	@Column(name="c_phoneno")
	private long c_phoneno;
	@Column(name="c_address")
	private String c_address;
	@Column(name="c_email")
	private String c_email;
	public CustomerModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerModule(int customer_id, String c_name, long c_phoneno, String c_address, String c_email) {
		super();
		this.customer_id = customer_id;
		this.c_name = c_name;
		this.c_phoneno = c_phoneno;
		this.c_address = c_address;
		this.c_email = c_email;
	}
	@Override
	public String toString() {
		return "CustomerModule [customer_id=" + customer_id + ", c_name=" + c_name + ", c_phoneno=" + c_phoneno
				+ ", c_address=" + c_address + ", c_email=" + c_email + "]";
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public long getC_phoneno() {
		return c_phoneno;
	}
	public void setC_phoneno(long c_phoneno) {
		this.c_phoneno = c_phoneno;
	}
	public String getC_address() {
		return c_address;
	}
	public void setC_address(String c_address) {
		this.c_address = c_address;
	}
	public String getC_email() {
		return c_email;
	}
	public void setC_email(String c_email) {
		this.c_email = c_email;
	}
	
}
