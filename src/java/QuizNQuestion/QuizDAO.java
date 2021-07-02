/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizNQuestion;

import Utils.DBHelpers;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class QuizDAO implements Serializable{
    
    private int n;
    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;
    
    private void closeConnection() throws SQLException {
        if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
    }
    
    public QuizDAO () throws NamingException, SQLException {
        n = count();
    }
    
    public int count() throws NamingException, SQLException {
        int number = 0;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
         try {
            con = DBHelpers.makeConnection();
            if (con != null) {
                String sql = "SELECT * " 
                            +"FROM Quiz ";  
                
                stm = con.prepareStatement(sql);
                
                rs = stm.executeQuery();
                while (rs.next()) {
                    number++;
                }
            }
        } finally {
            closeConnection();
        }
        return number;
    }
    
    public QuizDTO getQuiz (int quizID) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        QuizDTO dto = null;
        
         try {
            con = DBHelpers.makeConnection();
            if (con != null) {
                String sql = "SELECT subjectID, name, numOfQuestions, duration, passRate, level, status " 
                            +"FROM Quiz "
                        + " WHERE quizID = ?";  
                
                stm = con.prepareStatement(sql);
                stm.setInt(1, quizID);
                
                rs = stm.executeQuery();
                if (rs.next()) {
                    int subjectID = rs.getInt("subjectID");
                    String name = rs.getString("name");
                    int numOfQuestion = rs.getInt("numOfQuestion");
                    Time duration = rs.getTime("duration");
                    double passRate = rs.getDouble("passRate");
                    String level = rs.getString("level");
                    boolean status = rs.getBoolean("status");
                    dto = new QuizDTO(quizID, subjectID, name, numOfQuestion, duration, passRate, level, status);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
}
