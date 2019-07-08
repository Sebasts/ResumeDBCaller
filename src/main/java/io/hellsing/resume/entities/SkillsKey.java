package io.hellsing.resume.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class SkillsKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public SkillsKey() {
		super();
	}
	
	@Column(nullable = false, name="id")
	private int id;
	
	@GeneratedValue
	@Column(nullable = true, name="skill_id")
	private int skill_Id;

	
	
	public SkillsKey(int id, int skill_Id) {
		super();
		this.id = id;
		this.skill_Id = skill_Id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + skill_Id;
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
		SkillsKey other = (SkillsKey) obj;
		if (id != other.id)
			return false;
		if (skill_Id != other.skill_Id)
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSkill_Id() {
		return skill_Id;
	}
	public void setSkill_Id(int skill_Id) {
		this.skill_Id = skill_Id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}