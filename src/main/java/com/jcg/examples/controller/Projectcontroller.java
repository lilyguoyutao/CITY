package com.jcg.examples.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jcg.examples.service.CommunityService;
import com.jcg.examples.service.UserService;
import com.jcg.examples.viewBean.Adopt;
import com.jcg.examples.viewBean.Collect;
import com.jcg.examples.viewBean.Combin;
import com.jcg.examples.viewBean.Community;
import com.jcg.examples.viewBean.Follow;
import com.jcg.examples.viewBean.Likeq;
import com.jcg.examples.viewBean.Myadopt;
import com.jcg.examples.viewBean.Mycollection;
import com.jcg.examples.viewBean.Project;
import com.jcg.examples.viewBean.Student;
import com.jcg.examples.viewBean.col_thread;
import com.jcg.examples.viewBean.Followupda;

@Controller
public class Projectcontroller {
	@Autowired
	private UserService userService;
	//private HibernateTemplate hibernateTemplate;
    @Autowired
    private CommunityService conservice;
    
    @RequestMapping(value="/browse")
    public ModelAndView browse()
    {
    	ModelAndView model=new ModelAndView("Browse");
    	return model;
    }
    
    @RequestMapping(value="/searchproject",method=RequestMethod.POST)
    public ModelAndView searchproject(HttpServletRequest request) throws SQLException{
    	
    	ModelAndView model=new ModelAndView();
    	String name=request.getParameter("name");
    	String school=request.getParameter("school");
    	String teacher=request.getParameter("teacher");
    	String fromyear=request.getParameter("fromyear");
    	String toyear=request.getParameter("toyear");
    	String community=request.getParameter("community");
    	if(school==null)
    		school="";
    	if(teacher==null)
    		teacher="";
    	if(fromyear==null)
    		fromyear="";
    	if(toyear==null)
    		toyear="";
    	if(community==null)
    		community="";
    	String html="";
    		
    		html="from Project where projectname like '%"+name+"%'";
    	
    
    	

       if(!school.equals("")){	   
    	   html+=" and school='"+school+"'"; 

    }
       if(!teacher.equals("")){	   
    	   html+=" and teacher='"+teacher+"'"; 

    }
       if(!fromyear.equals(""))
          html+=" and fromyear='"+fromyear+"'";
       if(!toyear.equals(""))
    	   html+=" and toyear='"+toyear+"'";
       if(!community.trim().equals("all"))
    	   html+=" and communityname='"+community+"'";
       List<Project> projects=userService.searchproject(html);
       model.addObject("projects",projects);
       model.setViewName("Browse");
       return model;
       
}
    
    @RequestMapping(value="/searchthread")
    public ModelAndView searchthread()
    {   
    	ModelAndView model=new ModelAndView("searchthread");
    	return model;
    }
    
    @RequestMapping(value="/searchthread",method=RequestMethod.POST)
    public ModelAndView searchthread(HttpServletRequest request) throws SQLException{
    	
    	ModelAndView model=new ModelAndView();
    	String name=request.getParameter("name");
    	String author=request.getParameter("author");
    	String project=request.getParameter("project");
    	
    	if(name==null)
    		name="";
    	if(author==null)
    		author="";
    	if(project==null)
    		project="";
    	
    	String html="";
    		
    		html="from Thread where threadfocus like '%"+name+"%'";
    	
    
    	

       if(!author.equals("")){	   
    	   html+=" and author='"+author+"'"; 

    }
       if(!project.trim().equals("all")){	   
    	   html+=" and projectname='"+project+"'"; 

    }
 
       List<Thread> thread=userService.searchthread(html);
       model.addObject("threads",thread);
       model.setViewName("searchthread");
       return model;
       
}
    
    @RequestMapping(value="/getprojectname")
    @ResponseBody
    public List<String> getprojectname() throws SQLException
    {   String html="from Project";
    	List<Project> list=userService.searchproject(html);
    	List<String> projectname=new ArrayList<String>();
    	for(int i=0;i<list.size();i++)
    	{ projectname.add(list.get(i).getProjectname());}
    	return projectname;
    	
    }
    
    
    @RequestMapping(value="/whetherlike")
    @ResponseBody
    public List<String> getwhetherlike(HttpServletRequest request, HttpSession session) throws SQLException
       
