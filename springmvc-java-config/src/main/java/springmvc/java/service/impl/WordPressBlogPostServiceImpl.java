package springmvc.java.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;

public class WordPressBlogPostServiceImpl implements BlogPostService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WordPressBlogPostServiceImpl.class);
	
	@Override
	public void savePost(BlogPost blogpost) {
		LOGGER.debug("WordPressBlogPostServiceImpl: savePost is called");
	}

	@Override
	public void saveAsDraft(BlogPost blogpost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBlogPost(BlogPost blogpost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BlogPost> listAllBlogPostByUserAndDraftStatus(User user, boolean draft) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogPost> listAllBlogPostByUserAndTitleLike(User user, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogPost findBlogPostById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
