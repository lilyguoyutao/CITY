package com.jcg.examples.viewBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Usermore")
public class usermore implements Serializable{
	
	//private int id;
	
	@Id
    @Column(name = "userid")
	private int userid;
	private String interest;
	
	//public int getId(){
	//	return id;
	//}
    
    public int getUserid(){
    	return userid;
    }
    
    public String getInterest(){
    	return interest;
    }
    
    
    
    //public void setId(int id){
   // 	this.id=id;
   // }

    public void setUserid(int userid){
    	this.userid=userid;
    }
    public void setInterest(String interest){
    	this.interest=interest;
    }
}