    {   String userid=(String)session.getAttribute("id");
    	String threadname=(String)request.getParameter("thread");
    	System.out.println("this aaais "+ threadname);
    	return userService.checklike(Integer.parseInt(userid),threadname);
    	
    }
    
    @RequestMapping(value="/likeme")
    public ModelAndView insertlike(HttpServletRequest request,HttpSession session) throws SQLException{
    	String userid=(String)session.getAttribute("id");
     	String threadname=(String)request.getParameter("threadname");
     	ModelAndView model=new ModelAndView("threadpage");
     	Likeq lik=new Likeq();
     	lik.setUserid(Integer.parseInt(userid));
     	lik.setThread(threadname);
     	userService.insertlik(lik);
     	model.addObject("threadname", threadname);
     	return model;
    }
    
    @RequestMapping(value="/dislikeme")
    public ModelAndView dellike(HttpServletRequest request,HttpSession session) throws SQLException{
    	 
 	    String userid=(String)session.getAttribute("id");
     	String threadname=(String)request.getParameter("threadname");
     	ModelAndView model=new ModelAndView("threadpage");
     	Likeq lik=new Likeq();
     	lik.setUserid(Integer.parseInt(userid));
     	
     	lik.setThread(threadname);
     	userService.deletelik(lik);
     	model.addObject("threadname", threadname);
     	return model;
    }
    
    @RequestMapping(value="/likelist")
    public ModelAndView listlike(HttpServletRequest request,HttpSession session) throws SQLException{
    	String threadname=(String)request.getParameter("threadname");
    	ModelAndView model=new ModelAndView("listlike");
    	List<Likeq> list=userService.listlike(threadname);
    	List<Student> student=new ArrayList<Student>();
    	for(int i=0;i<list.size();i++){
    		
    		student.add(userService.listuserService(list.get(i).getUserid()));
    	}
    	model.addObject("listlike", student);
    	return model;
    }
    
    @RequestMapping(value="/follow")
    public ModelAndView follow(HttpServletRequest request,HttpSession session) throws SQLException{
    	 
  	  String userid=(String)session.getAttribute("id");
  	  String threadname=(String)request.getParameter("threadname");
  	   Follow follow=new Follow();
  	   follow.setUserid(Integer.parseInt(userid));
  	   
  	   follow.setFollowname(threadname);
  	   follow.setIsthread("true");
  	   userService.insertfollow(follow);
  	   
  	   ModelAndView model=new ModelAndView("threadpage");
  	   model.addObject("threadname", threadname);
  	   return model;
  		
  	   
    }
    
    
    @RequestMapping(value="/checkfollow")
    @ResponseBody
    public String getcheckfollow(HttpServletRequest request, HttpSession session) throws SQLException
       
    {   //String password=(String)session.getAttribute("password");
	    String userid=(String)session.getAttribute("id");
    	String threadname=(String)request.getParameter("thread");
    	
    	return userService.checkfollow(Integer.parseInt(userid), threadname);
    	
    }
    
    @RequestMapping(value="/checkadopt")
    @ResponseBody
    public String checkadopt(HttpServletRequest request, HttpSession session) throws SQLException
    
    {   
	    String userid=(String)session.getAttribute("id");
    	String threadname=(String)request.getParameter("thread");
    	String community=(String) request.getParameter("community");
    	String reason=(String)request.getParameter("reason");
    	return userService.checkadopt(Integer.parseInt(userid), threadname,community);
    	
       
    }
  
    
    @RequestMapping(value="/insertadopt",method=RequestMethod.POST)
    public ModelAndView insertadopt(HttpServletRequest request,HttpSession session) throws SQLException{
    	String userid=(String)session.getAttribute("id");
    	String threadname=(String)request.getParameter("threadname");
    	String reason=(String)request.getParameter("reason");
    	String community=(String) request.getParameter("community");
    	Adopt adopt=new Adopt();
    	adopt.setUserid(Integer.parseInt(userid));
    	adopt.setReason(reason);
    	adopt.setThreadname(threadname);
    	adopt.setCommunity(community);
    	userService.insertadopt(adopt);
    	
    	ModelAndView model=new ModelAndView("Adopt");
    	model.addObject("from",threadname+" has been recommended to '" +community+" 'community");
    	model.addObject("threadname", threadname);
    	return model;
    }
    
