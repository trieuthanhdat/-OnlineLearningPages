/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoalnm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class DispatchServlet extends HttpServlet {
private final String MAIN_PAGE = "login.html";
private final String MY_REGISTRATION= "ViewMyRegistrationServlet";
private final String LOGIN_SERVLET= "LoginServlet";
private final String SUBJECT_SERVLET="ViewSubjectServlet";
private final String USER_SERVLET="ViewUserServlet";
private final String UPDATE_USER_PROFILE_SERVLET="UpdateUserProfileServlet";
private final String LOG_OUT_SERVLET="LogOutServlet";
private final String VIEW_USER_PROFILE_SERVLET="ViewUserProfileServlet";
private final String SEARCH_USER_ID_SERVLET="SearchUserIDServlet";
private final String UPDATE_USER_SERVLET="UpdateUserServlet";
private final String SEARCH_USER_EMAIL_SERVLET="SearchUserEmailServlet";


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
        String button = request.getParameter("btAction");
        
        String url = MAIN_PAGE;
        
        try{
            if(button.equals("login")){
                url = LOGIN_SERVLET;
            }if(button.equals("ViewSubject")){
                url = SUBJECT_SERVLET;
            }
            if (button.equals("ViewRegistration")){
                url=MY_REGISTRATION;
            }
            if(button.equals("ViewUser")){
                url = USER_SERVLET;
            }
            if(button.equals("Update Your Profile")){
                url =UPDATE_USER_PROFILE_SERVLET;
            }
            if(button.equals("Log Out")){
                url= LOG_OUT_SERVLET;
            }
            if(button.equals("ViewUserProfile")){
                url=VIEW_USER_PROFILE_SERVLET;
            }
            if(button.equals("SearchUserID")){
                url=SEARCH_USER_ID_SERVLET;
            }
            if(button.equals("Update")){//asdsadsadasd
                url= UPDATE_USER_SERVLET;
            }
            if(button.equals("SearchUserEmail")){
                url=SEARCH_USER_EMAIL_SERVLET;  
            }
            
        }
        finally{
            RequestDispatcher rd=request.getRequestDispatcher(url);
            rd.forward(request, response);
            
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
