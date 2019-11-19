/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp User
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

public class register extends HttpServlet {
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/db";
    String DB_USERNAME = "root";
    String DB_PASSWORD = "21071993";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
	
        String username = request.getParameter("uname");
        String fullname = request.getParameter("fname");
        String email = request.getParameter("email");
        String pass = request.getParameter("psw");
        
        try {
        
            // loading drivers for mysql
                Class.forName("com.mysql.jdbc.Driver");
 
            Connection con = DriverManager.getConnection(DB_CONNECTION_URL, DB_USERNAME, DB_PASSWORD);
             
            PreparedStatement ps = con.prepareStatement ("insert into user(uname,fname,email,psw) values(?,?,?,?)");

            ps.setString(1, username);
            ps.setString(2, fullname);
            ps.setString(3, email);
            ps.setString(4, pass);
            int i = ps.executeUpdate();
            
            if(i > 0) {
                //out.println("You are sucessfully registered");
                response.sendRedirect("success.html");
            }
            else{
                response.sendRedirect("error.html");
            }
        
        }
        catch(Exception se) {
            se.printStackTrace();
        }
    }
    
   
    public void persist(Object object) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("WebApplication2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
    try {
        em.persist(object);
        em.getTransaction().commit();
    } catch (Exception e) {
        e.printStackTrace();
        em.getTransaction().rollback();
    } finally {
        em.close();
    }
}

    private Object assertThatExceptionOfType(Class<PersistenceException> aClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}