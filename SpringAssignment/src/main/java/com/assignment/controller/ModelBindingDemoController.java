package com.assignment.controller;

import java.time.LocalDate;
import java.util.HashSet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.assignment.dao.SpringDataDaoImpl;
import com.assignment.model.Book;
import com.assignment.model.Subject;

@Controller
public class ModelBindingDemoController {

	@Autowired
	private AppController bookAppController;
	
	
	@GetMapping("/addBook")
	public ModelAndView gotoAddBook(){		
		Book b=new Book();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("addBook");
		mv.addObject("customer",b);
		mv.addObject("subjectId"," ");
		return mv;
	}
	
	@PostMapping("/addBook")
	public ModelAndView addBook(@ModelAttribute("customer") Book customer,@RequestParam("subjectId")String subjectId){	
		
		SpringDataDaoImpl.subjectInput=Long.valueOf(subjectId);
		bookAppController.addBook(customer);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("addBook");
		mv.addObject("customer",customer);
		mv.addObject("subjectId",subjectId);
		return mv;

	}
	
	
	@GetMapping("/searchBook")
	public ModelAndView gotosearchBook(){		
		Book b=new Book();
		return new ModelAndView("searchBookForm","customer",b);
	}
	
	
	@PostMapping("/searchBook")
	public ModelAndView searchBook(@ModelAttribute("customer") Book customer){		
		customer=bookAppController.searchBook(String.valueOf(customer.getBookId()));
		if(customer==null){
			customer=new Book();
		}
		return new ModelAndView("searchBookForm","customer",customer);
	}
	
	@GetMapping("/deleteBook")
	public ModelAndView gotoDeleteBook(){		
		Book b=new Book();
		return new ModelAndView("deleteBookForm","customer",b);
	}
	
	
	@PostMapping("/deleteBook")
	public ModelAndView deleteBook(@ModelAttribute("customer") Book customer){		
		bookAppController.deleteBook(String.valueOf(customer.getBookId()));
		return new ModelAndView("deleteBookForm","customer",customer);
	}
	
	
	@GetMapping("/addSubject")
	public ModelAndView gotoAddSubject(){		
		return new ModelAndView("addSubject","customer",new Subject());
	}
	

	@PostMapping("/addSubject")
	public ModelAndView addSubject(@ModelAttribute("customer") Subject customer){
		customer.setReferences(new HashSet<Book>());
		bookAppController.addSubject(customer);		
		return new ModelAndView("addSubject","customer",customer);
	}
	
	
	@GetMapping("/searchSubject")
	public ModelAndView gotoSearchSubject(){		
		return new ModelAndView("searchSubjectForm","customer",new Subject());
	}
	

	@PostMapping("/searchSubject")
	public ModelAndView searchSubject(@ModelAttribute("customer") Subject customer){
		
		customer=bookAppController.searchSubject(String.valueOf(customer.getSubjectId()));
		if(customer==null){
			customer=new Subject();
		}
		return new ModelAndView("searchSubjectForm","customer",customer);
	}
	
	
	@GetMapping("/deleteSubject")
	public ModelAndView gotoDeleteSubject(){		
		return new ModelAndView("deleteSubjectForm","customer",new Subject());
	}
	

	@PostMapping("/deleteSubject")
	public ModelAndView deleteSubject(@ModelAttribute("customer") Subject customer){
		
		bookAppController.deleteSubject(String.valueOf(customer.getSubjectId()));
		return new ModelAndView("deleteSubjectForm","customer",customer);
	}

	@GetMapping("/close")
	public String close(){
		bookAppController.close();
		return "close"; 
	}
	
	
}