    @RequestMapping(value="/adopt")
    public ModelAndView adopt(HttpServletRequest request,HttpSession session) throws SQLException{
    	ModelAndView model=new ModelAndView("Adopt");
        model.addObject("threadname",(String)request.getParameter("threadname"));
        return model;
    }
    @RequestMapping(value="/collect")
    public ModelAndView collect(HttpServletRequest request,HttpSession session) throws SQLException{
    	ModelAndView model=new ModelAndView("Collect");
        model.addObject("threadname",(String)request.getParameter("threadname"));
        return model;
    }
    @RequestMapping(value="/insertcollect",method=RequestMethod.POST)
    public ModelAndView insertcollect(HttpServletRequest request,HttpSession session) throws SQLException{
    	String userid=(String)session.getAttribute("id");
    	String threadname=(String)request.getParameter("threadname");
    	String reason=(String)request.getParameter("reason");
    	String community=(String) request.getParameter("community");
    	Collect collect=new Collect();
    	collect.setUserid(Integer.parseInt(userid));
    	collect.setThreadname(threadname);
    	collect.setCommunity(community);
    	collect.setReason(reason);
    	userService.insertcollect(collect);
    	ModelAndView model=new ModelAndView("Collect");
    	model.addObject("from",threadname+" has been recommended to '" +community+" 'community");
    	model.addObject("threadname", threadname);
    	return model;
    }
    
    @RequestMapping(value="/personal")
    public ModelAndView personal(HttpServletRequest reqeust,HttpSession session) throws SQLException{
    	String userid=(String)session.getAttribute("id");
    	String password=(String)session.getAttribute("password");
	    String username=(String)session.getAttribute("username");
	    String type=(String)session.getAttribute("type");
	    List<Likeq> list=userService.listmylikes(Integer.parseInt(userid));
	    List<Follow> folist=userService.listfollow(Integer.parseInt(userid));
	    List<Followupda> update=new ArrayList<Followupda>();
	    
	    for(int i=0;i<folist.size();i++)
	    {  if(userService.searchthreadupdate(folist.get(i).getFollowname())!=null)
	    	update.add(userService.searchthreadupdate(folist.get(i).getFollowname()));
	    }
	    List<String> name=new ArrayList<String>();
	    if(type.equals("teacher"))
	    {
	    	List<Community> listco=conservice.listservice(username);
	    	for(int i=0;i<listco.size();i++)
	    	{
	    		name.add(listco.get(i).getCommunity_name());
	    	}
	    }
	    else
	    {
	    	name=userService.getcommunitybyuserid(Integer.parseInt(userid));
	    }
	    //List<Community> listco=conservice.listservice(username);
	    List<Adopt> adopt=new ArrayList<Adopt>();
	    for(int i=0;i<name.size();i++){
	    	 List<Adopt> listdaod=userService.findaoptbycommunity(name.get(i));
	    	 for(int j=0;j<listdaod.size();j++)
	    	 {
	    		 adopt.add(listdaod.get(j));
	    	 }
	    }
	    List<Mycollection> collect=userService.findcollectbyid(Integer.parseInt(userid));
	    
	    ModelAndView model=new ModelAndView("personal");
	    model.addObject("likelist", list);
	    model.addObject("update", update);
	    model.addObject("adopt", adopt);
	    model.addObject("collect",collect);
	    return model;
	    
    }
    
