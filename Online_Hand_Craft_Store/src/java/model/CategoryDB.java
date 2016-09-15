/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javaBeans.Category;
import javaBeans.Line;
import javaBeans.Product;
import javaBeans.ProductList;

/**
 *
 * @author theNextThing
 */
public class CategoryDB {
    
    private String databaseURL = ("jdbc:mysql://localhost:3306/craft_store"),
            userDB = "root",
            passDB = "";     
    private Connection connect;
    
    public int selectByProductsByCategoryID(int categoryID, ProductList productList)
    {

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT PRODUCT.PROD_ID, CAT_ID, PROD_NAME, PROD_PRICE,"
                + " PROD_DESCRIPTION, INV_LINE_QTY"
                + " FROM PRODUCT, INVENTORY_LINE"
                + " WHERE CAT_ID = ? AND PRODUCT.PROD_ID = INVENTORY_LINE.PROD_ID"
                + " AND INVENTORY_LINE.INV_LINE_QTY > 0";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setInt(1, categoryID);
            rs = ps.executeQuery();
            
            int i=0;
            while ( rs.next() ) {
                    Product bn = new Product();
                    Line ln = new Line();
                    bn.setProductID( rs.getInt( 1 ) );
                    bn.setProductCategoryID( rs.getInt( 2 ) );
                    bn.setProductName( rs.getString( 3 ) );
                    bn.setProductPrice( rs.getFloat ( 4 ) );
                    bn.setProductDescription( rs.getString( 5 ) );
                    ln.setLineQuantity( rs.getInt( 6 ) );
                    ln.setLineNum(i);
                    ln.setLineProduct(bn);
                    productList.setLine( i++, ln);
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
    
    public int selectAllCategories(ProductList categoryList)
    {
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM category";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            System.out.println(ps.executeQuery());
            rs = ps.executeQuery();
            
            int i=0;
            while ( rs.next() ) {
                    Category bn = new Category();
                    bn.setCategoryID( rs.getInt( 1 ) );
                    bn.setCategoryName( rs.getString( 2 ) );
                    bn.setCategoryDescription( rs.getString( 3 ) );
                    
                    categoryList.setCategory( i++, bn );
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
