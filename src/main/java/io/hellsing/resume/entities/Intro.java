package io.hellsing.resume.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "intro")
public class Intro {
	@Id
	@Column(nullable = false, name="id", unique = true)
	private int id;

	@Column(name = "content")
	private String content;

	@Transient
	@OneToOne(mappedBy = "intro")
	private Resume resume;

	public Intro() {
		super();
	}

	public Intro(String content) {
		this.content = content;
	}

	public Intro(int id, String content) {
		this.id = id;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Intro [id=" + id + ", content=" + content + ", resume=" + resume + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}
}
