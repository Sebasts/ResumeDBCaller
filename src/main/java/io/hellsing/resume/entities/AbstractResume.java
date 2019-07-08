package io.hellsing.resume.entities;

import java.util.List;

public abstract class AbstractResume {
	private int id;

	private String owner;

	private boolean isDefault;

	private Intro intro;

	private Address address;

	private Organization organization;
	
	private List<Skills> skills;
	
	
}
