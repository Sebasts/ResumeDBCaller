package io.hellsing.resume.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



@Entity
@Table(name = "resume")
//@NamedQueries({ @NamedQuery(name = "getAllResumes", query = "SELECT entity FROM Resume") })
public class Resume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "owner")
	private String owner;


	@Column(name = "isDefault")
	private boolean isDefault;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval=true)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Intro intro;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval=true)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Education education;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval=true)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval=true)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Organization organization;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval=true)
	@JoinColumn(name = "id", referencedColumnName = "id")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Skills> skills;
	
	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Intro getIntro() {
		return intro;
	}

	public void setIntro(Intro intro) {
		this.intro = intro;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	 
	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	
	
	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}
	
	

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	@Override
	public String toString() {
		return "Resume [id=" + id + ", owner=" + owner + ", isDefault=" + isDefault + ", intro=" + intro
				+ ", education=" + education + ", address=" + address + ", organization=" + organization + ", skills="
				+ skills + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + id;
		result = prime * result + ((intro == null) ? 0 : intro.hashCode());
		result = prime * result + (isDefault ? 1231 : 1237);
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
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
		Resume other = (Resume) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (id != other.id)
			return false;
		if (intro == null) {
			if (other.intro != null)
				return false;
		} else if (!intro.equals(other.intro))
			return false;
		if (isDefault != other.isDefault)
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		return true;
	}

	



}