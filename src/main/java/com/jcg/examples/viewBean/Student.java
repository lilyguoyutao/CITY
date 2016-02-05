package com.jcg.examples.viewBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="user")
public class Student implements Serializable{
	
	@Id
	@GeneratedValue
    @Column(name = "st_id")
	private int st_id;
	
	
	private String username;
	private String password;
	
	private String firstname;
	
	private String secondname;
	private String type;
	private String school;
	private String email;
	//private String community;
	
	public Student(){
	}
	
	public int getSt_id(){
		return st_id;
		
	}
	
	
	public String getUsername(){
		return username;
		
	}
	public String getPassword(){
		return password;
		
	}
	public String getFirstname(){
		return firstname;
	}
	public String getSecondname(){
		return secondname;
	}
	
	public String getType(){
		return type;
	}
	public String getSchool(){
		return school;
	}
	public String getEmail(){
		return email;
	}
	/*public String getCommunity(){
		return community;
	}*/

	
	public void setSt_id(int st_id){
		this.st_id=st_id;
		
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setFirstname(String firstname){
		this.firstname=firstname;
	}
	public void setSecondname(String secondname){
		this.secondname=secondname;
	}
	
	public void setType(String type){
		this.type=type;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public void setSchool(String school){
		this.school=school;
	}
	
	/*public void setCommunity(String community){
		this.community=community;
	}*/
	
}
