package DBproject.controller;

import java.util.Date;

public class Drug {
	private Integer drug_id;
	private String generic_name;
	private String brand_name;
	private String dosage_form;
	private String manufacturer;
	private Date expiration;
	private Integer upperbound;
	private Integer lowerbound;
	
	public Integer getDrug_id() {
		return drug_id;
	}
	public void setDrug_id(Integer drug_id) {
		this.drug_id = drug_id;
	}
	
	public String getGeneric_name() {
		return generic_name;
	}
	public void setGeneric_name(String generic_name) {
		this.generic_name = generic_name;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}	
	public String getDosage_form() {
		return dosage_form;
	}
	public void setDosage_form(String dosage_form) {
		this.dosage_form = dosage_form;
	}	
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}	
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date  expiration) {
		this.expiration =  expiration;
	}	
	public Integer getUpperbound() {
		return upperbound;
	}
	public void setUpperbound(Integer upperbound) {
		this.upperbound = upperbound;
	}	
	public Integer getLowerbound() {
		return lowerbound;
	}
	public void setLowerbound(Integer lowerbound) {
		this.lowerbound = lowerbound;
	}	
}
