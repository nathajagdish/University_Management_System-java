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
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class ExaminationDetails extends JFrame implements ActionListener{

   private JPanel contentPane;/*work like div in html*/
   private JTable table;/*table */
   private JTextField search;/*text field for search*/
   private JButton b1,b2,b3;/*buttions*/

   
    public void Book() {
        try {
            conn con = new conn();
            String sql = "select * from student";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {}

    }

   public ExaminationDetails() {/*Create comstructor*/

        setBounds(150, 50, 930, 475);/*setBount work as setsize+setlocation of frame*/
        contentPane = new JPanel();/*object of content plane*/
        contentPane.setBackground(Color.WHITE);
     //   contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();/*in java table is no directly created for creating table create object of JScrollPane */
        scrollPane.setBounds(79, 133, 1080, 282);/*set bound of table x-axis,y-axis,length,breadth*/
        contentPane.add(scrollPane);/*add ttable to to Jplane or div*/

        table = new JTable();/*create object of JTable*/
        table.addMouseListener(new MouseAdapter() {/*addMouseListener on  table and create object MouseAdapter*/
            @Override/*overide method*/
            public void mouseClicked(MouseEvent arg0) {/*overide mouseClicked and pass MouseEvents as Argumment*/
               int row = table.getSelectedRow();/*getSelectedRow and store in row variable*/
               search.setText(table.getModel().getValueAt(row, 10).toString());/*setText to Search JTextfield(getModel to table getValueAT(row 10)
               convert into String and set to Search*/
            }
        });
       
        table.setBackground(new Color(240, 248, 255));/*similar to setBackgroundcolor.red()*/
        table.setForeground(Color.DARK_GRAY);
        table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        scrollPane.setViewportView(table);/*add rable to scrollPane*/

        b1 = new JButton("Result");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
        b1.setForeground(new Color(199, 21, 133));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b1.setBounds(564, 89, 138, 33);
        contentPane.add(b1);

       
        JLabel l1 = new JLabel("Check Result");
        l1.setForeground(new Color(107, 142, 35));
        l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
        l1.setBounds(300, 15, 400, 47);
        contentPane.add(l1);

       
        search = new JTextField();
        search.setBackground(new Color(255, 240, 245));
        search.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
        search.setForeground(new Color(47, 79, 79));
        search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
        search.setBounds(189, 89, 357, 33);
        contentPane.add(search);
        search.setColumns(10);

        JLabel l3 = new JLabel("Back");
        l3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
            }
        });
        l3.setForeground(Color.GRAY);
        l3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        l3.setBounds(97, 89, 72, 33);
        contentPane.add(l3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "Book-Details",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
        panel.setBounds(67, 54, 1100, 368);
        contentPane.add(panel);
        panel.setBackground(Color.WHITE);
        Book();
        setSize(1200,500);
    }
   
    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            if(ae.getSource() == b1){ /*if button is Result clicked*/           
                new Marks(search.getText()).setVisible(true);/*send roll which is in search to Marks class and open Marks.java class*/
                this.setVisible(false);/*make current frame false*/
            };
        }
        catch(Exception e){}
    }

    public static void main(String[] args){
        new ExaminationDetails().setVisible(true);
    }
}
