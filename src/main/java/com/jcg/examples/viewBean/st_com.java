package com.jcg.examples.viewBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="st_com")
public class st_com implements Serializable{
	
	@Id
	@GeneratedValue
    @Column(name = "id")
	private int id;
	
	private int userid;
	
	private String community;
	
	public int getId(){
		return id;
	}
    public int getUserid(){
    	return userid;
    }
    public String getCommunity(){
    	return community;
    }
    
    public void setId(int id){
    	this.id=id;
    }
    public void setUserid(int userid){
    	this.userid=userid;
    }
    public void setCommunity(String community){
    	this.community=community;
    }
}
