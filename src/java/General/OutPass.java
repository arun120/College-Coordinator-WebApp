/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import Actor.Student;
import com.action.Find;
import dbconnection.dbcon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Home
 */
public class OutPass {
    private String id;
    private String expiry;

    public OutPass(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpiry() {
        return expiry;
    }

    
    
      public boolean insert(String requestid){
        Connection conn=null;
       Statement stmt=null;
       int update=0;
       try{
           conn=new dbcon().getConnection("sjitportal");
           stmt=conn.createStatement();
           
           String sql="insert into outpass values('"+requestid+"','"+this.id+"',now())";
       update+=stmt.executeUpdate(sql);
       
     
       
       }catch(Exception e){
       e.printStackTrace();
       }finally{
           try {
               if(stmt!=null)
                   stmt.close();
               if(conn!=null)
                   ;//conn.close();
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
       
       }
       if(update==1)
           return true;
       else
           return false;
    }
      
      public  boolean isExpired(){
        
               Connection conn=null;
                 Statement stmt=null;
                 boolean valid=false;
   
        try{
            
    conn=new dbcon().getConnection("sjitportal");
    stmt = conn.createStatement();
    String sql="select * from outpass where rollno like '"+id+"' and expiry >= now()-INTERVAL 6 HOUR";
    
    ResultSet rs=stmt.executeQuery(sql);
                    
                    rs.beforeFirst();
                    if(rs.next()){
                       valid=true;
                        
                    }
    }catch(Exception e){
    e.printStackTrace();
    }finally{
        try {
            if(stmt!=null)
                stmt.close();
            if(conn!=null)
                ;//conn.close();
        } catch (SQLException ex) {
      ex.printStackTrace();
        }
    }
        
    
    return valid;
    }
      
      public static String getnextID(String type){
        Connection  conn=null;
        Statement stmt=null;
        int res=0;
          try{
            
    conn=new dbcon().getConnection("sjitportal");
    stmt = conn.createStatement();
    String sql="select MAX(CONVERT(SUBSTR(id,13,8),unsigned int)) as res  from sjitportal.outpass where id like '%STAFF%'";
    
    ResultSet rs=stmt.executeQuery(sql);
                    
                    rs.beforeFirst();
                    if(rs.next()){
                        res=rs.getInt("res");
                    }
    }catch(Exception e){
    e.printStackTrace();
    }finally{
        try {
            if(stmt!=null)
                stmt.close();
            if(conn!=null)
                ;//conn.close();
        } catch (SQLException ex) {
      ex.printStackTrace();
        }
    }
          
          return "OUTPASSSTAFF"+(res+1);
      }
}
