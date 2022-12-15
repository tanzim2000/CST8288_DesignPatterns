package businessLayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import dataLayer.DataLayer;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @author Tanzim Ahmed Sagar
 * @version 1.0
 */
public class SagarTanzimAhmedLab02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataLayer dataLayer = new DataLayer();
        PrintLayout printLayout = new PrintLayout();
        InputStream propertiseFile = null;
        ResultSet queryData = null;
        ResultSetMetaData queryResultMetaData = null;
        try {
            //parsing database.propertise
            propertiseFile = Files.newInputStream(Paths.get("src/database.properties"));
        } catch (IOException ex) {
            System.err.print("Couldn't parse properties file!");
        }
        //setting credentials
        dataLayer.setCredentials(propertiseFile);
        //creating Connection
        dataLayer.connectDatabase();
        try {
            //Getting Result
            queryData = dataLayer.getResultSet("SELECT * FROM recipients");
        } catch (SQLException ex) {
            System.err.print("Couldn't get ResultSet for 1st time!");
        }
        try {
            //Getting Metadata of the result
            queryResultMetaData = dataLayer.provideMetaData(queryData);
        } catch (SQLException ex) {
            System.err.print("Couldn't get Metadata for the ResultSet!");
        }
        //Printing Query Table for first time!
        printLayout.printTable(queryResultMetaData, queryData, "recipients Table of Ontario Database:\n");
        //Printing Query Attribute Table for first time!
        printLayout.printAttriTable(queryResultMetaData);
        try {
            //inserting a new row in the table and printing the contents
            dataLayer.editDatabase("INSERT INTO recipients (Name, Year, City, Category) VALUES ('Ahmed; Tanzim', '2017', 'Ottawa', 'Programming');");
        } catch (SQLException ex) {}
        try {
            //Generating new ResultSet
            queryData = dataLayer.getResultSet("SELECT * FROM recipients");
        } catch (SQLException ex) {
            System.err.print("Couldn't get ResultSet for 2nd time!");
        }
        printLayout.printTable(queryResultMetaData, queryData, "recipients Table of Ontario Database (After inserting one row):\n");
        try {
            //delete the newly inserted row and print the table contents
            dataLayer.editDatabase("DELETE FROM recipients WHERE Name='Ahmed; Tanzim'");
        } catch (SQLException ex) {}
        try {
            //Generating new ResultSet
            queryData = dataLayer.getResultSet("SELECT * FROM recipients");
        } catch (SQLException ex) {
            System.err.print("Couldn't get ResultSet for 2nd time!");
        }
        printLayout.printTable(queryResultMetaData, queryData, "recipients Table of Ontario Database (After deleting the inserted row):\n");
        //Closing Connection
        dataLayer.closeConnection();
    }
    
}