package model;

import javaBeans.ProductList;
import javaBeans.Product;
import javaBeans.InvoiceLine;
import javaBeans.Invoice;
import java.sql.*;


public class InvoiceLineDB
{
    private String databaseURL = ("jdbc:mysql://localhost:3306/craft_store"),
            userDB = "root",
            passDB = "";     
    private Connection connect;
    
    // Need to insert product based on inventory id and update INVENTORY LINE table
    // FOR JUSTIN
    public void insertOneInvoiceLine(InvoiceLine invc) //, Inventory inventory)
    {
  
        PreparedStatement ps = null;

        String query = 
                "INSERT INTO INVOICE_LINE (INVOICE_ID, PROD_ID, INVOICE_LINE_NUM, INVOICE_LINE_QTY) " +
                "VALUES (?, ?, ?, ?)";
        try
        {     
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            
            ps = connect.prepareStatement(query);
            ps.setInt(1, invc.getLineID1());
            ps.setInt(2, invc.getLineID2());
            ps.setInt(3, invc.getInvoiceLineNum());
            ps.setInt(4, invc.getInvoiceLineNum());
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
    
    public InvoiceLine selectOneInvoiceLine(int invoiceID, int invoiceLineNum)
    {

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM INVOICE_LINE " +
                       "WHERE INVOICE_ID = ?" +
                        " AND INV_LINE_NUM = ?";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setInt(1, invoiceID);
            ps.setInt(2, invoiceLineNum);
            rs = ps.executeQuery();
            
            InvoiceLine invLine = null;
            
            if (rs.next())
            {
                invLine = new InvoiceLine();
                invLine.setLineID1(rs.getInt( 1 ) );
                invLine.setLineID2(rs.getInt( 2 ) );
                invLine.setInvoiceLineNum(rs.getInt( 3 ) );
                invLine.setLineQuantity(rs.getInt( 4 ) );
                
            }
            return invLine;
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
    
    public int selectAllInvoiceLinesByInvoiceID(int invcID)
    {
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM INVOICE_LINE"
                + " WHERE INVOICE_ID = ?";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setInt(1, invcID);
            rs = ps.executeQuery();
            
            Invoice invoice = new Invoice();
            InvoiceLine bn = null;
            
            int i=0;
            while ( rs.next() ) {
                    bn = new InvoiceLine();
                    bn.setLineID1( rs.getInt( 1 ) );
                    bn.setLineID2( rs.getInt( 2 ) );
                    bn.setInvoiceLineNum( rs.getInt( 3 ) );
                    bn.setLineQuantity( rs.getInt ( 4 ) );
                    
                    invoice.setInvoiceLine( i++, bn );
            }
            return 1;
        }
        catch (SQLException e){
            e.printStackTrace();
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