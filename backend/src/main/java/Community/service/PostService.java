package Community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Community.model.Post;
import Community.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	//Create operation
			public Post create(Post post) {
				return postRepository.save(post);
			}
			//Retrieve operation
			public List<Post> getAll(){
				return postRepository.findAll();
			}
			//Find by category operation
			public List<Post> findByCategory(String category) {
				return postRepository.findByCategory(category);
			}
			//Delete operation
			public void deleteAll() {
				postRepository.deleteAll();
			}
			//Sort by date operation
			public List<Post> sortByDate() {
				return postRepository.findAll(Sort.by(Sort.Direction.ASC, "timestamp"));
			}
			//Find post by ID operation
			public Post findPostByid(String id) {
				return postRepository.findPostByid(id);
			}
			
			//Update post vote count operation
			public Post updatePostVoteCount(String id, String option) {
				Post post = findPostByid(id);
				
				System.out.println(option);
				System.out.println(post.toString());
				
				
				Integer vote = post.getVoteScore();
				if(null==vote)
					vote=0;
				
				switch(option) {
		        case "upVote":
		        	post.setVoteScore(++vote);
		            break;
		        case "downVote":
		        	post.setVoteScore(--vote);
		            break;
		        default:
		            System.out.println("posts.vote received incorrect parameter: ${option}");
		    }
				
				return (postRepository.save(post));
			}
			
			public Post updatePost(String id, Post post) {
				
				Post orig_post = findPostByid(id);
				orig_post.setTitle(post.getTitle());
				orig_post.setBody(post.getBody());
				
				return postRepository.save(orig_post);
			}
}
