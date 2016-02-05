package com.jcg.examples.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jcg.examples.dao.UserDao;
import com.jcg.examples.service.CommunityService;
import com.jcg.examples.service.UserService;
import com.jcg.examples.viewBean.Community;
import com.jcg.examples.viewBean.Stgroup;
import com.jcg.examples.viewBean.Student;
import com.jcg.examples.viewBean.st_com;
import com.jcg.examples.viewBean.usermore;

@Controller
public class Usercontroller {
	
	@Autowired
	private UserService userService;
	//private HibernateTemplate hibernateTemplate;
    @Autowired
    private CommunityService conservice;
	

	
	@RequestMapping(value="/addm",method=RequestMethod.POST)
	public ModelAndView addto(HttpServletRequest request, @ModelAttribute("stu")Student stu) throws SQLException
	{ 
	   ModelAndView model=new ModelAndView();
	   stu.setType("writer");
	   st_com st=new st_com();
	  
	   String community=(String)request.getParameter("community");
	   
	   //stu.setCommunity(community);
       if(userService.checkUserpass_service(stu.getUsername(), stu.getPassword(), "writer")>0)
       {
    	    int userid=userService.getIdbyname(stu.getUsername(),stu.getPassword(),"writer");
    	    st.setUserid(userid);
            st.setCommunity(community);
            userService.saveintost_com(st);
       }
       else
       {
    	   userService.saveStuService(stu);
    	   int userid=userService.getIdbyname(stu.getUsername(),stu.getPassword(),"writer");
    	    st.setUserid(userid);
            st.setCommunity(community);
            userService.saveintost_com(st);
       }
	   
	   System.out.println("communit is"+community);
	   model.setViewName("redirect:/listuser?coname="+community);
	   return model;
	}
	
