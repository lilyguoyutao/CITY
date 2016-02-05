package com.jcg.examples.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcg.examples.dao.UserDao;
import com.jcg.examples.service.UserService;
import com.jcg.examples.viewBean.Adopt;
import com.jcg.examples.viewBean.Collect;
import com.jcg.examples.viewBean.Follow;
import com.jcg.examples.viewBean.Likeq;
import com.jcg.examples.viewBean.Myadopt;
import com.jcg.examples.viewBean.Mycollect;
import com.jcg.examples.viewBean.Mycollection;
import com.jcg.examples.viewBean.Project;
import com.jcg.examples.viewBean.Stgroup;
import com.jcg.examples.viewBean.Student;
import com.jcg.examples.viewBean.col_thread;
import com.jcg.examples.viewBean.st_com;
import com.jcg.examples.viewBean.usermore;
import com.jcg.examples.viewBean.Followupda;

@Service
public class UserServiceImpl implements UserService
{
        @Autowired
		private UserDao userDao;

		//public UserDao getUserDao()
		//{
		//		return this.userDao;
		//}

		//public void setUserDao(UserDao userDao)
		//{
		//		this.userDao = userDao;
		//}


		
		@Override
		public int checkUserpass_service(String username,String password,String type) throws SQLException
		{
			return userDao.checkUserpass(username, password,type);
		}
		
		
		@Override
		public void saveStuService(Student student) throws SQLException
		{
				 userDao.saveStuDao(student);
		}
		
		
		@Override
		public Student listuserService(int id) throws SQLException{
			return userDao.listuserDao(id);
		}
		
		
		@Override
		public Student userfile(String name,String password,String type) throws SQLException{
			return userDao.userfileDao(name,password,type);
		}
		
		@Override
		public List<String> findcombyuser(String name) throws SQLException{
			return userDao.findcombyuser(name);
		}
		
		@Override
		public void changepassservice(String username, String old,String password) throws SQLException{
			userDao.changeDao(username,old,password);
		}
		
		@Override
		 public boolean check(int id,String community) throws SQLException{
			return userDao.check(id,community);
		}
		
		@Override
		public void edit(Student student) throws SQLException{
			userDao.editDao(student);
		}
		
		@Override
		public List<Project> searchproject(String html) throws SQLException{
			return userDao.searchprojectDao(html);
		}
		
		@Override
		public List<Thread> searchthread(String html) throws SQLException{
			return userDao.searchthread(html);
		}
		
		@Override
		public List<String> checklike(int userid,String thread) throws SQLException{
			return userDao.checklike(userid,thread);
		}
		
		@Override
		  public void insertlik(Likeq lik) throws SQLException{
			userDao.insertlik(lik);
		}
		
		@Override
	        public void deletelik(Likeq lik) throws SQLException
	        {userDao.deletelik(lik);}
		
		@Override
		public List<Likeq> listlike(String threadname) throws SQLException{
			return userDao.listlike(threadname);
		}
		
		@Override
		 public void  insertfollow(Follow follow) throws SQLException{
			userDao.insertfollow(follow);
		}
		
		@Override
		public String checkfollow(int userid,String thread) throws SQLException{
			return userDao.checkfollow(userid,thread);
		}
		
		@Override
		public void  insertadopt(Adopt adopt) throws SQLException{
			userDao.insertadopt(adopt);
		}
		
		@Override
        public String  checkadopt(int userid,String thread,String community) throws SQLException{
			  return userDao.checkadopt(userid,thread,community);
		}
		
		@Override
		public List<Likeq> listmylikes(int userid) throws SQLException{
			return userDao.listmylikes(userid);
		}
		@Override
		public List<Follow> listfollow(int userid)throws SQLException{
			return userDao.listfollow(userid);
		}
        
		@Override
		public Followupda searchthreadupdate(String followname) throws SQLException{
			return userDao.searchthreadupdate(followname);
		}
		
		@Override
		public List<Adopt> findaoptbycommunity(String community_name) throws SQLException{
			return userDao.findaoptbycommunity(community_name);
		}


		@Override
		public String showusermore(int userid) throws SQLException {
			// TODO Auto-generated method stub
			return userDao.showusermore(userid);
		}


