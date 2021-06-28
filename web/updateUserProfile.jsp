<%-- 
    Document   : updateUserProfile
    Created on : Jun 19, 2021, 9:29:23 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <h1>UPDATE PROFILE </h1>
        Welcome, <a style="color: tomato">${sessionScope.fullname}</a> <br>
        <table border="1">
            <thead>
                <tr>
                    <th>Email</th>
                    <th>Avatar</th>
                    <th>Gender</th>
                    <th>Phone</th>
                    <th>Address</th>
                    
                </tr>
            </thead>
            <tbody>
            <form action="DispatchServlet">
                <tr>
                    <td><input name="txtEmail" value="${sessionScope.email}"readonly="True" /></td>
                    <td>
                        File to upload: <input type="file" name="upfile"><br/>
                        <br/>
                        <input type="submit" value="Press"> to upload the file!
                    </td>
                    <td><input type="text" name="txtGender" value="" /></td>
                    <td><input type="text" name="txtPhone" value="" /></td>          
                    <td><input type="text" name="txtAddress" value="" /></td>
                    
                    <br>
                    <input type="submit" value="Update" name="btAction" />
                    <input type="submit" value="Log Out" name="btAction" style="color: tomato" />
                </tr>
            </form> 
            </tbody>
    </table>  
    </body>
</html>
