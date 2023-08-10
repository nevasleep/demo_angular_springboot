package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.model.News;
import com.example.demo.model.NewsDTO;
import com.example.demo.repository.CatogoryRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.news.NewsService;
import com.example.demo.service.news.NewsServiceImp;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/apinews")
public class NewsController {
	@Autowired
	NewsService newsServiceImp;
	
	@Autowired
	CatogoryRepository catogoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/news/getNews")
	public List<News> getNews(@RequestParam(defaultValue = "0") Integer pageNumber,
			@RequestParam(defaultValue = "100") Integer pageSize) {
		Page<News> newsPage = newsServiceImp.getNews(pageNumber, pageSize);
		return newsPage.getContent();
	}
	
	@GetMapping("/categories")
	@ResponseBody
	public List<Category> getAllCate(){
		List<Category> list=catogoryRepository.findAll();

		return list;
	}
	@GetMapping("/news/findById/{id}")
	public News findById(@PathVariable int id) {
		return newsServiceImp.findById(id);
	}

	@PostMapping("/news/createNews")
	public News createNews(@RequestBody NewsDTO news) {
		return newsServiceImp.createNews(news);
	}

	@PutMapping("/news/updateNews/{id}")
	public News updateNews(@PathVariable int id, @RequestBody News news) {
		return newsServiceImp.updateNews(id, news);
	}

	@DeleteMapping("/news/deleteNews/{id}")
	public void deleteNews(@PathVariable int id) {
		newsServiceImp.deleteNews(id);
	}

//	@GetMapping("/news/getAllNewsByTitleIgnoreCase")
//	public Page<News> getNewsByTitleIgnoreCase(@RequestParam(defaultValue = "") String title,
//			@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize) {
//		return newsServiceImp.getAllByTitleIgnoreCase(title, pageNumber, pageSize);
//	}
	


//	@GetMapping("/news/getAllNews_Proc")
//	@Transactional
//	public List<News> getAllNews_Pro() {
////		List<News> lst = 
//
//		return newsServiceImp.getAllNews_Proc();
//	}

//	@GetMapping("/news/countByTitle_Proc")
//	public Integer countByTitle_Proc(@RequestParam(defaultValue = "") String title) {
//
//		return newsServiceImp.countByTitle_Proc(title);
//	}
//	
//	@GetMapping("/news/getAllNews")
//	public ResponseEntity<Page<News>> getAllNews(@RequestParam(defaultValue = "0") Integer pageNumber,
//			@RequestParam(defaultValue = "10") Integer pageSize) {
//		Page<News> newsPage = newsServiceImp.getAllNews(pageNumber, pageSize);
//		return ResponseEntity.ok(newsPage);
//	}
	
//	@GetMapping("/news/getAllNewsByTitleAndPaging_Proc")
//	public List<Object> getAllNewsByTitleAndPaging_Pro(@RequestParam(defaultValue="") String title, @RequestParam(defaultValue="0") Integer pageNumber,  @RequestParam(defaultValue="10") Integer pageSize){
//		
//		return newsServiceImp.getAllNewsByTitleAndPaging_Proc(title, pageNumber, pageSize);
//	}

}
