package augustine;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MySqlConnection {
//    String query = ("insert into data(firstname)values(?)");
      String name="Augustine";
      PreparedStatement statement;
         MySqlConnection() throws ClassNotFoundException, SQLException{

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/humandatabase","root","hacklab123");
        statement =connection.prepareStatement(" insert into data(firstname)values(?)");
        System.out.println("Connected Successfully to the Database");
//          statement.setString(1,"Augustini");
//
//        statement.executeUpdate();

        Scanner scan = new Scanner(System.in);
        System.out.println("Kindly Enter your name here :");
        String nametake = scan.nextLine();
        statement.setString(1,nametake);




    }
}
