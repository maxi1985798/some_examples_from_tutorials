package springmvc.java.controller;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.UserService;

@Controller
public class BlogPostController {
	
	//save a blogpost
	//save a draft blog post
	
	@Autowired
	private BlogPostService blogPostService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource messageSource;
	
	// this method can be used inside a page
	@RequestMapping(value="/saveBlogPost",method = RequestMethod.POST)
	public ModelAndView saveBlogPost(
			@RequestParam(value="title") String title,
			@RequestParam(value="content") String content,
			@RequestParam(value="draft",required = false) boolean draft,
			Locale locale,
			Principal principal
			) {
		BlogPost blogPost = new BlogPost();
		blogPost.setTitle(title);
		blogPost.setContent(content);
		
		blogPost.setUser(userService.findUserWithBlogPostByUsername(principal.getName()));
		
		
		if(draft == true) {
			blogPostService.saveAsDraft(blogPost);
		} else {
			blogPostService.savePost(blogPost);
		}
		
		return new ModelAndView("newblogpost", "message", messageSource.getMessage("blogpost.saved", null, locale));
		
	}
	
	@RequestMapping(value="/blogposts",method = RequestMethod.GET)
	public ModelAndView blogPosts(Principal principal) {
		User user = userService.findUserWithBlogPostByUsername(principal.getName());
		List<BlogPost> blogPosts = user.getBlogPosts();
		return new ModelAndView("blogposts","blogposts",blogPosts);
	}
	
	@RequestMapping(value="/draftBlogPosts",method = RequestMethod.GET)
	public ModelAndView draftBlogPosts(Principal principal) {
		User user = userService.findUserWithBlogPostByUsername(principal.getName());
		List<BlogPost> draftBlogPosts = blogPostService.listAllBlogPostByUserAndDraftStatus(user, true);
		return new ModelAndView("blogposts","blogposts",draftBlogPosts);
	}
	
	@RequestMapping(value="/searchByTitle",method = RequestMethod.POST)
	public ModelAndView searchByTitle(@RequestParam(value="title") String title, Principal principal) {
		User user = userService.findUserWithBlogPostByUsername(principal.getName());
		List<BlogPost> blogPosts = blogPostService.listAllBlogPostByUserAndTitleLike(user, title);
		return new ModelAndView("blogposts","blogposts",blogPosts);
	}
	
	@RequestMapping(value="/getBlogPostById/{id}",method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody BlogPost getBlogPostById(@PathVariable(value="id") long idBlogPost) {
		return blogPostService.findBlogPostById(idBlogPost);
	}
	
}
