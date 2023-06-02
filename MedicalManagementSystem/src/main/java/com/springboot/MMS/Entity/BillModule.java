package com.springboot.MMS.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="billmodule")
public class BillModule 
{
	@Id
	@Column(name="bill_no")
	private int bill_no;
	@Column(name="customer_id")
	private int customer_id;
	@Column(name="bill_amount")
	private int bill_amount;
	@Column(name="modeofPayment")
	private String modeofPayment;
	@Column(name="cancellation_options")
	private String cancellation_options;
	public BillModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillModule(int bill_no, int customer_id, int bill_amount, String modeofPayment,
			String cancellation_options) {
		super();
		this.bill_no = bill_no;
		this.customer_id = customer_id;
		this.bill_amount = bill_amount;
		this.modeofPayment = modeofPayment;
		this.cancellation_options = cancellation_options;
	}
	@Override
	public String toString() {
		return "BillModule [bill_no=" + bill_no + ", customer_id=" + customer_id + ", bill_amount=" + bill_amount
				+ ", modeofPayment=" + modeofPayment + ", cancellation_options=" + cancellation_options + "]";
	}
	public int getBill_no() {
		return bill_no;
	}
	public void setBill_no(int bill_no) {
		this.bill_no = bill_no;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getBill_amount() {
		return bill_amount;
	}
	public void setBill_amount(int bill_amount) {
		this.bill_amount = bill_amount;
	}
	public String getModeofPayment() {
		return modeofPayment;
	}
	public void setModeofPayment(String modeofPayment) {
		this.modeofPayment = modeofPayment;
	}
	public String getCancellation_options() {
		return cancellation_options;
	}
	public void setCancellation_options(String cancellation_options) {
		this.cancellation_options = cancellation_options;
	}
	
}
