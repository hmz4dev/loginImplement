<%-- 
    Document   : home
    Created on : Feb 4, 2019, 12:53:17 PM
    Author     : hmz4ever
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
         <%
             //invalidate the session if exists
    	 session = request.getSession(false);
    	if(session == null){
    		session.invalidate();
                //no encoding because we have invalidated the session
    	response.sendRedirect("../index.jsp");
    	}
    	
   String email = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) email = cookie.getValue();
}
}
if(email == null) response.sendRedirect("../index.jsp");

    %>
        <style>
          ul {
  list-style: none;
  text-align: center;
  padding: 0;
  margin: 0;
}
 li {
  font-family: 'Oswald', sans-serif;
  font-size: 1.2em;
  line-height: 40px;
  height: 40px;
  border-bottom: 1px solid #888;
}
        </style>
    </head>
    <body>

        <ul>
           
            <li> <%=email%></li>
            <li>
       <a href="Logout">Logout</a>
        
  </li>
</ul>
            
       
        <div align="center">
        <h1>Home page </h1>

        </div>
    </body>
</html>
