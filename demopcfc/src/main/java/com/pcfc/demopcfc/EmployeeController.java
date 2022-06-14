package com.pcfc.demopcfc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pcfc.hibernate.model.Employee;
import com.pcfc.service.EmployeeService;

/**
 * <b>Copyright@</b>
 * Employee Service 
 * Created Date : 2022-06-14
 * @author Nadeem
 * @since 1.0
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
	 
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {

		CustomDateEditor dateEditor = new CustomDateEditor(dateFormat1, true);
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        CustomNumberEditor numberEditor = new CustomNumberEditor(Double.class,false);
        
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
        dataBinder.registerCustomEditor(Date.class,"dob", dateEditor);
        dataBinder.registerCustomEditor(String.class,"salary", numberEditor);
    }
	
	/**
	 * Employee form Page load
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView showForm(Model model,@RequestParam(required = false) Integer id) {
		Employee employee =null;
		if(id!=null) {
			employee = employeeService.getEmployee(id);
		}
		ModelAndView mv = new ModelAndView("user.addEmployee", "employee",employee!=null?employee: new Employee());
		
		List<Employee> employees = employeeService.getEmployees();
		mv.addObject("employees", employees);
		return mv;
	}
	
	/**
	 * Employee form save method
	 * @param employee
	 * @param bindingResult
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = { "/save","/edit" }, method = RequestMethod.POST)
	public String saveEmployeeDetails(@Valid
	        @ModelAttribute("employee") final Employee employee,
	        final BindingResult bindingResult,
	        final Model model) {
		try {
			String action = employee.getId() >0 ? "Updated":"Saved";
	        if (bindingResult.hasErrors()) {
	        	bindingResult.getAllErrors().forEach((o)->{logger.error(o.getDefaultMessage());});
	        	List<Employee> employees = employeeService.getEmployees();
	        	model.addAttribute("employees",employees);
	            return "user.addEmployee";
	        }
	        logger.info("Employee ID : "+employee.getId());
	        try {employee.setManager(employeeService.getEmployee(Integer.valueOf(employee.getManagerid())));}catch(Exception ex) {}
        	employeeService.saveEmployee(employee);
        	model.addAttribute("smessage","Employee "+action+"  succesfully!");
        	return "redirect:/home";
		}catch(Exception ex) {
			logger.error("Error occured in saveEmployeeDetails() [ERROR] - "+ ex.getMessage());
			ex.printStackTrace();
			return "user.addEmployee";
		}
        
	}
	/**
	 * View Employee Details
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewEmpDetails(Model model,@RequestParam(required = true) Integer id) {
		Employee employee =null;
		if(id!=null) {
			employee = employeeService.getEmployee(id);
		}
		ModelAndView mv = new ModelAndView("user.viewEmployee", "employee",employee!=null?employee: new Employee());
		return mv;
	}
	

}
