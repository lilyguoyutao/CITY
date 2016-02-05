package com.jcg.examples.viewBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project implements Serializable{
	
	@Id
	@GeneratedValue
    @Column(name = "idProject")
	private int id;
	private String projectname;
	
	private String teacher;
	private String school;
	private String fromyear;
	private String toyear;
	private String projectowner;
	private String kf_url;
	private String grade;
	private int idpublish;
	private String data;
	private String timestamp;
	private String bigidea;
	private String lessonslearned;
	private String helpfulactivities;
	private String facilitated;
	private String attachment_path;
	private String attachment_title;
	private int encrypt;
	private String deleted;
	private String communityname;

	
	public Project(){
		
	}
	public int getId(){
		return id;
		
	}
	public String getProjectname(){
		return projectname;
		
	}
	
	public String getTeacher(){
		return teacher;
		
	}
	public String getSchool(){
		return school;
	}
	public String getFromyear(){
		return fromyear;
	}
	public String getToyear(){
		return toyear;
	}
	public String getProjectowner(){
		return projectowner;
	}
	public String getKf_url(){
		return kf_url;
	}
	public String getGrade(){
		return grade;
	}
	public int getIdpublish(){
		return idpublish;
	}
	public String getData(){
		return data;
	}
	public String getTimestamp(){
		return timestamp;
	}
	public String getBigidea(){
		return bigidea;
	}
	public String getlessonslearned(){
		return lessonslearned;
	}
	public String getHelpfulactivities(){
		return helpfulactivities;	
	}
	public String getFacilitated(){
		return facilitated;
	}
	
	public String getAttachment_path(){
		return attachment_path;
	}
	public String getAttachment_title(){
		return attachment_title;
	}
	public int getEncrypt(){
		return encrypt;
	}
	public String getDeleted(){
		return deleted;
	}
	
	public String getCommunityname(){
		return communityname;
		
	}
	public void setId(int id){
		this.id=id;
		
	}
	public void setTeacher(String teacher){
		this.teacher=teacher;
		
	}
	public void setSchool(String school){
		this.school=school;
	}
	public void setFromyear(String fromyear){
		this.fromyear=fromyear;
	}
	public void setToyear(String toyear){
		this.toyear=toyear;
	}
	public void setProjectowner(String projectowner){
		this.projectowner=projectowner;
	}
	public void setKf_url(String kf_url){
		this.kf_url=kf_url;
	}
	public void setGrade(String grade){
		this.grade=grade;
	}
	public void setIdpublish(int idpublish){
		this.idpublish=idpublish;
	}
	public void setData(String data){
		this.data=data;
	}
	public void setTimestamp(String timestamp){
		this.timestamp=timestamp;
	}
	public void setBigidea(String bigidea){
		this.bigidea=bigidea;
	}
	public void setlessonslearned(String lessonslearned){
		this.lessonslearned=lessonslearned;
	}
	public void setHelpfulactivities(String helpfulactivities){
		this.helpfulactivities=helpfulactivities;	
	}
	public void setFacilitated(String facilitated){
		this.facilitated=facilitated;
	}
	
	public void setAttachment_path(String attachment_path){
		this.attachment_path= attachment_path;
	}
	public void setAttachment_title(String attachment_title){
		this.attachment_title= attachment_title;
	}
	public void setEncrypt(int encrypt){
		this.encrypt= encrypt;
	}
	public void setDeleted(String deleted){
		this.deleted= deleted;
	}
	
	
	
	public void setCommunityname(String communityname){
		this.communityname=communityname;
	}
	public void setProjectname(String projectname){
		this.projectname=projectname;
	}

}
