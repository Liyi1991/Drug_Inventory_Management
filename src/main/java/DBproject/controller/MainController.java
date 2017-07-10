package DBproject.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;



@Controller
@SessionAttributes("userObj")

public class MainController {
	
	@Autowired
	Dao dao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	//For login behavior
	@RequestMapping(value={"/login"})
	public ModelAndView login() {
		
		return new ModelAndView("loginPage","user-entity", new User());
	}
	
	@RequestMapping(value = { "/process-login" }, method = RequestMethod.POST)
	   public String submit( @ModelAttribute User user, Model model) {
		
		String user_name = user.getUser_name();
		if(user_name == null || user_name =="") return "redirect:/login?error=true";	       
	    
		User user1 = dao.getUser(user_name);
	     
		//System.out.println(user1.getUser_name() + user1.getPassword() + user1.getRole_id());
	    if(user1 == null || !user1.getPassword().equals(user.getPassword())) return "redirect:/login?error=true";
	        
	    model.addAttribute("userObj", user1);
	    String role_id = user1.getRole_id();
	      
	    if (role_id.equals("admin"))
	        	return "redirect:/admin"; 
	      else  
	        	return "redirect:/user";

	}

	//For register behavior 
	@RequestMapping(value={"/register"}, method = RequestMethod.GET)
	public String register(@ModelAttribute User user) {
		
		return "registrationPage";
	}
	
	@RequestMapping("/insert")
	 public String insertData(@ModelAttribute("user") User user) {
		
		if (user != null & user.getUser_name() != "")
	    dao.insertUser(user);
		else return "redirect:/register?error=true";
		
	  return "redirect:/login"; 
	 }	

	//For admin user behavior
	@RequestMapping(value={"/admin"})
	public ModelAndView admin() {
		
		return new ModelAndView("adminPage");
	}
	

	//For common user behavior
	@RequestMapping(value={"/user"})
	public ModelAndView user(Model model) {
		List<Drug_warehouse> expireDrugsList = dao.getExpiredDrugs();
		List<Drug_warehouse> outOfBoundsDrugsList = dao.getOutofBoundDrugs();
		Integer expiredDrugsLength;
		Integer outOfBoundsDrugsLength;
		if (expireDrugsList.isEmpty()) expiredDrugsLength = 0;
		else expiredDrugsLength = expireDrugsList.size();
		if (outOfBoundsDrugsList.isEmpty()) outOfBoundsDrugsLength=0;
		else outOfBoundsDrugsLength = outOfBoundsDrugsList.size();
		
		model.addAttribute("expiredDrugsLength", expiredDrugsLength);
		model.addAttribute("outOfBoundsDrugsLength", outOfBoundsDrugsLength);
		return new ModelAndView("userPage");
	}
	
	
	
	//For query for drug behavior
	@RequestMapping(value={"/queryForDrug"}, method = RequestMethod.GET)
	public ModelAndView clickQueryForDrug() {
		
			
		return new ModelAndView("queryForDrug");
	}

	@RequestMapping(value = { "/queryForDrug" }, method = RequestMethod.POST)
	   public String queryOnDrug(HttpServletRequest request, Model model ) {
	        String generic_name = request.getParameter("generic_name");
	        String manufactuer = request.getParameter("manufacturer");
	        List<Drug> drugList = dao.getDrugList(generic_name, manufactuer);
	        model.addAttribute("drugList", drugList);
	        return "queryForDrug"; 
	}

	//For query for inventory behavior	
	@RequestMapping(value={"/queryForInventory"}, method = RequestMethod.GET)
	public ModelAndView clickQueryForInventory() {
		
		return new ModelAndView("queryForInventory");
	}

	@RequestMapping(value = { "/queryForInventory" }, method = RequestMethod.POST)
	   public String queryOnInventory( HttpServletRequest request, Model model) {
	        String drug_id = request.getParameter("drug_id");
	        String warehouse_id = request.getParameter("warehouse_id");
	        
	        if(drug_id == null || drug_id == "") drug_id ="%%";
	        if(warehouse_id == null || warehouse_id == "" ) warehouse_id = "%%";
	        
	        System.out.println(drug_id + " " + warehouse_id);
	        List<Drug_warehouse> drug_warehouseList = dao.getDrug_warehouseList(drug_id, warehouse_id);
	        model.addAttribute("drug_warehouseList",drug_warehouseList);
	        return "queryForInventory"; 
	}	
	
	//For query for history behavior	
	@RequestMapping(value={"/queryForHistory"}, method = RequestMethod.GET)
	public ModelAndView clickQueryForHistory() {
		
		return new ModelAndView("queryForHistory");
	}

	@RequestMapping(value = { "/queryForHistory" }, method = RequestMethod.POST)
	   public String queryOnHistory(HttpServletRequest request, Model model) throws ParseException {
			 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date start_date = formatter.parse(request.getParameter("start_date"));
		Date end_date = formatter.parse(request.getParameter("end_date"));
		
		List<Checking_history> checking_historyList = dao.getChecking_historyList(start_date, end_date);
		model.addAttribute("checking_historyList",checking_historyList);		
		
	    return "queryForHistory"; 
	}
	
