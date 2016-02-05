package com.jcg.examples.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jcg.examples.viewBean.Adopt;
import com.jcg.examples.viewBean.Collect;
import com.jcg.examples.viewBean.Follow;
import com.jcg.examples.viewBean.Idea;
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

/**
 * @author CENTAUR
 * This interface will be used to communicate with the
 * Database
 */

public interface UserDao
{
	    
		
		public int checkUserpass(String username,String password,String type)throws SQLException;
		public void saveStuDao(Student student) throws SQLException;
		public Student listuserDao(int id) throws SQLException;
		public Student userfileDao(String name,String password,String type) throws SQLException;
		public List<String> findcombyuser(String username) throws SQLException;
		public void changeDao(String username,String old,String password) throws SQLException;
		public boolean check(int id,String community) throws SQLException;
		public void editDao(Student student) throws SQLException;
		public List<Project> searchprojectDao(String html) throws SQLException;
		public List<Thread> searchthread(String html) throws SQLException;
	    public List<String> checklike(int userid,String thread) throws SQLException;
	    public void insertlik(Likeq lik) throws SQLException;
        public void deletelik(Likeq lik) throws SQLException;
        public List<Likeq> listlike(String threadname) throws SQLException;
        public void insertfollow(Follow follow) throws SQLException;
        public String checkfollow(int userid,String thread) throws SQLException;
        public void  insertadopt(Adopt adopt) throws SQLException;
        public String  checkadopt(int userid,String thread,String community) throws SQLException;
        public List<Likeq> listmylikes(int userid) throws SQLException;
        public List<Follow> listfollow(int userid)throws SQLException;
        public Followupda searchthreadupdate(String followname) throws SQLException;
        public List<Adopt> findaoptbycommunity(String community_name) throws SQLException;
		public String showusermore(int userid) throws SQLException;
		public void insertinterest(usermore user) throws SQLException;
		public int getIdbyname(String username, String password, String type) throws SQLException;
		public void saveintost_com(st_com st) throws SQLException;
		public List<Integer> getUseridbycommunity(String name) throws SQLException;
		public List<String> getcommunitybyuserid(int id) throws SQLException;
		public void insertcollect(Collect collect) throws SQLException;
		public List<Collect> findcollectbycommunity(String community_name) throws SQLException;
		public String checkmyadopt(int userid, String threadname) throws SQLException;
		public void insertmyadopt(Myadopt my) throws SQLException;
		public List<String> searchmyadopt(int userid) throws SQLException;
		public String checkmycollect(int userid, String threadname) throws SQLException;
		public void insertmycollect(Mycollect my) throws SQLException;
		public List<String> searchmycollect(int userid) throws SQLException;
		public List<Mycollection> searchcollection(int userid) throws SQLException;
		public int getidbycollection(int userid, String collection) throws SQLException;
		public void insertcol_thread(col_thread col) throws SQLException;
		public void insertmycollection(Mycollection mycollection) throws SQLException;
		public boolean checkcoexsit(int id, String threadname) throws SQLException;
		public List<Mycollection> findcollectbyid(int userid) throws SQLException;
		public List<String> findthreadbycollect(String collectname) throws SQLException;
		public double getsimilarthread(String thread1,String thread2) throws SQLException;
		public List<String> findallthread() throws SQLException;
		public List<String> findprojectbythread(String threadname) throws SQLException;
		public boolean checkst_com(int userid, String com);
		public List<Integer> getUseridbygroupid(String id);
		public void saveintostgroup(Stgroup sgroup);
}
