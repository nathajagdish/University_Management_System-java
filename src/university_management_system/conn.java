/*Conn.java:used to create connection with database with the help of JDBC,JDBC is the driver used to connect with database.*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university_management_system;
import java.sql.*;  /* Responsible for practically implementation of JDBC in our project  SQL have all connector and interface we use connection and statement  interface in our project connection is use for create connection and statement is used to execute query. There are two function in statement interface they are
1)executequery: used to ectract value from database eg select
2)Executeupdate:used to update database e.g insert,delete,update  */

/**
 *
 * @author Jagdish Nath
 */
public class conn { /* there are five step to create connection with database*/
    Connection c;
    Statement s;
    public conn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");/*STEP:1 Register driver with the help of       static  method forName*/  
            c =DriverManager.getConnection("jdbc:mysql:///ems","root",""); /*  STEP:2 create connection*/
            /* or c=DriverManager.getconnection("jdbc:mysql://localhost:portnumber/Ums","root","");*/
              
            s =c.createStatement();/*STEP:4 Create statement*/  
/*STEP:5 Close connection0*/
            
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
    
}

/*  note: add mysql library  and jar file*/


