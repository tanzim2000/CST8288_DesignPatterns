package dataaccesslayer;

import java.util.List;
import transferobjects.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Data Access Class
 * @author Tanzim Ahmed Sagar
 * @version 1.0
 * @since 03.11.2022
 */
public class CourseDAO implements CourseDAOInterface {
    private ResultSetMetaData metaData;
    private CredentialsDTO credentials;
    
    public CourseDAO (CredentialsDTO credentials) {
        this.credentials = credentials;
    }

    /**
     * method to get a list of all courses
     * @return List of Courses
     * @throws SQLException
     */
    @Override
    public List<CourseDTO> getAllCourses() throws SQLException {
        Connection connection;
        PreparedStatement sqlStatement = null;
        ResultSet result = null;
        ArrayList<CourseDTO> courses;
        DataSource dataSource = new DataSource(credentials);
        connection = dataSource.createConnection();
        try {
            sqlStatement = connection.prepareStatement("SELECT * FROM course");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            result = sqlStatement.executeQuery();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        courses = new ArrayList<>();
        int index = 1;
        try {
            while(result.next()) {
                CourseDTO course = new CourseDTO();
                try {
                    course.setCourseCode(result.getString("CourseCode"));
                } catch (SQLException ex) {
                    System.err.println("Couldn't fetch CourseCode for database row = " + index);
                }
                try {
                    course.setCourseName(result.getString("CourseName"));
                } catch (SQLException ex) {
                    System.err.println("Couldn't fetch Course Name for database row = " + index);
                }
                try {
                    course.setCourseDescription(result.getString("CourseDescription"));
                } catch (SQLException ex) {
                    System.err.println("Couldn't fetch Course Description for database row = " + index);
                }
                courses.add(course);
                index++;
            }
        } catch (SQLException ex) {
        } finally {
            try {
                metaData = result.getMetaData();
            } catch (SQLException ex) {
                System.err.println("Couldn't fetch the metadata for the last query result");
            }
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                System.err.println("Couldn't close the resultset! Either missing or null.");
            }
            try {
                if (sqlStatement != null) {
                    sqlStatement.close();
                }
            } catch (SQLException ex) {
                System.err.println("Couldn't close the sqlStatement! Either missing or null.");
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.err.println("Couldn't close the connection! Either missing or null.");
            }
        }
        return courses;
    }
    /**
     * method to get the metadata of the last result.
     * @return {@code List<String>} List of column names.
     */
    public List<String> getLastMetaData() {
        int columnCount = 0;
        try {
            columnCount = metaData.getColumnCount();
        } catch (SQLException ex) {
            System.err.print("Couldn't get column count!");
        }
        List<String> columnNames = new ArrayList<String>();
        String columnName = null;
        for (int index = 1; index <= columnCount; index++) {
            try {
                columnName= this.metaData.getColumnName(index);
            } catch (SQLException ex) {
                System.err.print("Couldn't get a column name!");
            }
            columnNames.add(columnName);
        }
        return columnNames;
    }
}