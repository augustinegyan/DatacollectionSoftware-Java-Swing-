package  augustine;


import com.mysql.cj.protocol.Message;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.*;
import java.text.MessageFormat;

public class DatabaseTabelView {


     JTable table = new JTable();
     JFrame frame = new JFrame();
     JTableHeader header  = new JTableHeader();
     JButton print = new JButton();
     JButton delete = new JButton();
     JButton update = new JButton();
    JLabel getGetPictureLabelText = new JLabel("Data Collection System");
    JTextField fname = new JTextField();
    JTextField mname = new JTextField();
    JTextField lname = new JTextField();
    JTextField tel = new JTextField();
    JTextField pol = new JTextField();
    JTextField numb = new JTextField();
    int selectedRows;



    Border btnBorder = BorderFactory.createLineBorder(new Color(21, 180, 241,1));
     DatabaseTabelView() throws SQLException ,ClassNotFoundException{


         Object [] columns = {"Number","First Name","Middle Name ","Last Name","Marital Status","Tel","Pol"};

         DefaultTableModel model = new DefaultTableModel();

         model.setColumnIdentifiers(columns);



         table.setModel(model);

         table.setModel(model);
         table.setBackground(Color.white);
         table.setForeground(Color.black);
         table.setSelectionBackground(new Color(20, 115, 231));
         table.setGridColor(new Color(21, 180, 241));
         table.setSelectionForeground(Color.white);
         table.setFont(new Font("Segoe UI",Font.PLAIN,12));
         table.setRowHeight(20);
         table.setAutoCreateRowSorter(true);
         table.setSize(400,200);
         table.setBorder(btnBorder);

         table.getTableHeader().setBackground(new Color(21, 180, 241));
         table.getTableHeader().setForeground(Color.white);
         table.getTableHeader().setFont(new Font("Segoe UI",Font.PLAIN,12));













         try {
             Class.forName("com.mysql.jdbc.Driver");
         } catch (ClassNotFoundException classNotFoundException) {
             classNotFoundException.printStackTrace();
         }
         Connection connection = null;
         try {
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/#schema#","#user#","#pass#");
         } catch (SQLException throwables) {
             throwables.printStackTrace();}
         try {


             String sql = "SELECT * FROM data";
             Statement s = connection.createStatement();
             ResultSet rst = s.executeQuery(sql);
             Object [] row = new Object[15];



             while(rst.next())
             {
                row[0]= rst.getInt("numb");
                row[1]=rst.getString("firstname");
                row[2]=rst.getString("middlename");
                row[3]=rst.getString("lastname");
                row[4]=rst.getString("married");
                row[5]=rst.getString("telephone");
                row[6]=rst.getString("placeofliving");

                model.addRow(row);

             }


             table.setModel(model);

         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }


         JScrollPane pane = new JScrollPane(table);
         pane.setForeground(Color.red);
         pane.setBackground(Color.white);
         pane.setBounds(70,80,1200,400);
         pane.setBorder(btnBorder);
         JScrollBar bar = new JScrollBar();
         bar.setBackground(Color.white);
         pane.setVerticalScrollBar(bar);



         Color textf = new Color(8,133,207);
         fname.setBounds(70,503,200,30);
         fname.setText("firstname");
         fname.setBorder(btnBorder);
         fname.setForeground(textf);
         fname.addFocusListener(new FocusListener() {
             @Override
             public void focusGained(FocusEvent e) {
                 if(fname.getText().equals("firstname")){
                     fname.setText("");
                 }
             }

             @Override
             public void focusLost(FocusEvent e) {
                if (fname.getText().equals("")){
                    fname.setText("firstname");
                }
             }
         });

         mname.setBounds(70,558,200,30);
         mname.setText("middlename");
         mname.setBorder(btnBorder);
         mname.setForeground(textf);
         mname.addFocusListener(new FocusListener() {
             @Override
             public void focusGained(FocusEvent e) {
                 if (mname.getText().equals("middlename")){
                     mname.setText("");
                 }
             }

             @Override
             public void focusLost(FocusEvent e) {
                 if (mname.getText().equals("")){
                     mname.setText("middlename");
                 }

             }
         });
         lname.setBounds(400,503,200,30);
         lname.setText("lastname");
         lname.setBorder(btnBorder);
         lname.setForeground(textf);
         lname.addFocusListener(new FocusListener() {
             @Override
             public void focusGained(FocusEvent e) {
                 if (lname.getText().equals("lastname")){
                     lname.setText("");
                 }
             }

             @Override
             public void focusLost(FocusEvent e) {
                 if (lname.getText().equals("")){
                     lname.setText("lastname");
                 }

             }
         });
         tel.setBounds(400,558,200,30);
         tel.setText("telephone number");
         tel.setBorder(btnBorder);
         tel.setForeground(textf);
         tel.addFocusListener(new FocusListener() {
             @Override
             public void focusGained(FocusEvent e) {
                 if (tel.getText().equals("telephone number")){
                     tel.setText("");
                 }
             }

             @Override
             public void focusLost(FocusEvent e) {
                 if (tel.getText().equals("")){
                     tel.setText("telephone number");
                 }

             }
         });
         pol.setBounds(730,503,200,30);
         pol.setText("place of living");
         pol.setBorder(btnBorder);
         pol.setForeground(textf);
         pol.addFocusListener(new FocusListener() {
             @Override
             public void focusGained(FocusEvent e) {
                 if (pol.getText().equals("place of living")){
                     pol.setText("");
                 }
             }

             @Override
             public void focusLost(FocusEvent e) {
                if (pol.getText().equals("")){
                    pol.setText("place of living");

                }
             }
         });

         numb.setBounds(730,558,200,30);
         numb.setBorder(btnBorder);
         numb.setText("row number");
         numb.setForeground(textf);
         numb.addFocusListener(new FocusListener() {
             @Override
             public void focusGained(FocusEvent e) {
                 if (numb.getText().equals("row number")){
                     numb.setText("");
                 }
             }

             @Override
             public void focusLost(FocusEvent e) {
                 if (numb.getText().equals("")){
                     numb.setText("row number");
                 }

             }
         });
         table.addMouseListener(new MouseListener() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        int selected = table.getSelectedRow();
                                        numb.setText(model.getValueAt(selected,0).toString());
                                        fname.setText(model.getValueAt(selected,1).toString());
                                        mname.setText(model.getValueAt(selected,2).toString());
                                        lname.setText(model.getValueAt(selected,3).toString());
                                        tel.setText(model.getValueAt(selected,4).toString());
                                        pol.setText(model.getValueAt(selected,5).toString());


                                    }

                                    @Override
                                    public void mousePressed(MouseEvent e) {

                                    }

                                    @Override
                                    public void mouseReleased(MouseEvent e) {

                                    }

                                    @Override
                                    public void mouseEntered(MouseEvent e) {

                                    }

                                    @Override
                                    public void mouseExited(MouseEvent e) {

                                    }
                                }
         );


         Font btnf = new Font("Segoe UI",Font.BOLD,15);

         print.setText("Print");
         print.setBounds(1035,20,150,50);
         ImageIcon p = new ImageIcon("print.png");
         print.setIcon(p);
         print.setBackground(Color.white);
         print.setFont(btnf);
         print.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 MessageFormat header = new MessageFormat("Printing in progress");
                 MessageFormat footer = new MessageFormat("Page{0,number,integer}");
                 try{
                     table.print(JTable.PrintMode.NORMAL,header,footer);

                 } catch (PrinterException printerException) {
                     System.err.format("No printer found",printerException.getMessage());

                 }

             }
         });



         delete.setText("Delete");
         delete.setBounds(500,20,150,50);
         ImageIcon d = new ImageIcon("delete.png");
         delete.setIcon(d);
         delete.setBackground(Color.white);
         delete.setFont(btnf);
         delete.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 int selectedRows = table.getSelectedRow();
                if (selectedRows>=0){
                    model.removeRow(selectedRows);



                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        }
                        Connection connection3 = null;
                        try {
                            connection3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/#schema#", "#user#", "#pass#");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        String sql = "delete  from  data where numb ='" + numb.getText() + "'";
                        Statement s = null;
                        try {
                            s = connection3.createStatement();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        try {
                            s.executeUpdate(sql);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }

                }



         });



         update.setBounds(10,20,150,50);
         update.setText("Update");
         ImageIcon u = new ImageIcon("update.png");
         update.setIcon(u);
         update.setBackground(Color.white);
         update.setFont(btnf);
         update.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 selectedRows=table.getSelectedRow();

                 if (selectedRows >= 0) {




                     model.setValueAt(fname.getText(), selectedRows, 1);
                     model.setValueAt(mname.getText(), selectedRows, 2);
                     model.setValueAt(lname.getText(), selectedRows, 3);
                     model.setValueAt(tel.getText(), selectedRows, 4);
                     model.setValueAt(pol.getText(), selectedRows, 5);

                    numb.setText(model.getValueAt(selectedRows,0).toString());




                     try {
                         Class.forName("com.mysql.jdbc.Driver");
                     } catch (ClassNotFoundException classNotFoundException) {
                         classNotFoundException.printStackTrace();
                     }
                     Connection connection = null;
                     try {
                         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/#schema#", "#user#", "#pass#");
                     } catch (SQLException throwables) {
                         throwables.printStackTrace();
                     }
                     Statement s = null;
                     try {
                         s = connection.createStatement();
                     } catch (SQLException throwables) {
                         throwables.printStackTrace();
                     }


                     String sql = "update data set firstname='"+fname.getText()+"',middlename='"+mname.getText()+"',lastname='"+lname.getText()+"'where numb ='"+numb.getText()+"'";
                     try {
                         s.executeUpdate(sql);
                     } catch (SQLException throwables) {
                         throwables.printStackTrace();
                     }


//                 try {
//
//                     int id = table.getSelectedRow();
//
//
//
//
//
//                 } catch (SQLException throwables) {
//                     throwables.printStackTrace();
//                 }
             }}
             });

        JLabel tp = new JLabel();
        tp.setBounds(5,10,50,40);
        ImageIcon img = new ImageIcon("back.png");
        Image img2 = img.getImage();
        Image imgscale = img2.getScaledInstance(50,40,Image.SCALE_SMOOTH);
        ImageIcon finI = new ImageIcon(imgscale);
        tp.setIcon(finI);
        tp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    frame.dispose();
                    DataCollectionBoard dataCollectionBoard = new DataCollectionBoard();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });




         JPanel panel = new JPanel();
         panel.add(update);
         panel.add(delete);
         panel.add(print);
         panel.setBounds(70,595,1200,90);
         panel.setLayout(null);
         panel.setBackground(new Color(21, 180, 241));
         Border bord = BorderFactory.createLineBorder(Color.white,2);
         panel.setBorder(bord);

         JLabel panelLogo = new JLabel();
         panelLogo.setBounds(420,6,60,50);
         ImageIcon panL = new ImageIcon("databasebtn.png");
         Image pan = panL.getImage();
         Image panscal = pan.getScaledInstance(60,50,Image.SCALE_SMOOTH);
         ImageIcon panscal2 = new ImageIcon(panscal);
         panelLogo.setIcon(panscal2);

         Font datacollection = new Font("Open Sans",Font.BOLD,30);
         getGetPictureLabelText.setBounds(500,6,800,40);
         getGetPictureLabelText.setFont(datacollection);
         getGetPictureLabelText.setForeground(Color.white);


         JPanel topPanel = new JPanel();
         topPanel.setBounds(0,10,1355,60);
         topPanel.setBackground(new Color(255, 224, 118));
         Border toppanelB = BorderFactory.createLineBorder(Color.white,0);
         topPanel.setBorder(toppanelB);
         topPanel.add(tp);
         topPanel.add(panelLogo);
         topPanel.add(getGetPictureLabelText);
         topPanel.setLayout(null);

         JPanel downPanel = new JPanel();
         downPanel.setBounds(0,630,1355,50);
         downPanel.setBackground(new Color(255, 224, 118));
         downPanel.setBorder(toppanelB);



         frame.setBounds(0,0,1900,730);
         frame.setLayout(null);
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         frame.getContentPane().add(pane);
         frame.getContentPane().setBackground(new Color(21, 180, 241));
         frame.add(panel);
         frame.add(topPanel);
         frame.add(fname);
         frame.add(mname);
         frame.add(lname);
         frame.add(tel);
         frame.add(pol);
         frame.add(numb);

         //frame.add(downPanel);


     }

}