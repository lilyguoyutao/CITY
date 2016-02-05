<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<style>
ul.lilydropmenu {
 
 
}

ul.lilydropmenu li {
  display: block;
  position: relative;
  
 
}

ul.lilydropmenu li ul { display: none; }

ul.lilydropmenu li a {
  display: block;
 padding: 0.5em;

  text-decoration: none;

  
 
  
  
  
}
.lilydropmenu li:hover > ul {
  display: block;
  position: absolute;
}

.lilydropmenu li:hover li { float: none; }

ul.lilydropmenu  li:hover a { background: white; }

.lilydropmenu li:hover li a:hover { background:#A0A0A0; }

.lilydropmenu li ul li { border-top: 0; }

ul.lilydropmenu li a:hover { background:yellow; }
ul.lilydropmenu ul  {border-style: outset;margin-left:110px;padding-left:0px;margin-top:-40px;
 }

ul.lilydropmenu ul ul {
  width:150px;
  left: -5%;
  top: 0%;
  border-style: outset;
  padding-left:0px;
  margin-top:10px;
}
ul.lilydropmenu:before,
ul.lilydropmenu:after {
  content: " "; /* 1 */
  display: table; /* 2 */
}

ul.lilydropmenu:after { clear: both; }
</style>
</head>

</head>
<body>
<script>
$(document).ready(function () {
    
    $.ajax({
        type: 'Get',
        url: '/example/json',
        contentType : 'application/json',
        dataType: 'json',
        success: function (data) {
        	var text="<ul+ class='lilydropmenu'><li class='first'><a href='#'>"+data.firstname+"</a><ul ><li><a href='#'>HTML</a></li><li><a href='#'>CSS</a>";
        	
         $(text).appendTo("ul#melist") ;
        	
        },
        error:function() {  
          alert("");  
        }  

    });
});


</script>

<ul id="melist" style="list-style-type:none">
		<li ><a href="/example/userprofile" style="text-decoration:none">My profile</a></li>
		<li><input type="hidden"/></li>
        <li><a class="i" href="/example/listcommunity" style="text-decoration:none">My community</a></li>
        
        <li>
        
        <ul class="lilydropmenu">
        
        <li class="first">
        <a href="#">${community.community_name}</a>

        <ul >

              <li><a href="#">HTML</a></li>

              <li><a href="#">CSS</a>

                   <ul>

                       <li><a href="#">Resets</a></li>

                       <li><a href="#">Grids</a></li>

                       <li><a href="#">Frameworks</a></li>

                   </ul>

              </li>

             <li><a href="#">JavaScript</a>

                   <ul>

                       <li><a href="#">Ajax</a></li>

                       <li><a href="#">jQuery</a></li>

                  </ul>

             </li>
             <li style="clear:left"></li>

         </ul>
         </li>
       
         
      </ul>
      
     </li>
       
        
        
        
        
		<li><input type="hidden" style="clear:left"/></li>
		<li><a class="i" href="/example/community" style="clear:left">Create Community</a></li>
		<li><input type="hidden"/></li>
		
		</ul>
</body>
</html>