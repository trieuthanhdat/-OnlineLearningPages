<%-- 
    Document   : viewuserprofile
    Created on : Jun 26, 2021, 10:49:07 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile</title>
    </head>
    <body>
        <h1>User Profile</h1>
        <br>
        <form action="DispatchServlet">
            Welcome, <a style="color: tomato">${sessionScope.fullname}</a>
            <input type="submit" value="Log Out" name="btAction" style=" color: crimson  " />
            <br>            
        </form>
        <br>
        <br>
        <c:set var="emailuser" value="${requestScope.userprofilelist}"/>
        <table border="1">
            <thead>
                <tr>
                    <th>Email</th>
                    <th>Avatar</th>
                    <th>Gender</th>
                    <th>Phone</th>   
                    <th>Address</th>
                    <th>Date</th>
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${emailuser.email}</td>
                    <td>                                
                        <c:if test="${ not empty emailuser.avartar  }">
                            <img src="PictureLib/${emailuser.avartar}" style="width:20%;">
                        </c:if>
                        <c:if test="${ empty emailuser.avartar }">
                            <img src="PictureLib/basicicon.png" style="width:20%;">
                        </c:if> 
                    </td>
                    <td>${emailuser.gender}</td>
                    <td>${emailuser.phone}</td>
                    <td>${emailuser.address}</td>
                    <td>${emailuser.date}</td>     
                    
                </tr>  
            </tbody>  
        </table>
    </body>
</html>
