<%-- 
    Document   : register
    Created on : Feb 4, 2019, 12:02:33 PM
    Author     : hmz4ever
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        
          <div align="center">
        <br>
        <br>
        <br>
        <h1>Create an account  </h1>
        <form name="register" action="UserServlet" method="POST">
            <table border="0">
              
                <tbody>
                    <tr>
                        <td>Email :</td>
                        <td><input type="text" name="email" value="" size="25"  placeholder="Enter your email"  height="10" required="true"/></td>
                    </tr>
                    <tr>
                        <td>Password :</td>
                        <td><input type="password" name="password" value="" size="25" placeholder="Enter your password" required="true" /></td>
                    </tr>
                </tbody>
            </table>
            <br>
            <div style="margin : 0px">
            <input  style="margin-right: 10px"type="reset" value="Reset" name="reset" />
            <input type="submit" value="New Account" name="register" />
           </div>
        </form>
        <br>
                    <a  style="margin-left: 0px;padding-left: 0px" href="index.jsp">I have already an account  ?</a>

    </div>
        
  
        
    </body>
</html>
