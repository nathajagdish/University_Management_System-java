/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university_management_system;

/**
 *
 * @author Jagdish
 */


import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentAttendanceDetail extends JFrame implements ActionListener{
  
    JTable j1;/*j1 is object of Jtable*/
    JButton b1;/*button print*/
    String h[]={"Roll Number","Date Time","First Half","Second Half"};/*static array*/
    String d[][]=new String[15][4];/*for dynamic data from database store all srudent attendance detail*/  
    int i=0,j=0;
    
    StudentAttendanceDetail(){/*constructor*/
        super("View Students Attendence");/* frame name*/
        setSize(800,300);/*frame size*/
        setLocation(450,150);/*frame location*/

        try{
            String q="select * from attendance_student";/*select from database*/
            conn c1=new conn();
            ResultSet rs=c1.s.executeQuery(q);/*storeall data in rs*/
            while(rs.next()){
                d[i][j++]=rs.getString("rollno");/*insert data from database to Jtable i=0,j=0*/
                d[i][j++]=rs.getString("Date");/*insert database to JTable and so on i=0,j=1*/
                d[i][j++]=rs.getString("first");/*insert database to JTable and so on i=0,j=2*/
                d[i][j++]=rs.getString("second");
                i++;/*i=1*/
                j=0;/*j=0 for next row*/
            }
        
            j1=new JTable(d,h);/*create table and pass 2D aray,1D aray*/

        }catch(Exception e){}
        
        b1=new JButton("Print");
        add(b1,"South");
        JScrollPane s1=new JScrollPane(j1);/*add scroll bar*/
        add(s1);/*add scroll bar to frame */
        
        b1.addActionListener(this);/*add click listener to print button */
    
    }
    public void actionPerformed(ActionEvent ae){
        try{
            j1.print();/*when print button is clicked CALL printer function and print data if we have printer*/
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new StudentAttendanceDetail().setVisible(true);
    }
}
