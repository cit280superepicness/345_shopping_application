package model;

import javaBeans.ProductList;
import javaBeans.Product;
import javaBeans.Category;
import javaBeans.InvoiceLine;
import javaBeans.Invoice;
import java.sql.*;


public class InvoiceDB
{
    private String databaseURL = ("jdbc:mysql://localhost:3306/craft_store"),
            userDB = "root",
            passDB = "";     
    private Connection connect;
    
    // Need to insert product based on inventory id and update INVENTORY LINE table
    // FOR JUSTIN
    public void insertOneInvoice(Invoice invoice) //, Inventory inventory)
    {
  
        PreparedStatement ps = null;

        String query = 
                "INSERT INTO INVOICE (INVOICE_ID, USER_ID, INVOICE_TIME, INVOICE_DATE) " +
                "VALUES (?, ?, ?, ?)";
        try
        {     
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            
            ps = connect.prepareStatement(query);
            ps.setInt(1, invoice.getInvoiceID());
            ps.setInt(2, invoice.getInvoiceUserID());
            ps.setTime(3, invoice.getInvoiceTime());
            ps.setDate(4, invoice.getInvoiceDate());
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBCloseUtil.closePrepStatement(ps);
        }
    }
    
    public Invoice selectOneInvoiceByInvoiceID(int invoiceID)
    {

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM INVOICE " +
                       "WHERE INVOICE_ID = ?";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setInt(1, invoiceID);
            rs = ps.executeQuery();
            Invoice invoice = null;
            
            if (rs.next())
            {
                invoice = new Invoice();             
                invoice.setInvoiceID( rs.getInt( 1 ) );
                invoice.setInvoiceUserID( rs.getInt( 2 ) );
                invoice.setInvoiceTime( rs.getTime ( 3 ) );
                invoice.setInvoiceDate( rs.getDate( 4 ) );

            }
            return invoice;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }        
        finally
        {
            DBCloseUtil.closeDBResultSet(rs);
            DBCloseUtil.closePrepStatement(ps);
            closeDBConnection(connect);
        }
    }
    
    
    /**NOTE: CAN SELECT MORE THAN 1 INVOICE SINCE 1 USER HAS MULTIPLE INVOICES
    public Invoice selectOneInvoiceByUserID(int userID)
    {

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM INVOICE " +
                       "WHERE USER_ID = ?";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            //ProductList prodList = new ProductList();
           Invoice invoice = null;
            
            if (rs.next())
            {
                invoice = new Invoice();             
                invoice.setInvoiceID( rs.getInt( 1 ) );
                invoice.setInvoiceUserID( rs.getInt( 2 ) );
                invoice.setInvoiceTime( rs.getTime ( 3 ) );
                invoice.setInvoiceDate( rs.getDate( 4 ) );
            }
            return invoice;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }        
        finally
        {
            DBCloseUtil.closeDBResultSet(rs);
            DBCloseUtil.closePrepStatement(ps);
            closeDBConnection(connect);
        }
    }**/
    
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