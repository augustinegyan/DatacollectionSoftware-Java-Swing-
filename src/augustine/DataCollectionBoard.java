package augustine;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


public class DataCollectionBoard {
    JFrame frame = new JFrame();
    JPanel topPanel = new JPanel();
    JPanel downPanel = new JPanel();
    JTextField firstNamefield = new JTextField();
    JTextField middleNamefield = new JTextField();
    JTextField lastNamefield = new JTextField();
    JComboBox sex = new JComboBox();
    JTextField pOB = new JTextField();
    JTextField nationality = new JTextField();
    JTextField country = new JTextField();
    JTextField telephoneNumber = new JTextField();
    JTextField height = new JTextField();
    JTextArea address = new JTextArea();
    JButton create = new JButton();
    JButton dataBase = new JButton();
    JButton reset = new JButton();
    JButton upload = new JButton();
    JLabel firstname = new JLabel("firstname");
    JLabel middlename = new JLabel("middlename");
    JLabel lastname  = new JLabel("lastname");
    JLabel sexlabel = new JLabel("sex");
    JLabel pictureFrame = new JLabel();
    JPanel picturePanel = new JPanel();
    JLabel poBLabel= new JLabel("place of birth");
    JLabel pOL = new JLabel("place of living");
    JLabel nationalityLabel = new JLabel("nationality");
    JLabel countryLabel  = new JLabel("country");
    JTextField polField = new JTextField();
    JLabel telephoneLabel  = new JLabel("telephone");
    JLabel heightLabel  = new JLabel("height");
    JLabel addressLabel = new JLabel("address");
    JRadioButton diaYes= new JRadioButton("Yes");
    JRadioButton diaNo = new JRadioButton("No");
    JRadioButton marriedYes = new JRadioButton("Yes");
    JRadioButton marriedNo = new JRadioButton("No");
    JLabel diabetess = new JLabel("diabetes");
    JLabel marriedLabel = new JLabel("married");
    JDateChooser dateChooser = new JDateChooser();
    JLabel dateChooserLabel = new JLabel("date of birth");
    Border border = BorderFactory.createLineBorder(Color.white,0);
    Border border2 = BorderFactory.createLineBorder(Color.black,0);
    JLabel getPictureLabel = new JLabel();
    JLabel getGetPictureLabelText = new JLabel("Data Collection System");
    PreparedStatement statement;
    String dians,marrians;
    String selectImagePath;
    File selectedImageFile;





