/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dbconnection.dbcon;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aravind
 */
public class updatemodeltype extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet markupdate</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet markupdate at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             response.setContentType("");
            HttpSession session = request.getSession();
            String[] regno = new String[80];
            
            
            regno = request.getParameterValues("id");
            String dept = session.getAttribute("dept").toString();
            Connection  con = new dbcon().getConnection(dept);
  
         
            Statement st1=null;
            ResultSet rs1=null;
            st1 = con.createStatement();
            
            
            for(int i =0;i<=regno.length;i++)
            {
                            
            String sql1 = "update student_personal set model_type ='spl' where regno = '"+regno[i]+"'" ;
             
            st1.executeUpdate(sql1);
            
           
           
            }
            response.getWriter().printf("<center><h1>UPDATE</h1></center>");
             if(st1!=null)
                            st1.close();
                              if(con!=null)
                                con.close();
        } catch (Exception ex) {
            response.getWriter().print(ex);
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            HttpSession session = request.getSession();
            PrintWriter out=response.getWriter();
            
            String[] regno = request.getParameterValues("id");
            
            
            String dept = session.getAttribute("dept").toString();
            Connection  con = new dbcon().getConnection(dept);
  
         
            Statement st1=null;
            ResultSet rs1=null;
            st1 = con.createStatement();
          
            out.println("Hello");
            for(int i =0;i<regno.length;i++)
            {
                            
                String sql = "update student_personal set model_type='gen'";
                String sql1 = "update student_personal set model_type ='spl' where regno = '"+regno[i]+"'" ;
             
            st1.executeUpdate(sql);
            st1.executeUpdate(sql1);
            
           
           
            }
            response.getWriter().printf("updated");
            
        } catch (Exception ex) {
            response.getWriter().print(ex);
        }
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}