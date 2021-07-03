/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group6.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ASUS
 */
public class DBHelpers implements Serializable {
    public static Connection makeConnection() 
            throws NamingException, SQLException {
        Context context = new InitialContext(); //get current OS
        Context tomcatContext = (Context)context.lookup("java:comp/env"); //get Tomcat OS
        DataSource ds = (DataSource)tomcatContext.lookup("OLS");
        Connection con = ds.getConnection();
        return con;
    }
}
