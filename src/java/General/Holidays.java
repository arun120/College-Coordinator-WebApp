/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import dbconnection.dbcon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Home
 */
public class Holidays {

    String name;
    String dept;
    String batch;
    String from;
    String till;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTill() {
        return till;
    }

    public void setTill(String till) {
        this.till = till;
    }
   
    public boolean insert(){
        Connection conn=null;
       Statement stmt=null;
       int update=0;
       try{
           conn=new dbcon().getConnection(dept);
           stmt=conn.createStatement();
           
           String sql;
           sql="select * from holidays where name='"+name+"' and batch ='"+batch+"'";
           ResultSet rs=stmt.executeQuery(sql);
           if(rs.next()){
           update+=update(stmt);
           }else{
           sql="insert into holidays values('"+name+"','"+batch+"','"+from+"','"+till+"')";
       update+=stmt.executeUpdate(sql);
           }
     
       
       }catch(Exception e){
       e.printStackTrace();
       }finally{
           try {
               if(stmt!=null)
                   stmt.close();
               if(conn!=null)
                   conn.close();
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
       
       }
       if(update==1)
           return true;
       else
           return false;
    }
    
    public int update(Statement stmt) throws SQLException{
        
        return stmt.executeUpdate("update holidays set from='"+from+"',till='"+till+"' where batch ='"+batch+"' and name='"+name+"'");
    
    }

    
}
