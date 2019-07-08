package io.hellsing.resume.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class BulletPointsKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="id")
	private int id;
	
	@GeneratedValue
	@Column(nullable=true, name="bullet_point_id")
	private int bulletPointId;
	
	
	public BulletPointsKey() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bulletPointId;
		result = prime * result + id;
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
		BulletPointsKey other = (BulletPointsKey) obj;
		if (bulletPointId != other.bulletPointId)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBulletPointId() {
		return bulletPointId;
	}
	public void setBulletPointId(int bulletPointId) {
		this.bulletPointId = bulletPointId;
	}

	
	

}