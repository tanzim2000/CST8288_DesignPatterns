package dataaccesslayer;
import java.sql.SQLException;
import java.util.List;
import transferobjects.*;

/**
 * Interface for Data Access Class
 * @author Tanzim Ahmed Sagar
 * @version 1.0
 * @since 03.11.2022
 */
public interface CourseDAOInterface {
    /**
     * method to get a list of all the students
     * @return {@code List<StudentDTO>} list of student objects
     */
    List<CourseDTO> getAllCourses () throws SQLException;
}