    @RequestMapping(value="/checkaoptaccept")
    @ResponseBody
    public String checkaoptaccept(HttpServletRequest request, HttpSession session) throws NumberFormatException, SQLException{
    	String userid=(String)session.getAttribute("id");
    	String threadname=(String)request.getParameter("thread");
    	return userService.checkmyadopt(Integer.parseInt(userid),threadname);
    }
    
    @RequestMapping(value="/insertmyadopt")
    public ModelAndView insertmyaopt(HttpServletRequest request, HttpSession session) throws SQLException{
    	String userid=(String)session.getAttribute("id");
    	String threadname=(String)request.getParameter("thread");
    	Myadopt my=new Myadopt();
    	my.setUserid(Integer.parseInt(userid));
    	my.setThread(threadname);
    	userService.insertmyadopt(my);
    	ModelAndView model=new ModelAndView("redirect:/userprofile");
    	return model;
    }
    
    @RequestMapping(value="/searchmyadopt")
    @ResponseBody
    public List<String> searchtmyaopt(HttpServletRequest request, HttpSession session) throws NumberFormatException, SQLException{
    	String userid=(String)session.getAttribute("id");
    	
    	return userService.searchmyadopt(Integer.parseInt(userid));
    	
    }
    
    @RequestMapping(value="/showcollection")
    public ModelAndView showcollection(HttpServletRequest request, HttpSession session)
    {
    	ModelAndView model=new ModelAndView("C_collect");
        String threadname=(String)request.getParameter("threadname");
        model.addObject("threadname", threadname);
        return model;
    }
    
    @RequestMapping(value="/searchcollection")
    @ResponseBody
    public List<String> searchcollection(HttpServletRequest request, HttpSession session) throws SQLException{
    	String userid=(String)session.getAttribute("id");
    	String threadname=(String)request.getParameter("threadname");
    	
    	List<Mycollection> list=userService.searchcollection(Integer.parseInt(userid));
    	List<String> st=new ArrayList<String>();
    	for(int i=0;i<list.size();i++){
    		if(userService.checkcoexsit(list.get(i).getId(),threadname))
    		{
    		   st.add(list.get(i).getCollectname());
    		}
    			
    	}
    	return st;
    }
    @RequestMapping(value="/listcollect")
    @ResponseBody
    public List<String> seearchcollection(HttpServletRequest request, HttpSession session) throws SQLException{
    	String userid=(String)session.getAttribute("id");
    	//String threadname=(String)request.getParameter("threadname");
    	
    	List<Mycollection> list=userService.searchcollection(Integer.parseInt(userid));
    	List<String> st=new ArrayList<String>();
    	for(int i=0;i<list.size();i++){
    		st.add(list.get(i).getCollectname());
    			
    	}
    	return st;
    }
    
    @RequestMapping(value="/collectinsert",method=RequestMethod.POST)
    public ModelAndView collectinsert(HttpServletRequest request, HttpSession session) throws  SQLException{
    	String userid=(String)session.getAttribute("id");
    	String threadname=(String)request.getParameter("threadname");
    	String newname=(String)request.getParameter("newname");
    	String collection=(String)request.getParameter("collection");
    	if(newname==null)
    		newname="";
    	System.out.println(newname);
    	if(collection==null)
    		collection="";
    	if(newname.equals(""))
    	{   
    	    int collectid=userService.getidbycollection(Integer.parseInt(userid),collection);
    	    col_thread col=new col_thread();
    	    col.setCollectid(collectid);
    	    col.setThread(threadname);
    		userService.insertcol_thread(col);
    		
    	}
    	else
    	{ 
    		Mycollection mycollection=new Mycollection();
    		mycollection.setUserid(Integer.parseInt(userid));
    		mycollection.setCollectname(newname);
    		userService.insertmycollection(mycollection);
    		int collectid=userService.getidbycollection(Integer.parseInt(userid),newname);
    	    col_thread col=new col_thread();
    	    col.setCollectid(collectid);
    	    col.setThread(threadname);
    		userService.insertcol_thread(col);
    		
    		
    	}
    	ModelAndView model=new ModelAndView("C_collect");
    	model.addObject("threadname", threadname);
    	model.addObject("message", threadname+"has been added into collection");
    	return model;
    	
    	
    }
    