    DataCollectionBoard()throws SQLException,ClassNotFoundException {
        Font datacollection = new Font("Open Sans",Font.BOLD,30);
        getGetPictureLabelText.setBounds(500,6,800,40);
        getGetPictureLabelText.setFont(datacollection);
        getGetPictureLabelText.setForeground(Color.white);

        getPictureLabel.setBounds(0,0,200,220);
        getPictureLabel.setBackground(Color.white);


        Font labelFont = new Font("Segoe UI",Font.BOLD,14);
        dateChooserLabel.setBounds(370,150,100,20);
        dateChooserLabel.setFont(labelFont);
        dateChooser.setBounds(370,170,200,30);



        Color color = new Color(255, 224, 118);
        marriedLabel.setBounds(690,230,100,20);
        marriedLabel.setFont(labelFont);
        marriedYes.setBounds(690,250,50,30);
        marriedYes.setBackground(color);
        marriedNo.setBounds(760,250,50,30);
        marriedNo.setBackground(color);
        ButtonGroup group2 = new ButtonGroup();
        group2.add(marriedYes);
        group2.add(marriedNo);

        diabetess.setBounds(690,150,100,20);
        diabetess.setFont(labelFont);
        diaYes.setBounds(690,170,50,30);
        diaYes.setBackground(color);
        diaNo.setBounds(760,170,50,30);
        diaNo.setBackground(color);
        ButtonGroup group1 = new ButtonGroup();
        group1.add(diaNo);
        group1.add(diaYes);


        addressLabel.setBounds(370,380,100,20);
        addressLabel.setFont(labelFont);
        address.setBounds(370,400,200,120);
        address.setBorder(border2);
        address.setWrapStyleWord(true);
        address.setLineWrap(true);


        heightLabel.setBounds(50,380,100,20);
        heightLabel.setFont(labelFont);
        height.setBounds(50,400,200,30);
        height.setBorder(border2);


        telephoneLabel.setBounds(690,300,100,20);
        telephoneLabel.setFont(labelFont);
        telephoneNumber.setBorder(border2);
        telephoneNumber.setBounds(690,320,200,30);

        country.setBounds(370,320,200,30);
        country.setBorder(border2);
        countryLabel.setBounds(370,300,100,20);
        countryLabel.setFont(labelFont);

        nationalityLabel.setBounds(50,300,100,20);
        nationalityLabel.setFont(labelFont);
        nationality.setBounds(50,320,200,30);
        nationality.setBorder(border2);

        polField.setBounds(370,250,200,30);
        polField.setBorder(border2);
        pOL.setBounds(370,230,100,20);
        pOL.setFont(labelFont);

        poBLabel.setBounds(50,230,100,20);
        poBLabel.setFont(labelFont);
        pOB.setBounds(50,250,200,30);
        pOB.setBorder(border2);

        picturePanel.setBounds(1020,100,200,220);
        picturePanel.setBackground(Color.white);
        picturePanel.add(pictureFrame);
        picturePanel.setLayout(null);

        pictureFrame.setBounds(50,10,200,220);
        pictureFrame.setBackground(Color.white);
        ImageIcon initPic = new ImageIcon("profilepic.png");
        Image initPic2 = initPic.getImage();
        Image toScale =initPic2.getScaledInstance(100,110,Image.SCALE_SMOOTH);
        ImageIcon scaled = new ImageIcon(toScale);
        pictureFrame.setIcon(scaled);


        firstname.setBounds(50,80,100,20);
        firstname.setFont(labelFont);
        firstNamefield.setBounds(50,100,200,30);
        firstNamefield.setBorder(border2);

        middlename.setBounds(370,80,100,20);
        middlename.setFont(labelFont);
        middleNamefield.setBounds(370,100,200,30);
        middleNamefield.setBorder(border2);

        lastname.setBounds(690,80,100,20);
        lastname.setFont(labelFont);
        lastNamefield.setBounds(690,100,200,30);
        lastNamefield.setBorder(border2);

        JLabel panelLabel = new JLabel("Data Collection System");

        JLabel panelLogo = new JLabel();
        panelLogo.setBounds(420,6,60,50);
        ImageIcon panL = new ImageIcon("databasebtn.png");
        Image pan = panL.getImage();
        Image panscal = pan.getScaledInstance(60,50,Image.SCALE_SMOOTH);
        ImageIcon panscal2 = new ImageIcon(panscal);
        panelLogo.setIcon(panscal2);

        topPanel.setBounds(0,0,1590,60);
        topPanel.setBackground(new Color(8,133,207));
        topPanel.setLayout(null);
        topPanel.add(panelLogo);
        topPanel.add(getGetPictureLabelText);

        String maleSex =("Male");
        String femaleSex = ("Female");
        String select = "select";
        sex.addItem(select);
        sex.addItem(maleSex);
        sex.addItem(femaleSex);
        sex.setBackground(Color.white);
        sex.setBounds(50,170,200,30);
        sexlabel.setBounds(50,150,100,20);
        sexlabel.setFont(labelFont);

        downPanel.setBounds(0,660,1590,30);
        downPanel.setBackground(new Color(8,133,207));

        upload.setBounds(1020,320,200,30);
        upload.setBackground(new Color(8,133,207));
        upload.setText("Upload");
        upload.setForeground(Color.white);
        upload.setVerticalTextPosition(JButton.CENTER);
        upload.setHorizontalTextPosition(JButton.CENTER);
        upload.setFont(labelFont);
        upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser imageBrowse = new JFileChooser();
                FileNameExtensionFilter imgExtension = new FileNameExtensionFilter("IMAGES","png","jpg","jpeg");
                imageBrowse.addChoosableFileFilter(imgExtension);
                int show = imageBrowse.showOpenDialog(null);
                if(show == JFileChooser.APPROVE_OPTION){
                    selectedImageFile = imageBrowse.getSelectedFile();
                    selectImagePath = selectedImageFile.getAbsolutePath();
                    JOptionPane.showMessageDialog(null,selectImagePath);


                    ImageIcon profile = new ImageIcon(selectImagePath);
                    Image image = profile.getImage().getScaledInstance(200,220,Image.SCALE_SMOOTH);
                    pictureFrame.setIcon(null);
                    picturePanel.add(getPictureLabel);
                    getPictureLabel.setIcon(new ImageIcon(image));

                }
            }
        });
        upload.setBorder(border);

        create.setBorder( border);
        create.setBackground(new Color(8,133,207));
        create.setText("Create");
        ImageIcon rt = new ImageIcon("create.png");
        create.setFocusable(false);
        create.setIcon(rt);
        create.setForeground(Color.white);
        create.setFont(labelFont);
