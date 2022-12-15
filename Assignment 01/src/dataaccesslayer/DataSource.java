package dataaccesslayer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * Class that creates a connection object with the database.
 * @author Tanzim Ahmed Sagar
 * @version 1.0
 * @since 03.11.2022
 */
public class DataSource {
    private Connection connection = null;
    /**
     * creates a connection with the database depending on the properties file.
     * Only allows to create single {@code Connection} object, prevents memory leak.
     * @return connection with the database
     * @see java.sql.Connection
     * @throws IOException if the properties file can't be parsed.
     * @throws SQLException  if connection can't be established.
     */
    public Connection createConnection() throws IOException, SQLException{
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Paths.get("src/database.properties")));
        } catch (IOException ex) {
            throw new IOException("Invalid Properties file!");
        }
        String url = properties.getProperty("jdbc.url");
	String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
	try {
            if (connection != null) {
                System.out.println("Cannot create new connection, one exists already");
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            throw new SQLException("Connection establishment failed!\nInvalid data in propertise file!");
        }
        return connection;
    }
}
