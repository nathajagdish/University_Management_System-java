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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Marks extends JFrame{

   JTextArea t1;/*text Area*/
   JPanel p1;/*like div*/
   
   Marks(){}
   Marks(String str){/*get roll from search textfield on click result in examinationDetails.java*/
       setSize(500,600)/*size of frame*/;
       setLayout(new BorderLayout());/*it can be set north, south,center,east,west*/
       
       p1 = new JPanel();/*object of JPanel*/

       t1 = new JTextArea(50,15);/*JTextArea(row,column)*/
       JScrollPane jsp = new JScrollPane(t1);/*JScrollPane is side scrolling bar jsp is object of JScrollPane*/
       t1.setFont(new Font("Senserif",Font.ITALIC,18));/*font of JTextArea*/
       
       add(p1,"North");/*add p1 to north*/
       
       add(jsp,"Center");/*add jsp to center*/
       
       setLocation(450,100);/*setlocation of frame*/
       mark(str);
   }
   
   public void mark(String s){ /*function take String s*/
    try{
           conn c = new conn();/*object of conn.java class*/
           
           t1.setText("\tResult of Examination\n\nSubject\n");/*set text to marks frame */
           
           ResultSet rs1 = c.s.executeQuery("select * from subject where rollno="+s);/*get value from database and store in rsl roll from ExaminationDetails.java*/
           
           if(rs1.next()){/*apeendd value from database columnwise*/
               t1.append("\n\t"+rs1.getString("subject1"));/*name of col in data base*/
               t1.append("\n\t"+rs1.getString("subject2"));/*name of col2 in database and so on*/
               t1.append("\n\t"+rs1.getString("subject3"));
               t1.append("\n\t"+rs1.getString("subject4"));
               t1.append("\n\t"+rs1.getString("subject5"));
               t1.append("\n-----------------------------------------");
               t1.append("\n");
           }
           
           ResultSet rs2 = c.s.executeQuery("select * from marks where rollno="+s);/*roll from examinationDetail.java*/
           
           if(rs2.next()){
               
               int marks1=Integer.parseInt(rs2.getString("marks1"));/*get marks and convert to string by using Integer.ParseInt and so on*/
               int marks2=Integer.parseInt(rs2.getString("marks2"));
               int marks3=Integer.parseInt(rs2.getString("marks3"));
               int marks4=Integer.parseInt(rs2.getString("marks4"));
               int marks5=Integer.parseInt(rs2.getString("marks5"));
               int total=marks1+marks2+marks3+marks4+marks5;/*sum of all marks*/
               
               t1.append("\nMarks\n\n\t"+rs2.getString("marks1"));/*add marks from database table marks and so on*/
               t1.append("\n\t"+rs2.getString("marks2"));
               t1.append("\n\t"+rs2.getString("marks3"));
               t1.append("\n\t"+rs2.getString("marks4"));
               t1.append("\n\t"+rs2.getString("marks5"));
               t1.append("\n-----------------------------------------");
               t1.append("\n");
               t1.append("\n Total Marks:   ");
               t1.append(total+"/500");
               
           }
         
       }catch(Exception e){
           e.printStackTrace();
       }
   }
   
   public static void main(String[] args){
       new Marks().setVisible(true);
   }
}