	//For check-in behavior
	@RequestMapping(value={"/checkIn"})
	public ModelAndView checkIn(@ModelAttribute Checking_history checking_history, Model model) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date today = new Date();
	    String Today = df.format(today);
	    model.addAttribute("Today",Today);
		return new ModelAndView("checkInPage");
	}
	
	@RequestMapping(value = { "/process-checkIn" }, method = RequestMethod.POST)
	   public String processCheckIn( @ModelAttribute Checking_history checking_history, Model model) {
		Integer drug_id = checking_history.getDrug_id();
		Integer warehouse_id = checking_history.getWarehouse_id();
		Integer quantity = checking_history.getQuantity();
		
		if ( quantity == null || quantity <=0 || drug_id == null || warehouse_id == null) return "redirect:/checkIn?error=true";
		checking_history.setIf_checked_in(true);
	    
		dao.insertChecking_history(checking_history);
		List<Drug_warehouse> drug_warehouseList = dao.getDrug_warehouseList(drug_id.toString(), warehouse_id.toString());
	    if (drug_warehouseList.isEmpty()) dao.insertDrug_warehouse(drug_id, warehouse_id, quantity);
	    else dao.increaseDrug_warehouse(drug_id, warehouse_id, quantity);
	    
	    Checking_history newestChecking_history = dao.getNewestChecking_history();
	    model.addAttribute("newestChecking_history", newestChecking_history);
	    return "checkInPage"; 
	
	}
	
	 //For check-out behavior
		@RequestMapping(value={"/checkOut"})
		public ModelAndView checkOut(@ModelAttribute Checking_history checking_history, Model model) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    Date today = new Date();
		    String Today = df.format(today);
		    model.addAttribute("Today",Today);
		    
			return new ModelAndView("checkOutPage");
		}
		
		@RequestMapping(value = { "/process-checkOut" }, method = RequestMethod.POST)
		   public String processCheckOut( @ModelAttribute Checking_history checking_history, Model model) {
			Integer drug_id = checking_history.getDrug_id();
			Integer warehouse_id = checking_history.getWarehouse_id();
			Integer quantity = checking_history.getQuantity();
			
			if (quantity == null || quantity <= 0 || drug_id == null || warehouse_id == null) return "redirect:/checkOut?error=true";
			checking_history.setIf_checked_in(false);
		    
			List<Drug_warehouse> drug_warehouseList = dao.getDrug_warehouseList(drug_id.toString(), warehouse_id.toString());
		     
			if (drug_warehouseList.isEmpty()) return "redirect:/checkOut?error=true";	
		    else {
		    	Integer quantity1 = drug_warehouseList.get(0).getQuantity();
		    	if(quantity > quantity1) return "redirect:/checkOut?error=true";
		    	else {
		    		dao.decreaseDrug_warehouse(drug_id, warehouse_id, quantity);
		    		dao.insertChecking_history(checking_history);
		    	}
		    }
			
			Checking_history newestChecking_history = dao.getNewestChecking_history();
		    model.addAttribute("newestChecking_history", newestChecking_history);
		    
		    return "checkOutPage"; 
		
		}
		
		 //For adding new drug behavior
		@RequestMapping(value={"/addNewDrug"})
		public ModelAndView addNewDrug(@ModelAttribute Drug drug, Model model) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    Date today = new Date();
		    String Today = df.format(today);
		    model.addAttribute("Today",Today);

			return new ModelAndView("addNewDrugPage");
		}
		
		@RequestMapping(value = { "/process-addNewDrug" }, method = RequestMethod.POST)
		   public String processAddNewDrug( @ModelAttribute("drug") Drug drug, Model model, BindingResult result) {
			if(result.hasErrors()) {
		        System.out.println("Error ::: " +result.toString());
		    }
			
			dao.insertDrug(drug);
			
			Drug newestDrug = dao.getNewestDrug();
			model.addAttribute("newestDrug", newestDrug);
		    return "addNewDrugPage"; 
		
		}
		
		// For listing expired drugs
		@RequestMapping(value = { "/expiredDrugs" }, method = RequestMethod.GET)
		   public String listExpiredDrugs( Model model) {

			List<Drug_warehouse> drug_warehouseList = dao.getExpiredDrugs();
			model.addAttribute("drug_warehouseList", drug_warehouseList);
		    return "expiredDrugsPage"; 
		
		}
		
		// For listing outOfBounds drugs
				@RequestMapping(value = { "/drugsOutOfBounds" }, method = RequestMethod.GET)
				   public String listOutofBoundsDrugs( Model model) {

					List<Drug_warehouse> drug_warehouseList = dao.getOutofBoundDrugs();
					model.addAttribute("drug_warehouseList", drug_warehouseList);
				    return "drugsOutOfBoundsPage"; 
				
				}
		// For listing warehouse information
		@RequestMapping(value = { "/warehouseInfo" }, method = RequestMethod.GET)
		public String listWarehouseInfo( Model model) {

			List<Warehouse> warehouseList = dao.getWarehouseList();
			model.addAttribute("warehouseList", warehouseList);
		    return "warehouseInfoPage"; 
				
		}
		
		// For altering passwords
		@RequestMapping(value={"/passwordChange"})
		public ModelAndView passwordChange( @ModelAttribute User user, Model model) {
			
			return new ModelAndView("passwordChangePage");
		}
		
		@RequestMapping(value = { "/process-passwordChange" }, method = RequestMethod.POST)
		 public String processPasswordChange( @ModelAttribute User user, Model model) {

			dao.updatePassword(user);
			
		    return "redirect:/passwordChange"; 
		
		}
		
		//For altering roles
		@RequestMapping(value={"/roleChange"})
		public ModelAndView roleChange( @ModelAttribute User user, Model model) {
			
			List<User> userRoleList = dao.getUserRoleList();
			model.addAttribute("userRoleList",userRoleList);
			return new ModelAndView("roleChangePage");
		}
		
		@RequestMapping(value = { "/process-roleChange" }, method = RequestMethod.POST)
		 public String processRoleChange( @ModelAttribute User user, Model model) {

			dao.updateRole(user);
			
		    return "redirect:/roleChange"; 
		
		}
}

