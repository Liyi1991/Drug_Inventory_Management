package DBproject.controller;



public class Warehouse {
	private Integer warehouse_id;
	private String street;
	private String city;
	private String state;
	private String zip_code;
	private String phone;
	
	public Integer getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(Integer warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}	
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String  phone) {
		this.phone =  phone;
	}	
	
}
