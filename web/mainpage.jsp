<%-- 
    Document   : mainpage
    Created on : Jun 18, 2021, 11:03:16 PM
    Author     : DELL
--%>
<%@page import="khoalnm.registration.UserProfileDTO"%>
<%@page import="khoalnm.registration.UserDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <c:set var="upList" value="${requestScope.userprofile}"/>
        <c:set var="uList" value="${requestScope.user}"/>
        <h1>Welcome To Our  Learning Page</h1>
        Welcome, <a style="color: red">${sessionScope.fullname}</a>
        <br>
        <form action="DispatchServlet">
            <input type="submit" value="Update Your Profile" name="btAction" style="color: crimson" />
            <input type="submit" value="Log Out" name="btAction" style=" color: crimson  " /><br><br>
            <input type="submit" value="ViewUser" name = "btAction"/><br><br>
            <input type="submit" value="ViewRegistration" name = "btAction"/><br><br>
            <input type="submit" value="ViewSubject" name = "btAction"/><br><br>      
        </form>    
        
    </body>
</html>
