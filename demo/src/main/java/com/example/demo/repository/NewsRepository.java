package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.News;

public interface NewsRepository extends JpaRepository<News, Integer> {
//	public Page<News> findAll(Pageable pageable);
	public News findById(int id);
////
//	@Query(value = "select * from News n where upper(n.VIETNAMESE_TITLE) like upper(?1) or upper(n.ENGLISH_TITLE) like upper(?1)", nativeQuery = true)
//	public Page<News> findAllByTitleIgnoreCase(String title, Pageable pageable);

//	@Procedure(name="News.getAllNews")
//	public List<News> getAllNews_Proc();
//	
//	@Procedure(name="News.countTitle")
//	public Integer countByTitle_Proc(@Param("title") String title);
	
	
	
}
