package businesslayer;

import java.util.List;
import dataaccesslayer.*;
import transferobjects.StudentDTO;

/**
 * Business Logic for Assignment 01
 * @author Tanzim Ahmed Sagar
 * @version 1.0
 * @since 03.11.2022
 */
public class BusinessLogic {
    private StudentDAO studentDAO;
    /**
     * default constructor
     */
    public BusinessLogic() {
        studentDAO = new StudentDAO();
    }
    /**
     * method to get a list of all the student records.
     * @return {@code List<StudentDTO>} List of all the students.
     */
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> studentList = studentDAO.getAllStudents();
        return studentList;
    }
    /**
     * method to get a list of all the column names.
     * @return {@code List<String>} List of column names.
     */
    public List<String> getColumnNames() {
        List<String> columnName = studentDAO.getLastMetaData();
        return columnName;
    }
    /**
     * method to add a student in the database
     * @param student StudentDTO
     */
    public void addStudent(StudentDTO student) {
        studentDAO.addStudent(student);
    }
    /**
     * method to add a student in the database
     * @param student StudentDTO
     */
    public void deleteAuthor(StudentDTO student){
        studentDAO.deleteStudent(student);
    }
}