//        create.setHorizontalTextPosition(JButton.CENTER);
//        create.setVerticalTextPosition(JButton.CENTER);
        create.setBounds(1020,500,200,30);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String gender ;
                gender=sex.getSelectedItem().toString();

                SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
                String date = sp.format((dateChooser.getDate()));

                if(marriedYes.isSelected()){
                    marrians="Yes";
                }else if (marriedNo.isSelected()){
                    marrians="No";
                }

                if(diaYes.isSelected()){
                    dians ="Yes";

                }else if (diaNo.isSelected()){
                    dians="No";


                }
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                Connection connection = null;
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/humandatabase","root","hacklab123");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    statement =connection.prepareStatement(" insert into data(firstname,middlename,lastname,dateofbirth,diabetes,placeofbirth,placeofliving,married,sex,nationality,country,telephone,height,address,image)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    statement.setString(1,firstNamefield.getText());
                    statement.setString(2,middleNamefield.getText());
                    statement.setString(3,lastNamefield.getText());
                    statement.setString(4,date);
                    statement.setString(5,dians);
                    statement.setString(6,pOB.getText());
                    statement.setString(7,polField.getText());
                    statement.setString(8,marrians);
                    statement.setString(9,gender);
                    statement.setString(10,nationality.getText());
                    statement.setString(11,country.getText());
                    statement.setInt(12, Integer.parseInt(telephoneNumber.getText()));
                    statement.setInt(13, Integer.parseInt(height.getText()));
                    statement.setString(14,address.getText());
                    InputStream in = new FileInputStream(selectedImageFile.getAbsolutePath());
                    statement.setBlob(15,in);


                    statement.executeUpdate();
                    firstNamefield.setText("");
                    middleNamefield.setText("");
                    lastNamefield.setText("");
                    pOB.setText("");
                    polField.setText("");
                    nationality.setText("");
                    country.setText("");
                    telephoneNumber.setText("");
                    height.setText("");
                    address.setText("");

                } catch (SQLException | FileNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });







        dataBase.setBorder(border);
        dataBase.setBackground(new Color(8,133,207));
        dataBase.setText("Database");
        ImageIcon dt = new ImageIcon("databasebtn.png");
        dataBase.setIcon(dt);
        dataBase.setForeground(Color.white);
//        dataBase.setHorizontalTextPosition(JButton.CENTER);
//        dataBase.setVerticalTextPosition(JButton.CENTER);
        dataBase.setFont(labelFont);
        dataBase.setBounds(1020,550,200,30);
        dataBase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.dispose();
                    DatabaseTabelView databaseTabelView = new DatabaseTabelView();
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        reset.setBorder(border);
        reset.setBackground(new Color(8,133,207));
        reset.setText("Reset");
        ImageIcon rtt = new ImageIcon("reset.png");
        reset.setIcon(rtt);
        reset.setForeground(Color.white);
        reset.setFont(labelFont);
//        reset.setHorizontalTextPosition(JButton.CENTER);
//        reset.setVerticalTextPosition(JButton.CENTER);
        reset.setBounds(1020,600,200,30);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNamefield.setText("");
                middleNamefield.setText("");
                lastNamefield.setText("");
                pOB.setText("");
                polField.setText("");
                nationality.setText("");
                height.setText("");
                country.setText("");
                address.setText("");
                telephoneNumber.setText("");
               getPictureLabel.setIcon(null);
                pictureFrame.setIcon(scaled);
                dateChooser.setDate(null);

            }
        });









        frame.setBounds(0,0,1590,730);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(topPanel);
        frame.add(downPanel);
        frame.add(firstNamefield);
        frame.add(middleNamefield);
        frame.add(lastNamefield);
        frame.add(firstname);
        frame.add(middlename);
        frame.add(lastname);
        frame.add(sex);
        frame.add(sexlabel);
        frame.add(picturePanel);
        frame.add(pOB);
        frame.add(poBLabel);
        frame.add(pOL);
        frame.add(polField);
        frame.add(nationality);
        frame.add(nationalityLabel);
        frame.add(country);
        frame.add(countryLabel);
        frame.add(telephoneLabel);
        frame.add(telephoneNumber);
        frame.add(upload);
        frame.add(height);
        frame.add(heightLabel);
        frame.add(address);
        frame.add(addressLabel);
        frame.add(create);
        frame.add(dataBase);
        frame.add(reset);
        frame.add(diaYes);
        frame.add(diaNo);
        frame.add(diabetess);
        frame.add(marriedYes);
        frame.add(marriedNo);
        frame.add(marriedLabel);
        frame.add(dateChooser);
        frame.add(dateChooserLabel);
        frame.getContentPane().setBackground(new Color(255, 224, 118));




    }
}
