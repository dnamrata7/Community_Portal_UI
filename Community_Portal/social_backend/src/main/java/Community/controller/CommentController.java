package Community.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Community.model.Comment;
import Community.model.Option;
import Community.service.CommentService;

@RestController
public class CommentController {
	public static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	@Autowired
	public CommentService commentService;
	
	@RequestMapping(path="/api/posts/{parentId}/comments")
	public List<Comment> findByParentId(@PathVariable String parentId) {
		System.out.println("Parent Id  "+ parentId);
		return commentService.findByParentId(parentId);
	}
	
	@RequestMapping(path = "/api/comments/{id}")
	public Comment findPostByid(@PathVariable String id){
		return commentService.findCommentByid(id);
	}
	
	@DeleteMapping("/api/comments/{id}")
	public Comment deleteComment(@PathVariable String id) {
		return commentService.deleteComment(id);
	}

	@RequestMapping(value = "/api/comments/{id}", method = RequestMethod.PUT)
	public @ResponseBody Comment updateComment(@PathVariable String id, @RequestBody Comment comment){
		return commentService.updateComment(id, comment);
	
	}
	
	@PostMapping(path = "/api/comments")
	public Comment create(@RequestBody Comment comment) {

		Comment c = commentService.create(comment);
		
		logger.info("Creating Comment : {}"+ comment.toString());
		System.out.println("ID is " + c.getid());

		return c;
	}
	
	@PostMapping(path = "/api/comments/{id}")
	public Comment updatePostVoteCount(@PathVariable String id,@RequestBody Option option) {

		System.out.println(option);
	
		logger.info("Updating Post Count:");
		
		Comment comment = commentService.updateCommentVoteCount(id, option.getOption());
		return comment;
	}
	
}
