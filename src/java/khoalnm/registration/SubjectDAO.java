/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoalnm.registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
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
public class SubjectDAO implements Serializable{
    
    private ArrayList<SubjectDTO> subject = null;
    public ArrayList<SubjectDTO> getSubjectList(){
       return subject;
    }

    public SubjectDAO() {
    }
    
    
   
    public void getSubject() throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelpers.makeConnection();
            if(con!=null){
                String sql = "SELECT SubjectID, SubjectCategoryID, Title, "
                        + "NumberOfLessons, TagLine, Thumbnail, "
                        + "Owner, Description, BriefInfo, Status "
                        +" From Subjects ";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while(rs.next()){
                    int subjectID = rs.getInt("SubjectID");
                    int subjectcategoryID = rs.getInt("SubjectCategoryID");
                    String title =rs.getString("Title");
                    int numberoflesson = rs.getInt("NumberOfLessons"); 
                    String tagline = rs.getString("Tagline");
                    String thumnail =rs.getString("Thumbnail");
                    String owner =rs.getString("Owner");
                    String description =rs.getString("Description");
                    String briefinfo =rs.getString("BriefInfo");
                    boolean status = rs.getBoolean("Status");           
                    SubjectDTO subjectlist = new SubjectDTO(subjectID, subjectcategoryID,
                            title, numberoflesson, 
                            tagline, thumnail, 
                            owner, description, 
                            briefinfo, status);
                    if(this.subject ==null){
                        this.subject = new ArrayList<>();
                    }
                    this.subject.add(subjectlist);
                }
            }  
        }finally{
            if(rs!=null){
                rs.close();
            }if(stm !=null){
                stm.close();
            }if(con!=null){
                con.close();
            }
        }
    }
     
}
