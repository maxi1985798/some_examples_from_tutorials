package springmvc.java.service;

import java.util.List;

import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;

public interface BlogPostService {
	
	void savePost(BlogPost blogpost);
	void saveAsDraft(BlogPost blogpost);
	void deleteBlogPost(BlogPost blogpost);
	List<BlogPost> listAllBlogPostByUserAndDraftStatus(User user, boolean draft);
	List<BlogPost> listAllBlogPostByUserAndTitleLike(User user, String title);
	BlogPost findBlogPostById(long id);
	
}
