package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FormController {
	@Autowired
	CustomerRepo repo;
	
	/*
	@RequestMapping("/")
	public String details() {
		return "customer";
	}*/
	@RequestMapping("/")
	public String detailss() {
		//repo.save(customers);
		return "customer";
	}
	@RequestMapping("/details")
	public String details(Customers customers) {
		repo.save(customers);
		
		return "viewCustomerDetails";
	}

/*
@GetMapping("customer")
public String show() {
	return "customer";
}

*/
@PostMapping("/getdetails")
public ModelAndView getdetails(@RequestParam int cid){
	
	ModelAndView mv = new ModelAndView("Retrive");
	Customers customers = repo.findById(cid).orElse(null);
	mv.addObject(customers);
	return mv;
}



}

