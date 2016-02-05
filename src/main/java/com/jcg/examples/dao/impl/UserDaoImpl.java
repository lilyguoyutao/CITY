package com.jcg.examples.dao.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jcg.examples.dao.UserDao;
import com.jcg.examples.function.Compare;
import com.jcg.examples.viewBean.Project;
import com.jcg.examples.viewBean.Stgroup;
import com.jcg.examples.viewBean.Student;
import com.jcg.examples.viewBean.col_thread;
import com.jcg.examples.viewBean.st_com;
import com.jcg.examples.viewBean.usermore;
import com.jcg.examples.viewBean.Followupda;
import com.jcg.examples.viewBean.Adopt;
import com.jcg.examples.viewBean.Collect;
import com.jcg.examples.viewBean.Follow;
import com.jcg.examples.viewBean.Likeq;
import com.jcg.examples.viewBean.Myadopt;
import com.jcg.examples.viewBean.Mycollect;
import com.jcg.examples.viewBean.Mycollection;


/**
 * @author CENTAUR
 */
@Repository
public class UserDaoImpl implements UserDao
{
        @Autowired
		private HibernateTemplate hibernateTemplate;

		//public DataSource getDataSource()
		//{
		//		return this.dataSource;
		//}

		

		
		
		@Override
		public  int checkUserpass(String username,String password,String type)
		{
			String hql="from Student u where u.username=? and password=? and type=?";
			//Object value=new Object[]{username};
			List<Student> loginlist=(List<Student>)hibernateTemplate.find(hql,username,password,type);
			
			if(loginlist.size()!=0)
				return loginlist.get(0).getSt_id();
			else
				return -1;
			
			
		}
		
		@Override
		public void saveStuDao(Student student) throws SQLException{
			hibernateTemplate.save(student);
		}
		
		@Override
		public Student listuserDao(int id) throws SQLException{
		   
		   
		   List<Student> student= (List<Student>)hibernateTemplate.find("from Student where st_id=?",id);
		   return student.get(0);
		    
		}
		
		
		@Override
		public Student userfileDao(String name,String password,String type) throws SQLException{
		  List<Student> student=(List<Student>)hibernateTemplate.find("from Student where username=? and password=? and type=?", name,password,type);
		  return student.get(0);
		}
		
		@Override
		public List<String> findcombyuser(String username) throws SQLException
		{
			return (List<String>)hibernateTemplate.find("select distinct(community) from Student where username=?",username);
		}
		
		@Override
		public void changeDao(String username,String old,String password) throws SQLException
		{   
			hibernateTemplate.bulkUpdate("update Student set password=? where username=? and password=?",password,username,old);
		}
		
		@Override
		public boolean check(int id,String community) throws SQLException{
			List<st_com> student=(List<st_com>)hibernateTemplate.find("from st_com where userid=? and community=?",id,community);
			if(student.size()==0)
				return true;
			else
				return false;
		}
		
		@Override
		public void editDao(Student student) throws SQLException{
			hibernateTemplate.update(student);
		}
		
		@Override
		public List<Project> searchprojectDao(String html) throws SQLException{
			return (List<Project>)hibernateTemplate.find(html);
		}
		
		@Override
		public List<Thread> searchthread(String html) throws SQLException{
			return (List<Thread>)hibernateTemplate.find(html);
		}
		
		@Override
		public List<String> checklike(int userid,String thread) throws SQLException{
			
			List<Likeq> likeq1=(List<Likeq>)hibernateTemplate.find("from Likeq where userid=? and thread=?", userid,thread);
			List<Likeq> likeq2=(List<Likeq>)hibernateTemplate.find("from Likeq where thread=?", thread);
			List<String> list=new ArrayList<String>();
			list.add(String.valueOf(likeq1.size()));
			list.add(String.valueOf(likeq2.size()));
			return list;
			
		}
		@Override
		  public void insertlik(Likeq lik) throws SQLException{
			hibernateTemplate.save(lik);
		}
		
		@Override
	        public void deletelik(Likeq lik) throws SQLException{
			List<Likeq> likes=(List<Likeq>)hibernateTemplate.find("from Likeq where userid=? and thread=?",lik.getUserid(),lik.getThread());
			int id=likes.get(0).getId();
			lik.setIdlike(id);
					hibernateTemplate.delete(lik);
		}
		
		@Override
		 public List<Likeq> listlike(String threadname) throws SQLException{
			return (List<Likeq>)hibernateTemplate.find("from Likeq where thread=?",threadname);
		}
        
		@Override
		public void insertfollow(Follow follow) throws SQLException{
			hibernateTemplate.save(follow);
		}
		
