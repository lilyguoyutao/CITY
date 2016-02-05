package com.jcg.examples.viewBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment implements Serializable{
	
	
	 @Id
	 @GeneratedValue
     @Column(name = "me_id")
	private int me_id;
	 
	 
	 
	private String me_text;
	
	private String time;
	
	private String fromw;
	
	
	
	private String author;
	
	private String password;
	private String status;
	
	public Comment(){}
	 public int getId(){
	  		return me_id;
	  		
	  	}
	     public void setId(int me_id){
	    	  this.me_id=me_id;
	      }
	      public String getMe_text(){
	    		return me_text;
	    		
	    	}
	     public void setMe_text(String me_text){
	      	  this.me_text=me_text;
	        }
	     public String getTime(){
	      		return time;
	      		
	      	}
	     public void setTime(String createtime){
	        	  this.time=createtime;
	          }
	     public String getFromw(){
	        		return fromw;
	        		
	        	}
	     public void setFromw(String fromw){
	          	  this.fromw=fromw;
	            }
	     public String getAuthor(){
	      	  return author;
	        }
	        public String getPassword(){
	      	  return password;
	        }
	                 
	         public void setAuthor(String author){
	       	  this.author=author;
	         }
	         public void setPassword(String password){
	       	  this.password=password;
	         }
		     public String getStatus(){
	        		return status;
	        		
	        	}
	     public void setStatus(String status){
	          	  this.status=status;
	            }

}
