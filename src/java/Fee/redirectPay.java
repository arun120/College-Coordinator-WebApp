/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Home
 */
public class redirectPay extends HttpServlet {

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
            out.println("<title>Servlet redirectPay</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet redirectPay at " + request.getContextPath() + "</h1>");
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
       // processRequest(request, response);
       
       String mode=request.getParameter("mode");
       String munum=request.getParameter("munumber");
       MUResponse mu=(MUResponse) request.getSession().getAttribute("MUResponse");
       
       if(mode.equals("offline")){
       request.getRequestDispatcher("/student/Challan.jsp").forward(request, response);
       }else if(mode.equals("indianbank")){
       String url="https://www.indianbank.net.in/servlet/ibs.servlets.IBSMultiUtilityServlet?HandleID=H_MULTIUTILTY_PAY&ref_number=" + mu.getRefno() + "&RUrl="+"https://" + request.getServerName()+"/receiveIBResponse";
       RequestDispatcher rd=request.getRequestDispatcher("/sendPost.jsp?RUrl="+(url).replace("&", "%26").replace(" ", "%20"));
        rd.forward(request, response);
       }
       else if(mode.equals("others")){
       
           TechProcess tp=new TechProcess();
           tp.setUser("SJIT");
      tp.setAmount(mu.getTotalamt());
      tp.setCustID(mu.getRollno());
      tp.setRefno(mu.getRefno());
      tp.setReturnURL("https://" + request.getServerName()+"/receiveTechProcessResponse");
      request.getSession().setAttribute("TPRequest", tp);
      response.sendRedirect(tp.getRedirectURL());
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
