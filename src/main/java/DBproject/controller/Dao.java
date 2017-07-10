package DBproject.controller;

import java.util.Date;
import java.util.List;


public interface Dao {
	public void insertUser(User user);
	public User getUser(String user_name);
	public void updatePassword(User user);
	public void updateRole(User user);
	public List<User> getUserRoleList();
	
	public List<Warehouse> getWarehouseList();
	
	public void insertDrug(Drug drug);
	public List<Drug> getDrugList(String generic_name, String manufactuer);
	public Drug getNewestDrug();
	
	public void insertChecking_history(Checking_history checking_history);
	public List<Checking_history> getChecking_historyList(Date start_date, Date end_date);
	public Checking_history getNewestChecking_history();
	
	public void insertDrug_warehouse(Integer drug_id, Integer warehouse_id, Integer quantity);
	public void increaseDrug_warehouse(Integer drug_id, Integer warehouse_id, Integer quantity);
	public void decreaseDrug_warehouse(Integer drug_id, Integer warehouse_id, Integer quantity);
	
	public List<Drug_warehouse> getDrug_warehouseList(String drug_id, String warehouse_id);
	
	public List<Drug_warehouse> getExpiredDrugs();
	public List<Drug_warehouse> getOutofBoundDrugs();
}
