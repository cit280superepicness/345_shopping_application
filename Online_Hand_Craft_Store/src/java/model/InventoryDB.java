package model;

import javaBeans.Inventory;
import java.sql.*;


public class InventoryDB
{
    private final String databaseURL = ("jdbc:mysql://localhost:3306/craft_store"),
            userDB = "root",
            passDB = "";     
    private Connection connect;
    
    // Need to insert product based on inventory id and update INVENTORY LINE table
    // FOR JUSTIN
    public void insertOneInventory(Inventory inventory) //, Inventory inventory)
    {
  
        PreparedStatement ps = null;

        String query = 
                "INSERT INTO INVENTORY (INV_ID, USER_ID) " +
                "VALUES (?, ?)";
        try
        {     
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            
            ps = connect.prepareStatement(query);
            ps.setInt(1, inventory.getInventoryID());
            ps.setInt(2, inventory.getInventoryUserID());
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            DBCloseUtil.closePrepStatement(ps);
        }
    }
    
    public Inventory selectOneInventoryByInventoryID(int invID)
    {

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM INVENTORY " +
                       "WHERE INV_ID = ?";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setInt(1, invID);
            rs = ps.executeQuery();
            Inventory inventory = null;
            
            if (rs.next())
            {
                inventory = new Inventory();             
                inventory.setInventoryID( rs.getInt( 1 ) );
                inventory.setInventoryUserID( rs.getInt( 2 ) );
            }
            return inventory;
        }
        catch (SQLException e){
            System.out.println(e);
            return null;
        }        
        finally
        {
            DBCloseUtil.closeDBResultSet(rs);
            DBCloseUtil.closePrepStatement(ps);
            closeDBConnection(connect);
        }
    }
    
    public Inventory selectOneInventoryByUserID(int userID)
    {

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM INVENTORY " +
                       "WHERE USER_ID = ?";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            Inventory inventory = new Inventory();
            
            if (rs.next())
            {
                             
                inventory.setInventoryID( rs.getInt( 1 ) );
                inventory.setInventoryUserID( rs.getInt( 2 ) );
            }
            return inventory;
        }
        catch (SQLException e){
            System.out.println(e);
            return null;
        }        
        finally
        {
            DBCloseUtil.closeDBResultSet(rs);
            DBCloseUtil.closePrepStatement(ps);
            closeDBConnection(connect);
        }
    }
    
    public void closeDBConnection(Connection connect)
    {
        try{
            connect.close();
        }
        catch(SQLException e)
        {
            e.getMessage();
        }
    }
}