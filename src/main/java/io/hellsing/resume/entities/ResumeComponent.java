package io.hellsing.resume.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ResumeComponent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "resume_id")
	private int resumeId;

	@Column(name = "content")
	private String content;
}
