package model;

import java.sql.*;
import javaBeans.InventoryLine;
import javaBeans.Inventory;


public class InventoryLineDB
{
    private final String databaseURL = ("jdbc:mysql://localhost:3306/craft_store"),
            userDB = "root",
            passDB = "";     
    private Connection connect;
    
    // Need to insert product based on inventory id and update INVENTORY LINE table
    // FOR JUSTIN
    public void insertOneInventoryLine(InventoryLine invLine) //, Inventory inventory)
    {
  
        PreparedStatement ps = null;

        String query = 
                "INSERT INTO INVENTORY_LINE (INV_ID, PROD_ID, INVENTORY_LINE_QTY) " +
                "VALUES (?, ?, ?)";
        try
        {     
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            
            ps = connect.prepareStatement(query);
            ps.setInt(1, invLine.getLineID1());
            ps.setInt(2, invLine.getLineID2());
            ps.setInt(3, invLine.getInventoryLineQuantity());
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
    
    public InventoryLine selectOneInventoryLine(int invID, int invLineNum)
    {

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM INVENTORY_LINE " +
                       "WHERE INV_ID = ?" +
                        " AND INV_LINE_NUM = ?";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setInt(1, invID);
            ps.setInt(2, invLineNum);
            rs = ps.executeQuery();
            
            InventoryLine inventoryLine = null;
            
            if (rs.next())
            {
                inventoryLine = new InventoryLine();
                inventoryLine.setLineID1(rs.getInt( 1 ) );
                inventoryLine.setLineID2(rs.getInt( 2 ) );
                inventoryLine.setInventoryLineNum(rs.getInt( 3 ) );
                inventoryLine.setLineQuantity(rs.getInt( 4 ) );
                
            }
            return inventoryLine;
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
    
    public Inventory selectAllInventoryLinesByInventoryID(int invID)
    {
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM INVENTORY_LINE"
                + " WHERE INV_ID = ?";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setInt(1, invID);
            rs = ps.executeQuery();
            
            Inventory inventory = new Inventory();
            InventoryLine bn = null;
            
            int i=0;
            while ( rs.next() ) {
                    bn = new InventoryLine();
                    bn.setLineID1( rs.getInt( 1 ) );
                    bn.setLineID2( rs.getInt( 2 ) );
                    bn.setInventoryLineNum( rs.getInt( 3 ) );
                    bn.setLineQuantity( rs.getInt ( 4 ) );
                    
                    inventory.setInventoryLine( i++, bn );
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
    
    public int getInvLineCountByInvID(int invID)
    {
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT count(*) FROM INVENTORY_LINE"
                + " WHERE INV_ID = ?";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setInt(1, invID);
            rs = ps.executeQuery();
            
            int count = rs.getInt(1);
           
            return count;
        }
        catch (SQLException e){
            System.out.println(e);
            return 0;
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