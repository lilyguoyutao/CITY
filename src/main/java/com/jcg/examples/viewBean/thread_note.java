package com.jcg.examples.viewBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="thread_note")
public class thread_note implements Serializable{
	    @Id
	    @Column(name="projectid")
        private int projectid;
        private String threadfocus;
        private int noteid;
        private int highlight;
        private String addtime;
        public int getProjectid(){
        	return projectid;
        }
        public String getThreadfocus(){
        	return threadfocus;
        }
        public int getNoteid(){
        	return noteid;
        }
        public int getHighlight(){
        	return highlight;
        }
        public String getAddtime(){
        	return addtime;
        }
        public void setProjectid(int projectid){
        	this.projectid=projectid;
        }
        public void setThreadfocus(String threadfocus){
        	this.threadfocus=threadfocus;
        }
        public void setNoteid(int noteid){
        	this.noteid=noteid;
        }
        public void setHighlight(int highlight){
        	this.highlight=highlight;
        }
        public void setAddtime(String addtime){
        	this.addtime=addtime;
        }
}
