package com.jcg.examples.viewBean;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="community")
public class Community implements Serializable{
	
	@Id
	@GeneratedValue
    @Column(name = "community_id")
	private int community_id;
	
	public Community(){
		
	}
	
	private String community_name;
	
	private String creator;
	
	private String grade_level;
	
	private String school_name;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String school_phone;
	
	private String email;
	
	
	
	public int getCommunity_id(){
		return community_id;
		
	}
	public String getCommunity_name(){
		return community_name;
	}
	public String getCreator(){
		return creator;
	}
	public String getGrade_level(){
		return grade_level;
	}
	public String getSchool_name(){
		return school_name;
	}
	public String getStreet(){
		return street;
	}
	public String getCity(){
		return city;
	}
	public String getState(){
		return state;
	}
	public String getCountry(){
		return country;
	}
	
	public String getSchool_phone(){
		return school_phone;
	}
	public String getEmail(){
		return email;
	}
	public void setCommunity_id(int community_id){
		this.community_id=community_id;
		
	}
	public void setCommunity_name(String community_name){
		this.community_name=community_name;
	}
	public void setCreator(String creator){
		this.creator=creator;
	}
	public void setGrade_level(String grade_level){
		this.grade_level=grade_level;
	}
	public void setSchool_name(String school_name){
		this.school_name=school_name;
	}
	public void setStreet(String street){
		this.street=street;
	}
	public void setCity(String city){
		this.city=city;
	}
	
	public void setState(String state){
		this.state=state;
	}
	public void setCountry(String country){
		this.country=country;
	}
	
	public void setSchool_phone(String school_phone){
		this.school_phone=school_phone;
	}
	public void setEmail(String email){
		this.email=email;
	}

}
