package model;

import javaBeans.ProductListTest;
import javaBeans.Product;
import javaBeans.Category;
import java.sql.*;

public class TestDB
{
    private String databaseURL = ("jdbc:mysql://localhost:3306/craft_store"),
            userDB = "root",
            passDB = "";     
    private Connection connect;
    
    public int selectAllProducts(ProductListTest productList)
    {
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM product";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            System.out.println(ps.executeQuery());
            rs = ps.executeQuery();
            
            int i=0;
            while ( rs.next() ) {
                    Product bn = new Product();
                    bn.setProductID( rs.getInt( 1 ) );
                    bn.setProductCategoryID( rs.getInt( 2 ) );
                    bn.setProductName( rs.getString( 3 ) );
                    bn.setProductPrice( rs.getFloat ( 4 ) );
                    bn.setProductDescription( rs.getString( 5 ) );
                    
                    productList.setProduct( i++, bn );
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
    
    public int selectAllCategories(ProductListTest categoryList)
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
    
    public ProductListTest selectOneProduct(int pID)
    {

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM product " +
                       "WHERE prod_id = ?";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setInt(1, pID);
            rs = ps.executeQuery();
            ProductListTest productList = new ProductListTest();
            Product bn = null;
            if (rs.next())
            {
                bn = new Product();
                bn.setProductID( rs.getInt( 1 ) );
                bn.setProductCategoryID( rs.getInt( 2 ) );
                bn.setProductName( rs.getString( 3 ) );
                bn.setProductPrice( rs.getFloat ( 4 ) );
                bn.setProductDescription( rs.getString( 5 ) );

                productList.setProduct( 0,bn );
            }
            return productList;
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