<%-- 
    Document   : Editallocatedsubjects
    Created on : Jan 30, 2016, 11:13:14 AM
    Author     : Divya Sri
--%>

<%@page import="com.action.Find"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="dbconnection.dbcon"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<% 
   try
    {
    String username = session.getAttribute("username").toString();
    String password = session.getAttribute("password").toString();
    
    Connection connn = new dbcon().getConnection("login");
    Statement sttt = connn.createStatement();
    String type1 ="";
    ResultSet rsss = sttt.executeQuery("select * from other_login_details where id='"+username+"' and password='"+password+"'");
    if(rsss.isBeforeFirst())
    {
        while(rsss.next())
        {
            type1 = rsss.getString("type");
        }
        if(type1.equals("dept"))
        {
    
    
    %>

    
    
    <head>
        <style>
        .omega
        {
        mso-page-orientation:landscape;
        }
    </style>
    <style>
        table.bordered {
    *border-collapse: collapse; /* IE7 and lower */
    border-spacing: 0;
    width:70%;
    overflow-x : auto; 
    background: #ffffff
}
table.bordered1 {
    *border-collapse: collapse; /* IE7 and lower */
    border-spacing: 0;
    width: 100%; 
    height: 170px;
    overflow-x : auto; 
    background: #ffffff
}
.bordered1 td, .bordered1 th {
   
    
    text-align: left;    
}


.bordered {
    border: solid #ccc 1px;
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    -webkit-box-shadow: 0 1px 1px #ccc; 
    -moz-box-shadow: 0 1px 1px #ccc; 
    box-shadow: 0 1px 1px #ccc;         
}

.bordered tr:hover {
    background: #fbf8e9;
    -o-transition: all 0.1s ease-in-out;
    -webkit-transition: all 0.1s ease-in-out;
    -moz-transition: all 0.1s ease-in-out;
    -ms-transition: all 0.1s ease-in-out;
    transition: all 0.1s ease-in-out;     
}    
    
.bordered td, .bordered th {
    border-left: 1px solid #ccc;
    border-top: 1px solid #ccc;
   
    padding: 10px;
    text-align: left;    
}

.bordered th {
    background-color: #dce9f9;
    background-image: -webkit-gradient(linear, left top, left bottom, from(#ebf3fc), to(#dce9f9));
    background-image: -webkit-linear-gradient(top, #ebf3fc, #dce9f9);
    background-image:    -moz-linear-gradient(top, #ebf3fc, #dce9f9);
    background-image:     -ms-linear-gradient(top, #ebf3fc, #dce9f9);
    background-image:      -o-linear-gradient(top, #ebf3fc, #dce9f9);
    background-image:         linear-gradient(top, #ebf3fc, #dce9f9);
    -webkit-box-shadow: 0 1px 0 rgba(255,255,255,.8) inset; 
    -moz-box-shadow:0 1px 0 rgba(255,255,255,.8) inset;  
    box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;        
    border-top: none;
    text-shadow: 0 1px 0 rgba(255,255,255,.5); 
}

.bordered td:first-child, .bordered th:first-child {
    
}

.bordered th:first-child {
    -moz-border-radius: 6px 0 0 0;
    -webkit-border-radius: 6px 0 0 0;
    border-radius: 6px 0 0 0;
}

.bordered th:last-child {
    -moz-border-radius: 0 6px 0 0;
    -webkit-border-radius: 0 6px 0 0;
    border-radius: 0 6px 0 0;
}

.bordered th:only-child{
    -moz-border-radius: 6px 6px 0 0;
    -webkit-border-radius: 6px 6px 0 0;
    border-radius: 6px 6px 0 0;
}

.bordered tr:last-child td:first-child {
    -moz-border-radius: 0 0 0 6px;
    -webkit-border-radius: 0 0 0 6px;
    border-radius: 0 0 0 6px;
}

.bordered tr:last-child td:last-child {
    -moz-border-radius: 0 0 6px 0;
    -webkit-border-radius: 0 0 6px 0;
    border-radius: 0 0 6px 0;
}
</style>
<div class='omega'>
    <center> <h1>St.Joseph's Institute of Technology</h1></center>
    </head>
    <body><center>
        <%
            String a = request.getParameter("word");
            if(a!=null)
            {
            if(a.equals("yes"))
            {
                String formName = "";
                        formName = "test.doc";
                        File filepath = new File(formName);
                        response.setContentType("application/vnd.ms-word");
                        response.setHeader("Content-Disposition", "inline; filename=" + filepath);
            }
            }
            int totalhrs=0 ;
            String id=request.getParameter("staff");
            String acyear = request.getParameter("acyear");
            if(id!=null)
            {
            if(id.equals("all"))
            {
                
                
                %>
                <center><h1>Department of CSE</h1></center>
                <br>
                
                <center><b>Subject Allotment <%=acyear%></b></center>
                <br>
                <table class="bordered" name='suballoc'>
                    <tr>
                        <th>NAME OF THE STAFF</th>
                        <th> THEORY </th>
                        
                        
                        <th>THEORY HRS</th>
                        <th>LAB </th>
                        
                        <th>LAB HRS</th>
                  
                    </tr>
                    
                
                
                <%
                Connection con=new dbcon().getConnection(Find.dept(username)); 
                 Statement st = con.createStatement();
                 ResultSet rs1 = st.executeQuery("select * from staff_table");
                 Statement st1 = con.createStatement();
                 Statement st2 = con.createStatement();
                
                 while(rs1.next())
                 {
                     int count1=0,count2=0,sp=0;
                     String staffid = rs1.getString("staffid").toString();
                     String staffname = rs1.getString("staffname").toString();
                     String sql="";
                     if(request.getParameter("sem").equals("Even"))
                         sql="select * from subject_allocation where staffid='"+staffid+"' and subtype='theory' and acyear='"+acyear+"' and (sem like '02' or sem like '04' or sem like '06' or sem like '08')";
                     else
                         sql="select * from subject_allocation where staffid='"+staffid+"' and subtype='theory' and acyear='"+acyear+"' and (sem like '01' or sem like '03' or sem like '05' or sem like '07')";
                     
                      ResultSet rs2 = st1.executeQuery(sql);
                     while(rs2.next())
                     {
                        count1++; 
                     }
                     
                     if(request.getParameter("sem").equals("Even"))
                     sql="select * from subject_allocation where staffid='"+staffid+"' and subtype='lab' and acyear='"+acyear+"' and (sem like '02' or sem like '04' or sem like '06' or sem like '08')";
                     else
                     sql="select * from subject_allocation where staffid='"+staffid+"' and subtype='lab' and acyear='"+acyear+"' and (sem like '01' or sem like '03' or sem like '05' or sem like '07')";
                         
                     ResultSet rs3=st2.executeQuery(sql); 
                     while(rs3.next())
                      {
                          count2++;
                      }
                      if(count1>=count2)
                      {
                          sp=count1;
                      }
                      else
                      {
                          sp=count2;
                      }
                      rs2.beforeFirst();
                      rs3.beforeFirst();
                     totalhrs=0;
                     %>
                     <tr>
                         <td rowspan="<%=sp%>">
                         <%=staffname%>
                     </td>
                     
                         
                             
                        
                     
                     <%
                     int i=0;
                  String subcode,dept,sec,sem,hrs="",subcode1="",dept1="",sec1="",sem1="",hrs1="";
                     while(i<sp)
                     {
                         if(rs2.next())
                         {
                            
                          subcode=rs2.getString("subcode");
                          dept = rs2.getString("dept");
                          sec = rs2.getString("sec");
                          sem = rs2.getString("sem");
                         hrs= rs2.getString("no_of_hours");
                          if(hrs==null)
                             hrs="0";
                         totalhrs = totalhrs+Integer.parseInt(hrs);
                         }
                         else
                         {
                             subcode=" ";
                             dept= " ";
                             sec= " ";
                             sem= " ";
                             hrs= " ";
                                    
                         }
                        
                         if(rs3.next())
                         {
                             
                          subcode1=rs3.getString("subcode");
                         dept1 = rs3.getString("dept");
                         sec1 = rs3.getString("sec");
                         sem1 = rs3.getString("sem");
                         hrs1= rs3.getString("no_of_hours");
                         if(hrs1==null)
                             hrs1="0";
                         totalhrs = totalhrs+Integer.parseInt(hrs1);
                         }
                         else
                         {
                             subcode1=" ";
                             dept1= " ";
                             sec1= " ";
                             sem1= " ";
                             hrs1= " ";
                         }
                         
                         %>
                         
                         <%
                        
                        
                         %>
                         <% if(!subcode.equals(" "))
                         {
                             
                         %>
                         <td><%=subcode%> (<%=sem%> SEM) (<%=dept%>-<%=sec%>)</td>
                         <td><%=hrs%></td>
                        <% }else{%>
                        <td>----</td><td>----</td> <%}%>
                         <% if(!subcode1.equals(" "))
                         {
                             
                         %>
                         <td><%=subcode1%> (<%=sem1%> SEM) (<%=dept1%>-<%=sec1%>)</td>
                         <td><%=hrs1%></td>
                         <% }else{%>
                       <td>----</td><td>----</td> <%}%>
                      
                         </tr>
                         <%
                     i++;
                     }              
                 }
                 
                            if(st!=null)
                            st.close();
                              if(con!=null)
                                con.close();

                            if(st1!=null)
                            st1.close();
                              if(con!=null)
                                con.close();
                %>
                </table>
                <%
            }
            
            else
            {
            
            
            
            
            %>
        <table class="bordered">
            <form action="${pageContext.request.contextPath}/deletesub" method="post">
            <tr>
                <th><center>DELETE</center></th>
                <th><center>BATCH</center></th>
        <th><center>SEM</center></th>
<th><center>DEPARTMENT</center></th>
<th><center>SECTION</center></th>
<th><center>SUBJECT CODE</center></th>
<th><center>SUBJECT NAME</center></th>
        </tr>
            
            <%
           
            Connection con=new dbcon().getConnection(Find.dept(username));
            Connection con1= new dbcon().getConnection("sjitportal");
            Statement st = con.createStatement();
            Statement st1 = con1.createStatement();
            String sql="";
            
                     if(request.getParameter("sem").equals("Even"))
                         sql="select * from subject_allocation where staffid='"+id+"'  and acyear='"+acyear+"' and (sem like '02' or sem like '04' or sem like '06' or sem like '08')";
                     else
                         sql="select * from subject_allocation where staffid='"+id+"'  and acyear='"+acyear+"' and (sem like '01' or sem like '03' or sem like '05' or sem like '07')";
                     
            ResultSet rs1 = st.executeQuery(sql);
            ResultSet rs2;
            String batch,subcode,subname=null,dept,sec,sem;
            int i=1;
            while(rs1.next())
            {
                batch=rs1.getString("batch");
                sem=rs1.getString("sem");
                dept=rs1.getString("dept");
                subcode=rs1.getString("subcode");
                sec =rs1.getString("sec");
                rs2=st1.executeQuery("select subname from subject_table where subcode='"+subcode+"'" );
                while(rs2.next())
                {
                    subname=rs2.getString("subname");
                }
             %>
             <tr>
                 <td><input type="checkbox" name="delete" value='<%=acyear%>_<%=id%>_<%=batch%>_<%=sem%>_<%=dept%>_<%=subcode%>_<%=sec%>'/></td>    
             <td><%=batch%></td>
             <td><%=sem%></td>
             <td><%=dept%></td>
             <td><%=sec%></td>
             <td><%=subcode%></td>
             <td><%=subname%></td>
             </tr>
             <%
             i++;
            }
                            if(st!=null)
                            st.close();
                              if(con!=null)
                                con.close();

                            if(st1!=null)
                            st1.close();
                              if(con1!=null)
                                con1.close();
            
            %>
           </table>
           <br>
           
           <br>
           <%
           int wflag=0;
              String work="",wsql;
                     con=new dbcon().getConnection(Find.dept(username));
                    wsql="select a.works as other from other_incharge a where a.staffid='"+id+"' and a.acyear='"+acyear+"' and a.semister='"+request.getParameter("sem")+"'";
                    Statement wstmt=con.createStatement();
                    ResultSet wrs=wstmt.executeQuery(wsql);
                    if(wrs.next())
                     work+=wrs.getString("other");
                    
                  
                    wsql="select * from councillor where staffid='"+id+"' and academicyr='"+acyear+"' and semister='"+request.getParameter("sem")+"'";
                     wrs=wstmt.executeQuery(wsql);
                     
                     if(wrs.next()){
                         if(!work.endsWith(","))
                             work+=",";
                         
                         work+="Councillor("+wrs.getString("batch")+"-"+wrs.getString("dept")+"-"+wrs.getString("sec")+")";
                         
                     }else if(work.endsWith(","))
                         work=work.substring(0, work.length()-1);
                     
                     if(wstmt!=null)
                         wstmt.close();
                         if(con!=null)
                            con.close();
                         
            if(!work.equals(""))
            {
           %>
           <table class="bordered">
                   <input type="hidden" name="acyear" value="<%=acyear%>">
               
               <input type="hidden" name="semister" value="<%=request.getParameter("sem")%>">
               
               
               <input type="hidden" name="staffid" value="<%=id%>">
            <tr>
                <th><center>DELETE</center></th>
                <th><center>INCHARGE</center></th>
             </tr>
             <tr>
                 <td><input type="checkbox" name="incharge" value='yes'/></td>
                 <td><%=work%></td>
             </tr>
           </table>
        <%}%>
           
           <br><br>
           <center><input type="submit" value="Delete" name="del" /></center>
            </form>
            
    </center>
            <% 
                   
                
                           
                           
                           
                           }
            }%>
         
    </body>
</div>
    <%
    }
        else
    {
        response.sendRedirect("../index.jsp");
    }
    }
    else
    {
        response.sendRedirect("../index.jsp");
    }

                            if(sttt!=null)
                            sttt.close();
                              if(connn!=null)
                                connn.close();
    }
catch(Exception e)
    {
        e.printStackTrace();
        response.sendRedirect("../index.jsp");
    }
    
    %>
</html>