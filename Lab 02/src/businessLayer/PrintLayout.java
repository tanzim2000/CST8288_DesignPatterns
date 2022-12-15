package businessLayer;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Business layer of lab 03 to print data
 * @author Tanzim Ahmed Sagar
 * @version 1.0
 */
public class PrintLayout {
    /**
     * prints the table in a specific format
     * @param queryResultMetaData Metadata of the query table
     * @param queryData Data table of the query
     * @param titleMsg Title of the table
     * @return integer that denotes the progress of execution
     */
    public int printTable(ResultSetMetaData queryResultMetaData, ResultSet queryData, String titleMsg) {
        int columnCount = 0;
        int status = 3;
        try {
            columnCount = queryResultMetaData.getColumnCount();
        } catch (SQLException ex) {
            System.err.print("Couldn't get column count!");
            return status;
        }
        status--;
        System.out.println(titleMsg);
        for (int i = 1; i <= columnCount; i++) {
            String columnName = "";
            try {
                columnName = queryResultMetaData.getColumnName(i);
            } catch (SQLException ex) {
            System.err.print("Couldn't get column name!");
            return status;
            }
            status--;
                System.out.printf("%-32s\t", columnName); //Printing Column Name
            }
        System.out.println();
        try {
            //Printing rows
            while(queryData.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-32s\t", queryData.getObject(i));
                }
                System.out.println();
            }
            System.out.println();
        } catch (SQLException ex) {
            System.err.print("queryData.next() isn't working!");
            return status;
        }
        status--;
        return status;
    }
    /**
     * prints a table of the field attributes
     * @param queryResultMetaData Metadata of the query table
     */
    public void printAttriTable(ResultSetMetaData queryResultMetaData) {
        int columnCount = 0;
        try {
            columnCount = queryResultMetaData.getColumnCount();
        } catch (SQLException ex) {
            System.err.print("Couldn't get column count!");
        }
        System.out.println("\nRecipients Table - Column Attributes:\n");
        for (int i = 1; i <= columnCount; i++) {
            try {
                System.out.printf("%-16s\t", queryResultMetaData.getColumnName(i));
                System.out.printf("%-16s\t", queryResultMetaData.getColumnTypeName(i));
                System.out.printf("%-16s\t", queryResultMetaData.getColumnClassName(i));
                System.out.print("\n");
            } catch (SQLException ex) {}
        }
        System.out.println();
    }
}