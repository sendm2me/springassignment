package com.assignment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.assignment.model.Book;
import com.assignment.model.Subject;
import com.assignment.service.AppService;
import com.assignment.service.AppServiceImpl;

@Component
public class AppController {
	@Autowired
	private AppService appService;
	
	public AppController(){
		
	}

	public void addSubject(Subject subj) {
		appService.addSubject(subj);
		System.out.println("Subject added");
		
	}
	
	public void addBook(Book map) {
		appService.addBook(map);
		System.out.println("Book added");
	}
	
	public void close(){
		appService.closeFile();		
	}

	public void deleteBook(String map) {
		
		appService.deleteBook(map);	
		System.out.println("Book deleted");
	}

	public boolean deleteSubject(String deleteSubjectInput) {
		System.out.println("Subject deleted");
		return appService.deleteSubject(deleteSubjectInput);
		
	}

	public Book searchBook(String map) {

		/*if(appService.searchBook(map)!=null){*/
			System.out.println(appService.searchBook(map));
			return appService.searchBook(map);
		/*}else{
			System.out.println("No Book found");
		}*/
		
	}

	
	public Subject searchSubject(String input) {

		/*if(appService.searchSubject(input)!=null){*/
			System.out.println(appService.searchSubject(input));
			return appService.searchSubject(input);
		/*}else{
			System.out.println("No Subject found");
		}*/
		
	}

	public List<Book> sortBookByTitle() {
		return appService.sortBookByTitle();
		
		
	}

	public List<Subject> sortBySubjectTitle() {
		return appService.sortBySubjectTitle();		
	}

	public List<Book> sortBookByPublishDate() {
		
		return appService.sortBookByPublishDate();
	}

}
