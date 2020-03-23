package ch.yagan.domainModels.tutorial;

import ch.yagan.core.CoreEntity;
import ch.yagan.domainModels.author.Author;

import javax.persistence.*;

@Entity
public class Tutorial extends CoreEntity {

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	public Tutorial() {
	}

	public Tutorial(String id) {
		super(id);
	}

	public Tutorial(String id, String title, String description, Author author) {
		super(id);
		this.title = title;
		this.description = description;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
