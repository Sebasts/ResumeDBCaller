package io.hellsing.resume.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import io.hellsing.resume.entities.Address;
import io.hellsing.resume.entities.BulletPoint;
import io.hellsing.resume.entities.BulletPointsKey;
import io.hellsing.resume.entities.Education;
import io.hellsing.resume.entities.Intro;
import io.hellsing.resume.entities.Organization;
import io.hellsing.resume.entities.Resume;
import io.hellsing.resume.entities.Skills;
import io.hellsing.resume.entities.SkillsKey;

@Transactional
public class Apps {

	public static void main(String[] args) {
		System.out.println("Hello World.");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ResumePersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		Resume newResume = new Resume();
		newResume.setOwner("me test 2");

		System.out.println(newResume);

		entityManager.persist(newResume);

		entityManager.flush();
		System.out.println(newResume);

		newResume.setSkills(new ArrayList<Skills>());
		newResume.getSkills().add(new Skills("Passing Butter"));
		newResume.getSkills().forEach(bp -> {

			if (bp.getKey() != null) {
				bp.getKey().setId(newResume.getId());

			} else {
				bp.setKey(new SkillsKey());
				bp.getKey().setId(newResume.getId());
			}

			 entityManager.persist(bp);

		});


		// entityManager.flush();

		System.out.println(newResume);

		newResume.setOrganization(new Organization());
		newResume.getOrganization().setId(newResume.getId());
		newResume.getOrganization().setName("Hellsing LLC");
		newResume.getOrganization().setFrom(new Date());
		newResume.getOrganization().setTo(new Date());
		entityManager.persist(newResume.getOrganization());

		newResume.getOrganization().setBulletPoints(new ArrayList<BulletPoint>());
		newResume.getOrganization().getBulletPoints().add(new BulletPoint("I passed butter"));

		newResume.getOrganization().getBulletPoints().forEach(bp -> {
			if (bp.getKey() != null) {
				bp.getKey().setId(newResume.getOrganization().getId());
			} else {
				bp.setKey(new BulletPointsKey());
				bp.getKey().setId(newResume.getOrganization().getId());
			}
			 entityManager.persist(bp);

		});
		// entityManager.persist(newResume.getOrganization());

		newResume.setAddress(new Address());
		newResume.getAddress().setAptNumber("315");
		newResume.getAddress().setCity("Denver");
		newResume.getAddress().setId(newResume.getId());
		newResume.getAddress().setState("CO");
		newResume.getAddress().setStreetAddress("13918 e Mississippi ave");
		newResume.getAddress().setZipcode("80012");

		// entityManager.flush();

		newResume.setIntro(new Intro(newResume.getId(), "Hello world o wole"));
		newResume.setEducation(new Education(newResume.getId(), "Stupid university", new Date(), new Date(),
				"Did stuff for grades", null));
		
		newResume.setSkills(null);
		newResume.getOrganization().setBulletPoints(null);
		entityManager.persist(newResume);

		 entityManager.flush();

		entityManager.getTransaction().commit();

		entityManager.close();

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		List<Resume> cats = em.createQuery("SELECT resume from Resume resume", Resume.class).getResultList();

		System.out.println(cats);

		em.close();

		EntityManager em2 = factory.createEntityManager();

		em2.getTransaction().begin();
		Resume cat = em2.find(Resume.class, newResume.getId());

		em2.close();

		EntityManager em3 = factory.createEntityManager();

		em3.getTransaction().begin();

		// em3.createQuery(
		// "DELETE from Resume resume WHERE id=" + cat.getId()).executeUpdate();
		// em2.remove(cat);

		em3.getTransaction().commit();

		cats = em3.createQuery("SELECT resume from Resume resume", Resume.class).getResultList();

		System.out.println(cats);

		factory.close();
	}

}
