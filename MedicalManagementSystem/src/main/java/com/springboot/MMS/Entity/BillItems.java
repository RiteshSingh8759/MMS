package com.springboot.MMS.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="billitems")
public class BillItems 
{
	@Id
	@Column(name="bill_items_id")
	private int bill_items_id;
	@Column(name="bill_no")
	private int bill_no;
	@Column(name="drug_id")
	private int drug_id;
	@Column(name="quantity")
	private int quantity;
	@Column(name="unit_price")
	private int unit_price;
	@Column(name="net_price")
	private int net_price;
	public BillItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillItems(int bill_items_id, int bill_no, int drug_id, int quantity, int unit_price, int net_price) {
		super();
		this.bill_items_id = bill_items_id;
		this.bill_no = bill_no;
		this.drug_id = drug_id;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.net_price = net_price;
	}
	@Override
	public String toString() {
		return "BillItems [bill_items_id=" + bill_items_id + ", bill_no=" + bill_no + ", drug_id=" + drug_id
				+ ", quantity=" + quantity + ", unit_price=" + unit_price + ", net_price=" + net_price + "]";
	}
	public int getBill_items_id() {
		return bill_items_id;
	}
	public void setBill_items_id(int bill_items_id) {
		this.bill_items_id = bill_items_id;
	}
	public int getBill_no() {
		return bill_no;
	}
	public void setBill_no(int bill_no) {
		this.bill_no = bill_no;
	}
	public int getDrug_id() {
		return drug_id;
	}
	public void setDrug_id(int drug_id) {
		this.drug_id = drug_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}
	public int getNet_price() {
		return net_price;
	}
	public void setNet_price(int net_price) {
		this.net_price = net_price;
	}
	
}
