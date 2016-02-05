package com.jcg.examples.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcg.examples.dao.CommunityDao;
import com.jcg.examples.service.CommunityService;
import com.jcg.examples.viewBean.Comment;
import com.jcg.examples.viewBean.Community;
import com.jcg.examples.viewBean.Idea;
import com.jcg.examples.viewBean.Mygroup;

@Service
public class CommunityServiceImpl implements CommunityService{
	
	@Autowired
	private CommunityDao comDao;
	
	
	@Override
	public void saveservice(Community community) throws SQLException{
		comDao.saveDao(community);
		
	}
	
	@Override
	public List<Community> listservice(String name) throws SQLException{
		return comDao.listDao(name);
	}
	
	@Override
	public boolean checkCommunity(String name) throws SQLException{
		return comDao.checkDao(name);
	}
	
	@Override
	public void deleteservice(int id) throws SQLException{
		comDao.deleteDao(id);
	}
	
	@Override
	public Community detailservice(String id) throws SQLException{
		return comDao.detailDao(id);
	}
	
	@Override
	public List<String> findcommunitybyusername(String username) throws SQLException{
		return comDao.findcombyuser(username);
	}
	
	@Override
	public void updatecreator(String comname,String username) throws SQLException{
		comDao.updatecreator(comname,username);
	}
	
	@Override
	 public List<Idea> listidea(List<Integer> noteid) throws SQLException{
		return comDao.listideaDao(noteid);
	}
	
	@Override
	public void savecomment(Comment comment) throws SQLException{
		comDao.savecomment(comment);
	}
	
	@Override
	public List<Idea> searchidea(String idea,String thread) throws SQLException{
		return comDao.searchidea(idea,thread);
	}
   
	@Override
    public List<String> searchproject(String community) throws SQLException{
		return comDao.searchproject(community);
	}
	
	@Override
    public List<String> searchthread(String project) throws SQLException{
		return comDao.searchthread(project);
		
	}
	
	@Override
	public List<String> listcommunityname() throws SQLException{
		return comDao.listcommunityname();
	}

	@Override
	public List<Comment> listcomment(String threadname) throws SQLException {
		// TODO Auto-generated method stub
		return comDao.listcomment(threadname);
	}

	@Override
	public List<Integer> getNoteBythreadname(String thread) {
		// TODO Auto-generated method stub
		return comDao.getNoteBythreadname(thread);
	}

	@Override
	public void savegroup(Mygroup mygroup) {
		 comDao.savegroup(mygroup);
		
	}

	@Override
	public List<Mygroup> listmygroup(String userid) {
		// TODO Auto-generated method stub
		return comDao.listmygroup(userid);
	}

	@Override
	public List<Integer> getgroupbyuserid(String userid) {
		// TODO Auto-generated method stub
		return comDao.getgroupbyuserid(userid);
	}

	@Override
	public Mygroup getgroupbygroupid(Integer integer) {
		// TODO Auto-generated method stub
		return comDao.getgroupbygroupid(integer);
	}
}
