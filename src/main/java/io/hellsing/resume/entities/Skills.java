package io.hellsing.resume.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
//@IdClass(SkillsKey.class)
@Table(name = "skills")
public class Skills  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4618681482979670663L;

//	@Id
//	@Column(nullable = false, name="id")
//	private int id;
//	
//	@Id
//	@GeneratedValue
//	@Column(nullable = false, name="skill_id")
//	private int skill_Id;
	
	@EmbeddedId
    private SkillsKey key;
	
	@Column(name = "content")
	private String content;

	@Transient
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id")
	private Resume resume;

	public Skills() {
		super();
	}

	public Skills(String content) {
		this.content = content;

	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

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
//	public int getSkill_Id() {
//		return skill_Id;
//	}
//
//	public void setSkill_Id(int skill_Id) {
//		this.skill_Id = skill_Id;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SkillsKey getKey() {
		return key;
	}

	public void setKey(SkillsKey key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((resume == null) ? 0 : resume.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skills other = (Skills) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (resume == null) {
			if (other.resume != null)
				return false;
		} else if (!resume.equals(other.resume))
			return false;
		return true;
	}
	
	
	
}
