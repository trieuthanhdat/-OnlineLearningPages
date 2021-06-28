<%-- 
    Document   : myregistration.jsp
    Created on : Jun 16, 2021, 7:28:45 PM
    Author     : DELL
--%>
<%@page import="khoalnm.registration.MyRegistrationDTO"%>
<%@page import="khoalnm.registration.SubjectDTO"%>
<%@page import="khoalnm.registration.PackageDTO"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Registration</title>
    </head>
    <body>
        
        <c:set var="rList" value="${requestScope.regislist}"/>
        <c:set var="sList" value="${requestScope.subjectlist}"/>
        <c:set var="pList" value="${requestScope.packagelist}"/>
        <h1>Registration List</h1>
        <br>
        <form action="DispatchServlet">
            Welcome, <a style="color: tomato">${sessionScope.fullname}</a>
            <input type="submit" value="Log Out" name="btAction" style=" color: crimson  " />
            <br>            
        </form>
        <br>
        <br>
        <!--Search Function-->
        <form action="DispatchServlet">
            <input type="submit" value="SearchUserID" name="btAction" />
            <input type="text" name="txtSearchValue" value="${requestScope.SearchField}" />
        </form>        
        <br>
        <table border="1">
                    <thead>
                        <tr>
                            <th>Registration ID</th>
                            <th>User ID</th>
                            <th>Subject Name</th>
                            <th>Registration Time</th>
                            <th>Package Name</th> 
                            <th>Total Cost</th>
                            <th>Valid To</th>
                            <th>Valid From</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="regis" items="${rList}" >
                            
                            <tr>
                                <td>${regis.registrationID}</td>
                                <td>${regis.userID}</td>
                                <td>
                                    <c:forEach var="sub" items ="${sList}" varStatus="counter">
                                            <c:if test = "${sub.subjectID==regis.subjectID}">
                                                <c:out value="${sub.title}"/>
                                            </c:if>
                                    </c:forEach>  
                                </td>
                                <td>${regis.registrationTime}</td>
                                <td>
                                    <c:forEach var="pkg" items ="${pList}" varStatus="counter">
                                            <c:if test = "${pkg.packageID==regis.packageID}">
                                                <c:out value="${pkg.name}"/>
                                            </c:if>
                                    </c:forEach>  
                                </td>
                                <td>${regis.totalCost}</td>
                                <td>${regis.vaalidTo}</td>
                                <td>${regis.vaalidFrom}</td>
                                
                                <td>
                                    <c:if test="${regis.status == 'True'}"> 
                                        <p style=" color:mediumseagreen ">Enroll</p>
                                    </c:if>
                                    <c:if test="${regis.status== 'False'}">
                                        <p style=" color: tomato">UnEnroll</p>
                                    </c:if>                                  
                                </td>
                            </tr>                          
                        
                        </c:forEach>
                    <!--For each nay la de show  search result -->
                    
                        <c:if test="${not empty SEARCHRESULT}">
                            <c:forEach var="search" items="${requestScope.SEARCHRESULT}" >
                                <tr>
                                    <td>${search.registrationID}</td>
                                    <td>${search.userID}</td>
                                    <td>
                                        <c:forEach var="sub1" items ="${sList}" varStatus="counter">
                                            <c:if test = "${sub1.subjectID==search.subjectID}">
                                                <c:out value="${sub1.title}"/>
                                            </c:if>
                                        </c:forEach>  
                                    </td>
                                    <td>${search.registrationTime}</td>                            
                                    <td>
                                        <c:forEach var="pkg1" items ="${pList}" varStatus="counter">
                                            <c:if test = "${pkg1.packageID==search.packageID}">
                                                <c:out value="${pkg1.name}"/>
                                            </c:if>
                                        </c:forEach>  
                                    </td>
                                    <td>${search.totalCost}</td>
                                    <td>${search.vaalidTo}</td>
                                    <td>${search.vaalidFrom}</td>
                                    <td>
                                        <c:if test="${search.status == 'True'}"> 
                                            <p style=" color:mediumseagreen ">Enroll</p>
                                        </c:if>
                                        <c:if test="${search.status== 'False'}">
                                            <p style=" color: tomato">UnEnroll</p>
                                        </c:if>                                  
                                    </td>                                    
                                </tr>                      
                            </c:forEach>
                        </c:if>
                </tbody>        
        </table>
        <c:if test="${empty rList && empty SEARCHRESULT}">                                    
            <h3>There is no Result to Show</h3>
        </c:if>        
                                    
    </body>
</html>
