package transferobjects;

/**
 * Data Transfer Object to transfer login info
 * @author Tanzim Ahmed Sagar
 */
public class CredentialsDTO {
    
    private String username;
    private String password;
    private final String URL = "jdbc:mysql://localhost:3306/tutoring?useSSL=false&allowPublicKeyRetrival=true";

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the value of username
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getURL() {
        return URL;
    }

}
