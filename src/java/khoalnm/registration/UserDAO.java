/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoalnm.registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import khoalnm.utils.DBHelpers;

/**
 *
 * @author DELL
 */
public class UserDAO implements Serializable{
    private ArrayList<UserDTO> user = null;
    public ArrayList<UserDTO> getUserList(){
       return user;
   }

    public UserDAO() {
    }
    
    public void getUser() throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelpers.makeConnection();
            if(con!=null){
                String sql = "SELECT Email, UserID, Role, Fullname, Password, Status "
                        + "FROM Users ";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while(rs.next()){
                String email= rs.getString("Email");
                String userid = rs.getString("UserID");
                String role= rs.getString("Role");
                String fullname = rs.getString("Fullname");
                String password = rs.getString("Password");
                boolean status = rs.getBoolean("Status");
                UserDTO dto = new UserDTO(email, userid, role, fullname, password, status);
                if(this.user==null){
                    this.user = new ArrayList<>();
                }    
                this.user.add(dto);
                }
            }
        }finally{
            if(rs!=null){
                rs.close();
            }if(stm!=null){
                stm.close();
            }if(con!=null){
            con.close();
            }
        } 
    }
    
    
    
    
    public String getUserName(String email) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try{
                //1.Connect DB
            con = DBHelpers.makeConnection();
            if(con!=null){
                //2.Create SQL String
                String sql = "Select Fullname " 
                            + "From Users " 
                            + "Where Email = ?";
                //3.Create Statement Object and assign Parameter value if any
               stm = con.prepareStatement(sql);
               stm.setString(1, email);
               rs = stm.executeQuery();
               if (rs.next()){
                  email= rs.getString("fullname");
               }
            
                }//end if it is existed
            //end if connection is opened
         
        }finally{
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }   
            if(con!=null){
                con.close();
            }
        }  
        return email; 
    }
    

    
    public String getUserID(String email) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
                //1.Connect DB
            con = DBHelpers.makeConnection();
            if(con!=null){
                //2.Create SQL String
                String sql = "Select UserID " 
                            + "From Users " 
                            + "Where Email = ?";
                //3.Create Statement Object and assign Parameter value if any
               stm = con.prepareStatement(sql);
               stm.setString(1, email);
               rs = stm.executeQuery();
               if (rs.next()){
                  email= rs.getString("userid");
               }
            
                }//end if it is existed
            //end if connection is opened
         
        }finally{
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }   
            if(con!=null){
                con.close();
            }
        }  
        return email; 
    }
    
    
    public void searchUserEmail(String searchValue) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelpers.makeConnection();
            if(con!=null){
                String sql = "SELECT Email, UserID, Role, Fullname, Password, Status "
                        + "FROM Users "
                        + "WHERE Email LIKE ? ";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, "%"  + searchValue + "%");
                rs = stm.executeQuery();
                while(rs.next()){
                String email= rs.getString("Email");
                String userid = rs.getString("UserID");
                String role= rs.getString("Role");
                String fullname = rs.getString("Fullname");
                String password = rs.getString("Password");
                boolean status = rs.getBoolean("Status");
                UserDTO dto = new UserDTO(email, userid, role, fullname, password, status);
                if(this.user==null){
                    this.user = new ArrayList<>();
                }    
                this.user.add(dto);
                }
            }
        }finally{
            if(rs!=null){
                rs.close();
            }if(stm!=null){
                stm.close();
            }if(con!=null){
            con.close();
            }
        } 
    }
    
    
    public boolean updateUser(
            String email,
            String role,
            boolean status
           ) throws NamingException, SQLException
    {
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBHelpers.makeConnection();
            String sql = "UPDATE Users "
                    + "SET Role = ? , Status = ? "
                    + "Where Email = ? ";
            stm= con.prepareStatement(sql);
            stm.setString(1, role);
            stm.setBoolean(2, status);
            stm.setString(3, email);
            
            int rowAffect = stm.executeUpdate();
            if(rowAffect>0){
                return true;
            }
        }finally{
            if(stm!=null){
                stm.close();
            }if(con!=null){
                con.close();
            }
        }
        return false;
    }
    
}
