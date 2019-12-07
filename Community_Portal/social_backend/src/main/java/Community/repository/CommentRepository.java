package Community.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Community.model.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

	public List<Comment> findByParentId(String parentId);
	public Comment findCommentByid(String id);
	
}
