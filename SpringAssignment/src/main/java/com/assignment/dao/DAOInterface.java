package com.assignment.dao;

import java.util.List;

import com.assignment.model.Book;
import com.assignment.model.Subject;

public interface DAOInterface {
	
	public String addSubject(Subject subj);
	public String addBook(Book  book);
	public void closeFile();
	public boolean deleteBook(String deleteBookInput);
	public Book searchBook(String input);
	public boolean deleteSubject(String deleteSubjectInput);
	public Subject searchSubject(String input);
	public List<Book> sortBookByTitle();
	public List<Subject> sortBySubjectTitle();
	public List<Book> sortBookByPublishDate();
	

}
