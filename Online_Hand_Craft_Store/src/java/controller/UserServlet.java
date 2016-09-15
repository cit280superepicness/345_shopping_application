package controller;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBCloseUtil;
import javaBeans.User;
import model.UserDB;

public class UserServlet extends HttpServlet {

    private static User user;
    String address;

    DBCloseUtil dbUtil = new DBCloseUtil();
    UserDB userDB;
    
    

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        address = "pagenotfound.jsp";
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String xvendor = request.getParameter("is_vendor"); //"checked" or null
        int vendor;
        if(xvendor == null){
            vendor = 0;
        }else{
            vendor = 1;
        }        switch (action) {
            case "Login":
                try {
                    // try to get a database connection
                    if (dbUtil.getConnection()) {
                        userDB = new UserDB();
                        User vc;
                        vc = userDB.selectUser(username);
                        vc.setLoggedIn(true);
                        if(password.equals(vc.getUserPassword())){
                            user = new User();
                            user = vc;
                            user.setLoggedIn(true);
                            request.setAttribute("user", user);
                            if(1 != vendor){
                                address = "Shop.jsp";
                            }else{
                                address = "ManageInventory.jsp";
                            }
                            
                        }else{
                            address = "Login.jsp";
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }// end for database connection try
                break;
            case "Logout": 
                try {
                    // try to get a database connection
                    if (dbUtil.getConnection()) {
                        user.setLoggedIn(false);
                        user.setUserID(0);
                        user.setUserUsername("");
                        user.setUserPassword("");
                        user.setUserFName("");
                        user.setUserLName("");
                        user.setUserInitial("");
                        user.setUserDOB("");
                        user.setUserAddress("");
                        user.setUserCity("");
                        user.setUserStateProvince("");
                        user.setUserCountry("");
                        user.setUserZIP("");
                        user.setUserAreaCode("");
                        user.setUserPhone("");
                        user.setUserCardNumber("");
                        user.setUserIsVendor(-1);
                        address = "Login.jsp";
                        request.setAttribute("user", user);
                    }
                    
                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }// end for database connection try
                break;
            case "Register":
                try {
                            String confirm = request.getParameter("confirm");
                            String fname = request.getParameter("fname");
                            String lname = request.getParameter("lname");
                            String initial = request.getParameter("initial");
                            String dob = request.getParameter("dob");
                            String card = request.getParameter("card_number");
                            String street = request.getParameter("address");
                            String phone = request.getParameter("phone");
                            String city = request.getParameter("city");
                            String stateprovince = request.getParameter("state_province");
                            String country = request.getParameter("country");
                            String zip = request.getParameter("zip");
                            String area = request.getParameter("area_code");
                    // try to get a database connection
                    if (dbUtil.getConnection()) {
                        if (password.equals(confirm)) {
                            userDB = new UserDB();
                            userDB.InsertUser(username, password, fname, lname,
                                    initial, dob, street, city, stateprovince, country,
                                    zip, area, phone, card, vendor);
                            user = new User(); 
                            user = userDB.selectUser(username);
                            address = "Shop.jsp";
                        }else{
                            address = "Login.jsp";
                        }
                    }
                    
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }// end for database connection try    
                break;  
            default:
                address = "Login.jsp";
                break;
            }
        

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                dispatcher.forward(request, response);

        }
        
        
        public static User getUser() { 
            return(user); 
        }
        
        @Override
        public void doPost
        (HttpServletRequest request,
                HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request, response);
        }

    }
