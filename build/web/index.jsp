<%-- 
    Document   : index
    Created on : Feb 4, 2019, 2:04:16 AM
    Author     : hmz4ever
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test</title>
    </head>
    
    <div align="center">
        <br>
        <br>
        <br>
        <h1>Login </h1>
        <form name="login" action="Login" method="POST">
            <table border="0">
              
                <tbody>
                    <tr>
                        <td>Email :</td>
                        <td><input type="text" name="email" value="" size="25"  placeholder="Enter your email"  height="10"/></td>
                    </tr>
                    <tr>
                        <td>Password :</td>
                        <td><input type="password" name="password" value="" size="25" placeholder="Enter your password" /></td>
                    </tr>
                </tbody>
            </table>
            <br>
            <input style="margin-right:  10px" type="reset" value="Reset" name="reset" />
            <input type="submit" value="Login" name="login" />

        </form>
        <br>
                    <a href="register.jsp">Need new account ?</a>

    </div>
    
    <%
    Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("user")){
  	                         response.sendRedirect("home.jsp");

    		}
    		cookie.setMaxAge(0);
    		response.addCookie(cookie);
    	}
    	}
    %>
    
    
    
</html>
