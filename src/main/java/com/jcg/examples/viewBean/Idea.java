package com.jcg.examples.viewBean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="note_table")
public class Idea implements Serializable{
	  @Id
	  @GeneratedValue
      @Column(name = "noteid")
      private int noteid;
	  
      private String notetitle;
      
      private String notecontent;
      
      private String offset;
      
      private String createtime;
      
      
      public Idea(){}
      
      public int getNoteid(){
  		return noteid;
  		
  	}
     public void setNoteid(int noteid){
    	  this.noteid=noteid;
      }
      public String getNotetitle(){
    		return notetitle;
    		
    	}
      
     
     public void setNotetitle(String notetitle){
      	  this.notetitle=notetitle;
        }
     
     public String getNotecontent(){
        		return notecontent;
        		
        	}
     public void setNotecontent(String notecontent){
          	  this.notecontent=notecontent;
            }
     public String getOffset(){
          		return offset;
          		
          	}
     public void setOffset(String offset){
            	  this.offset=offset;
              }
     public String getCreatetime(){
   		return createtime;
   		
   	}
  public void setCreatetime(String createtime){
     	  this.createtime=createtime;
       }
     

}
