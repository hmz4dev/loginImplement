package user;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;






/**
 *
 * @author hmz4ever
 */
@WebServlet(urlPatterns = {"/UserServlet"})

public class UserServlet extends HttpServlet {
    

    Dbconnect con = new Dbconnect();
    Logger logger= Logger.getLogger(UserServlet.class);

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

         try {
            String _email = request.getParameter("email");
            String _password = request.getParameter("password");
            String sql = "insert into users (email,password) values (?,?)";
            Connection connect = con.connect();
            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(sql);
            ps.setString(1, _email);
            ps.setString(2, _password);
            ps.executeUpdate();
            PrintWriter out = response.getWriter();
            out.print("you have successfuly add user");
            
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}


