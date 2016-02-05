package com.jcg.examples.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.jcg.examples.service.CommunityService;
import com.jcg.examples.service.UserService;
import com.jcg.examples.viewBean.Comment;
import com.jcg.examples.viewBean.Community;
import com.jcg.examples.viewBean.Idea;
import com.jcg.examples.viewBean.Mygroup;
import com.jcg.examples.viewBean.Student;
import com.jcg.examples.viewBean.st_com;

@Controller
@SessionAttributes({"listcom","listcomm"})

public class communityController {
	
	@Autowired
	private CommunityService communityservice;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/community", method=RequestMethod.GET)
	public ModelAndView getCommunity()
	{
		ModelAndView model=new ModelAndView("Addcommunity");
		return model;
	}
	
	@RequestMapping(value="/addgroup", method=RequestMethod.GET)
	public ModelAndView getGroup()
	{
		ModelAndView model=new ModelAndView("Addgroup");
		return model;
	}
	
	@RequestMapping(value="/community",method=RequestMethod.POST)
	public ModelAndView saveComunity(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws SQLException
	{   ModelAndView model=new ModelAndView();
		if(request.getParameter("check")!=null){
		if(communityservice.checkCommunity((String)request.getParameter("community_name")))
			{model.setViewName("Addcommunity");
		     model.addObject("message","community name is not available");}
		else
		{ model.setViewName("Addcommunity");
			model.addObject("message", "community name is available");	 
		     model.addObject("community_name",(String)request.getParameter("community_name")) ; }  
	}
		else{
		Community con=new Community();
	    
	    con.setCommunity_name((String)request.getParameter("community_name"));
	    con.setCreator((String)session.getAttribute("username"));
	    con.setGrade_level((String)request.getParameter("grade"));
	    con.setSchool_name((String)request.getParameter("schoolname"));
	    con.setSchool_phone((String)request.getParameter("schoolphone"));
	    con.setStreet((String)request.getParameter("street"));
	    con.setCity((String)request.getParameter("city"));
	    con.setState((String)request.getParameter("state"));
	    con.setCountry((String)request.getParameter("country"));
	    con.setEmail((String)request.getParameter("email"));
		
		communityservice.saveservice(con);
		model.setViewName("Addcommunity");
		model.addObject("message", "community has been added successfully");
		model.addObject("con", con);
		String username=(String)session.getAttribute("username");
		List<Community> listcommunity=communityservice.listservice(username);
	    

	    model.addObject("listcom",listcommunity);
		
		}
		return model;
	}
	@RequestMapping(value="/addgroup",method=RequestMethod.POST)
	public ModelAndView savegroup(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws SQLException
	{   ModelAndView model=new ModelAndView();
	    String id=(String) session.getAttribute("id");
		Mygroup mygroup=new Mygroup();
		mygroup.setGroup_name((String)request.getParameter("groupname"));
	    mygroup.setGroup_builder(id);
	    mygroup.setGroup_content((String)request.getParameter("groupcontent"));
	   
		
		communityservice.savegroup(mygroup);
		model.setViewName("group");
		model.addObject("message", "group has been added successfully");
		model.addObject("mygroup", mygroup);

		
		
		return model;
	}
	
	@RequestMapping(value="/listcommunity")
	public ModelAndView listcommunity(HttpSession session) throws SQLException{
		String login=(String)session.getAttribute("iflogin");
		String username=(String)session.getAttribute("username");
		String type=(String)session.getAttribute("type");
		String userid=(String)session.getAttribute("id");
		if(username==null)
			username="";
		if(login==null)
			login="";
		ModelAndView model=new ModelAndView();
		model.setViewName("listcommunity");
		if(login.equals("true"))
		{	List<Community> listcommunity=new ArrayList<Community>();
			if(type.equals("teacher"))
		    {listcommunity=communityservice.listservice(username);}
		    else
		    {   List<String> com_name=userService.getcommunitybyuserid(Integer.parseInt(userid));
		    	for(int i=0;i<com_name.size();i++){
		    		listcommunity.add(communityservice.detailservice(com_name.get(i)));
		    	}
		    }
		
		
		model.addObject("listcommunity", listcommunity);
		
		}
		else
		{
			
			model.setViewName("listcommunity");
		}
		return model;
	}
	
	@RequestMapping(value="/listmygroup")
	public ModelAndView listgroup(HttpSession session) throws SQLException{
		String login=(String)session.getAttribute("iflogin");
		String username=(String)session.getAttribute("username");
		String type=(String)session.getAttribute("type");
		String userid=(String)session.getAttribute("id");
		if(username==null)
			username="";
		if(login==null)
			login="";
		ModelAndView model=new ModelAndView();
		model.setViewName("listmygroup");
		if(login.equals("true"))
		{	List<Mygroup> listgroup=new ArrayList<Mygroup>();
			if(type.equals("teacher"))
		    {listgroup=communityservice.listmygroup(userid);}
		    else
		    {   List<Integer> group=communityservice.getgroupbyuserid(userid);
		    	for(int i=0;i<group.size();i++){
		    		listgroup.add(communityservice.getgroupbygroupid(group.get(i)));
		    	}
		    }
		
		
		model.addObject("listgroup", listgroup);
		
		}
		else
		{
			
			model.setViewName("listmygroup");
		}
		return model;
	}
	
	@RequestMapping(value="/listcomname1")
	
	public ModelAndView ppp(HttpSession session) throws SQLException{
		String username=(String)session.getAttribute("username");
		List<Community> listcommunity=communityservice.listservice(username);
	    
	    session.setAttribute("list", listcommunity);
	    ModelAndView model=new ModelAndView("teacher");
	    model.addObject("listcom",listcommunity);
	    return model;
	}
	
	@RequestMapping(value="/listcomname2")
	public ModelAndView pp(HttpSession session) throws SQLException{
		//String username=(String)session.getAttribute("username");
		//List<String> com=userService.findcombyuser(username);
		
	    ModelAndView model=new ModelAndView("teacher");
	   // model.addObject("listcomm",com);
	    return model;
	}
	
	@RequestMapping(value="/json",method = RequestMethod.GET)
	@ResponseBody
	public  List<String> getjson(HttpSession session) throws SQLException
	{  	String username=(String)session.getAttribute("username");
	    String userid=(String)session.getAttribute("id");
	    String type=(String)session.getAttribute("type");
	    
	   if(type.equals("teacher")){
	   List<Community> listcommunity=communityservice.listservice(username);
	   List<String> list=new ArrayList<String>();
		for(int i=0;i<listcommunity.size();i++ )
		{
			list.add(listcommunity.get(i).getCommunity_name());
			
		}
	    
		return list;}
	    else
	    {	   List<String> stcom=userService.getcommunitybyuserid(Integer.parseInt(userid));
		      
		    
			return stcom;
	    	
	    }
	}
	
	@RequestMapping(value="/level2",method = RequestMethod.GET)
	@ResponseBody
	public  List<String> getlevel2(HttpServletRequest request,HttpSession session) throws SQLException
	{  	String username=(String)session.getAttribute("username");
	    String community=(String)request.getParameter("community");
	   List<String> list=communityservice.searchproject(community);

		return list;
	}
	
	@RequestMapping(value="/level3",method = RequestMethod.GET)
	@ResponseBody
	public  List<String> getlevele(HttpServletRequest request,HttpSession session) throws SQLException
	{  	String username=(String)session.getAttribute("username");
	
	   String community=(String)request.getParameter("project");
	   System.out.println(community);
	  List<String> list=communityservice.searchthread(community);

		return list;
	}
	
	@RequestMapping(value="/delete")
	public ModelAndView delete(HttpServletRequest request) throws SQLException{
		String id=(String)request.getParameter("com_id");
		int idd=Integer.valueOf(id);
		communityservice.deleteservice(idd);
		System.out.println(id);
		ModelAndView model=new ModelAndView("redirect:/listcommunity");
		return model;
	}
   
	@RequestMapping(value="/detail")
	public ModelAndView detail(HttpServletRequest request) throws SQLException{
		String name=(String)request.getParameter("comm_name");
		ModelAndView model=new ModelAndView();
		
		Community community=communityservice.detailservice(name);
		model.setViewName("communitydetail");
		
		model.addObject("community", community);
		
		return model;
	}
	
	@RequestMapping(value="/groupdetail")
	public ModelAndView groupdetail(HttpServletRequest request) throws SQLException{
		String id=(String)request.getParameter("groupid");
		ModelAndView model=new ModelAndView();
		
		Mygroup my=communityservice.getgroupbygroupid(Integer.valueOf(id));
		model.setViewName("groupdetail");
		
		model.addObject("group",my);
		
		return model;
	}
	@RequestMapping(value="/groupuserlist")
	public ModelAndView groupuserlist(HttpServletRequest request,HttpSession session) throws SQLException{
		String id=(String)request.getParameter("groupid");
	
	    String type=(String)session.getAttribute("type");
	    
	    List<Student> student=new ArrayList<Student>();
	    List<Integer> listint=userService.getUseridbygroupid(id);
	    for(int i=0;i<listint.size();i++)
		   student.add(userService.listuserService(listint.get(i)));
		
			
		ModelAndView model=new ModelAndView();
		if(type.equals("teacher")){
	    model.setViewName("groupuser");}
		else
		{model.setViewName("groupuser");}	
	    model.addObject("userlist", student);
	    model.addObject("groupid",id);
	    return model;
	}
	
	
	@RequestMapping(value="/listusercommunity")
	public ModelAndView listuserco(HttpSession session) throws SQLException
	{
		String username=(String)session.getAttribute("username");
		if(username==null)
			username="";
		ModelAndView model=new ModelAndView();
		List<String> com=userService.findcombyuser(username);
		List<Community> communitylist=new ArrayList<Community>();
		int i=0;
		for(i=0;i<com.size();i++)
		{
			String name=com.get(i);
			Community community=communityservice.detailservice(name);
			communitylist.add(community);
		}
		model.addObject("listcommunity", communitylist);
		model.setViewName("listcommunity");
		return model;
	}
	
	@RequestMapping(value="/listcommunityname")
	@ResponseBody
	public List<String> listco(HttpServletRequest request,HttpSession session) throws SQLException{
		//String password=(String)session.getAttribute("password");
	    String userid=(String)session.getAttribute("id");
    	String threadname=(String)request.getParameter("threadname");
    	
		
    	String username=(String)session.getAttribute("username");
	    
	    String type=(String)session.getAttribute("type");
	    
	   if(type.equals("teacher")){
	   List<Community> listcommunity=communityservice.listservice(username);
	   List<Mygroup> listusergroupid=communityservice.listmygroup(userid);
	   
	   List<String> list=new ArrayList<String>();
	   for(int i=0;i<listusergroupid.size();i++){
		   
		   list.add(listusergroupid.get(i).getGroup_name());
	   }
	   
		for(int i=0;i<listcommunity.size();i++ )
		{   if(userService.checkadopt(Integer.parseInt(userid), threadname, listcommunity.get(i).getCommunity_name()).equals("true"))
			{list.add(listcommunity.get(i).getCommunity_name());}
			
		}
	    
		return list;}
	    else
	    {	   List<String> stcom=userService.getcommunitybyuserid(Integer.parseInt(userid));
		      List<String> list2=new ArrayList<String>();
				for(int i=0;i<stcom.size();i++ )
				{   if(userService.checkadopt(Integer.parseInt(userid), threadname, stcom.get(i)).equals("true"))
					{list2.add(stcom.get(i));}
					
				}
		    
			return stcom;
	    	
	    }
	}
	
	@RequestMapping(value="/listidea")
	public ModelAndView listidea(HttpServletRequest request) throws SQLException{
		
		String thread=(String)request.getParameter("threadname");
		System.out.println(thread);
		List<Integer> noteid=communityservice.getNoteBythreadname(thread);
		List<Idea> list=communityservice.listidea(noteid);
		
		ModelAndView model=new ModelAndView("comments");
		model.addObject("threadname", thread);
		model.addObject("list",list);
		return model;
	}
	
	@RequestMapping(value="/comment",method=RequestMethod.POST)
	public ModelAndView leavecomment(HttpServletRequest reqeust,HttpSession session) throws SQLException{
		String username=(String)session.getAttribute("username");
		String password=(String)session.getAttribute("password");
		Comment comment=new Comment();
		String thread=(String)reqeust.getParameter("threadname");
		System.out.println("thread is"+thread);
		String me_tex=(String)reqeust.getParameter("message");
		String me_idea=(String)reqeust.getParameter("idea2");
		String ifsearch=(String)reqeust.getParameter("search3");
		if(ifsearch==null)
			ifsearch="";
		System.out.println("ifseach"+ifsearch+"ifsearh");
		comment.setMe_text(me_tex);
		comment.setFromw(me_idea);
		comment.setStatus("1");
		comment.setPassword(password);
		comment.setAuthor(username);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		comment.setTime(df.format(new Date()));
		
		communityservice.savecomment(comment);
		ModelAndView model=null;
		if(ifsearch.equals(""))
		{
			 model=new ModelAndView("redirect:/listidea?threadname="+thread);
		}
		else
		{
		
			 model=new ModelAndView("redirect:/searchidea?search="+ifsearch+"&threadname="+thread);
			
		}
		return model;
		
	}
	
	@RequestMapping(value="/tcomment",method=RequestMethod.POST)
	public ModelAndView leavecomment2(HttpServletRequest reqeust,HttpSession session) throws SQLException{
		String username=(String)session.getAttribute("username");
		String password=(String)session.getAttribute("password");
		Comment comment=new Comment();
		
		String me_tex=(String)reqeust.getParameter("mess");
		String me_thread=(String)reqeust.getParameter("threadname");
		comment.setMe_text(me_tex);
		comment.setFromw(me_thread);
		comment.setStatus("0");
		comment.setPassword(password);
		comment.setAuthor(username);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		comment.setTime(df.format(new Date()));
		
		ModelAndView model=new ModelAndView("redirect:/threadcomment");
		model.addObject("t_mess", "Add comment successfully");
		model.addObject("threadname",me_thread);
		communityservice.savecomment(comment);
		return model;
		
	}
	
	@RequestMapping(value="/threadpage")
	public ModelAndView thread(HttpServletRequest request,HttpSession session)
	{   String thread=(String)request.getParameter("threadname");
	   if(thread==null)
		   thread="";
		ModelAndView model=new ModelAndView("threadpage");
		model.addObject("threadname", thread);
		return model;
	}
	
	@RequestMapping(value="/threadcomment")
	public ModelAndView threadcomment(HttpServletRequest re,HttpSession session) throws SQLException
	{  String tme=(String)re.getParameter("t_mess");
	   String threadname=(String)re.getParameter("threadname");
	if(tme==null)
		tme="";
	   List<Comment> comment=communityservice.listcomment(threadname);
		ModelAndView model=new ModelAndView("threadcomment");
		model.addObject("t_mess", tme);
		model.addObject("threadname", threadname);
		model.addObject("listcomment", comment);
		return model;
	}
	
	@RequestMapping(value="/searchidea")
	public ModelAndView searche(HttpServletRequest request) throws SQLException{
		    String mess=(String)request.getParameter("search");
		    String threadname=(String)request.getParameter("threadname");
		    List<Idea> list=communityservice.searchidea(mess,threadname);
		    ModelAndView model=new ModelAndView("comments");
		    model.addObject("list", list);
		    model.addObject("searchme", mess);
		    model.addObject("threadname", threadname);
		    return model;
		    
	}
	
	@RequestMapping(value="/searchidea", method=RequestMethod.POST)
	public ModelAndView search(HttpServletRequest request) throws SQLException{
		    String mess=(String)request.getParameter("search");
		    String threadname=(String)request.getParameter("threadname");
		    List<Idea>list=communityservice.searchidea(mess,threadname);
		    ModelAndView model=new ModelAndView("comments");
		    model.addObject("list", list);
		    model.addObject("threadname", threadname);
		    model.addObject("searchme", mess);
		    return model;
		    
	}
	
	@RequestMapping(value="/ideacomment")
	@ResponseBody
	public List<Comment> ideacomment(HttpServletRequest request) throws SQLException{
		String ideaname=(String)request.getParameter("ideaname");
		System.out.println(ideaname);
		return communityservice.listcomment(ideaname);
	}
	
	@RequestMapping(value="/listallcommunity")
	@ResponseBody
	public List<String> listallcommunity(HttpServletRequest request) throws SQLException{
		//String ideaname=(String)request.getParameter("ideaname");
		return communityservice.listcommunityname();
	}
	
}
