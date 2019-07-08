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
@Table(name = "bullet_points")
//@IdClass(BulletPointsKey.class)
public class BulletPoint implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1075328734982711280L;

	@EmbeddedId
    private BulletPointsKey key;
	
//	@Id
//	@Column(nullable = false)
//	private int id;
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(nullable = false, name="bullet_point_id")
//	private int bulletPointId;

	@Column(name = "content")
	private String content;

	@Transient
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id")
	private Organization organization;

	public BulletPoint() {
		super();
	}

	public BulletPoint(String content) {
		super();
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

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	
//	public int getBulletPointId() {
//		return bulletPointId;
//	}
//
//	public void setBulletPointId(int bulletPointId) {
//		this.bulletPointId = bulletPointId;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BulletPoint [id=" + ", content=" + content + ", organization=" + organization + "]";
	}

	public BulletPointsKey getKey() {
		return key;
	}

	public void setKey(BulletPointsKey key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
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
		BulletPoint other = (BulletPoint) obj;
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
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		return true;
	}
	
	
}

