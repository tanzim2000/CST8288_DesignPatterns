package dataaccesslayer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import transferobjects.CredentialsDTO;
/**
 * Class that creates a connection object with the database.
 * @author Tanzim Ahmed Sagar
 * @version 1.0
 * @since 03.11.2022
 */
public class DataSource {
    private Connection connection = null;
    private String url;
    private String username;
    private String password;
        
    /**
     * Default Constructor
     * @param credentials {@code CredentialsDTO} object
     */
    public DataSource(CredentialsDTO credentials) {
        this.username = credentials.getUsername();
        this.password = credentials.getPassword();
        this.url = credentials.getURL();
    }
    /**
     * creates a connection with the database depending on the properties file.
     * Only allows to create single {@code Connection} object, prevents memory leak.
     * @return connection with the database
     * @see java.sql.Connection
     * @throws SQLException  if connection can't be established.
     */
    public Connection createConnection() throws SQLException{
	try {
            if (connection != null) {
                System.err.println("Cannot create new connection, one exists already");
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            throw new SQLException("Connection establishment failed!\nInvalid username or password!");
        }
        return connection;
    }
}