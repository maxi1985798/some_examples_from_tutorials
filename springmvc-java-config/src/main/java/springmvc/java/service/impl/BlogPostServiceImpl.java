package springmvc.java.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import springmvc.java.dao.BlogPostDAO;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;

public class BlogPostServiceImpl implements BlogPostService{

	private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);
	
	@Autowired
	private BlogPostDAO blogPostDAO;
	
//  this is changed to blogPostDAO
//	@Autowired
//	private DataSource dataSource;

//  not used anymore	
//	@Autowired
//	private EmailService emailService;
	
	@Override
	public void savePost(BlogPost blogpost) {
		
		LOGGER.debug("BlogPostServiceImpl: savePost is called");
		blogpost.setPublishDate(new Date());
		blogPostDAO.save(blogpost);
		
//		blogPostDAO.findAllBlogPostsByUserAndTitleContaining(user, title);
		
	}

	@Override
	public void saveAsDraft(BlogPost blogpost) {
		blogpost.setDraft(true);
		blogPostDAO.save(blogpost);
		
	}

	@Override
	public void deleteBlogPost(BlogPost blogpost) {
		blogPostDAO.delete(blogpost);
		
	}

	@Override
	public List<BlogPost> listAllBlogPostByUserAndDraftStatus(User user, boolean draft) {
		return blogPostDAO.findAllBlogPostsByUserAndDraft(user, draft);
	}

	@Override
	public List<BlogPost> listAllBlogPostByUserAndTitleLike(User user, String title) {
		return blogPostDAO.findAllBlogPostsByUserAndTitleContaining(user, title);
	}

	@Override
	public BlogPost findBlogPostById(long id) {
		return blogPostDAO.findOne(id);
	}

}
