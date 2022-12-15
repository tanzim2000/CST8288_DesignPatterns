package dataaccesslayer;
import java.util.List;
import transferobjects.StudentDTO;

/**
 * Interface for Data Access Class
 * @author Tanzim Ahmed Sagar
 * @version 1.0
 * @since 03.11.2022
 */
public interface StudentDAOInterface {
    /**
     * method to get a list of all the students
     * @return {@code List<StudentDTO>} list of student objects
     */
    List<StudentDTO> getAllStudents();
    /**
     * creates a student row based on the given student object
     * @param student StudentDTO
     */
    void addStudent(StudentDTO student);
    /**
     * updates info of a student row based on the given student id
     * @param student StudentDTO
     */
    void updateStudent(StudentDTO student);
    /**
     * deletes a student row based on the given student id
     * @param student StudentDTO
     */
    void deleteStudent(StudentDTO student);
}
