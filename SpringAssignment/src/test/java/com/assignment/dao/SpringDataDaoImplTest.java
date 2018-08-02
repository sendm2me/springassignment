package com.assignment.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.model.Book;
import com.assignment.model.Subject;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class SpringDataDaoImplTest {

	@Autowired
    private SpringDataDaoImpl springDataDaoImpl;
	
	@Autowired
    private TestEntityManager entityManager;
 
	@MockBean	
    private IAppRepository appRepo;
    
    
    @TestConfiguration
    static class SpringDataDaoImplTestContextConfiguration {
  
        @Bean
        public static SpringDataDaoImpl springDataDao() {
            return new SpringDataDaoImpl();
        }
    } 
    
	@Test
	public void testAddBook() {
		
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
		
		springDataDaoImpl.subjectInput=5l;
		
		Mockito.when(appRepo.findById(subjectInput)).thenReturn(Optional.of(subject));
		Mockito.when(appRepo.save(subject)).thenReturn(subject);		
		
		String result=springDataDaoImpl.addBook(book);
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
		
		Mockito.when(appRepo.findBookByReferencesBookId(Long.valueOf(55))).thenReturn(book);	
		
		Book result=springDataDaoImpl.searchBook("55");
		
		assertThat(result.getBookId()).isEqualTo(book.getBookId());
		
		
	}
	
	@Test
	public void testDeleteBook() {
		
		boolean result=springDataDaoImpl.deleteBook("55");
		assertThat(result).isEqualTo(true);
	}
	
	@Test
	public void testSearchSubject() {	
		
		Subject subject=new Subject();
		subject.setSubjectId(5);
		subject.setSubtitle("Maths");
		subject.setDurationInHours(11);			
		
		Mockito.when(appRepo.findById(Long.valueOf("5"))).thenReturn(Optional.of(subject));
		Subject result=springDataDaoImpl.searchSubject("5");
		
		assertThat(result.getSubjectId()).isEqualTo(subject.getSubjectId());		
	}
	
	
	@Test
	public void testDeleteSubject() {
		
		boolean result=springDataDaoImpl.deleteSubject("5");
		assertThat(result).isEqualTo(true);
	}
	

}
