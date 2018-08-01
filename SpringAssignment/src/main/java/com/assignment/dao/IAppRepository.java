package com.assignment.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assignment.model.Book;
import com.assignment.model.Subject;


@Repository
public interface IAppRepository extends JpaRepository<Subject,Long>{

	@Query("select b from Subject u join u.references b where b.bookId=?1")
	 Book findBookByReferencesBookId(Long bookId);
	
	@Transactional
	@Modifying
	@Query(value="delete from assign_books1 where book_Id=?1",nativeQuery = true)
	 void DeleteBookByBookId(Long bookId);
	
}
