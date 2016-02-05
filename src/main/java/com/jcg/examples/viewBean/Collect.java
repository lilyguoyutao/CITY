package com.jcg.examples.viewBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="collect_thread")
public class Collect implements Serializable{
	@Id
	@GeneratedValue
    @Column(name = "id")
	private int id;
	
	private int userid;
	private String threadname;
	private String community;
	private String reason;
	public int getId(){
		return id;
	}
	public int getUserid(){
		return userid;
	}
	public String getThreadname(){
		return threadname;
	}
	public String getCommunity(){
		return community;
	}
	public String getReason(){
		return reason;
	}
	public void setId(int id){
		this.id=id;
	}
	public void setUserid(int userid){
		this.userid=userid;
	}
	public void setThreadname(String threadname){
		this.threadname=threadname;
	}
	public void setCommunity(String community){
		this.community=community;
	}
	public void setReason(String reason){
		this.reason=reason;
	}

}
