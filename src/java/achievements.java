/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.action.Find;
import dbconnection.dbcon;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
public class achievements extends HttpServlet {

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
            out.println("<title>Servlet achievement</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet achievement at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        //processRequest(request, response);
        PrintWriter out=response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet achievement</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet achievement</h1>");
            out.println("<h1>Servlet achievement</h1>");
            out.println("<h1>Servlet achievement</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
        String category=request.getParameter("cat");
        String colg=request.getParameter("colg");
        String event=request.getParameter("event");
        String date=request.getParameter("datepicker");
        String pos=request.getParameter("pos");
        String prize=request.getParameter("prize");
        String quantity=request.getParameter("quantity");
        
        String roll=request.getSession().getAttribute("username").toString();       
        
       Connection con=null,con1=null;
       Statement stmt=null,stmt1=null;
       
       try{
              con=new dbcon().getConnection("cse");
                stmt=con.createStatement();
                con1=new dbcon().getConnection("login");
                stmt1=con1.createStatement();
                String sql="INSERT INTO `achievements` (`rollno`, `category`, `college`, `event`, `date`, `position`, `prize`, `quantity`) VALUES ('"+roll+"', '"+category+"', '"+colg+"', '"+event+"', '"+date+"', '"+pos+"', '"+prize+"', '"+quantity+"');";
                stmt.executeUpdate(sql);
                /*
                ResultSet rs=stmt1.executeQuery(sql);
                if(rs.next())
                {
                }else{
                  response.sendRedirect("admin/staffdeleted.jsp?msg=Some Error Occured!!Staff Not Found");
                }
                */
       }catch(Exception e)
       {
           e.printStackTrace();
       }finally{
            try{
                if(stmt!=null)
                    stmt.close();
                if(con!=null)
                    con.close();
                if(stmt1!=null)
                    stmt1.close();
                if(con1!=null)
                    con1.close();
            
                }catch(Exception e){
                e.printStackTrace();
                }
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
