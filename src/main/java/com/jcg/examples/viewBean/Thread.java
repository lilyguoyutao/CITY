package com.jcg.examples.viewBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project_thread")
public class Thread implements Serializable{
	@Id
	@GeneratedValue
    @Column(name = "projectid")
	private int projectid;
	
	private String projectname;
	private String threadfocus;
	private String author;
	
	public Thread(){
		
	}
	public int getProjectid(){
		return projectid;
		
	}
	public String getProjectname(){
		return projectname;
		
	}
	public String getThreadfocus(){
		return threadfocus;
		
	}
	public String getAuthor(){
		return author;
		
	}
	
	public void setProjectid(int projectid){
		this.projectid=projectid;
		
	}
	
	public void setProjectname(String projectname){
		this.projectname=projectname;
	}
	public void setThreadfocus(String threadfocus){
		this.threadfocus=threadfocus;
	}
	public void setAuthor(String author){
		this.author=author;
	}

}
