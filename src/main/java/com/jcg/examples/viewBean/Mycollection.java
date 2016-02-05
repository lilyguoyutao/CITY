package com.jcg.examples.viewBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mycollection")
public class Mycollection implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	private int userid;
	private String collectname;
	private String collectdetail;
	
	public int getId(){
		return id;
	}
	public int getUserid(){
		return userid;
	}
	public String getCollectname(){
		return collectname;
	}
	public String getCollectdetail(){
		return collectdetail;
	}
	public void setId(int id){
		this.id=id;
	}
	public void setUserid(int userid){
		this.userid=userid;
	}
	public void setCollectname(String collectname){
		this.collectname=collectname;
	}
	public void setCollectdetail(String collectdetail){
		this.collectdetail=collectdetail;
	}

}
