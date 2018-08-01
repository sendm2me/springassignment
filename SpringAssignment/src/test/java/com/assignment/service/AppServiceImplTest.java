package com.assignment.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.dao.DAOInterface;
import com.assignment.dao.IAppRepository;
import com.assignment.dao.SpringDataDaoImpl;
import com.assignment.model.Book;
import com.assignment.model.Subject;


@RunWith(SpringRunner.class)
public class AppServiceImplTest {

	
	 @TestConfiguration
	    static class AppServiceImplTestContextConfiguration {
	  
	        @Bean
	        public AppServiceImpl appService() {
	            return new AppServiceImpl();
	        }
	    }  
	 
	 @TestConfiguration
	    static class SpringDataDaoImplTestContextConfiguration {
	  
	        @Bean
	        public static SpringDataDaoImpl springDataDao() {
	            return new SpringDataDaoImpl();
	        }
	    } 
	 
	 @Autowired
	    private AppServiceImpl appService;
	 
	 @Autowired
	    private DAOInterface daoInterface;
	 
	 @MockBean	 
		private IAppRepository subjRepo;
	 
	 
	@Test
	public void testAddSubject() {
		Book book=new Book();
		book.setBookId(55);
		book.setPrice(1);
		book.setPublishDate(LocalDate.now());
		book.setTitle("Maths");
		book.setVolume(1);
		Long subjectInput=5l;		
		
		Set<Book> setBook=new HashSet<Book>();
		setBook.add(book);		
		
		Subject subject=new Subject();
		subject.setSubjectId(5);
		subject.setSubtitle("Maths");
		subject.setDurationInHours(11);
		subject.setReferences(setBook);	
		
		SpringDataDaoImplTestContextConfiguration.springDataDao().subjectInput=5l;
				
		Mockito.when(subjRepo.findById(subjectInput)).thenReturn(Optional.of(subject));
		Mockito.when(subjRepo.save(subject)).thenReturn(subject);	
		
		String result=appService.addBook(book);
		assertThat(result).isEqualTo("success");		

	}
	
	
	@Test
	public void testSearchBook() {
		
		Book book=new Book();
		book.setBookId(55);
		book.setPrice(1);
		book.setPublishDate(LocalDate.now());
		book.setTitle("Maths");
		book.setVolume(1);
		
		Mockito.when(subjRepo.findBookByReferencesBookId(Long.valueOf(55))).thenReturn(book);	
		
		Book result=appService.searchBook("55");
		
		assertThat(result.getBookId()).isEqualTo(book.getBookId());
		
		
	}
	
	@Test
	public void testDeleteBook() {
		
		boolean result=appService.deleteBook("55");
		assertThat(result).isEqualTo(true);
	}
	
	@Test
	public void testSearchSubject() {	
		
		Subject subject=new Subject();
		subject.setSubjectId(5);
		subject.setSubtitle("Maths");
		subject.setDurationInHours(11);			
		
		Mockito.when(subjRepo.findById(Long.valueOf("5"))).thenReturn(Optional.of(subject));
		Subject result=appService.searchSubject("5");
		
		assertThat(result.getSubjectId()).isEqualTo(subject.getSubjectId());		
	}
	
	
	@Test
	public void testDeleteSubject() {
		
		boolean result=appService.deleteSubject("5");
		assertThat(result).isEqualTo(true);
	}
	
	

}
