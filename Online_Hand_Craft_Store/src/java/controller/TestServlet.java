package controller;  

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TestDB;
import model.DBCloseUtil;
import javaBeans.Product;
import javaBeans.Category;
import javaBeans.ProductListTest;

public class TestServlet extends HttpServlet {

  private ProductListTest productList, productList2;
  private ProductListTest categoryList;
  private Product productItem;
  String address;
  
    DBCloseUtil dbUtil = new DBCloseUtil();
     TestDB testDB = new TestDB();

  @Override
  public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
         throws ServletException, IOException {
		
    String action   = request.getParameter("action");
    address = "pagenotfound.jsp";

     DBCloseUtil dbUtil = new DBCloseUtil();
     TestDB testDB = new TestDB();
     
    if (action.equals("View All Products for Sale")) {
        try {
            // try to get a database connection
            if (dbUtil.getConnection()) {
                productList = new ProductListTest();
                testDB.selectAllProducts(productList);

                categoryList = new ProductListTest();
                testDB.selectAllCategories(categoryList);

                ProductListTest tempList = new  ProductListTest();
                tempList.setProdListInProductList(productList);
                tempList.setProdListInProductList(categoryList);
                address = "Shop.jsp";

                request.setAttribute("tempList", tempList); 
            }
        }
        catch( Exception e )
        {
            System.out.println(e.getMessage());    
        }// end for database connection try
    }// end if ViewAll requested
    else if (action.equals("View Product Details")) {
        int productID = 0;
        try {
            //productID = Integer.parseInt(request.getParameter("productID"));
            if (dbUtil.getConnection()) {
                productList2 = testDB.selectOneProduct(1);
                request.setAttribute("productList2", productList2);
                address = "ViewProductDetails.jsp";
            }
        }
        catch( Exception e )
        {
            System.out.println(e.getMessage());  
        
        }// end for database connection try
    }
    else if (action.equals("View All Products in Inventory")) {
        try {
            // try to get a database connection
            if (dbUtil.getConnection()) {
                productList = new ProductListTest();
                testDB.selectAllProducts(productList);

                categoryList = new ProductListTest();
                testDB.selectAllCategories(categoryList);

                ProductListTest tempList = new  ProductListTest();
                tempList.setProdListInProductList(productList);
                tempList.setProdListInProductList(categoryList);
                address = "ManageInventory.jsp";

                request.setAttribute("tempList", tempList); 
            }
        }
        catch( Exception e )
        {
            System.out.println(e.getMessage());    
        }// end for database connection try
    }// end if ViewAll requested
    else if (action.equals("View My Cart")) {
        try {
            // try to get a database connection
            if (dbUtil.getConnection()) {
                productList = new ProductListTest();
                testDB.selectAllProducts(productList);

                address = "ViewShoppingCart.jsp";
                request.setAttribute("productList", productList); 
            }
        }
        catch( Exception e )
        {
            System.out.println(e.getMessage());    
        }// end for database connection try
    }// end if ViewAll requested
       else if (action.equals("Proceed to Checkout")) {
        try {
            // try to get a database connection
            if (dbUtil.getConnection()) {
                productList = new ProductListTest();
                testDB.selectAllProducts(productList);

                address = "Checkout.jsp";
                request.setAttribute("productList", productList); 
            }
        }
        catch( Exception e )
        {
            System.out.println(e.getMessage());    
        }// end for database connection try
    }
    else address = "Login.jsp";
        

    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
    dispatcher.forward(request, response);

  }
  @Override
    public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
        doGet( request, response );
    }

}
