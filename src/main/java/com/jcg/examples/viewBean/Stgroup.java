package com.jcg.examples.viewBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stgroup")
public class Stgroup implements Serializable{
	
	@Id
	@Column(name="group_id")
	private int group_id;
	private int student_id;
	public int getGroup_id(){
		return group_id;
	}
	public int getStudent_id(){
		return student_id;
	}
	public void setGroup_id(int group_id){
		this.group_id=group_id;
	}
	public void setStudent_id(int student_id){
		this.student_id=student_id;
	}

}
