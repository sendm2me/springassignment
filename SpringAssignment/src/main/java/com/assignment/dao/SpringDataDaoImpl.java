package com.assignment.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.model.Book;
import com.assignment.model.Subject;

@Component
public class SpringDataDaoImpl implements DAOInterface{

	@Autowired
	private IAppRepository subjRepo;
	public static Long subjectInput;
	
	@Override
	public String addSubject(Subject subj) {
		subjRepo.save(subj);
		return "success";
	}

	@Transactional
	@Override
	public String addBook(Book book) {
		Optional<Subject> opSubject=subjRepo.findById(subjectInput);
		if(opSubject.isPresent()){
			Subject s=opSubject.get();
			HashSet<Book> bookSet=new HashSet<Book>();
			bookSet.add(book);
			s.setReferences(bookSet);
			
			subjRepo.save(s);
			return "success";
		}
		return null;
	}

	@Override
	public void closeFile() {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public boolean deleteBook(String deleteBookInput) {
		subjRepo.DeleteBookByBookId(Long.valueOf(deleteBookInput));
		return true;
	}

	@Transactional
	@Override
	public Book searchBook(String input) {		
		return subjRepo.findBookByReferencesBookId(Long.valueOf(input));
	}

	@Transactional
	@Override
	public boolean deleteSubject(String deleteSubjectInput) {
		subjRepo.deleteById(Long.valueOf(deleteSubjectInput));
		return true;
	}

	@Transactional
	@Override
	public Subject searchSubject(String input) {
		System.out.println("Spring data");
		Optional<Subject> opSubject=subjRepo.findById(Long.valueOf(input));
		return opSubject.isPresent()?opSubject.get():null;
		
	}

	@Override
	public List<Book> sortBookByTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subject> sortBySubjectTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> sortBookByPublishDate() {
		// TODO Auto-generated method stub
		return null;
	}

}
