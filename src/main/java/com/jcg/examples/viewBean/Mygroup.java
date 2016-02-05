package com.jcg.examples.viewBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="citygroup")
public class Mygroup implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="group_id")
	private int group_id;
	private String group_name;
	private String group_builder;
	private String group_content;
	public int getGroup_id(){
		return group_id;
	}
	public String getGroup_name(){
		return group_name;
	}
	public String getGroup_builder(){
		return group_builder;
	}
	public String getGroup_content(){
		return group_content;
	}
	public void setGroup_id(int group_id){
		this.group_id=group_id;
	}
	public void setGroup_name(String group_name){
		this.group_name=group_name;
	}
	public void setGroup_builder(String group_builder){
		this.group_builder=group_builder;
	}
	public void setGroup_content(String group_content){
		this.group_content=group_content;
	}
	

}
