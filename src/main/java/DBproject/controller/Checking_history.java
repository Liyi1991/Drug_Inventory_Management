package DBproject.controller;

import java.util.Date;

public class Checking_history {
	private Integer checking_id;
	private Integer drug_id;
	private Integer warehouse_id;
	private String user_name;
	private Integer quantity;
	private Date checking_date;
	private Boolean if_checked_in;
	
	
	public Integer getChecking_id() {
		return checking_id;
	}
	public void setChecking_id(Integer checking_id) {
		this.checking_id = checking_id;
	}
	
	public Integer getDrug_id() {
		return drug_id;
	}
	public void setDrug_id(Integer drug_id) {
		this.drug_id = drug_id;
	}
	public Integer getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(Integer warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Date getChecking_date() {
		return checking_date;
	}
	public void setChecking_date(Date checking_date) {
		this.checking_date = checking_date;
	}
	public Boolean getIf_checked_in() {
		return if_checked_in;
	}
	public void setIf_checked_in(Boolean if_checked_in) {
		this.if_checked_in = if_checked_in;
	}
	
	
	
}