		@Override
		public void insertinterest(usermore user) throws SQLException {
			// TODO Auto-generated method stub
			   userDao.insertinterest(user);
		}


		@Override
		public int getIdbyname(String username, String password, String type) throws SQLException{
			// TODO Auto-generated method stub
			return userDao.getIdbyname( username,password,type);
		}


		@Override
		public void saveintost_com(st_com st) throws SQLException {
			// TODO Auto-generated method stub
			userDao.saveintost_com(st);
		}


		@Override
		public List<Integer> getUseridbycommunity(String name) throws SQLException {
			return userDao.getUseridbycommunity(name);
		}


		@Override
		public List<String> getcommunitybyuserid(int id) throws SQLException {
			return userDao.getcommunitybyuserid(id);
		}


		@Override
		public void insertcollect(Collect collect) throws SQLException {
			userDao.insertcollect(collect);
			
		}


		@Override
		public List<Collect> findcollectbycommunity(String community_name) throws SQLException {
			return userDao.findcollectbycommunity(community_name);
		}


		@Override
		public String checkmyadopt(int userid, String threadname) throws SQLException {
			// TODO Auto-generated method stub
			return userDao.checkmyadopt(userid,threadname);
		}


		@Override
		public void insertmyadopt(Myadopt my) throws SQLException {
			// TODO Auto-generated method stub
			userDao.insertmyadopt(my);
		}


		@Override
		public List<String> searchmyadopt(int userid) throws SQLException {
			// TODO Auto-generated method stub
			return userDao.searchmyadopt(userid);
		}


		@Override
		public String checkmycollect(int userid, String threadname) throws SQLException {
			// TODO Auto-generated method stub
			return userDao.checkmycollect(userid,threadname);
		}


		@Override
		public void insertmycollect(Mycollect my) throws SQLException {
			// TODO Auto-generated method stub
			userDao.insertmycollect(my);
		}


		@Override
		public List<String> searchmycollect(int userid) throws SQLException {
			// TODO Auto-generated method stub
			return userDao.searchmycollect(userid);
		}


		@Override
		public List<Mycollection> searchcollection(int userid) throws SQLException {
			// TODO Auto-generated method stub
			return userDao.searchcollection(userid);
		}


		@Override
		public int getidbycollection(int userid, String collection) throws SQLException {
			// TODO Auto-generated method stub
			return userDao.getidbycollection(userid,collection);
		}


		@Override
		public void insertcol_thread(col_thread col) throws SQLException {
			// TODO Auto-generated method stub
			 userDao.insertcol_thread(col);
		}


		@Override
		public void insertmycollection(Mycollection mycollection) throws SQLException {
			// TODO Auto-generated method stub
			userDao.insertmycollection(mycollection);
		}


		@Override
		public boolean checkcoexsit(int id, String threadname) throws SQLException {
			// TODO Auto-generated method stub
			return userDao.checkcoexsit(id,threadname);
		}


		@Override
		public List<Mycollection> findcollectbyid(int userid) throws SQLException {
			return userDao.findcollectbyid(userid);
			
		}


		@Override
		public List<String> findthreadbycollect(String collectname) throws SQLException {
			return userDao.findthreadbycollect(collectname);
		}


		@Override
		public double getsimilarthread(String thread1,String thread2) throws SQLException {
			// TODO Auto-generated method stub
			return userDao.getsimilarthread(thread1,thread2);
		}


		@Override
		public List<String> findallthread() throws SQLException {
			// TODO Auto-generated method stub
			return userDao.findallthread();
		}


		@Override
		public List<String> findprojectbythread(String threadname) throws SQLException {
			// TODO Auto-generated method stub
			return userDao.findprojectbythread(threadname);
		}


		@Override
		public boolean checkst_com(int userid, String com) {
			// TODO Auto-generated method stub
			return userDao.checkst_com(userid,com);
		}


		@Override
		public List<Integer> getUseridbygroupid(String id) {
			// TODO Auto-generated method stub
			return userDao.getUseridbygroupid(id);
		}


		@Override
		public void saveintostgroup(Stgroup sgroup) {
			// TODO Auto-generated method stub
			userDao.saveintostgroup(sgroup);
		}


	
}
