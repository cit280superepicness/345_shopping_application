package model;

import java.sql.*;

public class DBCloseUtil
{
    private String databaseURL = ("jdbc:mysql://localhost:3306/craft_store"),
            userDB = "root",
            passDB = "";     
    private Connection connect;
    
    public boolean getConnection()
    {
         try {
         // load the driver

         Class.forName( "com.mysql.jdbc.Driver" );

         // connect to the database
         connect = DriverManager.getConnection(databaseURL, userDB, passDB);
         }
         catch ( SQLException sqlException) {
                 sqlException.printStackTrace();
                 return false;
         }
         catch ( ClassNotFoundException classException ) {
                 classException.printStackTrace();
                 return false;
         }
         return true;
    }
    public static void closeDBStatement(Statement statement)
    {
        try
        {
            if (statement != null)
                statement.close();
        }
        catch(SQLException sqlE)
        {
            sqlE.printStackTrace();
        }
    }
    
    public static void closePrepStatement(Statement prepStatement)
    {
        try
        {
            if (prepStatement != null)
                prepStatement.close();
        }
        catch(SQLException sqlE)
        {
            sqlE.printStackTrace();
        }
    }

    public static void closeDBResultSet(ResultSet resultSet)
    {
        try
        {
            if (resultSet != null)
                resultSet.close();
        }
        catch(SQLException sqlE)
        {
            sqlE.printStackTrace();
        }
    }
    
}
