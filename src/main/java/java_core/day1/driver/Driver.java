package java_core.day1.driver;

import java_core.day1.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Driver {
    public static void main(String[] args) {
        // database connection

        ResultSet resultSet;

        String query = "SELECT * FROM customers";


        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            ) {

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // print first name and last name
                System.out.println(resultSet.getString("firstname") + " " + resultSet.getString("lastname"));
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
