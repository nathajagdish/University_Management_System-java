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

public class StudentAttendance extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7;/*labels*/
    JTextField t1,t2,t3,t4,t5,t6,t7;/*Text field*/
    JButton b1,b2;/*submit and cancel button*/
    Choice c2,fh,sh;/*similar as combox used for select opction present absent leave in this frame*/
    
    StudentAttendance(){
       
        setLayout(new GridLayout(4,2,50,50));/*grid layout when we need data in the form of tabular then use grid layout 
        
                                                        GridLayout(number_of_row,number_of_col,length,breadth)*/
        
        c2 = new Choice();/*to select automatically roll number from database*/
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from student");/**select all data from database student table and store in rs*/
            while(rs.next()){
                c2.add(rs.getString("rollno"));/*add only maching rollno getText and add c2 to Roll number choice opction*/    
            }
      
      
       }catch(Exception e){ }
       
        add(new JLabel("Select Roll Number"));/* select Roll Number label*/
        add(c2);/*add c2 to  frame*/
      
        l1 = new JLabel("First Half");/*seconf half label */
        fh = new Choice();/* new choice object fh*/
        fh.add("Present");/*add present opction to new choice*/
        fh.add("Absent");/*add Absent opction to choice*/
        fh.add("Leave");/*add Leave opction to choice*/
       
        add(l1);/* add l1 to frame*/
        add(fh);/*add choice to frame*/
        
        l2 = new JLabel("Second Half");/*add second Half frame */
        sh = new Choice();/*create new Choice opction*/
        sh.add("Present");/*add present to choice opction*/
        sh.add("Absent");/*add Absent opction to choice*/
        sh.add("Leave");/*add Leave to choice opction*/
       
        add(l2);/*add l2 to frame*/
        add(sh);/*add choice to frame*/
       
        b1 =new JButton("Submit");/*Submit Button*/
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Cancel");/*Cancel Button*/
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        add(b1);/*add b1 to frame*/
        add(b2);/*add b2 to frame */
        
        b1.addActionListener(this);/*add actionListener to submit button*/
        b2.addActionListener(this);/*add actionListener to cancel button*/
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);/*make frame visible*/
        setSize(400,450);/*set size of frame*/
        setLocation(200,100);/*set location of frame*/
       
    }
    
    public void actionPerformed(ActionEvent ae){
       
        String f = fh.getSelectedItem();/*get selected choice*/
        String s = sh.getSelectedItem();/*get selected choice*/
        String dt = new java.util.Date().toString();/*get date and time */
        String id=c2.getSelectedItem();/*get selected choice*/
        String qry = "insert into attendance_student values("+ id +",'"+dt+"','"+f+"','"+s+"')";/*add to database table attendance_Student*/
       
        try{
            conn c1 = new conn();
            c1.s.executeUpdate(qry);
            JOptionPane.showMessageDialog(null,"Attendance confirmed");
            this.setVisible(false);
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    public static void main(String s[]){
        new StudentAttendance();
    }
}