		@Override
		public String checkfollow(int userid,String thread) throws SQLException{
			List<Follow> list=(List<Follow>)hibernateTemplate.find("from Follow where userid=? and followname=?",userid,thread);
			if(list.size()==0)
				return "true";
			else 
				return "false";
		}
		
		@Override
		public void  insertadopt(Adopt adopt) throws SQLException{
			  hibernateTemplate.save(adopt);
		}
		
		@Override
        public String  checkadopt(int userid,String thread,String community) throws SQLException{
			/*List<Adopt> adopt=(List<Adopt>)hibernateTemplate.find("from Adopt);
			if(adopt.size()==0)
				return "true";
			else
				return "false";*/
			return "true";
		}
		
		@Override
		public List<Likeq> listmylikes(int userid) throws SQLException{
			return (List<Likeq>)hibernateTemplate.find("from Likeq where userid=?",userid);
		}
		
		@Override
		public List<Follow> listfollow(int userid)throws SQLException{
			return (List<Follow>)hibernateTemplate.find("from Follow where userid=?",userid);
		}
		
		@Override
		public Followupda searchthreadupdate(String followname) throws SQLException{
			List<Followupda> list=(List<Followupda>)hibernateTemplate.find("from Followupda where thread=? order by time1 DESC",followname);
			if(list.size()>0)
			   return list.get(0);
			else
				return null;
		}

		@Override
		public List<Adopt> findaoptbycommunity(String community_name) throws SQLException {
			List<Adopt> list=(List<Adopt>)hibernateTemplate.find("from Adopt where community=? order by id DESC",community_name);
			return list;
		}

		@Override
		public String showusermore(int userid) throws SQLException {
			List<usermore> user=(List<usermore>)hibernateTemplate.find("from usermore where userid=?",userid);
			if(user.size()>0)
			    return user.get(0).getInterest();
			else
				return "";
		}

		@Override
		public void insertinterest(usermore user) throws SQLException {
			// TODO Auto-generated method stub
			//hibernateTemplate.saveorUpdate("update usermore set interest=? where username=? and password=?",user.getInterest(),user.getUsername(),user.getPassword());
			List<usermore> user1=(List<usermore>)hibernateTemplate.find("from usermore where userid=?",user.getUserid());;
			if(user1.size()>0)
			    hibernateTemplate.update(user);
			else
				hibernateTemplate.save(user);
			
			
		}

		@Override
		public int getIdbyname(String username, String password, String type) throws SQLException{
			// TODO Auto-generated method stub
			List<Integer> student=(List<Integer>)hibernateTemplate.find("select st_id from Student where username=? and password=? and type=?",username,password,type);
		    return student.get(0);
		}

		@Override
		public void saveintost_com(st_com st) throws SQLException {
			hibernateTemplate.save(st);// TODO Auto-generated method stub
			
		}

		@Override
		public List<Integer> getUseridbycommunity(String name) throws SQLException {
			return (List<Integer>)hibernateTemplate.find("select userid from st_com where community=?",name);
		}

		@Override
		public List<String> getcommunitybyuserid(int id) throws SQLException {
			return (List<String>)hibernateTemplate.find("select community from st_com where userid=?",id);
		}

