package com.jcg.examples.viewBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="upda")
public class Followupda implements Serializable{
	
	 @Id
	 @GeneratedValue
	 @Column(name="id")
	private int id;
	
	private String thread;
	private String time1;
	private String body;
	
	 public int getId(){
		  return id;
	  }
	  
	 
	  public String getTime1(){
		  return time1;
	  }
	  public String getBody(){
		  return body;
	  }
	  
	  public String getThread(){
		  return thread;
	  }
	  public void setId(int id){
		  this.id=id;
	  }
	  
	 public void setThread(String thread){
		 this.thread=thread;
	 }
	  public void setTime1(String time1){
		  this.time1=time1;
	  }
	  public void setBody(String body){
		  this.body=body;
	  }
}
