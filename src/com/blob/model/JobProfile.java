package com.blob.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;

@Entity
public class JobProfile implements Serializable{

	private static final long serialVersionUID = 5361430959849645178L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=20)
	private String name;
	@Lob
	private byte[] photo;
	@Lob
	private char[] resume;
	
	@Type(type="yes_no")
	private boolean isActive;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public char[] getResume() {
		return resume;
	}
	public void setResume(char[] resume) {
		this.resume = resume;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "JobProfile [id=" + id + ", name=" + name + ", isActive=" + isActive + "]";
	}
}
