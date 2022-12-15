package businesslayer;

import dataaccesslayer.CourseDAO;
import java.sql.SQLException;
import java.util.List;
import transferobjects.*;

/**
 *Business Logic for Assignment 02
 * @author Tanzim Ahmed Sagar
 * @version 1.0
 */
public class BusinessLogic {
    
    private CourseDAO daoClass;
    
    /**
     * default constructor
     * @param credentials {@code CredentialsDTO} object
     */
    public BusinessLogic(CredentialsDTO credentials) {
        daoClass = new CourseDAO(credentials);
    }
     /**
     * method to get a list of all the student records.
     * @return {@code List<CourseDTO>} List of all the students.
     */
    public List<CourseDTO> getAllCourses() throws SQLException{
        return daoClass.getAllCourses();
    }
}