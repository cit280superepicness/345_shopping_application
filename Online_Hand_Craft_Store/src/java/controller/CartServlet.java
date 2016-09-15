/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.*;
import java.util.Set;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductListDB;
import model.CategoryDB;
import model.DBCloseUtil;
import javaBeans.Product;
import javaBeans.Category;
import javaBeans.Cart;
import javaBeans.ProductList;
import javaBeans.Line;

public class CartServlet extends HttpServlet 
{

    private ProductList productList, productList2;
    //private Cart cart;
    // change to be accessed anywhere in class so checkout page can use it?
    // chnage if (cart != null) to if(!cart.IsEmpty()) in code
    private static Cart cart = new Cart(1);
    private ProductList categoryList;
    private Product productItem;
    String address;
    private String viewProductDetails;
  
    DBCloseUtil dbUtil = new DBCloseUtil();
    ProductListDB productListDB = new ProductListDB();
    CategoryDB categoryDB = new CategoryDB();
    
    public void setViewProductDetails(String s) {
        viewProductDetails = s;
    }

     public String getViewProductDetails() {
        return(viewProductDetails);
    }

    
    @Override
    public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
                    throws ServletException, IOException {
		
        String action = request.getParameter("action");
        String addToCart = request.getParameter("addToCart");
        String filterByCategory = request.getParameter("filterByCategory");
        viewProductDetails = request.getParameter("viewProductDetails");
        

        DBCloseUtil dbUtil = new DBCloseUtil();
        ProductListDB productListDB = new ProductListDB();
        
        if (viewProductDetails != null) {
            try {
                address = "ViewProductDetails.jsp";
                setViewProductDetails(viewProductDetails);
                productList = new ProductList();
                    //viewProductDetails = 
                    Product bn = productListDB.selectOneByName(viewProductDetails);
                    Line line = productListDB.selectProductAndQuantity(bn.getProductID());  
                    setViewProductDetails(null);
                    productList.setLine(0, line, productList);
                    request.setAttribute("productList", productList);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage() + " "
                        + e.getStackTrace() + " " + e.getCause());
            }
        }// end if SelectOne
                   
        
        else if (addToCart != null ) { //&& addToCart.equals("Add to Cart")) {
            
            try {
                if (dbUtil.getConnection()) {
                    
                    Product bn = productListDB.selectOne(Integer.parseInt(addToCart));
                    
                    int lnIndex = cart.addProductToCart(Integer.parseInt(request.getParameter("addToCart")), bn);
                    
                    //int shopCurrentQty = Integer.parseInt(request.getParameter("shopCurrentQty"));
                    request.setAttribute("cart", cart);
                } 
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage() + " "
                        + e.getStackTrace() + " " + e.getCause());
                address = "index.jsp";
            }
        }// end if SelectOne
        
        else if( filterByCategory != null) {
             try {
                // try to get a database connection
                if (dbUtil.getConnection()) {
                    productList = new ProductList();
                    categoryDB.selectByProductsByCategoryID(Integer.parseInt(filterByCategory), productList);

                    categoryList = new ProductList();
                    categoryDB.selectAllCategories(categoryList);

                    ProductList tempList = new  ProductList();
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
        
        else if( action.equals("View All Products for Sale")) {
            try {
                // try to get a database connection
                if (dbUtil.getConnection()) {
                    productList = new ProductList();
                    productListDB.selectAllProductsNonzeroQty(productList);

                    categoryList = new ProductList();
                    categoryDB.selectAllCategories(categoryList);

                    ProductList tempList = new  ProductList();
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
        else if (action.equals("View My Cart")) {
            try {
                
                address = "ViewShoppingCart.jsp";
                // try to get a database connection
                if (dbUtil.getConnection()) {
                    productList = new ProductList();
                    productList = this.cart.getProductList();
                    //productListDB.selectAllProducts(productList);
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
                
                //if(cart != null) {
                    //int uID = Integer.parseInt(request.getParameter("uID"));
                    //productList =  new ProductList();
                    productList = cart.getProductList();
                    //User user = new User();
                    //user = userDB.selectUser(uID);
                    
                    //OR DO
                    //String userAddress = user.getAddress();
                    //String userFullName = "" + user.getFirstName() + user.getLastName + "";
                    

                    address = "Checkout.jsp";
                    //request.setAttribute("userAddress", userAddress);
                    //request.setAttribute("userFullName", userFullName); 
                    request.setAttribute("productList", productList);
                //}
            }
            catch( Exception e )
            {
                System.out.println(e.getMessage());    
            }// end for database connection try
        }
           
        else if (action.equals("Remove")) {
            
            try {
                int pIDToRemove = Integer.parseInt(request.getParameter("pIDToRemove"));
                    
                if (cart != null) {
                    cart.removeProductFromCart(pIDToRemove);
                }
            }
            catch( Exception e ){ }
        }
        
        else if (action.equals("Update Quantity")) {
            
            try {
                int pIDToUpdateQty = Integer.parseInt(request.getParameter("pIDToUpdateQty"));
                int qtyAddSub = Integer.parseInt(request.getParameter("qtyAddSub"));
                
                //NOTE: Set up DB connection whne inventory_line DB done, create inventory line and
                //, then to select * from inventory_line
                //where prod_id = pIDToUpdateQty, return prodlist with inv_lines, 
                // add them up qty in each inv_line, assign to int totalQtyInvLine,
                // then nested in if cart != null, put if cart.getLineInCart(pIDToUpdateQty).getLineQuantity() >=
                // totalQtyInvLine) do nothing, else cart.updateCartQty(pIDToUpdateQty, qtyAddSub);
                    
                if (cart != null) {
                    //if (cart.getLineInCart(pIDToUpdateQty).getLineQuantity() >= totalQtyInvLine) {}
                    // else {
                        cart.updateCartQty(pIDToUpdateQty, qtyAddSub);
                        //}
                }
            }
            catch( Exception e ) { }
        }
       /** else if (action.equals("View Product Details")) {
            
            try {
                if (dbUtil.getConnection()) {
            
                    address = "ViewProductDetails.jsp";
                    productList = new ProductList();
                    //viewProductDetails = 
                    Product bn = productListDB.selectOneByName(viewProductDetails);
                    productListDB.selectProductAndQuantity(productList, bn.getProductID());  
                    setViewProductDetails(null);
                    request.setAttribute("productList", productList);                             
                }
            }
            catch( Exception e ) { }
        }**/

        else address = "ViewShoppingCart.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);

    }
    
        
    public static Cart getCart() {
        return cart;
    }
    
    @Override
    public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
                    throws ServletException, IOException 
    {
        doGet(request, response);
    }


}