package com.example.demo.service.news;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.demo.model.News;
import com.example.demo.model.NewsDTO;;

public interface NewsService {
	public Page<News> getNews(Integer pageNumber, Integer pageSize);

//	public Optional<News> getNewsById(int id);
	public News findById(int id);

	public News createNews(NewsDTO news);

	public News updateNews(int id, News news);

	public void deleteNews(int id);

//	public Page<News> getAllByTitleIgnoreCase(String title, Integer pageNumber, Integer pageSize);

//	public List<Object> getAllNewsByTitleAndPaging_Proc(String title, Integer pageNumber, Integer pageSize);
	
//	public List<News> getAllNews_Proc();
	
//	public Integer countByTitle_Proc(String title);
	
}
