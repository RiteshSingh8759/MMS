package com.springboot.MMS.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vendormodule")
public class VendorModule 
{
	@Id
	@Column(name="vendor_id")
	private int vendor_id;
	@Column(name="vname")
	private String vname;
	@Column(name="v_phoneno")  
	private long v_phoneno;
	@Column(name="v_address")
	private String v_address;
	@Column(name="tin_no")
	private int tin_no;
	@Column(name="gst_no")
	private long gst_no;
	@Column(name="v_email")
	private String v_email;
	public VendorModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VendorModule(int vendor_id, String vname, long v_phoneno, String v_address, int tin_no, long gst_no,
			String v_email) {
		super();
		this.vendor_id = vendor_id;
		this.vname = vname;
		this.v_phoneno = v_phoneno;
		this.v_address = v_address;
		this.tin_no = tin_no;
		this.gst_no = gst_no;
		this.v_email = v_email;
	}
	@Override
	public String toString() {
		return "VendorModule [vendor_id=" + vendor_id + ", vname=" + vname + ", v_phoneno=" + v_phoneno + ", v_address="
				+ v_address + ", tin_no=" + tin_no + ", gst_no=" + gst_no + ", v_email=" + v_email + "]";
	}
	public int getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public long getV_phoneno() {
		return v_phoneno;
	}
	public void setV_phoneno(long v_phoneno) {
		this.v_phoneno = v_phoneno;
	}
	public String getV_address() {
		return v_address;
	}
	public void setV_address(String v_address) {
		this.v_address = v_address;
	}
	public int getTin_no() {
		return tin_no;
	}
	public void setTin_no(int tin_no) {
		this.tin_no = tin_no;
	}
	public long getGst_no() {
		return gst_no;
	}
	public void setGst_no(long gst_no) {
		this.gst_no = gst_no;
	}
	public String getV_email() {
		return v_email;
	}
	public void setV_email(String v_email) {
		this.v_email = v_email;
	}

	
}
