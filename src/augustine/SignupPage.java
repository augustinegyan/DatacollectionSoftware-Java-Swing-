package augustine;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class SignupPage implements ActionListener  {
    JButton signUpbtn = new JButton();
    JFrame frame = new JFrame();
    PreparedStatement statement;
    SignupPage() throws ClassNotFoundException,SQLException {




        //SignUP Label at the top
        JLabel signUplabel = new JLabel();
        signUplabel.setText("SIGN UP");
        signUplabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        signUplabel.setBounds(150, 50, 200, 30);


        //FirstName Label
        Font textfieldLabelfonts = new Font("Open Sans", Font.PLAIN, 12);
        JLabel firstNameLabel = new JLabel("firstname");
        firstNameLabel.setBounds(50, 86, 100, 30);
        firstNameLabel.setFont(textfieldLabelfonts);

        //LastName Label
        JLabel lastNameLabel = new JLabel("lastname");
        lastNameLabel.setBounds(50, 146, 100, 30);
        lastNameLabel.setFont(textfieldLabelfonts);

        //Email Label
        JLabel emailLabel = new JLabel("email");
        emailLabel.setBounds(50, 216, 100, 30);
        emailLabel.setFont(textfieldLabelfonts);

        //Password Label
        JLabel passwordLabel = new JLabel("password");
        passwordLabel.setBounds(50, 286, 100, 30);
        passwordLabel.setFont(textfieldLabelfonts);

        //Side Image in Label
        JLabel image = new JLabel();
        ImageIcon icon = new ImageIcon("Group 2.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(160, 700, Image.SCALE_SMOOTH);//Scaling image to side
        ImageIcon scaledicon = new ImageIcon(imgScale);
        image.setIcon(scaledicon);
        image.setBounds(0, 0, 170, 700);
        image.setLayout(null);


        //First Name Text Field
        JTextField firstNamefield = new JTextField();
        firstNamefield.setFont(textfieldLabelfonts);
        Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(21, 180, 241));
        firstNamefield.setBounds(50, 110, 300, 30);
        firstNamefield.setBorder(border);

        //Last Name Text field
        JTextField lastNamefield = new JTextField();
        lastNamefield.setFont(textfieldLabelfonts);
        lastNamefield.setBounds(50, 170, 300, 30);
        lastNamefield.setBorder(border);

        //Email Account Textfield
        JTextField emailaccountfield = new JTextField();
        emailaccountfield.setFont(textfieldLabelfonts);
        emailaccountfield.setBounds(50, 240, 300, 30);
        emailaccountfield.setBorder(border);

        //Password Textfield
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(50, 310, 300, 30);
        passwordField.setBorder(border);

        JLabel link  = new JLabel("Sign in here");
        link.setForeground(new Color(8,133,207));
        link.setBounds(50,360,100,20);
        link.setFont(textfieldLabelfonts);
        link.setCursor(new Cursor(Cursor.HAND_CURSOR));
        link.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    frame.dispose();
                    SignInPage sign = new SignInPage();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });

        //Button Below WhitePanel

        signUpbtn.setText("Sign Up");
        signUpbtn.setHorizontalTextPosition(JButton.CENTER);
        signUpbtn.setVerticalTextPosition(JButton.CENTER);
        signUpbtn.setBounds(50, 410, 300, 30);
        signUpbtn.setBackground(new Color(21, 180, 241));
        signUpbtn.setForeground(Color.WHITE);
        Border signupBtnborder = BorderFactory.createLineBorder(Color.blue, 0);
        signUpbtn.setBorder(signupBtnborder);
        Font butnfonts = new Font("Segoe UI", Font.BOLD, 15);
        signUpbtn.setFont(butnfonts);

        //Action Event for Buttone
        signUpbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                Connection connection = null;
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/signuppage", "root", "#pass#");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    statement = connection.prepareStatement(" insert into accounts(firstname,lastname,email,pass)values(?,?,?,?)");
                    statement.setString(1,firstNamefield.getText());
                    statement.setString(2,lastNamefield.getText());
                    statement.setString(3,emailaccountfield.getText());
                    statement.setString(4, String.valueOf(passwordField.getPassword()));

                    statement.executeUpdate();

                    frame.dispose();
                    try {
                        SignInPage signInPage = new SignInPage();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }});

        //Right Side Panel
        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.white);
        whitePanel.setBounds(800, 100, 400, 500);
        whitePanel.setLayout(null);
        whitePanel.add(signUplabel);
        whitePanel.add(firstNamefield);
        whitePanel.add(lastNamefield);
        whitePanel.add(emailaccountfield);
        whitePanel.add(passwordField);
        whitePanel.add(firstNameLabel);
        whitePanel.add(lastNameLabel);
        whitePanel.add(emailLabel);
        whitePanel.add(passwordLabel);
        whitePanel.add(signUpbtn);
        whitePanel.add(link);


        //Frame Config
        frame.setTitle("Sign Up  ");
        frame.setSize(1900, 738);
        frame.getContentPane().setBackground(new Color(21, 180, 241));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(whitePanel);
        frame.add(image);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==signUpbtn){
            frame.dispose();
            try {
                SignInPage signIn = new SignInPage();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        }
    }
}
