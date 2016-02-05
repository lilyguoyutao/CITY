package com.jcg.examples.viewBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myadopt")
public class Myadopt implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	private int userid;
	
	private String thread;
	
	public int getId(){
		return id;
	}
	public int getUserid(){
		return userid;
	}
	public String getThread(){
		return thread;
	}
	public void setId(int id){
		this.id=id;
	}
	public void setUserid(int userid){
		this.userid=userid;
	}
	public void setThread(String thread){
		this.thread=thread;
	}
}
