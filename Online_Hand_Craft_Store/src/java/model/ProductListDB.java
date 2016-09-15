package model;

import javaBeans.ProductList;
import javaBeans.Product;
import javaBeans.Category;
import javaBeans.Line;
import java.sql.*;


public class ProductListDB
{
    private String databaseURL = ("jdbc:mysql://localhost:3306/craft_store"),
            userDB = "root",
            passDB = "";     
    private Connection connect;
    
    // Need to insert product based on inventory id and update INVENTORY LINE table
    // FOR JUSTIN
    public ProductList insertOne(Product product) //, Inventory inventory)
    {
  
        PreparedStatement ps = null;

        String query = 
                "INSERT INTO PRODUCT (PROD_ID, PROD_NAME, PROD_PRICE, PROD_DESCRIPTION) " +
                "VALUES (?, ?, ?, ?)";
        try
        {     
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            
            ps = connect.prepareStatement(query);
            ps.setInt(1, product.getProductID());
            ps.setString(2, product.getProductName());
            ps.setFloat(3, product.getProductPrice());
            ps.setString(4, product.getProductDescription());
            //ps.setString(5, inventory.getInventoryID());
            ps.executeUpdate();
            
            ProductList prodList = new ProductList();
            //prodList.setLine(0, product);
            return prodList;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            DBCloseUtil.closePrepStatement(ps);
        }
    }
    
    //FOR JUSTIN EXAMPLE
    public ProductList updateOneProduct(Product product)//, Inventory inventory)
    {

        PreparedStatement ps = null;
        
        //NOTE: FOR SECURITY USE PREPARED STATEMENT, NOT STRING
        /*
                UPDATE PRODUCT
                JOIN INVENTORY_LINE ON PRODUCT.PROD_ID = INVENTORY_LINE.PROD_ID
                JOIN INVENTORY ON INVENTORY_LINE.INV_ID = INVENTORY.INV_ID
                SET     PROD_NAME = ?,
                	PROD_PRICE = ?,
                	PROD_DESCRIPTION = ?
                WHERE PRODUCT.PROD_ID = ? AND
		INVENTORY.INV_ID = ?; 
        */
        
        String query = "UPDATE PRODUCT " 
                + " JOIN INVENTORY_LINE ON PRODUCT.PROD_ID = INVENTORY_LINE.PROD_ID"
                + " JOIN INVENTORY ON INVENTORY_LINE.INV_ID = INVENTORY.INV_ID"
                + " SET     PROD_NAME = ?, "
                        + " PROD_PRICE = ?, "
                        + " PROD_DESCRIPTION = ? "
                + " WHERE PRODUCT.PROD_ID = ? "
                + " AND INVENTORY.INV_ID = ?";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setString(1, product.getProductName());
            ps.setFloat(2, product.getProductPrice());
            ps.setString(3, product.getProductDescription()); 
            ps.setInt(4, product.getProductID());
            //ps.setInt(5, inventory.getInventoryID());
            ps.executeUpdate();
            
            ProductList prodList = new ProductList();
            //prodList.setLine( 0,product );
            return prodList;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            DBCloseUtil.closePrepStatement(ps);
            closeDBConnection(connect);
        }
    }
    
    public Product selectOne(int product_id)
    {

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM PRODUCT " +
                       "WHERE  PROD_ID = ?";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setInt(1, product_id);
            rs = ps.executeQuery();
            //ProductList prodList = new ProductList();
            Product bn = null;
            
            if (rs.next())
            {
                bn = new Product();
                
                bn.setProductID( rs.getInt( 1 ) );
                bn.setProductCategoryID( rs.getInt( 2 ) );
                bn.setProductName( rs.getString( 3 ) );
                bn.setProductPrice( rs.getFloat ( 4 ) );
                bn.setProductDescription( rs.getString( 5 ) );
            }
            return bn;
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

    public Product selectOneByName(String prodName)
    {

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM PRODUCT " +
                       "WHERE  PROD_NAME = ?";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setString(1, prodName);
            rs = ps.executeQuery();

            Product bn = null;
            
            if (rs.next())
            {
                bn = new Product();
                
                bn.setProductID( rs.getInt( 1 ) );
                bn.setProductCategoryID( rs.getInt( 2 ) );
                bn.setProductName( rs.getString( 3 ) );
                bn.setProductPrice( rs.getFloat ( 4 ) );
                bn.setProductDescription( rs.getString( 5 ) );
            }
            return bn;
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
    
    public int selectAllProducts(ProductList productList)
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
    
    public int selectAllProductsByUserID(ProductList productList)
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
    
    public int selectAllProductsNonzeroQty(ProductList productList)
    {
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT PRODUCT.PROD_ID, CAT_ID, PROD_NAME, PROD_PRICE,"
                + " PROD_DESCRIPTION, INV_LINE_QTY"
                + " FROM PRODUCT, INVENTORY_LINE"
                + " WHERE PRODUCT.PROD_ID = INVENTORY_LINE.PROD_ID"
                + " AND INVENTORY_LINE.INV_LINE_QTY > 0";
        
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            System.out.println(ps.executeQuery());
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
    
    public Line selectProductAndQuantity(int prodID)
    {
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT PRODUCT.PROD_ID, CAT_ID, PROD_NAME, PROD_PRICE,"
                + " PROD_DESCRIPTION, INV_LINE_QTY"
                + " FROM PRODUCT, INVENTORY_LINE"
                + " WHERE PRODUCT.PROD_ID = ? AND INVENTORY_LINE.PROD_ID = ?";
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setInt(1, prodID);
            ps.setInt(2, prodID);
            rs = ps.executeQuery();
            
            Line ln = new Line();
            
            int i=0;
            while ( rs.next() ) {
                    Product bn = new Product();
                    
                    bn.setProductID( rs.getInt( 1 ) );
                    bn.setProductCategoryID( rs.getInt( 2 ) );
                    bn.setProductName( rs.getString( 3 ) );
                    bn.setProductPrice( rs.getFloat ( 4 ) );
                    bn.setProductDescription( rs.getString( 5 ) );
                    ln.setLineQuantity( rs.getInt( 6 ) );
                    ln.setLineNum(i);
                    ln.setLineProduct(bn);
                    //productList.setLine( i++, ln);
            }
            return ln;
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
    
    public ProductList selectOneProduct(int pID)
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
            ProductList productList = new ProductList();
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