package Community.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Community.model.Option;
import Community.model.Post;
import Community.service.PostService;

@RestController
public class PostController {
	public static final Logger logger = LoggerFactory.getLogger(PostController.class);

	@Autowired
	private PostService postService;

	@PostMapping(path = "/api/posts")
	public String create(@RequestBody Post post) {

		Post p = postService.create(post);
		logger.info("Creating Post : {}");
		System.out.println("ID is " + p.id);

		return p.id;
	}

	@RequestMapping(path = "/api/posts")
	public List<Post> getAll() {
		return postService.getAll();
	}
	
	@RequestMapping(path = "/api/{category}/posts")
	public List<Post> findByCategory(@PathVariable String category) {
		return postService.findByCategory(category);
	}
	
	@RequestMapping(path = "/posts/sortByDate")
	public List<Post> sortByDate() {
		return postService.sortByDate();
	}
	
	@RequestMapping(path = "/api/posts/{id}")
	public Post findPostByid(@PathVariable String id){
		return postService.findPostByid(id);
	}
	
	@PostMapping(path = "/api/posts/{id}")
	public Post updatePostVoteCount(@PathVariable String id,@RequestBody Option option) {

		System.out.println(option);
		//String result = postService.updatePostVoteCount(_id, option);
		logger.info("Updating Post Count:");
		//System.out.println("Result is = " + postService.updatePostVoteCount(_id, option) );
		Post post = postService.updatePostVoteCount(id, option.getOption());
		return post;
	}
	
	@RequestMapping(value = "/api/posts/{id}", method = RequestMethod.PUT)
	public @ResponseBody Post updatePost(@PathVariable String id, @RequestBody Post post){
		
		return postService.updatePost(id, post);
	
	}
	
	
}