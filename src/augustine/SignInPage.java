package augustine;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SignInPage {

    JFrame frame;
    JLabel loginLabel;
    JLabel usernameLabel;
    JLabel passWordLabel;
    JLabel signInwith;
    JLabel imageLabel;
    JPanel whitePanel;
    JPasswordField passwordField;
    JTextField userNameField;
    JButton signInButton;
    JLabel googleimage;
    JLabel facebookImage;
    Credential credential = new Credential();
    ResultSet authenticate;



    SignInPage() throws SQLException, ClassNotFoundException {

    Font font = new Font("Segoe UI",Font.BOLD,15);
    Font font3 = new Font("Open Sans",Font.PLAIN,20);
    Font font4 = new Font("Open Sans",Font.PLAIN,12);

    googleimage  = new JLabel();
    ImageIcon imagee = new ImageIcon("google.png");
    googleimage.setIcon(imagee);
    googleimage.setBounds(50,380,45,40);

    facebookImage = new JLabel();
    ImageIcon faceboImg = new ImageIcon("facebook.png");
    facebookImage.setIcon(faceboImg);
    facebookImage.setBounds(130,380,45,40);

    loginLabel = new JLabel("LOGIN");
    loginLabel.setBounds(230,30,100,30);
    loginLabel.setFont(font3);

    usernameLabel = new JLabel("username");
    usernameLabel.setBounds(50,80,100,30);
    usernameLabel.setFont(font4);


    userNameField = new JTextField();
    Border border = BorderFactory.createMatteBorder(0,0,2,
            0,new Color(21, 180, 241));
    userNameField.setBorder(border);
    userNameField.setBounds(50,100,370,30);

    passWordLabel = new JLabel("password");
    passWordLabel.setBounds(50,175,100,30);
    passWordLabel.setFont(font4);


    passwordField = new JPasswordField();
    passwordField.setBorder(border);
    passwordField.setBounds(50,200,370,30);


    signInButton = new JButton("Sign In");
    signInButton.setBackground(new Color(21, 180, 241));
    signInButton.setForeground(Color.WHITE);
    signInButton.setVerticalTextPosition(JButton.CENTER);
    signInButton.setHorizontalTextPosition(JButton.CENTER);
    signInButton.setBounds(50,300,370,30);
    Border btnBorder = BorderFactory.createLineBorder(new Color(21, 180, 241,0));
    signInButton.setBorder(btnBorder);
    signInButton.setFont(font);
    signInButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
            Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/signuppage","root","hacklab123");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            Statement stm = null;
            try {
                stm = connection.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            ResultSet authenticate= null;
            try {
                authenticate = stm.executeQuery("select * from accounts where email='"+userNameField.getText()+"'and pass='"+passwordField.getText()+"'");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (authenticate.next()){
                    try {
                        frame.dispose();
                        DataCollectionBoard dataCollectionBoard = new DataCollectionBoard();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }else{
                    System.out.println("Error Connecting");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
//        t * from accounts where" +
//                        "email='"+userNameField.getText()+"'and pass='"+passwordField.getText()+"'")
    });




    Font font2 = new Font("Open Sans",Font.PLAIN,12);
    signInwith = new JLabel("Sign In With");
    signInwith.setBounds(50,330,100,30);
    signInwith.setFont(font2);

    whitePanel = new JPanel();
    whitePanel.setBounds(390,100,500,500);
    whitePanel.setBackground(Color.white);
    whitePanel.setLayout(null);
    whitePanel.add(userNameField);
    whitePanel.add(passwordField);
    whitePanel.add(signInButton);
    whitePanel.add(signInwith);
    whitePanel.add(usernameLabel);
    whitePanel.add(passWordLabel);
    whitePanel.add(loginLabel);
    whitePanel.add(googleimage);
    whitePanel.add(facebookImage);





    imageLabel    = new JLabel();
    ImageIcon icon = new ImageIcon("sidepanedesign.png");
    Image img = icon.getImage();
    Image imgScale = img.getScaledInstance(160, 700, Image.SCALE_SMOOTH);//Scaling image to side
    ImageIcon scaledicon = new ImageIcon(imgScale);
    imageLabel.setIcon(scaledicon);
    imageLabel.setBounds(1200,0,160,700);
    imageLabel.setLayout(null);






    frame = new JFrame("Sign In");
    frame.setBounds(0,0,1590,730);
    frame.setVisible(true);
    frame.setLayout(null);
    frame.getContentPane().setBackground(new Color(21, 180, 241));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(imageLabel);
    frame.add(whitePanel);
    }
}
