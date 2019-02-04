package user;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author hmz4ever
 */
@WebServlet(urlPatterns = {"/Login"})

public class Login extends HttpServlet {
    
  Dbconnect con = new Dbconnect();
     static final Logger logger = LogManager.getLogger(Login.class);
    
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

         try {

                                     HttpSession session = request.getSession();
                                     if (session.getAttribute("user") != null) {
                                         response.sendRedirect("home.jsp");
                                     }
                logger.info("Start login process");

             String dbEmail = null;
             String dbPassword=null;
            String _email = request.getParameter("email");
            String _password = request.getParameter("password");
            String sql = "select * from users where email=? and password=?";
           Connection connect = con.connect();
            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(sql);
            ps.setString(1, _email);
            ps.setString(2, _password);
            ResultSet rs = ps.executeQuery();
            PrintWriter out = response.getWriter();
            
            while( rs.next()) {
                dbEmail = rs.getString(2);
                dbPassword = rs.getString("password");
            }
            
            if ( _email.equals(dbEmail) && _password.equals(dbPassword)) {
			session.setAttribute("user", _email);
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
                                                            session.getId();
			Cookie loginCookie = new Cookie("user",_email);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30*60);
			response.addCookie(loginCookie);
			loginCookie.setMaxAge(30*60);
			response.addCookie(loginCookie);

                        response.sendRedirect("home.jsp");
                       logger.info("success logged in");
                       logger.info("the user with email "+_email +" logged in at " + LocalDateTime.now());

            }else {
                                              logger.error("a client failed to login at " + LocalDateTime.now());

             RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
             rd.include(request, response);
            
            }
            
            
        }catch (SQLException ex) {
                                   logger.fatal(ex.getMessage());

            //java.util.logging.Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