    @RequestMapping(value="/mycollectthread")
    @ResponseBody
    public List<Combin> mycollectthread(HttpServletRequest request,HttpSession session) throws SQLException{
    	String collectname=(String)request.getParameter("collectid");
    	List<Combin> result=new ArrayList<Combin>();
    	List<String> threadlist= userService.findthreadbycollect(collectname);
    	for(int i=0;i<threadlist.size();i++){
    		Combin comb=new Combin();
    		comb.setThreadname(threadlist.get(i));
    		//System.out.println(threadlist.get(i));
    		List<String> ccc=userService.findprojectbythread(threadlist.get(i));
    		//System.out.println("ccc"+ccc.get(0));
    		comb.setProjectname(ccc.get(0));
    		comb.setCommunityname(ccc.get(1));
    		result.add(comb);
    		
    	}
    	return result;
    	
    }
    
    @RequestMapping(value="/getsimilarthread")
    @ResponseBody
    public List<String> getsimilarthread(HttpServletRequest request,HttpSession session) throws SQLException{
    	List<String> result=new ArrayList<String>();
    	String threadname=(String)request.getParameter("threadname");
    	String list=(String)request.getParameter("more");
    	System.out.println(list);
    	int more=Integer.parseInt(list);
    	List<String> strinname=userService.findallthread();
    	System.out.println("this.is"+threadname);
        String[] name=new String[strinname.size()];
        double[] namevalue=new double[strinname.size()];
        for(int i=0;i<strinname.size();i++){
        	name[i]=strinname.get(i); 
        	if(strinname.get(i).equals(threadname))
        		   namevalue[i]=-1;
        	else   
        		namevalue[i]=userService.getsimilarthread(threadname, strinname.get(i));
        	
        }
        //System.out.println(userService.getsimilarthread(threadname, threadname));
     for(int i=0;i<namevalue.length;i++) {
    	 System.out.println(name[i]+" "+namevalue[i]);
     }  
     int listindex=0;
     
     while(listindex<namevalue.length-1){
    	 double maxinde=0;
    	 int finalindex=-1;
     for(int i=0;i<namevalue.length;i++){
    	 if(namevalue[i]>=maxinde){
    		 finalindex=i;
    		 maxinde=namevalue[i];
    	 }
     }
     System.out.println(finalindex);
     result.add(name[finalindex]);
     namevalue[finalindex]=-1;
     listindex++;
     }
     List<String> finalresult=new ArrayList<String>();
     for(int i=more;i<result.size()&&i<more+2;i++){
    	 finalresult.add(result.get(i));
    	 
     }
     
     return finalresult;
    }
   
    @RequestMapping(value="/similarfindbar")
    public ModelAndView similarfindbar(HttpServletRequest request,HttpSession session) throws SQLException{
    	List<Combin> result=new ArrayList<Combin>();
    	String threadname=(String)request.getParameter("threadname");
    	List<String> strinname=userService.findallthread();
        String[] name=new String[strinname.size()];
        double[] namevalue=new double[strinname.size()];
        for(int i=0;i<strinname.size();i++){
        	name[i]=strinname.get(i); 
        	if(strinname.get(i).equals(threadname))
        		   namevalue[i]=-1;
        	else   
        		namevalue[i]=userService.getsimilarthread(threadname, strinname.get(i));
        	
        }
        //System.out.println(userService.getsimilarthread(threadname, threadname));
     for(int i=0;i<namevalue.length;i++) {
    	 System.out.println(name[i]+" "+namevalue[i]);
     }  
     int listindex=0;
     
     while(listindex<namevalue.length-1){
    	 double maxinde=0;
    	 int finalindex=-1;
     for(int i=0;i<namevalue.length;i++){
    	 if(namevalue[i]>=maxinde){
    		 finalindex=i;
    		 maxinde=namevalue[i];
    	 }
     }
     Combin combin=new Combin();
     combin.setThreadname(name[finalindex]);
     
     result.add(combin);
     namevalue[finalindex]=-1;
     listindex++;
     }
     ModelAndView mode=new ModelAndView("similar");
     mode.addObject("threadlist",result);
     return mode;
     
     
    
    }
    
    
    
    
    
