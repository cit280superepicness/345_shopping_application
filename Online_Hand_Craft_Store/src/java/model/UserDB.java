package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javaBeans.User;

public class UserDB {
    private final String databaseURL = ("jdbc:mysql://localhost:3306/craft_store"),
            userDB = "root",
            passDB = "";     
    private Connection connect;
    
    public User selectUser(String username){
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM user WHERE USERNAME = ?";
        
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            
            User marvel = new User();
            
            while ( rs.next() ) {
                    User dc = new User();
                    dc.setUserID( rs.getInt( 1 ) );
                    dc.setUserUsername(rs.getString(2));
                    dc.setUserPassword(rs.getString(3));
                    dc.setUserFName( rs.getString( 4 ) );
                    dc.setUserLName( rs.getString(5));
                    dc.setUserInitial(rs.getString(6));
                    dc.setUserDOB(rs.getString(7));
                    dc.setUserAddress(rs.getString(8));
                    dc.setUserCity(rs.getString(9));
                    dc.setUserStateProvince(rs.getString(10));
                    dc.setUserCountry(rs.getString(11));
                    dc.setUserZIP(rs.getString(12));
                    dc.setUserAreaCode(rs.getString(13));
                    dc.setUserPhone(rs.getString(14));
                    dc.setUserCardNumber(rs.getString(15));
                    dc.setUserIsVendor(rs.getInt(16));
                    
                    marvel = dc;  
                    
            }
            
            return marvel;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
        finally
        {
            DBCloseUtil.closeDBResultSet(rs);
            DBCloseUtil.closePrepStatement(ps);
            closeDBConnection(connect);
            
        }
      
    }
    
    /**
     *
     * @param username
     * @param password
     * @param fname
     * @param lname
     * @param initial
     * @param dob
     * @param address
     * @param city 
     * @param stateprovince
     * @param country
     * @param zip
     * @param area
     * @param phone
     * @param card
     * @param vendor
     * @return
     */
    public int InsertUser(String username, String password, String fname, 
                String lname, String initial, String dob, String address, 
                String city, String stateprovince, String country, String zip, 
                String area, String phone, String card, int vendor){
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "INSERT INTO user (USERNAME, PASSWORD, FNAME, LNAME, INITIAL, DOB, ADDRESS, CITY, STATE_PROVINCE, COUNTRY, ZIP, AREA_CODE, PHONE, CARD_NUMBER, IS_VENDOR) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try
        {
            connect = DriverManager.getConnection(databaseURL, userDB, passDB);
            ps = connect.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fname);
            ps.setString(4, lname);
            ps.setString(5, initial);
            ps.setString(6, dob);
            ps.setString(7, address);
            ps.setString(8, city);
            ps.setString(9, stateprovince);
            ps.setString(10, country);
            ps.setString(11, zip);
            ps.setString(12, area);
            ps.setString(13, phone);
            ps.setString(14, card);
            ps.setInt(15, vendor);
            ps.executeUpdate();

            return 1;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
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
