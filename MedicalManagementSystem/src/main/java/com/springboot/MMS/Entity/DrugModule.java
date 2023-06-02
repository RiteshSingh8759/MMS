package com.springboot.MMS.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="drugmodule")
public class DrugModule 
{
	@Id
	@Column(name="drug_id")
	private int drug_id;
	@Column(name="d_name")
	private String d_name;
	@Column(name="dose")
	private int dose;
	@Column(name="company")
	private String company;
	@Column(name="batch_no")
	private int batch_no;
	@Column(name="mfg_date")
	private String mfg_date;
	@Column(name="exp_date")
	private String exp_date;
	@Column(name="quantity")
	private int quantity;
	@Column(name="vendor_id")
	private int vendor_id;
	@Column(name="unit_price")
	private int unit_price;
	public DrugModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "DrugModule [drug_id=" + drug_id + ", d_name=" + d_name + ", dose=" + dose + ", company=" + company
				+ ", batch_no=" + batch_no + ", mfg_date=" + mfg_date + ", exp_date=" + exp_date + ", quantity="
				+ quantity + ", vendor_id=" + vendor_id + ", unit_price=" + unit_price + "]";
	}

	public DrugModule(int drug_id, String d_name, int dose, String company, int batch_no, String mfg_date,
			String exp_date, int quantity, int vendor_id, int unit_price) {
		super();
		this.drug_id = drug_id;
		this.d_name = d_name;
		this.dose = dose;
		this.company = company;
		this.batch_no = batch_no;
		this.mfg_date = mfg_date;
		this.exp_date = exp_date;
		this.quantity = quantity;
		this.vendor_id = vendor_id;
		this.unit_price = unit_price;
	}

	public int getDrug_id() {
		return drug_id;
	}
	public void setDrug_id(int drug_id) {
		this.drug_id = drug_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public int getDose() {
		return dose;
	}
	public void setDose(int dose) {
		this.dose = dose;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getBatch_no() {
		return batch_no;
	}
	public void setBatch_no(int batch_no) {
		this.batch_no = batch_no;
	}
	public String getMfg_date() {
		return mfg_date;
	}
	public void setMfg_date(String mfg_date) {
		this.mfg_date = mfg_date;
	}
	public String getExp_date() {
		return exp_date;
	}
	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}

	public int getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}
	
	
}
