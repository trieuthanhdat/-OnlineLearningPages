/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoalnm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khoalnm.registration.MyRegistrationDAO;
import khoalnm.registration.UserDAO;
import khoalnm.registration.UserDTO;
import khoalnm.registration.UserProfileDAO;
import khoalnm.registration.UserProfileDTO;

/**
 *
 * @author DELL
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
private final String EROR_PAGE = "index.html";
private final String REGISTRATION_PAGE="mainpage.jsp";
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
        String url= EROR_PAGE;
        try {
            
            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");
            MyRegistrationDAO dao = new MyRegistrationDAO();
            UserDAO udao = new UserDAO();
            boolean result = dao.checkLogin(email, password);
            
            if(result){
                //to Session user name && user id && email
                HttpSession session = request.getSession();
                String fullname = udao.getUserName(email);
                String userid = udao.getUserID(email);
                session.setAttribute("fullname", fullname);
                session.setAttribute("userid", userid);
                session.setAttribute("email", email);
                //get User Profile 
                UserProfileDAO user = new UserProfileDAO();
                user.getUserProfile();
                ArrayList<UserProfileDTO> profile = user.getUserProfileList();
                request.setAttribute("userprofile", profile);
                //get User
                UserDAO User = new UserDAO();
                User.getUser();
                ArrayList<UserDTO> u = User.getUserList();
                request.setAttribute("user", u);
                
                
                url = REGISTRATION_PAGE;
                if(profile.isEmpty()){
                    log("User Profile List - LoginServlet is empty");
                }if(u.isEmpty()){
                    log("User List - LoginServlet is empty");
                }
            }
        }catch(SQLException ex){
            log("Check LoginServlet SQLException - " +ex.getMessage());
        }catch(NamingException ex){
            log("Check LoginServlet NamingException - " +ex.getMessage()); 
        } finally {
            response.sendRedirect(url);
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
        processRequest(request, response);
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