		@Override
		public void insertcollect(Collect collect) throws SQLException {
			hibernateTemplate.save(collect);
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Collect> findcollectbycommunity(String community_name) throws SQLException {
			// TODO Auto-generated method stub
		     return (List<Collect>)hibernateTemplate.find("from Collect where community=?",community_name);
		}

		@Override
		public String checkmyadopt(int userid, String threadname) throws SQLException {
			// TODO Auto-generated method stub
			List<Myadopt> mydopt=(List<Myadopt>)hibernateTemplate.find("from Myadopt where userid=? and thread=?",userid,threadname);
			if(mydopt.size()==0)
					return "true";
			else
				return "false";
		}

		@Override
		public void insertmyadopt(Myadopt my) throws SQLException {
			// TODO Auto-generated method stub
			hibernateTemplate.save(my);
		}

		@Override
		public List<String> searchmyadopt(int userid) throws SQLException {
			List<String> mydopt=(List<String>)hibernateTemplate.find("select thread from Myadopt where userid=?",userid);
			return mydopt;
		}

		@Override
		public String checkmycollect(int userid, String threadname) throws SQLException {
			List<Mycollect> mycollect=(List<Mycollect>)hibernateTemplate.find("from Mycollect where userid=? and threadname=?",userid,threadname);
			if(mycollect.size()==0)
					return "true";
			else
				return "false";
		}

		@Override
		public void insertmycollect(Mycollect my) throws SQLException {
			// TODO Auto-generated method stub
			hibernateTemplate.save(my);
		}

		@Override
		public List<String> searchmycollect(int userid) throws SQLException {
			List<String> mycollect=(List<String>)hibernateTemplate.find("select thread from Mycollect where userid=?",userid);// TODO Auto-generated method stub
			return mycollect;
		}

		@Override
		public List<Mycollection> searchcollection(int userid) throws SQLException {
			// TODO Auto-generated method stub
			return (List<Mycollection>)hibernateTemplate.find("from Mycollection where userid=?",userid);
		}

		@Override
		public int getidbycollection(int userid, String collection) throws SQLException {
			List<Integer> list=(List<Integer>)hibernateTemplate.find("select id from Mycollection where userid=? and collectname=?",userid,collection);
			return list.get(0);
		}

		@Override
		public void insertcol_thread(col_thread col) throws SQLException {
			// TODO Auto-generated method stub
			hibernateTemplate.save(col);
		}

		@Override
		public void insertmycollection(Mycollection mycollection) throws SQLException {
			// TODO Auto-generated method stub
			hibernateTemplate.save(mycollection);
		}

		@Override
		public boolean checkcoexsit(int id, String threadname) throws SQLException {
			// TODO Auto-generated method stub
			 List<col_thread> list=(List<col_thread>)hibernateTemplate.find("from col_thread where collectid=? and thread=?",id,threadname);
			 if(list.size()==0)
				 return true;
			 else 
				 return false;
		}

		@Override
		public List<Mycollection> findcollectbyid(int userid) throws SQLException {
			
			return (List<Mycollection>)hibernateTemplate.find("from Mycollection where userid=?",userid);
		}

		@Override
		public List<String> findthreadbycollect(String collectname) throws SQLException {
			// TODO Auto-generated method stub
			int collectid=Integer.parseInt(collectname);
			return (List<String>)hibernateTemplate.find("select thread from col_thread where collectid=?",collectid);
		}

		@Override
		public double getsimilarthread(String threada,String threadb) throws SQLException {
			List<Integer> noteid1=(List<Integer>)(hibernateTemplate.find("select noteid from thread_note where threadfocus=?",threada));
			List<Integer> noteid2=(List<Integer>)(hibernateTemplate.find("select noteid from thread_note where threadfocus=?",threadb));
			List<String> str1=new ArrayList<String>();
			for(int i=0;i<noteid1.size();i++){
				List<String> tem1=(List<String>)hibernateTemplate.find("select notecontent from Idea where noteid=?",noteid1.get(i));
				if(tem1.size()!=0)
					str1.add(tem1.get(0));
			}
			List<String> str2=new ArrayList<String>();
			for(int i=0;i<noteid2.size();i++){
				List<String> tem2=(List<String>)hibernateTemplate.find("select notecontent from Idea where noteid=?",noteid2.get(i));
				if(tem2.size()!=0)
					str1.add(tem2.get(0));
			}
			//List<String> str1=(List<String>)hibernateTemplate.find("select idea from Idea where thread=?",threada);
			
			String s1="";
			String s2="";
			for(int i=0;i<str1.size();i++){
				s1+=str1.get(i)+" ";
			}
			
			for(int i=0;i<str2.size();i++){
				s2+=str2.get(i)+" ";
			}
			return Compare.getSimilarDegree(s1, s2);
		}

		@Override
		public List<String> findallthread() throws SQLException {
			// TODO Auto-generated method stub
			return (List<String>)hibernateTemplate.find("select threadfocus from Thread");
		}

		@Override
		public List<String> findprojectbythread(String threadname) throws SQLException {
			List<String> project=(List<String>)hibernateTemplate.find("select projectname from Thread where threadfocus=?",threadname);
			
			String projectname=project.get(0);
			System.out.println(projectname);
			List<String> community=(List<String>)hibernateTemplate.find("select communityname from Project where projectname=?",projectname);
			String communityname=community.get(0);
			System.out.println("this is"+communityname);
			List<String> result=new ArrayList<String>();
			result.add(projectname);
			result.add(communityname);
			
			return result;
		}

		@Override
		public boolean checkst_com(int userid, String com) {
			List<st_com> list=(List<st_com>) hibernateTemplate.find("from st_com where userid=? and community=?",userid,com);
			if(list.size()!=0) return true;
			else return false;
		}

		@Override
		public List<Integer> getUseridbygroupid(String id) {
			// TODO Auto-generated method stub
			return (List<Integer>)hibernateTemplate.find("select student_id from Stgroup where group_id=?",Integer.valueOf(id));
		}

		@Override
		public void saveintostgroup(Stgroup sgroup) {
			// TODO Auto-generated method stub
			hibernateTemplate.save(sgroup);
		}
}