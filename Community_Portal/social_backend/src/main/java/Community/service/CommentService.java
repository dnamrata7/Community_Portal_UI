package Community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Community.model.Comment;
import Community.model.Post;
import Community.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	//Get all comments for a post operation
	public List<Comment> findByParentId(String parentId) {
	
		List<Comment> comments1= commentRepository.findByParentId(parentId);
		
		for(Comment c : comments1) {
			System.out.println(c.toString());
			
			
		}
		
		return comments1;
	}

	//Get comment by id operation
	public Comment findCommentByid(String id) {
		return commentRepository.findCommentByid(id);
	}
	
	//Delete a comment by id operation
	public Comment deleteComment(String id) {
		Comment deletedComment = findCommentByid(id);
		deletedComment.setDeleted(true);
		return commentRepository.save(deletedComment);
	}
	
	//Update comment details operation
	public Comment updateComment(String id, Comment comment) {
		
		Comment orig_comment = findCommentByid(id);

		orig_comment.setBody(comment.getBody());
		
		return commentRepository.save(orig_comment);
	}

	public Comment create(Comment comment) {
		

		return commentRepository.save(comment);
		
	}

	public Comment updateCommentVoteCount(String id, String option) {
		Comment comment = findCommentByid(id);		
		System.out.println(option);
		System.out.println(comment.toString());	
		Integer vote = comment.getVoteScore();
		if(null==vote)
			vote=0;
		
		switch(option) {
        case "upVote":
        	comment.setVoteScore(++vote);
            break;
        case "downVote":
        	comment.setVoteScore(--vote);
            break;
        default:
            System.out.println("posts.vote received incorrect parameter: ${option}");
    }
		
		return (commentRepository.save(comment));
	}
	
}
