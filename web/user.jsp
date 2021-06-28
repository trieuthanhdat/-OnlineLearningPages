<%-- 
    Document   : user
    Created on : Jun 17, 2021, 10:00:12 PM
    Author     : DELL
--%>
<%@page import="khoalnm.registration.UserDTO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
    </head>
    <body>
        <h1>User List</h1>
          
        <br>
        <form action="DispatchServlet">
            Welcome, <a style="color: red">${sessionScope.fullname}</a>  
            <input type="submit" value="Log Out" name="btAction" style=" color: crimson  " />
        </form>
            <br>
            
        <!--Search Function-->
        <form action="DispatchServlet">
            <input type="submit" value="SearchUserEmail" name="btAction" />
            <input type="text" name="txtSearchEmail" value="${requestScope.SearchField}" />
            <br>
            <br>
        </form>        
         <table border="1">
                    <thead>
                        <tr>
                            <th>User ID</th>
                            <th>Email</th>
                            <th>Role</th>
                            <th>Full Name</th>
                            <th>Status</th>
                            <th></th>                           
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="uList" items="${requestScope.userlist}">
                        <form action="DispatchServlet" method="POST">
                            <tr>
                                <td>
                                    ${uList.userID}</a>
                                </td>
                                <td>
                                    <a href="DispatchServlet?btAction=ViewUserProfile&email=${uList.email}">${uList.email}</a>
                                </td>
                                <td>
                                    
                                    
                                    <select name="selectRole">
                                        <option hidden="" value="${uList.role}">${uList.role}</option>
                                        <option value="Sale">Sale</option>
                                        <option value="Expert">Expert</option>
                                        <option value="Admin">Admin</option>
                                        <option value="User">User</option>
                                        <option value="Marketing">Marketing</option>
                                    </select>
                                    
                                   
                                </td>
                                <td>${uList.fullname}</td>
                                <td>
                                    <br>
                                    
                                        <select name="selectStatus" id="">
                                            <option hidden="">${uList.status}</option>
                                            <option value="true">true</option>
                                            <option value="false">false</option>
                                        </select>
                                    
                                    <br>
                                    <br>
                                    <%--
                                            <c:if test="${uList.status == 'True'}">
                                                <p style="color: lawngreen"> Active</p>
                                            </c:if>                                    
                                            <c:if test="${uList.status == 'False'}">
                                                <p style="color: tomato"> De-active</p>
                                            </c:if>
                                    --%>
                                </td>
                                <td>
                                    <input type="submit" value="Update" name="btAction" />
                                    <input type="hidden" name="email" value="${uList.email}" />
                                </td>                                
                            </tr>
                            </form>
                        </c:forEach>   
                            <!--For each nay la de show  search result -->
                            <c:if test="${not empty SEARCHRESULT}">
                                <c:forEach var="uList" items="${requestScope.SEARCHRESULT}">
                                <form action="DispatchServlet" method="POST">
                                
                                    <tr>
                                        <td>
                                            ${uList.userID}</a>
                                        </td>
                                        <td>
                                            <a href="DispatchServlet?btAction=ViewUserProfile&email=${uList.email}">${uList.email}</a>
                                        </td>
                                        <td>
                                            
                                            
                                                <select name="selectRole" id="selectRole">
                                                    <option hidden="">${uList.role}</option>
                                                    <option value="Sale">Sale</option>
                                                    <option value="Expert">Expert</option>
                                                    <option value="Admin">Admin</option>
                                                    <option value="User">User</option> 
                                                    <option value="Marketing">Marketing</option>  
                                                </select>    
                                        </td>
                                        <td>${uList.fullname}</td>
                                        <td>
                                            <br>
                                           
                                                <select name="selectStatus" id="selectStatus">
                                                    <option hidden=""> ${uList.status}</option>
                                                    <option value="true">true</option>
                                                    <option value="false">false</option>
                                                </select>
                                            <br>
                                            <br>
                                            <%--
                                            <c:if test="${uList.status == 'True'}">
                                                <p style="color: lawngreen"> Active</p>
                                            </c:if>
                                            <c:if test="${uList.status == 'False'}">
                                                <p style="color: tomato"> De-active</p>
                                            </c:if>
                                            --%>
                                        </td>
                                        <td>
                                            <input type="submit" value="Update" name="btAction" />
                                            <input type="hidden" name="email" value="${uList.email}" />
                                        </td>                                
                                    </tr>
                            </form>
                                </c:forEach>
                            </c:if>

                    </tbody>
    </table>
            <c:if test="${empty userlist && empty SEARCHRESULT}">                                    
                <h3>There is no Result to Show</h3>
            </c:if> 
         <br>
    </body>
</html>
<%--<c:forEach var="userlist" items="${uList}">
                            
                            <tr>
                                
                                <td>${userlist.email}</td>
                                
                                <td>                                
                                    <c:if test="${ not empty userlist.avartar  }">
                                        <img src="PictureLib/${userlist.avartar}" style="width:20%;">
                                    </c:if>
                                    <c:if test="${ empty userlist.avartar }">
                                        <img src="PictureLib/basicicon.png" style="width:20%;">
                                    </c:if> 
                                </td>
                                <td>${userlist.gender}</td>
                                <td>${userlist.phone}</td>
                                <td>${userlist.address}</td>
                                <td>${userlist.date}</td>    
                                
                            </tr>  
                        </c:forEach>--%>