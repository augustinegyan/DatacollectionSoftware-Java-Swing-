package augustine;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainPage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel imLabel = new JLabel();
    JLabel text = new JLabel();
    JPanel topPanel = new JPanel();
    JLabel logoPanel = new JLabel();
    JLabel logolabel = new JLabel();
    JLabel statementLabel1 = new JLabel();
    JLabel statementLabel2 = new JLabel();
    JButton logInbutton = new JButton();
    JButton signUpButton = new JButton();
    JLabel signupLabelIcon = new JLabel();
    JLabel loginLabelIcon = new JLabel();


    MainPage(){


   ImageIcon signupIcon = new ImageIcon("signin.png");
   signupLabelIcon.setIcon(signupIcon);
   signupLabelIcon.setBounds(400,452,45,40);
   signupLabelIcon.setLayout(null);

   ImageIcon loginIcon = new ImageIcon("login.png");
   loginLabelIcon.setIcon(loginIcon);
   loginLabelIcon.setBounds(400,589,45,40);
   loginLabelIcon.setLayout(null);


   Font btnFont = new Font("Open Sans",Font.PLAIN,20);

   signUpButton = new JButton();
   signUpButton.setBounds(500,450,360,40);
   signUpButton.setBackground(new Color(39,81,106));
   signUpButton.setText("Sign Up");
   signUpButton.setForeground(Color.white);
   signUpButton.setHorizontalTextPosition(JButton.CENTER);
   signUpButton.setVerticalTextPosition(JButton.CENTER);
   signUpButton.setBorder(BorderFactory.createLineBorder(Color.white,0));
   signUpButton.setFont(btnFont);
   signUpButton.addActionListener(this);



   logInbutton = new JButton();
   logInbutton.setBounds(500,590,360,40);
   logInbutton.setBackground(new Color(8,133,207));
   logInbutton.setText("Login");
   logInbutton.setForeground(Color.white);
   logInbutton.setHorizontalTextPosition(JButton.CENTER);
   logInbutton.setVerticalTextPosition(JButton.CENTER);
   logInbutton.setBorder(BorderFactory.createLineBorder(Color.white,0));
   logInbutton.setFont(btnFont);
   logInbutton.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           if(e.getSource()==logInbutton){
               frame.dispose();
               try {
                   SignInPage signInPage= new SignInPage();
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               } catch (ClassNotFoundException classNotFoundException) {
                   classNotFoundException.printStackTrace();
               }

           }
       }
   });




    Font font = new Font("Segoe UI",Font.PLAIN,15);
    statementLabel1.setText("Enjoy our No.1 data storage");
    statementLabel1.setBounds(53,280,500,20);
    statementLabel1.setFont(font);
    statementLabel2.setText("system with our advanced technology.");
    statementLabel2.setBounds(53,300,500,20);
    statementLabel2.setFont(font);

    logolabel.setText("Database Management Software");
    Font logolabelFont = new Font("Segoe UI",Font.PLAIN,20);
    logolabel.setFont(logolabelFont);
    logolabel.setBounds(530,160,300,50);

    ImageIcon logoicon = new ImageIcon("database.png");
    Image logoicon2 = logoicon.getImage();
    Image logoiconScaled = logoicon2.getScaledInstance(150,150,Image.SCALE_SMOOTH);
    ImageIcon finalicon = new ImageIcon(logoiconScaled);
    logoPanel.setIcon(finalicon);
    logoPanel.setBounds(600,40,150,150);


    topPanel.setBounds(0,0,1590,50);
    topPanel.setBackground(new Color(21, 180, 241));
    Border topPanelBorder = BorderFactory.createLineBorder(Color.white,0);
    topPanel.setBorder(topPanelBorder);

    text.setText("HEY THERE");
    text.setLayout(null);
    text.setBounds(50,200,500,100);
    Font textFont = new Font("Open Sans",Font.PLAIN,60);
    text.setFont(textFont);
    text.setForeground(new Color(0, 168, 255));
        ImageIcon icon = new ImageIcon("Group 11.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(400, 670, Image.SCALE_SMOOTH);//Scaling image to side
        ImageIcon scaledicon = new ImageIcon(imgScale);
        imLabel.setIcon(scaledicon);
        imLabel.setBounds(1080,35,400,700);
        imLabel.setLayout(null);

    frame.setSize(1590,730);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.white);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.add(imLabel);
    frame.add(text);
    frame.add(logoPanel);
    frame.add(logolabel);
    frame.add(statementLabel1);
    frame.add(statementLabel2);
    frame.add(signUpButton);
    frame.add(logInbutton);
    frame.add(signupLabelIcon);
    frame.add(loginLabelIcon);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==signUpButton){

            frame.dispose();

            try {
                SignupPage signupPage = new SignupPage();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}
