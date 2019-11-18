package Community.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "post")
public class Post {

	@Id
	public String id;

	Date timestamp;
	public String get_id() {
		return id;
	}

	public void set_id(String _id) {
		this.id = _id;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Integer getVoteScore() {
		return voteScore;
	}

	String title;
	String body;
	String author;
	String category;
	Integer voteScore;
	Boolean deleted;
	Integer commentCount;


	public Post(Date timestamp, String title, String body, String author, String category, Integer voteScore,
			Boolean deleted, Integer commentCount) {
		this.timestamp = timestamp;
		this.title = title;
		this.body = body;
		this.author = author;
		this.category = category;
		this.voteScore = voteScore;
		this.deleted = deleted;
		this.commentCount = commentCount;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer VoteScore() {
		return voteScore;
	}

	public void setVoteScore(Integer voteScore) {
		this.voteScore = voteScore;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
}
