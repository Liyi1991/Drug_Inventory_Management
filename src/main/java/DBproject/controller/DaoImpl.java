package DBproject.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class DaoImpl implements Dao{
	 @Autowired
	 DataSource dataSource;
	 
	 // User Operation
	 public void insertUser(User user) {
		 
		  user.setRole_id("user");

		  String sql = "INSERT INTO user "
		    + "(user_name, role_id, password) VALUES (?, ?, ?)";

		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		  jdbcTemplate.update(sql, new Object[] { user.getUser_name(), user.getRole_id(), user.getPassword()});

		 }
		 
	 public void updatePassword(User user) {

		  String sql = "UPDATE user "
		    + "SET password = ? "
		    + "WHERE user_name = ?";

		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		  jdbcTemplate.update(sql, new Object[] { user.getPassword(), user.getUser_name()});

		 }
	 public void updateRole(User user) {

		  String sql = "UPDATE user "
		    + "SET role_id = ? "
		    + "WHERE user_name = ?";

		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		  jdbcTemplate.update(sql, new Object[] { user.getRole_id(), user.getUser_name()});

		 }
	 
	 public User getUser(String user_name) {
			
			  String sql = "select * from user where user_name = ?";
			  try{
				  
				  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				  List<User> userList = jdbcTemplate.query(sql, new Object[]{user_name}, new UserMapper());
				  
				  return userList.get(0);
				  
			  }catch (IndexOutOfBoundsException e) {
					return null;
				}
			  catch(NullPointerException e){
				  return null;
			  }
 
			 }
		 public class UserMapper implements RowMapper<User> {
			 
		   	   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		   		   try{
		   	   User user = new User();
		  	  
		  	  user.setUser_name(rs.getString(1));
		  	  user.setRole_id(rs.getString(2));
		  	  user.setPassword(rs.getString(3));	  
		  	  return user;
		   	   }
		   		catch(NullPointerException e){
					  return null;
				  }
			 }
		   	
		   	}
		 
		 public List<User> getUserRoleList(){
			 String sql = "SELECT user_name, user.role_id AS role_id, role_name FROM user,role WHERE user.role_id = role.role_id ";
			  try{
				  
				  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				  List<User> userList = jdbcTemplate.query(sql, new Object[]{ }, new UserRoleMapper());
				  
				  return userList;
				  
			  }catch (IndexOutOfBoundsException e) {
					return null;
				}
			  catch(NullPointerException e){
				  return null;
			  }
		 }
		 public class UserRoleMapper implements RowMapper<User> {
			 
		   	   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		   		   try{
		   	   User user = new User();
		  	  
		  	  user.setUser_name(rs.getString("user_name"));
		  	  user.setRole_id(rs.getString("role_id"));
		  	  user.setRole_name(rs.getString("role_name"));	  
		  	  return user;
		   	   }
		   		catch(NullPointerException e){
					  return null;
				  }
			 }
		   	
		   	}
		 
	   //Get warehouse information
		 public List<Warehouse> getWarehouseList(){
			 String sql = "select * from warehouse ";
			  try{
				  
				  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				  List<Warehouse> warehouseList = jdbcTemplate.query(sql, new Object[]{}, new WarehouseMapper());
				  
				  return warehouseList;
				  
			  }catch (IndexOutOfBoundsException e) {
					return null;
				}
			  catch(NullPointerException e){
				  return null;
			  }
		 }
		    public class WarehouseMapper implements RowMapper<Warehouse> {
		   	   public Warehouse mapRow(ResultSet rs, int rowNum) throws SQLException {
		   		   try{
				   	   Warehouse warehouse = new Warehouse();
				  	  
				   	  warehouse.setWarehouse_id(rs.getInt("warehouse_id"));
				     warehouse.setStreet(rs.getString("street"));
				     warehouse.setCity(rs.getString("city"));
				     warehouse.setState(rs.getString("state"));
				     warehouse.setZip_code(rs.getString("zip_code"));
				     warehouse.setPhone(rs.getString("phone"));
				  	  return warehouse;
		   	      }
		   		catch(NullPointerException e){
					  return null;
				  }
			 }		 
		   	}
		 
	  // Drug operation	 
		public void insertDrug(Drug drug){
			  String sql = "INSERT INTO drug "
					    + "(generic_name,brand_name,dosage_form,manufacturer,expiration,upperbound,lowerbound) VALUES (?, ?, ?, ?, ?, ?, ?)";

					  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

					  jdbcTemplate.update(sql, new Object[] { drug.getGeneric_name(), drug.getBrand_name(), drug.getDosage_form(), drug.getManufacturer(), drug.getExpiration(), drug.getUpperbound(), drug.getLowerbound()});

					 }
		
		public List<Drug> getDrugList(String generic_name, String manufacturer){
			String sql = "SELECT * FROM drug WHERE generic_name LIKE ? AND manufacturer LIKE ?";
			  try{
				  
				  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				  List<Drug> drugList = jdbcTemplate.query(sql, new Object[]{"%"+generic_name+"%", "%"+manufacturer+"%" }, new DrugMapper());
				  return drugList;
				  
			  }catch (IndexOutOfBoundsException e) {
					return null;
				}
			  catch(NullPointerException e){
				  return null;
			  }
		}
		 public class DrugMapper implements RowMapper<Drug> {
		   	   public Drug mapRow(ResultSet rs, int rowNum) throws SQLException {
		   		Drug drug = new Drug();
		  	  
		   		drug.setDrug_id(rs.getInt(1));
		   		drug.setGeneric_name(rs.getString(2));
		   		drug.setBrand_name(rs.getString(3));
		   		drug.setDosage_form(rs.getString(4));
		   		drug.setManufacturer(rs.getString(5));
		   		drug.setExpiration(rs.getDate(6));
		   		drug.setUpperbound(rs.getInt(7));
		   		drug.setLowerbound(rs.getInt(8));	
		  	  return drug;
		  	  
		   	   }
		   	}
		 public Drug getNewestDrug(){
				String sql = "SELECT * FROM drug WHERE drug_id = "
						+ "(SELECT max(drug_id) FROM drug)";
				  try{
					  
					  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
					  List<Drug> drugList = jdbcTemplate.query(sql, new Object[]{ }, new DrugMapper());
					  return drugList.get(0);
					  
				  }catch (IndexOutOfBoundsException e) {
						return null;
					}
				  catch(NullPointerException e){
					  return null;
				  }
			}
		 
		// Manage checking_history
		 public void insertChecking_history(Checking_history checking_history){
			 String sql = "INSERT INTO checking_history "
					    + "(drug_id,warehouse_id,user_name,quantity,checking_date, if_checked_in) VALUES (?, ?, ?, ?, ?, ?)";

					  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

					  jdbcTemplate.update(sql, new Object[] { checking_history.getDrug_id(), checking_history.getWarehouse_id(), checking_history.getUser_name(), checking_history.getQuantity(), checking_history.getChecking_date(), checking_history.getIf_checked_in()});

		 }
		 public List<Checking_history> getChecking_historyList(Date start_date, Date end_date){
			 String sql = "SELECT * FROM checking_history WHERE checking_date BETWEEN ? AND ?";
			  try{
				  
				  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				  List<Checking_history> checking_historyList = jdbcTemplate.query(sql, new Object[]{start_date, end_date}, new Checking_historyMapper());
				  return checking_historyList;
				  
			  }catch (IndexOutOfBoundsException e) {
					return null;
				}
			  catch(NullPointerException e){
				  return null;
			  }
		 }
		 
		 public class Checking_historyMapper implements RowMapper<Checking_history> {
		   	   public Checking_history mapRow(ResultSet rs, int rowNum) throws SQLException {
		   		Checking_history checking_history = new Checking_history();
		  	  
		   		checking_history.setChecking_id(rs.getInt(1));
		   		checking_history.setDrug_id(rs.getInt(2));
		   		checking_history.setWarehouse_id(rs.getInt(3));
		   		checking_history.setUser_name(rs.getString(4));
		   		checking_history.setQuantity(rs.getInt(5));
		   		checking_history.setChecking_date(rs.getDate(6));
		   		checking_history.setIf_checked_in(rs.getBoolean(7));
		   			
		  	  return checking_history;
		  	  
		   	   }
		   	}
		 
		 public Checking_history getNewestChecking_history(){
			 String sql = "SELECT * FROM checking_history WHERE checking_id = "
					 +"(SELECT max(checking_id) FROM checking_history)";
			  try{
				  
				  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				  List<Checking_history> checking_historyList = jdbcTemplate.query(sql, new Object[]{}, new Checking_historyMapper());
				  return checking_historyList.get(0);
				  
			  }catch (IndexOutOfBoundsException e) {
					return null;
				}
			  catch(NullPointerException e){
				  return null;
			  }
		 }
		 
		  //Update Inventory Information
			public void insertDrug_warehouse(Integer drug_id, Integer warehouse_id, Integer quantity){
				 String sql = "INSERT INTO drug_warehouse "
						    + "(drug_id,warehouse_id,quantity) VALUES (?, ?, ?)";

						  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

						  jdbcTemplate.update(sql, new Object[] { drug_id, warehouse_id, quantity});

			}
			public void increaseDrug_warehouse(Integer drug_id, Integer warehouse_id, Integer quantity){
				String sql = "Update drug_warehouse "
						+ "SET quantity = quantity + ? "
					    + "WHERE drug_id = ? AND warehouse_id = ? ";

					  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

					  jdbcTemplate.update(sql, new Object[] { quantity, drug_id, warehouse_id });
			}
			public void decreaseDrug_warehouse(Integer drug_id, Integer warehouse_id, Integer quantity){
				String sql = "Update drug_warehouse "
						+ "SET quantity = quantity - ? "
					    + "WHERE drug_id = ? AND warehouse_id = ? ";

					  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

					  jdbcTemplate.update(sql, new Object[] { quantity, drug_id, warehouse_id });
			}
			
			//Query for Inventory Information
			public List<Drug_warehouse> getDrug_warehouseList(String drug_id, String warehouse_id){
				 String sql = "SELECT drug.drug_id, generic_name, warehouse_id, quantity FROM drug, drug_warehouse WHERE drug.drug_id = drug_warehouse.drug_id AND drug.drug_id LIKE ? AND warehouse_id LIKE ?";
				  try{
					  
					  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
					  List<Drug_warehouse> drug_warehouseList = jdbcTemplate.query(sql, new Object[]{drug_id, warehouse_id}, new Drug_warehouseMapper());
					  return drug_warehouseList;
					  
				  }catch (IndexOutOfBoundsException e) {
						return null;
					}
				  catch(NullPointerException e){
					  return null;
				  }
			}
			 public class Drug_warehouseMapper implements RowMapper<Drug_warehouse> {
			   	   public Drug_warehouse mapRow(ResultSet rs, int rowNum) throws SQLException {
			   		   try{			   			  			   		
					   		Drug_warehouse drug_warehouse = new Drug_warehouse();
					  	    Drug drug = new Drug();
					  	    Warehouse warehouse = new Warehouse();
					  	    
					  	    drug.setDrug_id(rs.getInt(1));
					  	    drug.setGeneric_name(rs.getString(2));
					  	    warehouse.setWarehouse_id(rs.getInt(3));
					  	    
					   		drug_warehouse.setDrug(drug);
					   		drug_warehouse.setWarehouse(warehouse);
					   		drug_warehouse.setQuantity(rs.getInt(4));
				
			  	  return drug_warehouse;
			   		   }
			  	catch (IndexOutOfBoundsException e) {
					return null;
				}
			  catch(NullPointerException e){
				  return null;
			  	  
			   	   }
			   
			  }
			   	}
			
			// Query for expired drugs
			public List<Drug_warehouse> getExpiredDrugs(){
				 String sql = "SELECT drug.drug_id AS drug_id, generic_name, expiration, warehouse_id, quantity" 
						 + " FROM drug, drug_warehouse"
						 + " WHERE drug.drug_id = drug_warehouse.drug_id AND expiration <= CURDATE()";
				  try{
					  
					  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
					  List<Drug_warehouse> drug_warehouseList = jdbcTemplate.query(sql, new Object[]{}, new Drug_warehouse_ExpiredMapper());
					  return drug_warehouseList;
					  
				  }catch (IndexOutOfBoundsException e) {
						return null;
					}
				  catch(NullPointerException e){
					  return null;
				  }
			}
			
			 public class Drug_warehouse_ExpiredMapper implements RowMapper<Drug_warehouse> {
			   	   public Drug_warehouse mapRow(ResultSet rs, int rowNum) throws SQLException {
			   		Drug_warehouse drug_warehouse = new Drug_warehouse();
			  	    Drug drug = new Drug();
			  	    Warehouse warehouse = new Warehouse();
			  	    
			  	    drug.setDrug_id(rs.getInt("drug_id"));
			  	    drug.setGeneric_name(rs.getString("generic_name"));
			  	    drug.setExpiration(rs.getDate("expiration"));
			  	    warehouse.setWarehouse_id(rs.getInt("warehouse_id"));
		
			   		drug_warehouse.setDrug(drug);
			   		drug_warehouse.setWarehouse(warehouse);
			   		drug_warehouse.setQuantity(rs.getInt("quantity"));
				
			  	    return drug_warehouse;
			  	  
			   	   }
			   	}
			
			 
			 
			// QUERY for drugs whose quantity is beyond the upper bound or below the lower bound
			 public List<Drug_warehouse> getOutofBoundDrugs(){
				 String sql = "SELECT drug.drug_id AS drug_id, min(generic_name) AS generic_name, sum(quantity) AS total_quantity, min(lowerbound) AS lowerbound, min(upperbound) AS upperbound " 
						 + "FROM drug, drug_warehouse "
						 + "WHERE drug.drug_id = drug_warehouse.drug_id "
						 + "GROUP BY drug.drug_id "
						 + "HAVING total_quantity < lowerbound OR total_quantity > upperbound ";
				  try{
					  
					  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
					  List<Drug_warehouse> drug_warehouseList = jdbcTemplate.query(sql, new Object[]{}, new Drug_warehouse_OutofBoundMapper());
					  return drug_warehouseList;
					  
				  }catch (IndexOutOfBoundsException e) {
						return null;
					}
				  catch(NullPointerException e){
					  return null;
				  }
			}
			 public class Drug_warehouse_OutofBoundMapper implements RowMapper<Drug_warehouse> {
			   	   public Drug_warehouse mapRow(ResultSet rs, int rowNum) throws SQLException {
			   		Drug_warehouse drug_warehouse = new Drug_warehouse();
			  	    Drug drug = new Drug();
			  	    
			  	    
			  	    drug.setDrug_id(rs.getInt("drug_id"));
			  	    drug.setGeneric_name(rs.getString("generic_name"));
			  	    drug.setLowerbound(rs.getInt("lowerbound"));
			  	    drug.setUpperbound(rs.getInt("upperbound"));
			  	    
			   		drug_warehouse.setDrug(drug);
			   		drug_warehouse.setWarehouse(null);
			   		drug_warehouse.setQuantity(rs.getInt("total_quantity"));
				
			  	    return drug_warehouse;
			  	  
			   	   }
			   	}
			
	 
	
}
