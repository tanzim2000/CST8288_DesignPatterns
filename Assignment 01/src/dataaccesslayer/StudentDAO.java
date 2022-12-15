package dataaccesslayer;

import java.io.IOException;
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
public class StudentDAO implements StudentDAOInterface{
    private ResultSetMetaData metaData;

    @Override
    public List<StudentDTO> getAllStudents(){
        Connection connection = null;
        PreparedStatement sqlStatement = null;
        ResultSet result = null;
        ArrayList<StudentDTO> students;
        DataSource dataSource = new DataSource();
        try {
            connection = dataSource.createConnection();
        } catch (IOException | SQLException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            sqlStatement = connection.prepareStatement("SELECT StudentID, LastName, FirstName, Email, PhoneNumber FROM student");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            result = sqlStatement.executeQuery();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        students = new ArrayList<>();
        int index = 1;
        try {
            while(result.next()) {
                StudentDTO student = new StudentDTO();
                try {
                    student.setStudentID(result.getInt("StudentID"));
                } catch (SQLException ex) {
                    System.err.println("Couldn't fetch StudentID for database row = " + index);
                }
                try {
                    student.setFirstName(result.getString("FirstName"));
                } catch (SQLException ex) {
                    System.err.println("Couldn't fetch FirstName for studentID" + student.getStudentID());
                }
                try {
                    student.setLastName(result.getString("LastName"));
                } catch (SQLException ex) {
                    System.err.println("Couldn't fetch LastName for studentID" + student.getStudentID());
                }
                try {
                    student.setEmail(result.getString("Email"));
                } catch (SQLException ex) {
                    System.err.println("Couldn't fetch Email for studentID" + student.getStudentID());
                }
                try {
                    student.setPhoneNumber(result.getString("PhoneNumber"));
                } catch (SQLException ex) {
                    System.err.println("Couldn't fetch PhoneNumber for studentID" + student.getStudentID());
                }
                students.add(student);
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
        return students;
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
        List<String> columnNames=new ArrayList<String>();
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

    @Override
    public void addStudent(StudentDTO student) {
        Connection connection = null;
		PreparedStatement sqlStatement = null;
		try{
                    DataSource ds = new DataSource();
                    connection = ds.createConnection();
                    sqlStatement = connection.prepareStatement("INSERT INTO Students (StudentID, FirstName, LastName, Email, PhoneNumber) VALUES(?, ?, ?, ?)");
                    sqlStatement.setInt(1, student.getStudentID());
                    sqlStatement.setString(2, student.getFirstName());
                    sqlStatement.setString(3, student.getLastName());
                    sqlStatement.setString(4, student.getEmail());
                    sqlStatement.setString(5, student.getPhoneNumber());
                    sqlStatement.executeUpdate();
		} catch(SQLException | IOException e){
                    e.printStackTrace();
		}
		finally{
			try{ if(sqlStatement != null){ sqlStatement.close(); }}
			catch(SQLException ex){System.err.println(ex.getMessage());}
			try{ if(connection != null){ connection.close(); }}
			catch(SQLException ex){System.err.println(ex.getMessage());}
		}
    }
    @Override
    public void updateStudent(StudentDTO student) {
        Connection connection = null;
        PreparedStatement sqlStatement = null;
        try{
            DataSource ds = new DataSource();
            connection = ds.createConnection();
            sqlStatement = connection.prepareStatement("UPDATE Students SET FirstName = ?, LastName = ?, Email = ?, PhoneNumber = ? WHERE StudentID = ?");
            sqlStatement.setString(1, student.getFirstName());
            sqlStatement.setString(2, student.getLastName());
            sqlStatement.setString(3, student.getEmail());
            sqlStatement.setString(4, student.getPhoneNumber());
            sqlStatement.setInt(5, student.getStudentID());
            sqlStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            try{
                if(sqlStatement != null){
                    sqlStatement.close();
                }
            } catch(SQLException ex){
                System.err.println(ex.getMessage());
            }
            try{
                if(connection != null){
                    connection.close();
                }
            } catch(SQLException ex){
                System.err.println(ex.getMessage());
            }
        }
    }
    @Override
    public void deleteStudent(StudentDTO student) {
        Connection connection = null;
        PreparedStatement sqlStatement = null;
        try{
            DataSource ds = new DataSource();
            connection = ds.createConnection();
            sqlStatement = connection.prepareStatement("DELETE FROM Students WHERE StudentID = ?");
            sqlStatement.setInt(1, student.getStudentID());
            sqlStatement.executeUpdate();
        } catch(SQLException | IOException e){
            e.printStackTrace();
        } finally {
            try{
                if(sqlStatement != null){
                    sqlStatement.close(); 
                }
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            try{
                if(connection != null){
                    connection.close();
                }
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
