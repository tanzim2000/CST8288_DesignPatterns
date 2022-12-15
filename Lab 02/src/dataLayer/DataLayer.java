package dataLayer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Class that connects with MySQL Database and stores credentials to login
 * @author Tanzim Ahmed Sagar
 * @version 1.0
 */
public class DataLayer {
    private Properties databaseCredentials = new Properties();
    private String url;
    private String username;
    private String password;
    private Connection connection;
    private Statement statement;
    private int connectionState = -1;

    /**
     * Extracts User Credentials from properties file
     * @param propertiseFile
     * @return returns a {@code boolean} value,<br> {@code true} if the file is located successfully otherwise {@code false}
     */
    public boolean setCredentials (InputStream propertiseFile) {
        try {
            databaseCredentials.load(propertiseFile);
        } catch (IOException ex) {
            return false;
        }
        url = databaseCredentials.getProperty("databaseURL");
        username = databaseCredentials.getProperty("username");
        password = databaseCredentials.getProperty("password");
        return true;
    }

    /**
     * Creates a instance of {@code Connection} along with a {@code  Statement}
     * @return an {@code int} value to indicate connection process status.
     * <br> {@code  -1} : instantiating Connection and Statement unsuccessful.
     * <br> {@code  0} : instantiating Connection or Statement unsuccessful.
     * <br> {@code  1} : means connection with {@code Database} successful.
     */
    public int connectDatabase(){
        try {
            connection = DriverManager.getConnection(url, username, password);
            connectionState++;
        } catch (SQLException ex) {}
        try {
            statement = connection.createStatement();
            connectionState++;
        } catch (SQLException ex) {}
        return connectionState;
    }

    /**
     * Generates a ResultSet of a SQL SELECT query
     * @param query String that represents a query
     * @return ResultSet
     * @throws SQLException If the query is invalid
     */
    public ResultSet getResultSet(String query) throws SQLException {
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }
    
    /**
     * Gathers Metadata of a ResultSet
     * @param resultSet ResultSet that need it's metadata
     * @return MataData
     * @throws SQLException If the ResultSet doesn't match with the database or turns invalid.
     */
    public ResultSetMetaData provideMetaData(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        return metaData;
    }
    
    /**
     * Edits the database based on a SQL query
     * @param query String that represents a query
     */
    public void editDatabase(String query) throws SQLException{
        statement.executeUpdate(query);
    }
    
    /**
     * closes connection instance
     * @return {@code true} if all the instances closes successfully
     */
    public boolean closeConnection() {
        try {
            statement.close();
            connection.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}