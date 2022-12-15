
import businesslayer.BusinessLogic;
import java.util.List;
import transferobjects.StudentDTO;

/**
 * main() class that accesses a SQL database serves as the starter class for Assignment1 of 22F_CST8288
 * @author Tanzim Ahmed Sagar
 * @version 1.0
 * @since 04.11.2022
 */
public class Main {

    /**
     * main method for demonstration purpose
     * @param args the command line arguments (not used in this program)
     */
    public static void main(String[] args) {
        BusinessLogic logic = new BusinessLogic();
        List<StudentDTO> students = logic.getAllStudents();
        List<String> columns = logic.getColumnNames();
        System.out.printf("%10s  %-10s  %-10s %-24s  %-15s\n",
                columns.get(0),
                columns.get(1),
                columns.get(2),
                columns.get(3),
                columns.get(4)
        );
        for (StudentDTO student : students) {
            System.out.printf("%10d  %-10s  %-10s %-20s  %-15s\n",
                    student.getStudentID(),
                    student.getLastName(),
                    student.getFirstName(),
                    student.getEmail(),
                    student.getPhoneNumber()
            );
        }
    }//end of main()
}//end of class
