package controller;

import java.io.*;
import java.util.Set;
import javaBeans.Inventory;
import javaBeans.User;
import javaBeans.InventoryLine;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InventoryDB;
import model.DBCloseUtil;
import model.InventoryLineDB;
import javaBeans.ProductList;
import javaBeans.Line;
import model.ProductListDB;


public class InventoryServlet extends HttpServlet 
{

    private Inventory inventory;
    private ProductList productList;
    String address;
  
    DBCloseUtil dbUtil = new DBCloseUtil();
    ProductListDB productListDB = new ProductListDB();

    @Override
    public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
                    throws ServletException, IOException {
		
        String action = request.getParameter("action");
        
        InventoryDB inventoryDB = new InventoryDB();
        InventoryLineDB inventoryLineDB = new InventoryLineDB();
    
        switch (action) {
            case "Add Product":
                try {
                    // try to get a database connection
                    if (dbUtil.getConnection()) {
                        User user = UserServlet.getUser();
                        inventory = inventoryDB.selectOneInventoryByUserID(user.getUserID());
                        
                        /**
                        for(int i = 0; i < ; i++ ) {
                            InventoryLine inventoryLine = new InventoryLine();
                            inventoryLine.setLineID1(inventory.getInventoryID());
                            //inventoryLine.setLineID2();
                            //inventoryLine.setLineQuantity();
                            
                            inventoryLineDB.insertOneInventoryLine(inventoryLine);
                        }
                        **/
                        address = "ManageInventory.jsp";
                    }
                }
                catch( Exception e )
                {
                    System.out.println(e.getMessage());
                    System.out.println(e.getCause());
                }// end for database connection try
                break;
                
            case "Delete Product":
                address = "ManageInventory.jsp";
                break;
            case "Edit":
                address = "EditProductDetails.jsp";
                break;
            case "View All Products in Inventory":
                try {
                    // try to get a database connection
                    if (dbUtil.getConnection()) {
                        User user = UserServlet.getUser();
                        inventory = inventoryDB.selectOneInventoryByUserID(user.getUserID());
                        inventory = inventoryLineDB.selectAllInventoryLinesByInventoryID(inventory.getInventoryID());
                        productList = new ProductList();
                        //productList.setInventory(inventory);
                        request.setAttribute("productList", productList);
 
                        address = "ManageInventory.jsp";
                    }
                }
                catch( Exception e )
                {
                    System.out.println(e.getMessage());
                    System.out.println(e.getCause());
                }// end for database connection try
                break;
            default:
                address = "ManageInventory.jsp";
                break;
        }
            
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
                    throws ServletException, IOException 
    {
        doGet(request, response);
    }

}