    @RequestMapping(value="/morefunction")
    @ResponseBody
    public List<String> morefunction(HttpServletRequest request,HttpSession session) throws SQLException{
    	//String threadname=(String)request.getParameter("threadname");
    	List<String> result=userService.findallthread();
    	String list=(String)request.getParameter("more");
    	int more=Integer.parseInt(list);
    	System.out.println(more);
    	List<String> lre=new ArrayList<String>();
    	System.out.println(result.get(0));
    	lre.add(result.get(more));
    	lre.add(result.get(more+1));
    	return lre;
    }
    
    @RequestMapping(value="/listcollectcommunity")
    @ResponseBody
    public List<String> listcommunity(HttpServletRequest request,HttpSession session) throws SQLException{
    	//String threadname=(String)request.getParameter("threadname");
    	 String username=(String)session.getAttribute("username");
    	 List<String> result=conservice.findcommunitybyusername(username);
    	 System.out.println("how mand"+result.size());
     	return conservice.findcommunitybyusername(username);
    }
    
    @RequestMapping(value="/addition")
    public ModelAndView addtion() throws SQLException{
    	ModelAndView model=new ModelAndView();
    	model.setViewName("addition");
       return model;
    }
    @RequestMapping(value="/addition",method=RequestMethod.POST)
    public ModelAndView addtion1(HttpSession session,HttpServletRequest request) throws SQLException{
    	String[] threads=(String[])request.getParameterValues("threads");
    	String userid=(String)session.getAttribute("id");
    	String newname=(String)request.getParameter("collectname");
    	String dis=(String)request.getParameter("disc");
    	if(dis==null)
    		dis="";
    	Mycollection mycollection=new Mycollection();
		mycollection.setUserid(Integer.parseInt(userid));
		mycollection.setCollectname(newname);
		mycollection.setCollectdetail(dis);
		userService.insertmycollection(mycollection);
		int collectid=userService.getidbycollection(Integer.parseInt(userid),newname);
		for(int i=0;i<threads.length;i++)
	    {col_thread col=new col_thread();
	    col.setCollectid(collectid);
	    col.setThread(threads[i]);
		userService.insertcol_thread(col);}
    	ModelAndView model=new ModelAndView();
    	model.setViewName("redirect:/personal");
       return model;
    }
    
    @RequestMapping(value="/recomendcollect")
    public ModelAndView recocollectq(HttpServletRequest request,HttpSession session){
    	String collectname=(String)request.getParameter("collectname");
    	System.out.println("collect: "+collectname);
    	ModelAndView model=new ModelAndView();
    	model.setViewName("collectrecommend");
    	model.addObject("collectname", collectname);
    	return model;
    	
    }
    
    
    
    
    @RequestMapping(value="/recommendcollect",method=RequestMethod.POST)
    public ModelAndView recocollect(HttpServletRequest request,HttpSession session) throws SQLException{
    	String userid=(String)session.getAttribute("id");
    	String threadname=(String)request.getParameter("collectname");
    	String reason=(String)request.getParameter("reason");
    	String community=(String) request.getParameter("community");
    	Adopt adopt=new Adopt();
    	adopt.setUserid(Integer.parseInt(userid));
    	adopt.setReason(reason);
    	adopt.setThreadname(threadname);
    	adopt.setCommunity(community);
    	userService.insertadopt(adopt);
    	
    	ModelAndView model=new ModelAndView("collectrecommend");
    	model.addObject("from",threadname+" has been recommended to '" +community+" 'community");
    	model.addObject("collectname", threadname);
    	return model;
    }
    
    @RequestMapping(value="/findallthreadforcollection")
    @ResponseBody
    public List<String> findallthread(HttpSession session,HttpServletRequest request) throws SQLException{
    	List<String> strinname=userService.findallthread();
    	return strinname;
    }
    

    
    
    
}