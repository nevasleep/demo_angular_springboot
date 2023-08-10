package com.example.demo.service.news;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.News;
import com.example.demo.model.NewsDTO;
import com.example.demo.repository.CatogoryRepository;
import com.example.demo.repository.NewsRepository;

@Service
public class NewsServiceImp implements NewsService {

	@Autowired
	NewsRepository newsRepository;
	@Autowired
	CatogoryRepository catogoryRepository;

	@Override
	public Page<News> getNews(Integer pageNumber, Integer pageSize) {
		PageRequest pageable = PageRequest.of(pageNumber, pageSize);
		return newsRepository.findAll(pageable);
	}

	@Override
	public News findById(int id) {
		News news = newsRepository.findById(id);
		return news;
	}

	@Override
	public News updateNews(int id, News news) {
//		Optional<News> onews = getNewsById(id);
//		if (!onews.isPresent())
//			return null;
//		News updateNews = onews.get();
		News updateNews = newsRepository.findById(id);
		if (updateNews == null)
			return null;
		updateNews.setVietnameseTitle(news.getVietnameseTitle());
		updateNews.setEnglishTitle(news.getEnglishTitle());
		updateNews.setContent(news.getContent());
		updateNews.setImageUrl(news.getImageUrl());
		return newsRepository.save(updateNews);
	}

	@Override
	public void deleteNews(int id) {
		News news = findById(id);
		if (news != null)
			newsRepository.delete(news);
	}

	@Override
	public News createNews(NewsDTO newsDTO) {
		News news= new News();
		news.setContent(newsDTO.getContent());
		news.setEnglishTitle(newsDTO.getEnglishTitle());
		news.setVietnameseTitle(newsDTO.getVietnameseTitle());
		news.setImageUrl(newsDTO.getImageUrl());
		Category c= catogoryRepository.findById(newsDTO.getCateID()).get();
		news.setCategory(c);
		return newsRepository.save(news);
	}

//	@Override
//	public Page<News> getAllByTitleIgnoreCase(String title, Integer pageNumber, Integer pageSize) {
//		return newsRepository.findAllByTitleIgnoreCase("%" + title + "%", PageRequest.of(pageNumber, pageSize));
//
//	}

//	@Override
//	public Integer countByTitle_Proc(String title) {
//		return newsRepository.countByTitle_Proc(title);
//	}

//	@Override
//	public List<News> getAllNews_Proc() {
//		List<News> lst = new ArrayList<News>();
//		try {
//
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			String url = "jdbc:oracle:thin:@//192.168.10.23:1521/pdb_bidv";
//			String username = "ftv_training";
//			String password = "ftv_training";
//		
//			Connection con = DriverManager.getConnection(url, username, password);
//			System.out.println("Connected to database");
//
//			String command = "{call GET_ALL_NEWS(?)}";
//			CallableStatement cstmt = con.prepareCall(command);
//			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
//			cstmt.execute();
//			ResultSet rs = (ResultSet) cstmt.getObject(1);
//			while (rs.next()) {
//				String vt = rs.getString(1);
//				String et = rs.getString(2);
//				String ct = rs.getString(3);
//				String im = rs.getString(4);
//				News n = new News(vt, et, ct, im);
//				lst.add(n);
//			}
//			cstmt.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return lst;

//		return newsRepository.getAllNews_Proc();

//	}



//	@Override
//	public List<Object> getAllNewsByTitleAndPaging_Proc(String title, Integer pageNumber, Integer pageSize) {
//		System.out.println("1");
//		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("GET_ALL_NEWS_BY_TITLE_AND_PAGING")
//				.registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
//				.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN)
//				.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN)
//				.registerStoredProcedureParameter(4, Class.class, ParameterMode.REF_CURSOR).setParameter(1, title)
//				.setParameter(2, pageNumber).setParameter(3, pageSize);
////		query.execute();
//		System.out.println("2");
//		List<Object> allNews = query.getResultList();
//
//		System.out.println("3");
////		System.out.println(query.getResultList().get(0).toString());
////		System.out.println(allNews.get(0).toString());
//		System.out.println("4");
//		return allNews;
//	}

}
