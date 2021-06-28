<%-- 
    Document   : viewsubject
    Created on : Jun 17, 2021, 10:18:00 PM
    Author     : DELL
--%>
<%@page import="khoalnm.registration.SubjectDTO"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View subject</title>
    </head>
    <body>
        
        <h1>Subject Info</h1>
        
        Welcome, ${sessionScope.fullname}
        <form action="DispatchServlet">
            <input type="submit" value="Log Out" name="btAction" style=" color: crimson  " />
        </form>
       <c:set var="sList" value="${requestScope.subjectlist}"/>
            <table border="1">
                    <thead>
                        <tr>
                            <th>subject ID</th>
                            <th>subject Category ID</th>
                            <th>title</th>
                            <th>number Of Lesson </th>
                            <th>tag Line</th>
                            <th>thumbnail</th>
                            <th>owner</th>
                            <th>description</th>
                            <th>brief Info</th>   
                            <th>status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="subject" items="${sList}">
                            <tr>
                                <td>${subject.subjectID}</td>
                                <td>${subject.subjectCategoryID}</td>
                                <td>${subject.title}</td>
                                <td>${subject.numberOfLesson}</td>
                                <td>${subject.tagLine}</td>
                                <td>${subject.thumbnail}</td>
                                <td>${subject.owner}</td>
                                <td>${subject.description}</td>
                                <td>${subject.briefInfo}</td>
                                <td>${subject.status}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
            </table>
    
    </body>
</html>
