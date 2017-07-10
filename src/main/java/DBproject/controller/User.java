package DBproject.controller;

public class User {
	private String user_name;
	private String role_id;
	private String password;
	private String role_name;
	
	   public void setUser_name(String user_name) {
	      this.user_name = user_name;
	   }
	   public String getUser_name() {
	      return user_name;
	   }
	   
	   public void setRole_id(String role_id) {
		   this.role_id = role_id;
		}
	   public String getRole_id() {
		   return role_id;
	    }

	   public void setPassword(String password) {
	      this.password = password;
	   }
	  
	   public String getPassword() {
		   return password;
	   }
	   public void setRole_name(String role_name) {
		   this.role_name = role_name;
		}
		   public String getRole_name() {
		      return role_name;
		   }
	  
}
