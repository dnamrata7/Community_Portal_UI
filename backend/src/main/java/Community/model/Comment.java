package Community.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")

public class Comment {

	String id;
	String parentId;
	Date timestamp;
	String body;
	String author;
	String category;
	Integer voteScore;
	Boolean deleted;
	Boolean parentDeleted;
	
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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
	public Integer getVoteScore() {
		return voteScore;
	}
	public void setVoteScore(Integer voteScore) {
		this.voteScore = voteScore;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public Boolean getParentDeleted() {
		return parentDeleted;
	}
	public void setParentDeleted(Boolean parentDeleted) {
		this.parentDeleted = parentDeleted;
	}
	
	public Comment(String id, String parentId, Date timestamp, String body, String author, String category, Integer voteScore, Boolean deleted, Boolean parentDeleted) {
		this.id=id;
		this.parentId = parentId;
		this.timestamp = timestamp;
		this.body = body;
		this.author = author;
		this.category = category;
		this.voteScore = voteScore;
		this.deleted = deleted;
		this.parentDeleted = parentDeleted;
	}
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", timestamp=" + timestamp + ", body=" + body + ", author="
				+ author + ", category=" + category + ", voteScore=" + voteScore + ", deleted=" + deleted
				+ ", parentDeleted=" + parentDeleted + "]";
	}
	
	
}
