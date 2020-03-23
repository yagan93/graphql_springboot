package ch.yagan.domainModels.author;

import ch.yagan.core.CoreEntity;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author extends CoreEntity {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "age")
	private Integer age;

	public Author() {
	}

	public Author(String id) {
		super(id);
	}

	public Author(String id, String name, Integer age) {
		super(id);
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public Author setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getAge() {
		return age;
	}

	public Author setAge(Integer age) {
		this.age = age;
		return this;
	}
}
