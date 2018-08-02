package com.assignment.service;


import com.assignment.model.Book;
import com.assignment.model.Subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.dao.DAOInterface;
//import com.assignment.dao.HibernateDaoImpl;

@Service
public class AppServiceImpl implements AppService{

	@Autowired
	private DAOInterface daoInterface;
	public AppServiceImpl(){

	}
	
	
	public String addSubject(Subject subj) {
		return daoInterface.addSubject(subj);		

	}

	public String addBook(Book  book) {
		return daoInterface.addBook(book);		
	
	}
	
	@Override
	public void closeFile() {
		daoInterface.closeFile();
		
	}

	@Override
	public boolean deleteBook(String deleteBookInput) {
		return daoInterface.deleteBook(deleteBookInput);
		
	}


	@Override
	public boolean deleteSubject(String deleteSubjectInput) {
		return daoInterface.deleteSubject(deleteSubjectInput);
		
	}


	@Override
	public Book searchBook(String input) {
		return 	daoInterface.searchBook(input);
		
	}


	@Override
	public Subject searchSubject(String input) {
		return daoInterface.searchSubject(input);
		
	}


	@Override
	public List<Book> sortBookByTitle() {

		return daoInterface.sortBookByTitle();
	}


	@Override
	public List<Subject> sortBySubjectTitle() {
		return daoInterface.sortBySubjectTitle();
	}


	@Override
	public List<Book> sortBookByPublishDate() {
		return daoInterface.sortBookByPublishDate();
	}
	

}