	@RequestMapping(value="/addtogroupm",method=RequestMethod.POST)
	public ModelAndView addtogroup(HttpServletRequest request, @ModelAttribute("stu")Student stu) throws SQLException
	{ 
	   ModelAndView model=new ModelAndView();
	   stu.setType("writer");
	   Stgroup sgroup=new Stgroup();
	  
	   String groupid=(String)request.getParameter("groupid");
	   
	   //stu.setCommunity(community);
       if(userService.checkUserpass_service(stu.getUsername(), stu.getPassword(), "writer")>0)
       {
    	    int userid=userService.getIdbyname(stu.getUsername(),stu.getPassword(),"writer");
    	    sgroup.setGroup_id(Integer.valueOf(groupid));
    	    sgroup.setStudent_id(userid);
            userService.saveintostgroup(sgroup);
       }
       else
       {
    	   
       }
	   
	   model.setViewName("redirect:/groupuserlist?groupid="+groupid);
	   return model;
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView addt(HttpServletRequest request)
	{   String community=(String)request.getParameter("com_name");
	   ModelAndView model=new ModelAndView("Add");
	   model.addObject("community", community);
	   return model;
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView addq(HttpServletRequest res) 
	{   
	   
	   ModelAndView model=new ModelAndView("Add");
	   
       
       
       DiskFileItemFactory factory = new DiskFileItemFactory();
       ServletFileUpload upload = new ServletFileUpload(factory);
       
       List<FileItem> fileItems;
	try {
		fileItems = upload.parseRequest(res);
	
	
       factory.setSizeThreshold(4096);
       Iterator iter = fileItems.iterator();
       
       FileItem item = (FileItem) iter.next();
       String fileName = item.getName();
       String path = res.getSession().getServletContext().getRealPath("//");
       if (!item.isFormField()) {
         
               
               item.write(new File(path,fileName));

          
               
           }
       System.out.println(fileName);
       FileItem item2=(FileItem) iter.next();
       String com=(item2.getString());
       System.out.println(com);
       FileInputStream input;
	
		input = new FileInputStream(path+fileName);
	

       XSSFWorkbook wb;

		wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheetAt(0);
		System.out.println(sheet.getLastRowNum());
		   
		   
	       Row row;
	       for(int i=1; i<=sheet.getLastRowNum(); i++){
	       row = sheet.getRow(i);
	       
	    	   
	    	   String username="";
	    	   Cell cell0=row.getCell(0);
	           if(cell0.getCellType()==1)
	                { username=(cell0.getRichStringCellValue().getString());
                       }
	           else if( cell0.getCellType()==0)
	                {
                   int en=((int)cell0.getNumericCellValue());
                   username=String.valueOf(en);
                       }
               
               else
                   {username="";}
	           
	           String password="";
	    	   Cell cell1=row.getCell(1);
	           if(cell1.getCellType()==1)
	                { password=(cell1.getRichStringCellValue().getString());
                       }
	           else if( cell1.getCellType()==0)
	                {
                   int en=((int)cell1.getNumericCellValue());
                   password=String.valueOf(en);
                       }
               
               else
                   {password="";}
	           
	           String firstname="";
	           Cell cell2=row.getCell(2);
	           if(cell2.getCellType()==1)
               { firstname=(cell2.getRichStringCellValue().getString());
                  }
          else if( cell2.getCellType()==0)
               {
              int en=((int)cell2.getNumericCellValue());
              firstname=String.valueOf(en);
                  }
          
          else
              {firstname="";}
	           
	           
	           String secondname="";
	           Cell cell3=row.getCell(3);
	           if(cell3.getCellType()==1)
               { secondname=(cell3.getRichStringCellValue().getString());
                  }
          else if( cell3.getCellType()==0)
               {
              int en=((int)cell3.getNumericCellValue());
              secondname=String.valueOf(en);
                  }
          
          else
              {secondname="";}
	           
	           String school="";
	           Cell cell4=row.getCell(4);
	           if(cell4.getCellType()==1)
               { school=(cell4.getRichStringCellValue().getString());
                  }
          else if( cell4.getCellType()==0)
               {
              int en=((int)cell4.getNumericCellValue());
              school=String.valueOf(en);
                  }
          
          else
              {school="";}  
	           
	           
	           String email="";
	           Cell cell5=row.getCell(5);
	           if(cell5.getCellType()==1)
               { email=(cell5.getRichStringCellValue().getString());
                  }
          else if( cell5.getCellType()==0)
               {
              int en=((int)cell5.getNumericCellValue());
              email=String.valueOf(en);
                  }
          
          else
              {email="";}
	           
	           

	           Student student=new Student();
	           student.setUsername(username);
	           student.setPassword(password);
	           student.setFirstname(firstname);
	           student.setSecondname(secondname);
	           student.setSchool(school);
	           student.setEmail(email);
	           
	           student.setType("writer");
	           st_com st=new st_com();
	           
	           if(userService.checkUserpass_service(username, password, "writer")>0)
	           {
	        	    int userid=userService.getIdbyname(username,password,"writer");
	        	    if(!userService.checkst_com(userid,com))
	        	     {st.setUserid(userid);
		            st.setCommunity(com);
		            userService.saveintost_com(st);
	        	     }
	           }
	           else
	           {
	        	   userService.saveStuService(student);
	        	   int userid=userService.getIdbyname(username,password,"writer");
	        	    st.setUserid(userid);
		            st.setCommunity(com);
		            userService.saveintost_com(st);
	           }
	           
	           
	           
	           
	    	   
	       }
	       
	       
	   model.addObject("message", fileName+" has been added to community of "+com);
	   model.addObject("community", com);    
	      input.close();
	
	}catch (Exception e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
	}
       
       
     
	 
	   
	
       return model;
	}
	
	
	@RequestMapping(value="/listuser")
	public ModelAndView listuser(HttpServletRequest res,HttpSession session) throws SQLException
	{   String name=(String)res.getParameter("coname");
	    String type=(String)session.getAttribute("type");
	    if(name==null)
	    	name="";
	    List<Student> student=new ArrayList<Student>();
	    List<Integer> listint=userService.getUseridbycommunity(name);
	    for(int i=0;i<listint.size();i++)
		   student.add(userService.listuserService(listint.get(i)));
		
			
		ModelAndView model=new ModelAndView();
		if(type.equals("teacher")){
	    model.setViewName("Userlist");}
		else
		{model.setViewName("userlistforstu");}	
	    model.addObject("userlist", student);
	    model.addObject("coname",name);
	    return model;
		
		
		
	}
	
	@RequestMapping(value="/userprofile")
	public ModelAndView userprofile(HttpServletRequest request,HttpSession session) throws SQLException{
		String username=(String)session.getAttribute("username");
		if(username==null)
			username="";
		String password=(String)session.getAttribute("password");
		if(password==null)
			password="";
		String type=(String)session.getAttribute("type");
		if(type==null)
			type="";
		String message=(String)request.getParameter("message");
		if(message==null)
			message="";
		
		Student student=userService.userfile(username,password,type);
	   ModelAndView model=new ModelAndView("Userfile");
	   model.addObject("student",student);
	   model.addObject("message", message);
	   return model;
	}
	
	@RequestMapping(value="/head")
	public ModelAndView userhead(HttpSession session) throws SQLException{
		String type=(String)session.getAttribute("type");
		ModelAndView model=new ModelAndView();
		if(type.equals("writer"))
		{
			model.setViewName("tablehead");
		}
		else
		{model.setViewName("tablehead");}
		return model;
	}
	
	@RequestMapping(value="/download")
    public String download(ModelMap model,HttpServletRequest request) throws IOException, SQLException
    {
		String com=(String)request.getParameter("com");
		List<Student> student=new ArrayList<Student>();
	    List<Integer> listint=userService.getUseridbycommunity(com);
	    for(int i=0;i<listint.size();i++)
		   student.add(userService.listuserService(listint.get(i)));
		
        model.addAttribute("liststudent", student);
	    
	    return "userListExcel";
    }
	
	@RequestMapping(value="/changepass",method=RequestMethod.GET)
	public ModelAndView changepassword(HttpServletRequest request,HttpSession session) throws SQLException{
		ModelAndView model=new ModelAndView("changepass");
		return model;
		
	}
	
	@RequestMapping(value="/changepass", method=RequestMethod.POST )
	public ModelAndView changepass(HttpServletRequest request,HttpSession session) throws SQLException{
		String old=(String)request.getParameter("old");
		String new1=(String)request.getParameter("new1");
		String username=(String) session.getAttribute("username");
		String type=(String)session.getAttribute("type");
		ModelAndView model=new ModelAndView();
		if(userService.checkUserpass_service(username, old, type)>0)
		{
			userService.changepassservice(username,old,new1);
			model.addObject("message", "password change successfully, please re-login");
			model.setViewName("userlogin");
			session.removeAttribute("password");
			session.removeAttribute("iflogin");
			session.removeAttribute("username");
			session.removeAttribute("type");
			session.invalidate();
		
		}
		else
		{model.addObject("message", "password not correct");
		model.setViewName("changepass");
		}
		
		return model;
		
	}
	/*@RequestMapping(value="/jss")
	public ModelAndView get11json()
	{
		ModelAndView model=new ModelAndView("lala");
		
		return model;}
	
	@RequestMapping(value="/js")
	public ModelAndView get1json()
	{
		ModelAndView model=new ModelAndView("lala");
		model.addObject("lily", "guo");
		return model;}*/

	
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public ModelAndView edit(HttpServletRequest request,HttpSession session) throws SQLException{
		ModelAndView model=new ModelAndView();
		String username=(String)session.getAttribute("username");
		String type=(String)session.getAttribute("type");
		String password=(String)request.getParameter("password");
		String id=(String)session.getAttribute("id");
		int idd=Integer.parseInt(id);
		String newusername=(String)request.getParameter("user");
		String newfirstname=(String)request.getParameter("firstname");
		String newlastname=(String)request.getParameter("lastname");
		String newschool=(String)request.getParameter("school");
		String newemail=(String)request.getParameter("email");
		Student student=new Student();
		student.setSt_id(idd);
		student.setUsername(newusername);
		student.setFirstname(newfirstname);
		student.setSecondname(newlastname);
		student.setSchool(newschool);
		student.setEmail(newemail);
		student.setPassword(password);
		String message2="";
		if(type.equals("teacher")){
			student.setType("teacher");
			if(newusername.equals(username))
			{
				userService.edit(student);
				message2="profile has been changed successfully";
			}
			else{
			   List<String> list=conservice.findcommunitybyusername(username);
			   for(int i=0;i<list.size();i++)
			   {
				   conservice.updatecreator(list.get(i),newusername);
			   }
			    userService.edit(student);	
				session.removeAttribute("username");
			   session.setAttribute("username", newusername);
			   message2="username is beening changerd";
		}
		}	
		else{
			 
		}
			
			model.setViewName("redirect:/userprofile?message="+message2);
			return model;
	}
	
	
	@RequestMapping(value="/showinterestpage")
	public ModelAndView showpage(HttpServletRequest request,HttpSession session) throws SQLException{
		String userid=(String)session.getAttribute("id");
	    String interest=userService.showusermore(Integer.parseInt(userid));
	    ModelAndView model=new ModelAndView("interest");
	    model.addObject("interest", interest);
	    return model;
	}
	
	@RequestMapping(value="/insertinterest",method=RequestMethod.POST)
	public ModelAndView showpage1(HttpServletRequest request,HttpSession session) throws SQLException{
		
	    String userid=(String)session.getAttribute("id");
	    String interest=(String)request.getParameter("interest");
	    usermore user=new usermore();
	    user.setUserid(Integer.parseInt(userid));
	    
	    user.setInterest(interest);
	    userService.insertinterest(user);
	    ModelAndView model=new ModelAndView("interest");
	    model.addObject("interest", interest);
	    return model;
	}
	
	@RequestMapping(value="/similarbar")
	public ModelAndView similarbar(){
		ModelAndView model=new ModelAndView("similar");
		return model;
	}
	

}
